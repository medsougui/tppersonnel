package web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ClassesDaoImpl;
import dao.IClassesDao;
import metier.entities.Classes;

@WebServlet(name = "classesServ", urlPatterns = {"/classes", "/saisieClasse", "/saveClasse", "/supprimerClasse", "/editerClasse", "/updateClasse"})
public class ClassesServlet extends HttpServlet {
    IClassesDao metier;

    @Override
    public void init() throws ServletException {
        metier = new ClassesDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        System.out.println("PATH " + path);
        if (path.equals("/classes")) {
            ClassesModele model = new ClassesModele();
            List<Classes> classes = metier.getAllClasses();
            model.setClasses(classes);
            request.setAttribute("model", model);
            request.getRequestDispatcher("classes.jsp").forward(request, response);
        } else if (path.equals("/saisieClasse")) {
            request.getRequestDispatcher("saisieClasse.jsp").forward(request, response);
        } else if (path.equals("/saveClasse") && request.getMethod().equals("POST")) {
            String nom = request.getParameter("nom");
            Classes classe = metier.save(new Classes(nom));
            request.setAttribute("classe", classe);
            response.sendRedirect("classes");
        } else if (path.equals("/supprimerClasse")) {
            Long id = Long.parseLong(request.getParameter("id"));
            metier.deleteClasses(id);
            response.sendRedirect("classes");
        } else if (path.equals("/editerClasse")) {
            Long id = Long.parseLong(request.getParameter("id"));
            Classes classe = metier.getClasses(id);
            request.setAttribute("classe", classe);
            request.getRequestDispatcher("editerClasse.jsp").forward(request, response);
        } else if (path.equals("/updateClasse")) {
            Long id = Long.parseLong(request.getParameter("id"));
            String nom = request.getParameter("nom");
            Classes classe = new Classes();
            classe.setId(id);
            classe.setNomClass(nom);
            metier.updateClasses(classe);
            response.sendRedirect("classes");
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
