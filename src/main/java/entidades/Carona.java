/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Reginaldo
 */
public class Carona {
    private int id;
    private int idUsuario; 
    private String origem;
    private String destino;
    private float distancia;
    private Time hora;
    private Date data;
    private float ajudaDeCusto;

    public Carona() {
    }

	public Carona(int id, int idUsuario, String origem, String destino, float distancia, Time hora, Date data,
			float ajudaDeCusto) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.origem = origem;
		this.destino = destino;
		this.distancia = distancia;
		this.hora = hora;
		this.data = data;
		this.ajudaDeCusto = ajudaDeCusto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public float getDistancia() {
		return distancia;
	}

	public void setDistancia(float distancia) {
		this.distancia = distancia;
	}

	public Time getHora() {
		return hora;
	}

	public void setHora(Time hora) {
		this.hora = hora;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public float getAjudaDeCusto() {
		return ajudaDeCusto;
	}

	public void setAjudaDeCusto(float ajudaDeCusto) {
		this.ajudaDeCusto = ajudaDeCusto;
	}


    

    
    
}
