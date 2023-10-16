package aplicacao;

import java.util.Scanner;

import dao.PacotesDAO;
import model.Pacotes;

public class MainPacote {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		PacotesDAO pacoteDAO = new PacotesDAO();

		int opcao = 0, id = 0;


		do {

			System.out.println("\n============================== PACOTES =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();

			switch (opcao) {
			case 1:
				System.out.println("Digite o desconto do pacote:");
				double descPacote = s.nextDouble();
				s.nextLine();
				System.out.println("Digite o valor do pacote:");
				double valorPacote = s.nextDouble();
				s.nextLine();

				Pacotes pacote1 = new Pacotes(descPacote, valorPacote);

				pacoteDAO.create(pacote1);
				break;
			case 2:

				for (Pacotes p : pacoteDAO.read()) {
					System.out.println(p.toString());
				}

				break;
			case 3:

				System.out.println("Digite o id:");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Digite o desconto do pacote:");
				descPacote = s.nextDouble();
				s.nextLine();
				System.out.println("Digite o valor do pacote:");
				valorPacote = s.nextDouble();
				s.nextLine();

				Pacotes pacote2 = new Pacotes(id, descPacote, valorPacote);

				pacoteDAO.update(pacote2);
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();

				pacoteDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();

				Pacotes pacote3 = pacoteDAO.readById(id);

				System.out.println(pacote3.toString());
				break;
			default:

				break;
			}

		} while (opcao != 0);

		System.out.println("Até mais!");
		s.close();

	}

}
