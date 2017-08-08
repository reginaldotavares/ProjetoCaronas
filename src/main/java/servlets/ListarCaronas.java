/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entidades.Pesquisa;
import gerenciadores.GerenciadorDeCaronas;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Reginaldo
 */
public class ListarCaronas extends HttpServlet {

   private GerenciadorDeCaronas caronasGer = new GerenciadorDeCaronas();
    private Object FORMATTER;

    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        UsuarioDao dao = new UsuarioDao();
       request.setCharacterEncoding("UTF-8");
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/carona.jsp");
        String origem = request.getParameter("origem");
        String destino = request.getParameter("destino");
        String data = request.getParameter("data");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate lDate = LocalDate.parse(data, formatter);
        List<Pesquisa> lista = new ArrayList();
         try {
             lista = caronasGer.listarCaronas(origem, destino, lDate);
         } catch (SQLException ex) {
             Logger.getLogger(ListarCaronas.class.getName()).log(Level.SEVERE, null, ex);
         }
        request.setAttribute("caronas", lista);

        dispatcher.forward(request, response);

    }
}
