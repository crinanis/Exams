 import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
 import java.sql.*;
 import java.util.ArrayList;
 import java.util.List;

 @WebServlet( name ="GoServlet", value = "/go")
public class GoServlet extends HttpServlet {
     private  Connection connection;
     private Statement statement;

   @Override
 protected  void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       Integer countUsersAll = 0;
       try {
           if ( req.getParameterValues("checkboxes") !=null) {
               final String[] checkedCheckboxes = req.getParameterValues("checkboxes");
               for (String checkedCheckbox : checkedCheckboxes) {
                   statement = GetConnection().createStatement();
                   statement.execute("UPDATE presidents SET countUsers = countUsers + 1 WHERE last_name = '" + checkedCheckbox + "'");
               }
           }
           ResultSet resultSet = statement.executeQuery("select * from presidents");

           List<CandidateWithNumber> allCandidates = new ArrayList<CandidateWithNumber>();

           while (resultSet.next()) {
               allCandidates.add(new CandidateWithNumber(resultSet.getString(2), resultSet.getInt(3)));
           }
           List<CandidateWithNumber> choosedCandidates = new ArrayList<CandidateWithNumber>() ;
           if ( req.getParameterValues("checkboxes") != null) {
               final String[] checkedCheckboxes = req.getParameterValues("checkboxes");
               choosedCandidates= allCandidates.stream().filter(x-> {
                   for (String checkedCheckbox : checkedCheckboxes) {
                       if (x.last_name.equals(checkedCheckbox)) {
                           return true;
                       }
                   }
                   return false;
               }).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
           }
           for (CandidateWithNumber candidate : allCandidates) {
               countUsersAll += candidate.countUsers;
           }
           List<String> resultArray = new ArrayList<String>();

           resultSet = statement.executeQuery("select * from presidents");

           for (CandidateWithNumber choosedCandidate : choosedCandidates) {
               double procent = (choosedCandidate.countUsers * 100.0) / countUsersAll;
               resultArray.add(choosedCandidate.last_name + " " + procent + "%");
           }
           req.getSession().setAttribute("resultArr", resultArray);
          req.getRequestDispatcher("percent.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
   }

     public Connection GetConnection() throws SQLException {
         try {
             Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
             connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/exam?serverTimezone=Europe/Moscow&useSSL=false",
                     "root", "Ksusha20031007");
             System.out.println("Connection successful!");
         }catch (Exception ex) {
             System.out.println("Connection failed...");
             System.out.println(ex);
         }
         return connection;
     }
}
