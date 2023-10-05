
let enlacesHeader = document.querySelector(".links1")
/* let semaforo = true; */

/* document.querySelectorAll(".menu")[0].addEventListener("click", function(){
    if(semaforo){
        document.querySelectorAll(".menu")[0].style.color ="#000"
        semaforo = false
    }else{
        document.querySelectorAll(".menu")[0].style.color ="#fff"
        semaforo = true
    }
    enlacesHeader.classList.toggle("links2")
}) */

document.querySelector(".menu > span").addEventListener("click", function(){
    enlacesHeader.classList.toggle("links2")
})

document.querySelector(".links1 > span").addEventListener("click", function(){
    enlacesHeader.classList.toggle("links2")
})

let est = document.getElementById("estudiante")
let tra = document.getElementById("trainee")
let jun = document.getElementById("junior")
let sel = document.getElementById("select")

est.addEventListener("click", function(){
    sel.value = "1"
})
tra.addEventListener("click", function(){
    sel.value = "2"
})
jun.addEventListener("click", function(){
    sel.value = "3"
})

const pre = 1000;
let cant = document.getElementById("items")
let val = sel.value
let tot = document.getElementById("total") 

if(val == "1"){
let total = (pre*0.2)*cant
tot.innerHTML = total
}
