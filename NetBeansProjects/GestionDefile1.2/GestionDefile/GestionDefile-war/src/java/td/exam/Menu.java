/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package td.exam;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import td.exam.BeansEntite.*;
import td.exam.BeansSession.*;
import td.exam.Facades.CouturierFacadeLocal;
import td.exam.Facades.LieuFacadeLocal;

/**
 *
 * @author Meriem
 */
@WebServlet(name = "Menu", urlPatterns = {"/Menu"})
public class Menu extends HttpServlet {

    @EJB
    private CouturierFacadeLocal couturierFacade;

    @EJB
    private LieuFacadeLocal lieuFacade;

    GestionOrganisateurLocal gestionOrganisateur = lookupGestionOrganisateurLocal();
    GestionMannequinLocal gestionMannequin = lookupGestionMannequinLocal();
    GestionCouturierLocal gestionCouturier = lookupGestionCouturierLocal();
    GestionPublicLocal gestionPublic = lookupGestionPublicLocal();
    GestionAdminLocal gestionAdmin = lookupGestionAdminLocal();
    
  

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String jspClient = null;
        String act = request.getParameter("action");
        
            if((act == null) || (act.equals("null")))
            {
                    jspClient="/Accueil.jsp";
                    
            }else if (act.equals("home")){
                
                Personne p = gestionPublic.getP();
                if(p != null){
                    if(p instanceof Couturier){
                        jspClient="/MenuCouturier.jsp";
                    }else if(p instanceof Mannequin){
                        jspClient="/MenuMannequin.jsp";
                    }else if(p instanceof Organisateur){
                        jspClient="/MenuOrganisateur.jsp";
                    }
                }else{
                    jspClient="/Accueil.jsp";
                }
                
            }else if(act.equals("demandeLogin")){
                
                String login = request.getParameter("login");
                String pass = request.getParameter("password");
                
                if(login.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("admin")){
                    
                    jspClient="/MenuAdmin.jsp";
                    
                }else{
                    Personne p = gestionPublic.authentification(login, pass);
                
                    if(p instanceof Couturier){
                        jspClient="/MenuCouturier.jsp";
                        gestionCouturier.setPersonne(p);
                    }else if(p instanceof Mannequin){
                        jspClient="/MenuMannequin.jsp";
                        gestionMannequin.setPersonne(p);
                    }else if(p instanceof Organisateur){
                        jspClient="/MenuOrganisateur.jsp";
                        gestionOrganisateur.setPersonne(p);
                    }else if(p == null){
                      //Erreur authentification
                        jspClient="/Accueil.jsp";
                        request.setAttribute("message", "Erreur d'authentification. Réessayez !");
                   }
                }
            }else if(act.equals("creerCouturier")){
                
                jspClient="/SaisirCouturier.jsp";
                doActionCreerCouturier(request,response);
                
            }else if(act.equals("creerOrganisateur")){
                
                jspClient="/SaisirOrganisateur.jsp";
                doActionCreerOrganisateur(request,response);
                
            }else if(act.equals("creerMannequin")){
                
                jspClient="/SaisirMannequin.jsp";
                doActionCreerMannequin(request,response);
                
            }else if(act.equals("creerVetement")){
                
                jspClient="/SaisirVetement.jsp";
                doActionCreerVetement(request,response);
                
            }else if(act.equals("newDefile")){
                
                jspClient="/SaisirDefile.jsp";
                Collection<Lieu> listLieu = lieuFacade.rechercherLieux();
                Collection<Couturier> listCout = couturierFacade.rechercherCouturiers();
                request.setAttribute("listeLieux", listLieu);
                request.setAttribute("listeCouturiers", listCout);
                
            }else if (act.equals("creerDefile")){
                
                jspClient="/SaisirDefile.jsp";
                doActionCreerDefile(request,response);
                
            }
             
            
        RequestDispatcher Rd;
        Rd = getServletContext().getRequestDispatcher(jspClient);
        Rd.forward(request, response);
  
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Menu</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Menu at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    private void doActionCreerCouturier(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String adresse = request.getParameter("adresse");
        String telephone = request.getParameter("telephone");
        String login = request.getParameter("login");
        String pass = request.getParameter("password");
        String message;
        
        
        if(nom.trim().isEmpty() || prenom.trim().isEmpty() || adresse.trim().isEmpty() || telephone.trim().isEmpty() || login.trim().isEmpty() || pass.trim().isEmpty()){
            message = "Erreur - Vous n'avez pas renseigné tous les champs obligatoires" 
                    + "<br/><a href=\"SaisirCouturier.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un couturier.";
        } else {
            gestionAdmin.creerCouturier(nom, prenom, adresse,telephone, login, pass);
            message = "Couturier créé avec succès !";
        }
        
        request.setAttribute("message", message);
        //Collection<Article> list = gestion.rechercherArticlesFrs(id_four);
        //request.setAttribute("listearticles", list);
    }
    
    private void doActionCreerOrganisateur(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String raisonSociale = request.getParameter("raisonSociale");
        String adresse = request.getParameter("adresse");
        String telephone = request.getParameter("telephone");
        String login = request.getParameter("login");
        String pass = request.getParameter("password");
        String message;
        
        
        if( raisonSociale.trim().isEmpty() || adresse.trim().isEmpty() || telephone.trim().isEmpty() || login.trim().isEmpty() || pass.trim().isEmpty()){
            message = "Erreur - Vous n'avez pas renseigné tous les champs obligatoires" 
                    + "<br/><a href=\"SaisirOrganisateur.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un organisateur.";
        } else {
            gestionAdmin.creerOrganisateur(raisonSociale, adresse, telephone, login, pass);
            message = "Organisateur créé avec succès !";
        }
        
        request.setAttribute("message", message);
    }
    
    private void doActionCreerMannequin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String adresse = request.getParameter("adresse");
        String telephone = request.getParameter("telephone");
        String login = request.getParameter("login");
        String pass = request.getParameter("password");
        double salaire = Double.parseDouble(request.getParameter("salaire"));
        String message;
        
        
        if( nom.trim().isEmpty() || prenom.trim().isEmpty() || adresse.trim().isEmpty() || telephone.trim().isEmpty() || login.trim().isEmpty() || pass.trim().isEmpty()){
            message = "Erreur - Vous n'avez pas renseigné tous les champs obligatoires" 
                    + "<br/><a href=\"SaisirMannequin.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un mannequin.";
        } else {
            gestionAdmin.creerMannequin(nom, prenom, adresse, telephone, login, pass, salaire);
            message = "Mannequin créé avec succès !";
        }
        
        request.setAttribute("message", message);
    }
    
    private void doActionCreerVetement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String date_c = request.getParameter("dateCreation");
        Date dateCreation = Date.valueOf(date_c);
        String libelle = request.getParameter("libelle");
        String taille = request.getParameter("taille");
        String colori = request.getParameter("colori");
        String matiere = request.getParameter("matiere");
        int position = Integer.parseInt(request.getParameter("position"));
        Couturier couturier = (Couturier)gestionCouturier.getPersonne();
        String message;
        
        
        if( libelle.trim().isEmpty() || taille.trim().isEmpty() || colori.trim().isEmpty() || matiere.trim().isEmpty()){
            message = "Erreur - Vous n'avez pas renseigné tous les champs obligatoires" 
                    + "<br/><a href=\"SaisirVetement.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un vêtement.";
        } else {
            gestionCouturier.creerVetement(dateCreation, libelle, couturier, taille, colori, matiere, position);
            message = "Vêtement créé avec succès !";
        }
        
        request.setAttribute("message", message);
    }
    
    private void doActionCreerDefile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String date_d = request.getParameter("dateDefile");
        Date dateDefile = Date.valueOf(date_d);
        String nom = request.getParameter("nom");
        Organisateur orga = (Organisateur)gestionOrganisateur.getPersonne();
        
        Long lieuId = Long.parseLong(request.getParameter("lieu"));
        Lieu lieu = lieuFacade.rechercheLieuId(lieuId);
        Long coutId = Long.parseLong(request.getParameter("couturier"));
        Couturier cout = couturierFacade.rechercheCouturierId(coutId);
        
        String message;
        
        
        //if( dateDefile == null || nom == null || orga == null || lieu == null || cout == null ||){
            //message = "Erreur - Vous n'avez pas renseigné tous les champs obligatoires" 
            //        + "<br/><a href=\"SaisirVetement.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un vêtement.";
        //} else {
            gestionOrganisateur.creerDefile(dateDefile, nom, orga, lieu, cout);
            message = "Vêtement créé avec succès !";
        //}
        
        request.setAttribute("message", message);
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private GestionAdminLocal lookupGestionAdminLocal() {
        try {
            Context c = new InitialContext();
            return (GestionAdminLocal) c.lookup("java:global/GestionDefile/GestionDefile-ejb/GestionAdmin!td.exam.BeansSession.GestionAdminLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private GestionPublicLocal lookupGestionPublicLocal() {
        try {
            Context c = new InitialContext();
            return (GestionPublicLocal) c.lookup("java:global/GestionDefile/GestionDefile-ejb/GestionPublic!td.exam.BeansSession.GestionPublicLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private GestionCouturierLocal lookupGestionCouturierLocal() {
        try {
            Context c = new InitialContext();
            return (GestionCouturierLocal) c.lookup("java:global/GestionDefile/GestionDefile-ejb/GestionCouturier!td.exam.BeansSession.GestionCouturierLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private GestionMannequinLocal lookupGestionMannequinLocal() {
        try {
            Context c = new InitialContext();
            return (GestionMannequinLocal) c.lookup("java:global/GestionDefile/GestionDefile-ejb/GestionMannequin!td.exam.BeansSession.GestionMannequinLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    private GestionOrganisateurLocal lookupGestionOrganisateurLocal() {
        try {
            Context c = new InitialContext();
            return (GestionOrganisateurLocal) c.lookup("java:global/GestionDefile/GestionDefile-ejb/GestionOrganisateur!td.exam.BeansSession.GestionOrganisateurLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    

    

    

    

    

    

}
