package tpsi.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Schodek
 */


@WebServlet(name = "StudentServlet", urlPatterns = {"/StudentServlet"})
public class StudentServlet extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        HttpSession session = request.getSession();
            
            
        if (session.getAttribute("licznik") == null) {
            session.setAttribute("licznik", 1);
        } else {
            session.setAttribute("licznik", (Integer) session.getAttribute("licznik") + 1);
        }
        
         //request.getRequestDispatcher("students.jsp").forward(request, response);
    
         if (session.getAttribute("Lista_osob") == null) {
            List<Person> Lista_osob = new ArrayList<>();
            session.setAttribute("Lista_osob", Lista_osob);
        }
                 
    }    
    
   

     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);
        HttpSession session = request.getSession();
        
        /*if (session.getAttribute("licznik") == null) {
            session.setAttribute("licznik", 1);
        } else {
            session.setAttribute("licznik", (Integer) session.getAttribute("licznik") + 1);
        }*/

        request.getRequestDispatcher("students.jsp").forward(request, response);

    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        processRequest(request, response);
       
        List<Person> Lista_osob;
        String imie = request.getParameter("firstName");
        String nazwisko = request.getParameter("lastName");
        String email = request.getParameter("email");
        Person p = new Person(imie, nazwisko, email);

        Lista_osob = (ArrayList<Person>) session.getAttribute("Lista_osob");

        if (Lista_osob == null) {
            Lista_osob = new ArrayList<Person>();
        }

        Lista_osob.add(p);

        session.setAttribute("Lista_osob", Lista_osob);

        /*if (session.getAttribute("licznik") == null) {
            session.setAttribute("licznik", 1);
        } else {
            session.setAttribute("licznik", (Integer) session.getAttribute("licznik") + 1);
        }*/

        request.getRequestDispatcher("students.jsp").forward(request, response);
    }
    
    
    
    

}
