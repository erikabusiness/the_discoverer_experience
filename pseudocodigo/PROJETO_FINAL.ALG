Algoritmo "projeto final"
const
   qtdClientes = 5
   //qtdDestinos <-
   //qtdInfo
Var
   opcao, i,j, codCliente: inteiro
   clientes: vetor [0..qtdClientes, 0..5] de caractere

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
   caso 3
      escreval("3 - Consultar cliente")
      consultarCliente()
   caso 4
      escreval("4 - Consultar destino")
   caso 5
      interrompa
   outrocaso
      menu()
   fimescolha
fimprocedimento

procedimento cadastrarCliente()
inicio
   limpatela
   escreval("1 - Cadastrar cliente")
   se codCliente <= qtdClientes entao
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
         leia(clientes[codCliente,j])
      fimpara
      clientes [codCliente,0] <- numpcarac(codCliente+1)
      codCliente <- codCliente+1
   senao
      escreval("Todos os clientes já foram cadastrados!")
   fimse
   escreva("Digite 1 para sair ou 2 para voltar ao menu anterior: ")
   leia(opcao)
   escolha (opcao)
   caso 1
      interrompa
   outrocaso
      menu()
   fimescolha

fimprocedimento

procedimento consultarCliente()
inicio
   limpatela
   escreval("Consutar cliente: ")
   para i de 0 ate qtdClientes faca
      para j de 0 ate 4 faca
         se clientes [i,0] <> "" entao
            escolha (j)
            caso 0
               escreva("Codigo: ")
            caso 1
               escreva("Nome: ")
            caso 2
               escreva("Cidade: ")
            caso 3
               escreva("Idade: ")
            caso 4
               escreva("CPF: ")
            fimescolha
            escreval(clientes [i, j])
         fimse
      fimpara
      escreval("")
   fimpara
   escreva("Digite 1 para sair ou 2 para voltar ao menu anterior: ")
   leia(opcao)
   escolha (opcao)
   caso 1
      interrompa
   outrocaso
      menu()
   fimescolha


fimprocedimento




Inicio
   codCliente <- 0
   menu()






Fimalgoritmo