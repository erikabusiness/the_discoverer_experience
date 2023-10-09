import { onScroll } from "../../main.js";
import { BtnsHome, CardHome, Footer, Header } from "../components/index.js";
import { btnsHome, cardHome } from "../constants/data.js";

const header = document.querySelector("header");
const divCardHome = document.querySelector("#cardsHome")
const divBtnsHome = document.querySelector("#btnsHome")
const footer = document.querySelector("footer")

window.addEventListener("scroll", () => {
  onScroll(header);
});

header.innerHTML = Header();

cardHome.map((destino) => {
  divCardHome.innerHTML += CardHome(destino)     
})

btnsHome.map((botao) => {
  divBtnsHome.innerHTML += BtnsHome(botao)
})


footer.innerHTML = Footer()