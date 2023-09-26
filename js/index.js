// Menu

let enlacesHeader = document.querySelector(".links1");
/* let semaforo = true; */

/* document.querySelectorAll(".menu")[0].addEventListener("click", function(){
    if(semaforo){
        document.querySelectorAll(".menu")[0].style.color ="#000";
        semaforo = false;
    }else{
        document.querySelectorAll(".menu")[0].style.color ="#fff";
        semaforo = true;
    }
    enlacesHeader.classList.toggle("links2")
}) */

document.querySelector(".menu > span").addEventListener("click", function(){
    enlacesHeader.classList.toggle("links2")
})

document.querySelector(".links1 > span").addEventListener("click", function(){
    enlacesHeader.classList.toggle("links2")
})