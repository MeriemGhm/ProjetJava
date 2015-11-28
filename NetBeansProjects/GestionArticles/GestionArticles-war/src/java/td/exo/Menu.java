
package td.exo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Meriem
 */
@WebServlet(name = "Menu", urlPatterns = {"/Menu"})
public class Menu extends HttpServlet {
    @EJB
    private GestionLocal gestion;

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
                jspClient="/Choix.jsp";
            }else if(act.equals("creerF")){
                jspClient="/SaisirFrs.jsp";
            }else if(act.equals("insererF")){
                jspClient="/AfficherFrs.jsp";
                doActionInsererF(request,response);
            }else if (act.equals("afficherFrs")){
                jspClient="/AfficherFrs.jsp";
                Collection<Fournisseur> list = gestion.afficherFournisseurs();
                request.setAttribute("listefournisseurs", list);
                request.setAttribute("message", "Liste des fournisseurs existants");
            }else if(act.equals("creerA")){
                jspClient="/CreerArticle.jsp";
                doActionCreerArt(request,response);
            }else if(act.equals("creerV")){
                jspClient="/CreerVetement.jsp";
                doActionCreerVet(request,response);
            }else if(act.equals("creerF")){
                jspClient="/CreerFraicheur.jsp";
                doActionCreerFraich(request,response);
            }else if(act.equals("afficherArtFrs")){
                jspClient="/RechercherArticlesFrs.jsp";
            }else if(act.equals("rechArtFrs")){
                jspClient="/AfficherArticlesFrs.jsp";
                long num_four = Long.parseLong(request.getParameter("numFour"));
                Collection<Article> list = gestion.rechercherArticlesFrs(num_four);
                request.setAttribute("listearticles", list);
                request.setAttribute("message", "Liste des article existants du fournisseur");
            }
            
        RequestDispatcher Rd;
        Rd = getServletContext().getRequestDispatcher(jspClient);
        Rd.forward(request, response);
        
        String nom = request.getParameter("nomFournisseur");
        String adresse = request.getParameter("adresseFournisseur");
        String type = request.getParameter("type");
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Menu</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet Menu at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    protected void doActionInsererF(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nom = request.getParameter("nomFournisseur");
        String adresse = request.getParameter("adresseFournisseur");
        String type = request.getParameter("type");
        String message;
        
        if(nom.trim().isEmpty() || adresse.trim().isEmpty()){
            message = "Erreur - Vous n'avez pas renseigné tous les champs obligatoires" 
                    + "<br/><a href=\"SaisirFrs.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un fournisseur.";
        } else {
            gestion.creerFournisseur(nom, adresse, type);
            message = "Fournisseur créé avec succès !";
        }
        
        request.setAttribute("message", message);
        Collection<Fournisseur> list = gestion.afficherFournisseurs();
        request.setAttribute("listefournisseur", list);
        
    }
    
    private void doActionCreerArt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String des = request.getParameter("designationArticle");
        double prix = Double.parseDouble(request.getParameter("prixArticle"));
        String type = request.getParameter("typeArticle");
        long id_four = Long.parseLong(request.getParameter("frsArticle"));
        String message;
        
        
        if(des.trim().isEmpty() || type.trim().isEmpty()){
            message = "Erreur - Vous n'avez pas renseigné tous les champs obligatoires" 
                    + "<br/><a href=\"CreerArticle.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un article.";
        } else {
            gestion.creerArticle(des, prix, type,id_four);
            message = "Article créé avec succès !";
        }
        
        request.setAttribute("message", message);
        Collection<Article> list = gestion.rechercherArticlesFrs(id_four);
        request.setAttribute("listearticles", list);
    }

    private void doActionCreerVet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String des = request.getParameter("designationVet");
        String p = request.getParameter("prixVet");
        double prix = Double.valueOf(p);
        String type = request.getParameter("typeVet");
        String colori = request.getParameter("coloriVet");
        long id_four = Long.parseLong(request.getParameter("frsVet"));
        String message;
        
        
        if(des.trim().isEmpty() || type.trim().isEmpty() || colori.trim().isEmpty()){
            message = "Erreur - Vous n'avez pas renseigné tous les champs obligatoires" 
                    + "<br/><a href=\"CreerVetement.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un vêtement.";
        } else {
            gestion.creerVetement(des, prix, type,id_four, colori);
            message = "Vêtement créé avec succès !";
        }
        
        request.setAttribute("message", message);
        Collection<Vetement> list = gestion.rechercherVetementsFrs(id_four);
        request.setAttribute("listevetements", list);
    }

    private void doActionCreerFraich(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String des = request.getParameter("designationProd");
        String p = request.getParameter("prixProd");
        double prix = Double.valueOf(p);
        String type = request.getParameter("typeProd");
        String date = request.getParameter("limitProd");
        Date limite = Date.valueOf(date);
        long id_four = Long.parseLong(request.getParameter("frsProd"));
        String message;
        
        
        if(des.trim().isEmpty() || type.trim().isEmpty()){
            message = "Erreur - Vous n'avez pas renseigné tous les champs obligatoires" 
                    + "<br/><a href=\"CreerFraicheur.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un produit frais.";
        } else {
            gestion.creerFraicheur(des, prix, type, id_four, limite);
            message = "Produit frais créé avec succès !";
        }
        
        request.setAttribute("message", message);
        Collection<Fraicheur> list = gestion.rechercherFraicheurFrs(id_four);
        request.setAttribute("listefraicheur", list);
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

    

}
