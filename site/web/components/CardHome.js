
export const CardHome = ({img, title}) => {
    return `
    <div class="col-4 text-center">
    <img src="../assets/home/${img}.jpg" class="img-fluid rounded-custom" alt="${title}">
    <div class="caption my-3"><h3>${title}</h3></div>
    </div>
    `
}