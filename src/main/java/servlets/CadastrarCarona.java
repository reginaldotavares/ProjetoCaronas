/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import converterInformacao.ConverterData;
import gerenciadores.GerenciadorDeCaronas;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import conexao.ConnectionFactory;


/**
 *
 * @author Reginaldo
 */
public class CadastrarCarona extends HttpServlet {

    private GerenciadorDeCaronas caronaGer = new GerenciadorDeCaronas();
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
            request.setCharacterEncoding("UTF-8");
            ConverterData converter = new ConverterData();
            try {
                String id = request.getParameter("idUsuario");
                int idUsuario = Integer.parseInt(id);
                String[] origens = request.getParameter("origem").split(";");
                String origem = "";
	            origem += origens[0];
                String[] destinos = request.getParameter("destino").split(";");
                String destino = "";   
	            destino += destinos[0];
                String ajuda = request.getParameter("custo");
                String h = request.getParameter("hora");
                float ajudaDeCusto = Float.parseFloat(ajuda);
                String dat = h;
                SimpleDateFormat formatador = new SimpleDateFormat("HH:mm");
                Date d = formatador.parse(dat);
                Time hora = new Time(d.getTime());
                //Time hora = Time.valueOf(h);
                String data = request.getParameter("data"); 
                String[] dis = request.getParameter("distancia").split(" ");
                float distancia = Float.parseFloat(dis[0]);
                caronaGer.adicionarCarona(idUsuario, origem, destino, distancia, hora, converter.stringParaDate(data), ajudaDeCusto);
                if(!request.getParameter("pontos").equals("")){
                    Connection con = new ConnectionFactory().getConnection();
                    String sql = "select idcarona from carona where ((idusuario = ? and origem = ?) and (destino = ? and horasaida = ?)) and (data = ? and ajudadecusto = ?)";
                    PreparedStatement stmt = con.prepareStatement(sql);
                    stmt.setInt(1, idUsuario);
                    stmt.setString(2, origem);
                    stmt.setString(3, destino);
                    stmt.setTime(4, hora);
                    stmt.setDate(5, converter.stringParaDate(data));
                    stmt.setFloat(6, ajudaDeCusto);
                    ResultSet rs = stmt.executeQuery();
                    int idCarona = 0;
                    while(rs.next()) {
                    	idCarona = rs.getInt("idcarona");
                    }
                    stmt.close();
                    con.close();
                    String[] pontos = request.getParameter("pontos").split("; ");
                    for(int i = 0; i < pontos.length; i++) {
                    	caronaGer.adicionarPonto(idCarona, pontos[i]);
                    }
                }
                
                

            } catch (SQLException ex) {
            Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("principal.jsp").forward(request, response);
    }

   
}
