import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet( name = "CandidatsServlet",  value = "/getCandidats")
public class CandidatsServlet extends HttpServlet {

    private  Connection connection;
    private Statement statement;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, IOException {

        ArrayList<Candidats> candidats = new ArrayList<Candidats>();
        try {
            statement = GetConnection().createStatement();
            String sql ="select * from presidents";
            ResultSet resultSet= statement.executeQuery(sql);
            if(resultSet!=null)
            {
            while (resultSet.next()) {
                int id_new=resultSet.getInt("id");
                String last_name_new=resultSet.getString("last_name");
                int countUsers_new=resultSet.getInt("countUsers");
                Candidats candidat = new Candidats(id_new, last_name_new, countUsers_new);
           candidats.add(candidat);
            }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getSession().setAttribute("Candidates", candidats);
        req.getRequestDispatcher("result.jsp").forward(req, resp);
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

