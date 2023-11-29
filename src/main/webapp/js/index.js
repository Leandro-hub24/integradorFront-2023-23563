/**
 * 
 */
// veo si vienen parametros - si es vienen es por que llame actualizar
const valores = window.location.search;
const urlParams = new URLSearchParams(valores);
const id = urlParams.get('id');
const id1 = urlParams.get('id1');
const id2 = urlParams.get('id2');
const nombre = urlParams.get('nombre');
const apellido = urlParams.get('apellido');
const cuit = urlParams.get('cuit');
const razon = urlParams.get('razon');
const idCli = urlParams.get('idCli');
const idTec = urlParams.get('idTec');
const tipoInci = urlParams.get('tipoInci');
const descripInci = urlParams.get('descripInci');


if (id != null){
	window.addEventListener('load', () => {
   // Ejecuta manualmente el evento de click de tu elemento
    document.getElementById("botonCliente").click()
})
	abrirNuevo()
	document.getElementById("form-nuevo").className = "row";
	document.getElementById("form-action").setAttribute('action', 'ActCliente')
	document.getElementById("id").className = "form-control" 
	document.getElementById("id").value = id
	document.getElementById("nombre").value = nombre
	document.getElementById("apellido").value = apellido
	document.getElementById("cuit").value = cuit
	document.getElementById("razon").value = razon
	document.getElementById("exampleModalLabel").innerHTML = "ACTUALIZA REGISTRO ID " + id
	
	
}



if (id1 != null){
	
	window.addEventListener('load', () => {
   // Ejecuta manualmente el evento de click de tu elemento
   document.getElementById("botonTecnico").click()
})
	abrirNuevo1()
	document.getElementById("form-nuevo").className = "row";
	document.getElementById("form-action").setAttribute('action', 'ActTecnico')
	document.getElementById("id").className = "form-control" 
	document.getElementById("id").value = id1
	document.getElementById("nombre").value = nombre
	document.getElementById("apellido").value = apellido
	document.getElementById("exampleModalLabel").innerHTML = "ACTUALIZA REGISTRO ID " + id1
	
}

if (id2 != null){
	
	window.addEventListener('load', () => {
   // Ejecuta manualmente el evento de click de tu elemento
   document.getElementById("botonIncidente").click()
})
	abrirNuevo2()
	document.getElementById("form-nuevo").className = "row";
	document.getElementById("form-action").setAttribute('action', 'ActIncidente')
	document.getElementById("idInci").className = "form-control" 
	document.getElementById("idInci").value = id2
	document.getElementById("idCli").value = idCli
	document.getElementById("idTec").value = idTec
	document.getElementById("tipoInci").value = tipoInci
	document.getElementById("descripInci").value = descripInci
	document.getElementById("exampleModalLabel").innerHTML = "ACTUALIZA REGISTRO ID " + id2
	
}



function abrirNuevo(){
	
	document.getElementById("idModal").innerHTML =`<div id="form-nuevo" class="row d-none">
			<div class="col-lg-2"></div>
			<div class="col-lg-8">

				<div class="modal fade" id="exampleModal" tabindex="-1"
					aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">....</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div id="modal-body"
								class="modal-body text-center pb-0 mb-0 fw-bold text-danger">

								<form id="form-action" method="post" action="AddCliente">
									<div
										class="mb-3 d-flex flex-column gap-3 justify-content-spacebetween">
	
										<input type="text" class="form-control" name="id"
											id="id" placeholder="id" readonly>
										<input type="text" class="form-control" name="nombre"
											id="nombre" placeholder="Nombre">
										<input type="text" class="form-control" name="apellido"
											id="apellido" placeholder="Apellido">
										<input type="text" class="form-control" name="cuit"
											id="cuit" placeholder="Cuit">
										<input type="text" class="form-control" name="razon"
											id="razon" placeholder="Razón Social">
								
									
										
											<button id="btn-enviar" type="submit" class="btn btn-success w-100">Enviar</button>
									</div>
										
							

								</form>



							</div>

							
						</div>
					</div>
				</div>
			</div>

			<div class="col-lg-2"></div>


		</div>`
		
	  document.getElementById("form-nuevo").className = "row" ;
	  document.getElementById("form-action").setAttribute('action', 'AddCliente')
	  document.getElementById("id").className = "d-none"
	  document.getElementById("exampleModalLabel").innerHTML = "NUEVO REGISTRO"
	  var myModal = new bootstrap.Modal(document.getElementById('exampleModal'), {
            keyboard: false
        })
        
        myModal.show()
	  
	  
	  limpiarForm();

	}

	
function limpiarForm(){
	 document.getElementById("nombre").value = ""
	 document.getElementById("apellido").value = ""
	 document.getElementById("cuit").value = ""
	 document.getElementById("id").value = "d-none"
	 document.getElementById("id").value = ""
	 document.getElementById("razon").value = ""
}



function listClientes(){
	document.getElementById("listaInci").innerHTML=` `
	document.getElementById("section").innerHTML=`
	<div class="d-flex justify-content-center">
		<h1 class="fw-bolder">LISTA DE CLIENTES</h1>
	</div>

	<div class="container d-flex flex-column" >
	
	<table class="table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">NOMBRE</th>
      <th scope="col">APELLIDO</th>
      <th scope="col">CUIT</th>
      <th scope="col">RAZÓN SOCIAL</th>
      <th scope="col">ACCIONES</th>
    </tr>
  </thead>
  <tbody id="body"></tbody>
  </table>
  <div class="d-flex justify-content-end mb-3">
			<button id="nuevo" class="btn btn-warning" onclick="abrirNuevo()">
				NUEVO</button>
		</div>
	</div>
	
	</div>`	
  
  for(let i = 0; i < clientes.length; i++){
  document.getElementById("body").innerHTML+=`
  			
				<tr>
					<th scope="row">${clientes[i].id}</th>
					<td>${clientes[i].nombre}</td>
					<td>${clientes[i].apellido}</td>
					<td>${clientes[i].cuit}</td>
					<td>${clientes[i].razon}</td>
					<td><a id="btn-eliminar" href="EliminarCliente?id=${clientes[i].id}"
						class="btn btn-danger">ELIMINAR</a>
						<a href="index.jsp?id=${clientes[i].id}&nombre=${clientes[i].nombre}&apellido=${clientes[i].apellido}&cuit=${clientes[i].cuit}&razon=${clientes[i].razon}"
						class="btn btn-success">ACTUALIZAR</a>
					</td>	
				</tr>`}
		
}

function listTecnicos(){
	document.getElementById("listaInci").innerHTML=` `
	document.getElementById("section").innerHTML=`
	<div class="d-flex justify-content-center">
		<h1 class="fw-bolder">LISTA DE TECNICOS</h1>
	</div>

	<div class="container d-flex flex-column" >
	
	<table class="table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">NOMBRE</th>
      <th scope="col">APELLIDO</th>
      <th scope="col">INCIDENTES</th>
      <th scope="col">ACCIONES</th>
    </tr>
  </thead>
  <tbody id="body"></tbody>
  </table>
  <div class="d-flex justify-content-end mb-3">
			<button id="nuevo" class="btn btn-warning" onclick="abrirNuevo1()">
				NUEVO</button>
		</div>
	</div>
	
	</div>`	
  
  for(let i = 0; i < tecnicos.length; i++){
  document.getElementById("body").innerHTML+=`
  			
				<tr>
					<th scope="row">${tecnicos[i].id}</th>
					<td>${tecnicos[i].nombre}</td>
					<td>${tecnicos[i].apellido}</td>
					<td>${tecnicos[i].incidente} <a class="btn btn-primary ms-2" onclick="verIncidentes(${tecnicos[i].id})">Ver</a></td>
					<td><a id="btn-eliminar" href="EliminarTecnico?id=${tecnicos[i].id}"
						class="btn btn-danger">ELIMINAR</a>
						<a href="index.jsp?id1=${tecnicos[i].id}&nombre=${tecnicos[i].nombre}&apellido=${tecnicos[i].apellido}"
						class="btn btn-success">ACTUALIZAR</a>
					</td>	
				</tr>`}
		
}

function abrirNuevo1(){
	 document.getElementById("idModal").innerHTML = `<div id="form-nuevo" class="row d-none">
			<div class="col-lg-2"></div>
			<div class="col-lg-8">

				<div class="modal fade" id="exampleModal" tabindex="-1"
					aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">....</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div id="modal-body"
								class="modal-body text-center pb-0 mb-0 fw-bold text-danger">

								<form id="form-action" method="post" action="AddTecnico">
									<div
										class="mb-3 d-flex flex-column gap-3 justify-content-spacebetween">
	
										<input type="text" class="form-control" name="id"
											id="id" placeholder="id" readonly>
										<input type="text" class="form-control" name="nombre"
											id="nombre" placeholder="Nombre">
										<input type="text" class="form-control" name="apellido"
											id="apellido" placeholder="Apellido">						
																		
											<button id="btn-enviar" type="submit" class="btn btn-success w-100">Enviar</button>
									</div>
										
							

								</form>



							</div>

							
						</div>
					</div>
				</div>
			</div>

			<div class="col-lg-2"></div>


		</div>`
		
		document.getElementById("form-nuevo").className = "row" ;
	  document.getElementById("form-action").setAttribute('action', 'AddTecnico')
	  document.getElementById("id").className = "d-none"
	  document.getElementById("exampleModalLabel").innerHTML = "NUEVO REGISTRO"
	  var myModal = new bootstrap.Modal(document.getElementById('exampleModal'), {
            keyboard: false
        })
        
        myModal.show()	 
}

function listIncidentes(){
	document.getElementById("listaInci").innerHTML=` `
	
	document.getElementById("section").innerHTML=`
	<div class="d-flex justify-content-center">
		<h1 class="fw-bolder">LISTA DE INCIDENTES</h1>
	</div>

	<div class="container d-flex flex-column" >
	
	<table class="table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">TIPO INCIDENTE</th>
      <th scope="col">DESCRIPCION INCIDENTE</th>
      <th scope="col">CLIENTE</th>
      <th scope="col">TECNICO</th>
      <th scope="col">ACCIONES</th>
    </tr>
  </thead>
  <tbody id="body"></tbody>
  </table>
  <div class="d-flex justify-content-end mb-3">
			<button id="nuevo" class="btn btn-warning" onclick="abrirNuevo2()">
				NUEVO</button>
		</div>
	</div>
	
	</div>`	
  
  for(let i = 0; i < incidentes.length; i++){
	  let j = cliente(incidentes[i].idCliente)
	  let k = tecnico(incidentes[i].idTecnico)
  document.getElementById("body").innerHTML+=`
  			
				<tr>
					<th scope="row">${incidentes[i].id}</th>
					<td>${incidentes[i].tipoInci}</td>
					<td>${incidentes[i].descripInci}</td>
					<td>${clientes[j].nombre} ${clientes[j].apellido}</td>
					<td>${tecnicos[k].nombre} ${tecnicos[k].apellido}</td>
					<td><a id="btn-eliminar" href="EliminarIncidente?idInci=${incidentes[i].id}&idCli=${clientes[j].id}&idTec=${tecnicos[k].id}"
						class="btn btn-danger">ELIMINAR</a>
						<a href="index.jsp?id2=${incidentes[i].id}&idCli=${incidentes[i].idCliente}&idTec=${incidentes[i].idTecnico}&tipoInci=${incidentes[i].tipoInci}&descripInci=${incidentes[i].descripInci}"
						class="btn btn-success">ACTUALIZAR</a>
					</td>	
				</tr>`}
		
}

function cliente(a){
	for(let i=0;i<clientes.length;i++){
		if(clientes[i].id == a){
			return i
		}
		
	}
	
}

function tecnico(a){
	for(let i=0;i<tecnicos.length;i++){
		if(tecnicos[i].id == a){	
			return i
		}
		
	}
	
}

function verIncidentes(a){
	 
	document.getElementById("listaInci").innerHTML=`
	<div class="d-flex justify-content-center">
		<h1 class="fw-bolder">LISTA DE INCIDENTES</h1>
	</div>

	<div class="container1 d-flex flex-column" >
	
	<table class="table">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">TIPO INCIDENTE</th>
      <th scope="col">DESCRIPCION INCIDENTE</th>
      <th scope="col">CLIENTE</th>
    </tr>
  </thead>
  <tbody id="body1"></tbody>
  </table>
	</div>`	
 document.getElementById("body1").innerHTML=` `
  let cont = 0
  for(let i = 0; i < incidentes.length; i++){
	  let j = cliente(incidentes[i].idCliente)
	  
	  if(incidentes[i].idTecnico == a){
		  document.getElementById("body1").innerHTML+=`
  			
				<tr>
					<th scope="row">${incidentes[i].id}</th>
					<td>${incidentes[i].tipoInci}</td>
					<td>${incidentes[i].descripInci}</td>
					<td>${clientes[j].nombre} ${clientes[j].apellido}</td>
				</tr>`
				cont++
				}
	  }
  	if(cont == 0){	
		  document.getElementById("listaInci").innerHTML=` <div class="d-flex justify-content-center"><h2>No hay incidentes registrados</h2></div> `
	  }
		
}


function abrirNuevo2(){
	 document.getElementById("idModal").innerHTML = `<div id="form-nuevo" class="row d-none">
			<div class="col-lg-2"></div>
			<div class="col-lg-8">

				<div class="modal fade" id="exampleModal" tabindex="-1"
					aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">....</h5>
								<button type="button" class="btn-close" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div id="modal-body"
								class="modal-body text-center pb-0 mb-0 fw-bold text-danger">

								<form id="form-action" method="post" action="AddIncidente">
									<div
										class="mb-3 d-flex flex-column gap-3 justify-content-spacebetween">
	
										<input type="text" class="form-control" name="idInci"
											id="idInci" placeholder="id" readonly>
										<input type="text" class="form-control" name="tipoInci"
											id="tipoInci" placeholder="Tipo de incidente">
										<textarea type="text" class="form-control" name="descripInci"
											id="descripInci" placeholder="Descripcion incidente"></textarea>
										<input type="text" class="form-control" name="idCli"
											id="idCli" placeholder="Id Cliente">
										<input type="text" class="form-control" name="idTec"
											id="idTec" placeholder="Id Tecnico">						
																		
											<button id="btn-enviar" type="submit" class="btn btn-success w-100">Enviar</button>
									</div>
										
							

								</form>



							</div>

							
						</div>
					</div>
				</div>
			</div>

			<div class="col-lg-2"></div>


		</div>`
		
		document.getElementById("form-nuevo").className = "row" ;
	  document.getElementById("form-action").setAttribute('action', 'AddIncidente')
	  document.getElementById("idInci").className = "d-none"
	  document.getElementById("exampleModalLabel").innerHTML = "NUEVO REGISTRO"
	  var myModal = new bootstrap.Modal(document.getElementById('exampleModal'), {
            keyboard: false
        })
        
        myModal.show()	 
}
