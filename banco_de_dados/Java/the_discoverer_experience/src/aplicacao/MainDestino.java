package aplicacao;

import java.util.Scanner;

import dao.DestinosDAO;
import model.Destinos;

public class MainDestino {
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		DestinosDAO destinoDAO = new DestinosDAO();

		int opcao = 0, id = 0;


		do {

			System.out.println("\n============================== DESTINOS =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();

			switch (opcao) {
			case 1:
				System.out.println("Digite o seu destino:");
				String nomeDestino = s.nextLine();
				System.out.println("Digite a sua avaliação:");
				int avaliacao = s.nextInt();
				s.nextLine();

				Destinos destino1 = new Destinos(nomeDestino, avaliacao);

				destinoDAO.create(destino1);
				break;
			case 2:

				for (Destinos d : destinoDAO.read()) {
					System.out.println(d.toString());
				}

				break;
			case 3:

				System.out.println("Digite o id:");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Digite o seu destino:");
				nomeDestino = s.nextLine();
				System.out.println("Digite a sua avaliação:");
				avaliacao = s.nextInt();
				s.nextLine();

				Destinos destino2 = new Destinos(id, nomeDestino, avaliacao);

				destinoDAO.update(destino2);
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();

				destinoDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();

				Destinos destino3 = destinoDAO.readById(id);

				System.out.println(destino3.toString());
				break;
			default:

				break;
			}

		} while (opcao != 0);

		System.out.println("Até mais!");
		s.close();

	}
}
