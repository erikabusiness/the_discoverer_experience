Algoritmo "projeto final"
const
   qtdClientes = 5
   qtdDestinos = 5
Var
   opcao, i, j, codCliente, codDestino: inteiro
   clientes: vetor [0..qtdClientes, 0..4] de caractere
   destinos: vetor [0..qtdDestinos, 0..2] de caractere

procedimento menu()
inicio
   limpatela
   escreval("Digite o numero correspondente com a opção: ")
   escreval("1 - Cadastrar cliente")
   escreval("2 - Cadastrar destino")
   escreval("3 - Consultar cliente")
   escreval("4 - Consultar destino")
   escreval("5 - Sair")
   leia(opcao)

   escolha (opcao)
   caso 1
      escreval("1 - Cadastrar cliente")
      cadastrarCliente()
   caso 2
      escreval("2 - Cadastrar destino")
      cadastrarDestino()
   caso 3
      escreval("3 - Consultar cliente")
      consultarCliente()
   caso 4
      escreval("4 - Consultar destino")
      consultarDestino()
   caso 5
      interrompa
   outrocaso
      escreval("Opção inválida. Tente novamente.")
      aguarde(2000)
      menu()
   fimescolha
fimprocedimento

procedimento cadastrarCliente()
inicio
   limpatela
   se codCliente < qtdClientes entao
      para j de 1 ate 4 faca
         escolha(j)
         caso 1
            escreval("Nome: ")
         caso 2
            escreval("Cidade: ")
         caso 3
            escreval("Idade: ")
         caso 4
            escreval("CPF: ")
         fimescolha
         leia(clientes[codCliente, j])
      fimpara
      codCliente <- codCliente + 1
      escreval("Cliente cadastrado com sucesso!")
   senao
      escreval("Todos os clientes já foram cadastrados!")
   fimse

   menu()
fimprocedimento

procedimento cadastrarDestino()
inicio
   limpatela
   se codDestino < qtdDestinos entao
      escreval("2 - Cadastrar destino")
      para j de 1 ate 2 faca
         escolha(j)
         caso 1
            escreval("Nome do destino: ")
         caso 2
            escreval("Descrição do destino: ")
         caso 3
            escreval("Preço do destino: ")
         fimescolha
         leia(destinos[codDestino, j-1])
      fimpara
      codDestino <- codDestino + 1
      escreval("Destino cadastrado com sucesso!")
   senao
      escreval("Todos os destinos já foram cadastrados!")
   fimse

   menu()
fimprocedimento

procedimento consultarCliente()
inicio
   limpatela
   escreval("Consultar cliente:")
   escreval("")
   para i de 0 ate qtdClientes faca
      se clientes[i, 1] <> "" entao
         escreva("Código: ", clientes[i, 0])
         escreva(" | Nome: ", clientes[i, 1])
         escreva(" | Cidade: ", clientes[i, 2])
         escreva(" | Idade: ", clientes[i, 3])
         escreva(" | CPF: ", clientes[i, 4])
         escreval("")
      fimse
   fimpara
   escreva("")
   escreva("Digite 1 para sair ou 2 para voltar ao menu anterior: ")
   leia(opcao)
   escolha(opcao)
   caso 1
      interrompa
   outrocaso
      menu()
   fimescolha
fimprocedimento

procedimento consultarDestino()
inicio
   limpatela
   escreval("Consultar destino:")
   escreval("")
   para i de 0 ate qtdDestinos faca
      se destinos[i, 0] <> "" entao
         escreva("Código: ", i)
         escreva(" | Nome do destino: ", destinos[i, 0])
         escreva(" | Descrição: ", destinos[i, 1])
         escreva(" | Preço: ", destinos[i, 2])
         escreval("")
      fimse
   fimpara
   escreva("")
   escreva("Digite 1 para sair ou 2 para voltar ao menu anterior: ")
   leia(opcao)
   escolha(opcao)
   caso 1
      interrompa
   outrocaso
      menu()
   fimescolha
fimprocedimento

Inicio
   codCliente <- 0
   codDestino <- 0
   menu()
Fimalgoritmo


