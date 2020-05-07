package model.entidade;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {
	
	private Integer numQuarto;
	private Date entrada;
	private Date saida;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reserva(Integer numQuarto, Date entrada, Date saida) {
		this.numQuarto = numQuarto;
		this.entrada = entrada;
		this.saida = saida;
	}
	public Integer getNumQuarto() {
		return numQuarto;
	}
	public void setNumQuarto(Integer numQuarto) {
		this.numQuarto = numQuarto;
	}
	public Date getEntrada() {
		return entrada;
	}
	
	public Date getSaida() {
		return saida;
	}
	
	public long duracao() {
		long dif = saida.getTime() - entrada.getTime(); // calculando a diferença de horario
		return TimeUnit.DAYS.convert(dif,TimeUnit.MILLISECONDS); // converte milisegundos para dias 		
	}
	
	public void dataAtualizada(Date entrada, Date saida) {
		this.entrada = entrada;
		this.saida = saida;
	}
	@Override
	public String toString() {
		return " Quarto: " + numQuarto + ", entrada: " + sdf.format(entrada) 
				+ ", saida: " + sdf.format(saida)  + " (Total " + duracao() + " noites)";
	}
	
	
}











