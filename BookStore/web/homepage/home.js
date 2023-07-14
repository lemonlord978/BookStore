let menu = document.querySelector("#menu-icon");
let navbar = document.querySelector(".navbar");

menu.onclick = () => {
    navbar.classList.toggle('open');
};

let filtericon = document.querySelector("#filter-icon");
let filternav = document.querySelector(".filter");

filtericon.onclick = () => {
    filternav.classList.toggle('open_filter');
};

let searchicon = document.querySelector("#search_icon");
let searchnav = document.querySelector(".search_container");

searchicon.onclick = () => {
    searchnav.classList.toggle('open_search');
}


