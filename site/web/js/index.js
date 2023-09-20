import { onScroll } from "../../main.js";
import { BtnsHome, CardHome, Header } from "../components/index.js";
import { btnsHome, cardHome } from "../constants/data.js";

const header = document.querySelector("header");
const divCardHome = document.querySelector("#cardsHome")
const divBtnsHome = document.querySelector("#btnsHome")
window.addEventListener("scroll", () => {
  onScroll(header);
});

header.innerHTML = Header();

cardHome.map((destino) => {
  divCardHome.innerHTML += CardHome(destino)     //escreve no html o conteudo da variavel cardsHome
})

btnsHome.map((botao) => {
  divBtnsHome.innerHTML += BtnsHome(botao)
})