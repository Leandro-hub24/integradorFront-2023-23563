
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
        tot.innerHTML = `${total}`
    }
    if (cant == "") {
        tot.innerHTML = "0"
    }

    est.classList.toggle("vibrate")

    setTimeout(() => {
        est.classList.toggle("vibrate");
    }, 2000);
})

tra.addEventListener("click", function () {
    sel.value = "2"
    cant = cantidad.value
    if (cant != "") {
        total = (pre * 0.5) * cant
        tot.innerHTML = `${total}`
    }
    if (cant == "") {
        tot.innerHTML = "0"
    }

    tra.classList.toggle("vibrate")

    setTimeout(() => {
        tra.classList.toggle("vibrate");
    }, 2000);
})

jun.addEventListener("click", function () {
    sel.value = "3"
    cant = cantidad.value
    if (cant != "") {
        total = (pre * 0.85) * cant
        tot.innerHTML = `${total}`
    }
    if (cant == "") {
        tot.innerHTML = "0"
    }

    jun.classList.toggle("vibrate")

    setTimeout(() => {
        jun.classList.toggle("vibrate");
    }, 2000);

})



cantidad.addEventListener("input", (e) => {
    cant = cantidad.value
    val = sel.value
    if (val == "1" && cant != "") {
        total = (pre * 0.2) * cant
        tot.innerHTML = `${total}`
    }

    if (val == "2" && cant != "") {
        total = (pre * 0.5) * cant
        tot.innerHTML = `${total}`
    }

    if (val == "3" && cant != "") {
        total = (pre * 0.85) * cant
        tot.innerHTML = `${total}`
    }

    if (cant == "") {
        tot.innerHTML = "0"
    }

    if (isNaN(cant)) {
        tot.innerHTML = "0"
        alert("Ingrese un número por favor")
    }
})

sel.addEventListener("change", (e) => {
    if (e.target.value != "") {
        cant = cantidad.value
        val = e.target.value
        if (val == "1" && cant != "") {
            total = (pre * 0.2) * cant
            tot.innerHTML = `${total}`
        }

        if (val == "2" && cant != "") {
            total = (pre * 0.5) * cant
            tot.innerHTML = `${total}`
        }

        if (val == "3" && cant != "") {
            total = (pre * 0.85) * cant
            tot.innerHTML = `${total}`
        }

        if (cant == "") {
            tot.innerHTML = "0"
        }
    }
})

document.getElementById("delete").addEventListener("click", (e) => {
    tot.innerHTML = "0"
})

let nombre = document.getElementById("name")
let apellido = document.getElementById("lastName")
let mail = document.getElementById("mail")
let nom = nombre.value
let ape = apellido.value
let ma = mail.value

document.getElementById("resum").addEventListener("click", (e) => {
    nom = nombre.value
    ape = apellido.value
    ma = mail.value
    if (nom != "" && ape != "" && ma != "" && cant != "") {
        let opcion = confirm("¿Desea realizar la compra?")
    }

    if (opcion == "true"){

    }
})


