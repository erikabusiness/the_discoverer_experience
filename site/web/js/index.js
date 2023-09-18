import { onScroll } from "../../main.js";
import { Header } from "../components/Header.js";

const header = document.querySelector("header");
window.addEventListener("scroll", () => {
  onScroll(header);
});

header.innerHTML = Header();
