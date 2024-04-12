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
import dao.IAnimauxDao;
import dao.AnimauxDaoImpl;
import metier.entities.Animaux;
import metier.entities.Classes;

@WebServlet(name = "controleurServ", urlPatterns = {"/controleur", "*.do"})
public class ControleurServlet extends HttpServlet {
    IAnimauxDao metier;
    IClassesDao metierClasses;

    @Override
    public void init() throws ServletException {
        metier = new AnimauxDaoImpl();
        metierClasses = new ClassesDaoImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        if (path.equals("/index.do")) {
            request.getRequestDispatcher("animaux.jsp").forward(request, response);
        }else if (path.equals("/editercal.do")) {
            request.getRequestDispatcher("animaux.jsp").forward(request, response);
	
        } 
        else if (path.equals("/chercher.do")) {
            String motCle = request.getParameter("motCle");
            AnimauxModele model = new AnimauxModele();
            model.setMotCle(motCle);
            List<Animaux> animaux = metier.animauxParMC(motCle);
            model.setAnimaux(animaux);
            request.setAttribute("model", model);
            request.getRequestDispatcher("animaux.jsp").forward(request, response);
        } else if (path.equals("/saisie.do")) {
            List<Classes> classes = metierClasses.getAllClasses();
            ClassesModele model = new ClassesModele();
            model.setClasses(classes);
            request.setAttribute("classesModel", model);
            request.getRequestDispatcher("saisieAnimaux.jsp").forward(request, response);
        } else if (path.equals("/save.do") && request.getMethod().equals("POST")) {
            String nom = request.getParameter("nom");
            Long classeId = Long.parseLong(request.getParameter("classe"));
            Classes classe = metierClasses.getClasses(classeId);
            Animaux animal = metier.save(new Animaux(nom, classe));
            request.setAttribute("animal", animal);
            response.sendRedirect("chercher.do?motCle=");
        } else if (path.equals("/supprimer.do")) {
            Long id = Long.parseLong(request.getParameter("id"));
            metier.deleteAnimal(id);
            response.sendRedirect("chercher.do?motCle=");
        }
        else if (path.equals("/editer.do")) {
            Long id = Long.parseLong(request.getParameter("id"));
            Animaux animal = metier.getAnimal(id);
            request.setAttribute("animal", animal);
            List<Classes> classes = metierClasses.getAllClasses();
            ClassesModele model = new ClassesModele();
            model.setClasses(classes);
            request.setAttribute("classesModel", model);
            request.getRequestDispatcher("editerAnimaux.jsp").forward(request, response);
        } if (path.equals("/update.do")) {
            String idParam = request.getParameter("id");
            String nom = request.getParameter("nom");
            String type = request.getParameter("type"); // Adding type parameter
            String classeIdParam = request.getParameter("classe");
            String ageParam = request.getParameter("age");

            // Parse parameters
            Long id = Long.parseLong(idParam);
            Long classeId = Long.parseLong(classeIdParam);
            float age = Float.parseFloat(ageParam); // Parsing age as float
            Classes classe = metierClasses.getClasses(classeId);
            
            
            Animaux animal = new Animaux();
            animal.setId(id);
            animal.setNom(nom);
            animal.setType(type); 
            animal.setAge(age);
            animal.setClasses(classe);
            metier.updateAnimal(animal);
            response.sendRedirect("chercher.do?motCle=");
        }
 else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
