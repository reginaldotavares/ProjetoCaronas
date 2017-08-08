package servlets;


import entidades.Carona;
import entidades.Pesquisa;
import gerenciadores.GerenciadorDeCaronas;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Reginaldo
 */
public class AbrirCarona extends HttpServlet {
    
    private GerenciadorDeCaronas carGer = new GerenciadorDeCaronas();

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

   public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    
        request.setCharacterEncoding("UTF-8");

        String id = request.getParameter("idCarona");
        int idCarona = Integer.parseInt(id);
       
        RequestDispatcher dispatcher = request.getRequestDispatcher("carona.jsp");
        try{
            Pesquisa p = carGer.pesquisar(idCarona);
            request.setAttribute("pesquisa",p);
            dispatcher.forward(request, response);
        }catch(Exception ex){
            ex.printStackTrace();
        }

   }
}
