package aplicacao;

import java.util.Scanner;

import dao.DestinosDAO;
import dao.PacotesDAO;
import dao.ReservaDAO;
import dao.UsuarioDAO;
import model.Destinos;
import model.Pacotes;
import model.Reserva;
import model.Usuario;

public class MainReserva {
public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		ReservaDAO reservaDAO = new ReservaDAO();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		PacotesDAO pacoteDAO = new PacotesDAO();
		DestinosDAO destinoDAO = new DestinosDAO();
		
		int opcao = 0, id = 0; 
		
		
		do {
			
			System.out.println("\n============================== RESERVAS =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite a data do check in:");
				String dataCheckIn = s.nextLine();
				System.out.println("Digite a data do check out:");
				String dataCheckOut = s.nextLine();
				System.out.println("Digite o status da reserva:");
				boolean statusReserva = s.nextBoolean();
				System.out.println("Digite o id do pacote:");
				int idPacote = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id do destino:");
				int idDestino = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id do usuario:");
				int idUsuario = s.nextInt();
				s.nextLine();
				
				Usuario usuario1 = usuarioDAO.readById(idUsuario);
				Destinos destino1 = destinoDAO.readById(idDestino);
				Pacotes pacote1 = pacoteDAO.readById(idPacote);
				
				
				Reserva reserva1 = new Reserva(dataCheckIn,dataCheckOut, statusReserva, pacote1, destino1, usuario1);
				
				
				reservaDAO.create(reserva1);
				break;
			case 2:
				
				for (Reserva r : reservaDAO.read()) {
					
					System.out.println(r.toString());
					
				}
				
				break;
			case 3:
				System.out.println("Digite o id da reserva:");
				id = s.nextInt();
				s.nextLine();				
				System.out.println("Digite a data do check in:");
				dataCheckIn = s.nextLine();
				System.out.println("Digite a data do check out:");
				dataCheckOut = s.nextLine();
				System.out.println("Digite o status da reserva:");
				statusReserva = s.nextBoolean();
				System.out.println("Digite o id do pacote:");
				idPacote = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id do destino:");
				idDestino = s.nextInt();
				s.nextLine();
				System.out.println("Digite o id do usuario:");
				idUsuario = s.nextInt();
				s.nextLine();
				
				
				Usuario usuario2 = usuarioDAO.readById(idUsuario);
				Destinos destino2 = destinoDAO.readById(idDestino);
				Pacotes pacote2 = pacoteDAO.readById(idPacote);
				
				Reserva reserva2 = new Reserva(id, dataCheckIn,dataCheckOut, statusReserva, pacote2, destino2, usuario2);
				
				
				reservaDAO.update(reserva2);
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				reservaDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				Reserva reserva3 = reservaDAO.readById(id);
				
				System.out.println(reserva3.toString());
				break;
			default:
				System.out.println(opcao != 0 ? "Opção invalida, digite novamente" : "");
				break;
			}
			
		} while (opcao != 0);
		
		System.out.println("Até mais!");
		s.close();

	}
}
