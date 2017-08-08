package entidades;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;

public class App {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Pesquisa p = new Pesquisa();
		p.setNomeUsuario("matheus");
		p.setOrigem("petrolina");
		p.setDestino("cajazeiras");
		p.setHora(LocalTime.now());
		p.setData(LocalDate.now());
		p.setDistancia(450);
		System.out.println(p.calculaHoraChegada());
	}

}
