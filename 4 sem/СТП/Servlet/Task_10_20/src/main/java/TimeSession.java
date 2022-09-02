import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class TimeSession {
    public static void go(HttpServletResponse resp, HttpServletRequest req, HttpSession session ) {
        PrintWriter out = null;

        try {
            out = resp.getWriter();
            out.write("<br> Role: " + req.getParameter("login"));
            out.write("<br> Session Id: " + req.getRequestedSessionId());
            out.write("<br> Creation Time: " + new Date(session.getCreationTime()));
            out.write("<br> Request URI: " + req.getRequestURI());
            out.write("<br> Session alive! ");
            out.flush();
            out.close();
        } catch (NullPointerException e) {

//если сессия не существует, то генерируется исключение
            if (out != null)
                out.print("Session disabled!");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("i/o failed: " + e);
        }
    }
}
