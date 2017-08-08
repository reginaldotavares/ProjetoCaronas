/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexao.ClasseConexao;
import conexao.ConnectionFactory;
import entidades.Carona;
import entidades.Pesquisa;
import entidades.Pontos;
import interfaces.CaronaDaoIF;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Reginaldo
 */
public class CaronaDao implements CaronaDaoIF {
    ConnectionFactory factory = new ConnectionFactory();
    ClasseConexao conexao = new ClasseConexao();
    Connection con;
    PreparedStatement pstm;
    
    public CaronaDao() {
        try {
            con = factory.getConnection();
        } catch (Exception e) {
        }
    }

    @Override
    public void inserir(Carona c) throws SQLException {
        try{ 
        conexao.abrir();
        String SQL = "insert into carona(idUsuario, origem, destino, distancia, horasaida, data, ajudadecusto) values (?,?,?,?,?,?,?)";
        pstm = con.prepareStatement(SQL);
        pstm.setInt(1, c.getIdUsuario());
        pstm.setString(2, c.getOrigem());
        pstm.setString(3, c.getDestino());
        pstm.setFloat(4, c.getDistancia());
        pstm.setTime(5, c.getHora());
        pstm.setDate(6, (java.sql.Date) c.getData());
        pstm.setFloat(7, c.getAjudaDeCusto());
        
        pstm.executeUpdate();
        }catch(SQLException e){
               System.out.println(e);
        }
           finally {
                conexao.liberar();
        }
    }
    
    public void inserirPonto(Pontos p) throws SQLException {
        try{ 
        conexao.abrir();
        String SQL = "insert into pontos_adicinais(idCarona, ponto) values (?,?)";
        pstm = con.prepareStatement(SQL);
        pstm.setInt(1, p.getIdCarona());
        pstm.setString(2, p.getPonto());
        
        pstm.executeUpdate();
        }catch(SQLException e){
               System.out.println(e);
        }
           finally {
                conexao.liberar();
        }
    }

   
    @Override
    public List<Carona> pesquisarCarona(String Origem, String Destino) throws SQLException {
         List<Carona> caronas = new ArrayList<Carona>();
        try {
            conexao.abrir();
            
            String SQL = "";
            
            pstm = con.prepareStatement(SQL);
            
            ResultSet result = pstm.executeQuery();            
            
            while(result.next()){
                Carona carona = new Carona();
                carona.setId(result.getInt("id"));
                carona.setIdUsuario(result.getInt("idusuario"));
                carona.setOrigem(result.getString("origem"));
                carona.setDestino(result.getString("destino"));
                carona.setHora(result.getTime("hora"));
                carona.setData(result.getDate("data"));
                carona.setAjudaDeCusto(result.getFloat("ajudadecusto"));
                
                caronas.add(carona);
            }
            return caronas;
            
        } catch(Exception E) { 
            E.printStackTrace();
        } finally {
            conexao.liberar();
        }
        return null;
    } 
    
    public List<Pesquisa> listarCarona(String origem, String destino, LocalDate data) throws SQLException {
        List<Pesquisa> pesquisas = new ArrayList<Pesquisa>();
        try {
            conexao.abrir();
            
            String sql = "SELECT u.nome, u.telefone, c.origem, c.destino, c.distancia, c.data, c.horasaida, c.ajudadecusto "
                    + "FROM carona c, usuario u, pontos_adicinais p "
                    + "WHERE (c.idUsuario = u.idUsuario and c.idCarona = p.idCarona) and (? ilike c.origem or p.ponto ilike ?) and ? = c.destino and ? = c.data";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, origem);
            pstm.setString(2, origem);
            pstm.setString(3, destino);
            pstm.setDate(4, java.sql.Date.valueOf(data));
            ResultSet result = pstm.executeQuery();
  
            while(result.next()){
                Pesquisa pesquisa = new Pesquisa();
                pesquisa.setNomeUsuario(result.getString("nome"));
                pesquisa.setTelefone(result.getString("telefone"));
                pesquisa.setOrigem(origem);
                pesquisa.setDestino(result.getString("destino"));
                pesquisa.setDistancia(result.getFloat("distancia"));
                pesquisa.setData(result.getDate("data").toLocalDate());
                pesquisa.setHora(result.getTime("horasaida").toLocalTime());
                pesquisa.setAjuda(result.getFloat("ajudadecusto"));
                LocalTime tempo = pesquisa.calculaHoraChegada();
                pesquisa.setViagem(tempo);
 
                pesquisas.add(pesquisa);
            }
            return pesquisas;
        } catch(Exception E) { 
            JOptionPane.showMessageDialog(null, E);
        } finally {
            conexao.liberar();
        }
        return null;
    }
    
    public Pesquisa pesquisar(int idCarona) throws SQLException {
        try {
            conexao.abrir();
            
            String SQL = "SELECT u.nome, u.telefone, c.origem, c.destino, c.distancia, c.data, c.horasaida, c.ajudadecusto "
                    + "FROM carona c, usuario u "
                    + "WHERE c.idCarona = "+ idCarona +" and c.idUsuario = u.idUsuario";
            
            pstm = con.prepareStatement(SQL);
            
            ResultSet result = pstm.executeQuery();
            
            
            Pesquisa pesquisa = new Pesquisa();
            while(result.next()){
                
                
                pesquisa.setNomeUsuario(result.getString("nome"));
                pesquisa.setNomeUsuario(result.getString("telefone"));
                pesquisa.setOrigem(result.getString("origem"));
                pesquisa.setDestino(result.getString("destino"));
                pesquisa.setDistancia(result.getFloat("distancia"));
                pesquisa.setData(result.getDate("distancia").toLocalDate());
                pesquisa.setHora(result.getTime("horasaida").toLocalTime());
                pesquisa.setAjuda(result.getFloat("ajudadecusto"));
                
            }
            return pesquisa;
            
        } catch(Exception E) { 
            E.printStackTrace();
        } finally {
            conexao.liberar();
        }
        return null;
    }
}
