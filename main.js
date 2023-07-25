window.addEventListener('scroll', onScroll)

const header = document.querySelector('#header')

function onScroll() {
  if (scrollY > 0) {
    header.classList.add("scrolled")
  } else {
    header.classList.remove("scrolled")
  }
}