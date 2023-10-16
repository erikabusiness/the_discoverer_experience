package aplicacao;

import java.util.Scanner;

import dao.UsuarioDAO;
import model.Usuario;

public class Main {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		int opcao = 0, id = 0; 
		
		String nome, email, senha, cpf, localizacao;
		
		
		do {
			
			System.out.println("\n============================== USUARIOS =================================\n");
			System.out.println("1-CRIAR   2-CONSULTAR   3-ATUALIZAR   4-DELETAR   5-CONSULTAR POR ID  0-SAIR");
			opcao = s.nextInt();
			s.nextLine();
			
			switch (opcao) {
			case 1:
				System.out.println("Digite a senha:");
				senha = s.nextLine();
				System.out.println("Digite o email:");
				email = s.nextLine();
				System.out.println("Digite o CPF:");
				cpf = s.nextLine();
				System.out.println("Digite o nome:");
				nome = s.nextLine();
				System.out.println("Digite a localização:");
				localizacao = s.nextLine();

				Usuario usuario1 = new Usuario(senha, email, cpf, nome, localizacao);
				
				usuarioDAO.create(usuario1);
				break;
			case 2:
				
				for (Usuario u : usuarioDAO.read()) {
					System.out.println(u.toString());
				}
				
				break;
			case 3:
				
				System.out.println("Digite o id:");
				id = s.nextInt();
				s.nextLine();
				System.out.println("Digite a senha:");
				senha = s.nextLine();
				System.out.println("Digite o email:");
				email = s.nextLine();
				System.out.println("Digite o CPF:");
				cpf = s.nextLine();
				System.out.println("Digite o nome:");
				nome = s.nextLine();
				System.out.println("Digite a localização:");
				localizacao = s.nextLine();
				
				
				Usuario usuario2 = new Usuario(id, senha, email, cpf, nome, localizacao);
				
				usuarioDAO.update(usuario2);
				break;
			case 4:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				usuarioDAO.delete(id);
				break;
			case 5:
				System.out.println("Digite um id:");
				id = s.nextInt();
				s.nextLine();
				
				Usuario usuario3 = usuarioDAO.readById(id);
				
				System.out.println(usuario3.toString());
				break;
			default:
				
				break;
			}
			
		} while (opcao != 0);
		
		System.out.println("Até mais!");
		s.close();

	}

	

}
