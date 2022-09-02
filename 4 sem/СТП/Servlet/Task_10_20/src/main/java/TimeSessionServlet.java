import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "TimeSessionServlet", value = "/TimeSessionServlet")
public class TimeSessionServlet extends HttpServlet {
    boolean flag = true;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException {performTask(req, resp);
    }
    private void performTask(HttpServletRequest req, HttpServletResponse resp) throws ServletException {

        HttpSession session = null;
        if (flag) {
//создание сессии и установка времени инвалидации
            session = req.getSession();
            int timeLive = 10; //десять секунд!
            session.setMaxInactiveInterval(timeLive);
            flag = false;
        } else {
//если сессия не существует, то ссылка на нее не будет получена
            session = req.getSession(false);
        }

        TimeSession.go(resp, req, session);

    }

}

