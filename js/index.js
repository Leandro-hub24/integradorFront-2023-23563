
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

document.querySelector(".menu > span").addEventListener("click", function () {
    enlacesHeader.classList.toggle("links2")
})

document.querySelector(".links1 > span").addEventListener("click", function () {
    enlacesHeader.classList.toggle("links2")
})

let est = document.getElementById("estudiante")
let tra = document.getElementById("trainee")
let jun = document.getElementById("junior")
let sel = document.getElementById("select")

const pre = 1000;
let cantidad = document.querySelector("#items")
let cant = cantidad.value
let val = sel.value
let tot = document.querySelector("#total")
let total

est.addEventListener("click", function () {
    sel.value = "1"
    cant = cantidad.value
    if (cant != "") {
        total = (pre * 0.2) * cant
        tot.textContent = `${total}`
    }
    if (cant == "") {
        tot.textContent = "0"
    }
})

tra.addEventListener("click", function () {
    sel.value = "2"
    cant = cantidad.value
    if (cant != "") {
        total = (pre * 0.5) * cant
        tot.textContent = `${total}`
    }
    if (cant == "") {
        tot.textContent = "0"
    }
})

jun.addEventListener("click", function () {
    sel.value = "3"
    cant = cantidad.value
    if (cant != "") {
        total = (pre * 0.85) * cant
        tot.textContent = `${total}`
    }
    if (cant == "") {
        tot.textContent = "0"
    }
})



cantidad.addEventListener("input", (e) => {
    cant = cantidad.value
    val = sel.value
    if (val == "1" && cant != "") {
        total = (pre * 0.2) * cant
        tot.textContent = `${total}`
    }

    if (val == "2" && cant != "") {
        total = (pre * 0.5) * cant
        tot.textContent = `${total}`
    }

    if (val == "3" && cant != "") {
        total = (pre * 0.85) * cant
        tot.textContent = `${total}`
    }

    if (cant == "") {
        tot.textContent = "0"
    }
})

sel.addEventListener("change", (e) => {
    if (e.target.value != "") {
        cant = cantidad.value
        val = e.target.value
        if (val == "1" && cant != "") {
            total = (pre * 0.2) * cant
            tot.textContent = `${total}`
        }

        if (val == "2" && cant != "") {
            total = (pre * 0.5) * cant
            tot.textContent = `${total}`
        }

        if (val == "3" && cant != "") {
            total = (pre * 0.85) * cant
            tot.textContent = `${total}`
        }

        if (cant == "") {
            tot.textContent = "0"
        }
    }
})
