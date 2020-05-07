package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidade.Reserva;

public class Programa {
	
	public static void main(String[] args) throws ParseException {
		
		Scanner tec = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.print("N�mero do quarto: ");
		int num = tec.nextInt();
		System.out.print("Data de entrada (dd/MM/yyyy): ");
		Date entrada = sdf.parse(tec.next());
		System.out.print("Data da sa�da (dd/MM/yyyy): ");
		Date saida = sdf.parse(tec.next());
		
		if(!saida.after(entrada)) {
			System.out.print("Erro na reserva: a data de sa�da deve ser posterior � data do entrada");
		}
		else {
			Reserva reserva = new Reserva(num, entrada, saida);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Atualizar dados de uma nova reserva:");
			System.out.print("Data de entrada (dd/MM/yyyy): ");
			entrada = sdf.parse(tec.next());
			System.out.print("Data da sa�da (dd/MM/yyyy): ");
			saida = sdf.parse(tec.next());
			
			Date agora = new Date();
			if(entrada.before(agora) || saida.before(agora)) {
				System.out.println("Erro na reserva: as datas da reserva para atualiza��o devem ser futuras");				
			}
			else if(!saida.after(entrada)) {
				System.out.print("Erro na reserva: a data de sa�da deve ser posterior � data do entrada");
			}
			else {
				reserva.dataAtualizada(entrada, saida);
				System.out.println("Reserva: " + reserva);
			}
			
		}
		
		tec.close();
		 
	}

}
