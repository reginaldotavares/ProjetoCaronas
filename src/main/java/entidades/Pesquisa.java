package entidades;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Pesquisa {
	private String nomeUsuario;
	private String origem;
	private String destino;
	private float distancia;
	private LocalDate data;
	private LocalTime hora;
	private float ajuda;
	
	
	
	public Pesquisa() {
	}

	public Pesquisa(String nomeUsuario, String origem, String destino, float distancia, LocalDate data, LocalTime hora,
			float ajuda) {
		this.nomeUsuario = nomeUsuario;
		this.origem = origem;
		this.destino = destino;
		this.distancia = distancia;
		this.data = data;
		this.hora = hora;
		this.ajuda = ajuda;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
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

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	public float getAjuda() {
		return ajuda;
	}

	public void setAjuda(float ajuda) {
		this.ajuda = ajuda;
	}
	
	public LocalTime calculaHoraChegada() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("H:mm:ss");
		float tempo = distancia/100;
		int hours = (int) tempo;
		int minutes = (int) (60 * (tempo - hours));
		String t = hours+":"+minutes;
		LocalTime horas = LocalTime.parse(t);
		LocalTime soma = horas.plusHours(hora.getHour()).plusMinutes(hora.getMinute());
		return soma;
	}
	
}
