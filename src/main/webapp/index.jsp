<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.util.List" %>   
 <%@page import="org.hibernate.*" %> 
 <%@page import="models.Cliente" %>
 <%@page import="models.Tecnico" %>  
 <%@page import="models.Incidente" %> 
 <%@page import="models.Especialidad" %> 
 <%@page import="controller.ClienteController" %> 
 <%@page import="controller.TecnicoController" %> 
 <%@page import="controller.IncidenteController" %> 
 <%@page import="controller.EspecialidadController" %> 


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IntegradorJava</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<% ClienteController ClienteCont = new ClienteController();
	
	List<Cliente> clienteLista = ClienteCont.ListadoClientes(); 
	
	TecnicoController TecnicoCont = new TecnicoController();
	
	List<Tecnico> tecnicoLista = TecnicoCont.ListadoTecnicos();
	
	IncidenteController IncidenteCont = new IncidenteController();
	
	List<Incidente> incidenteLista = IncidenteCont.ListadoIncidentes();
	
	%>
	<div class="d-flex flex-column align-items-center">
	<h1>Listas de la Base de datos</h1>
	<div class="d-flex justify-content-center mb-3 mt-3">	
	<button type="button" class="btn btn-success me-3" id="botonCliente" onclick="listClientes()">Clientes</button>
	<button type="button" class="btn btn-success" id="botonTecnico" onclick="listTecnicos()">Técnicos</button>
	<button type="button" class="btn btn-success ms-3" id="botonIncidente" onclick="listIncidentes()">Incidentes</button>
	</div>
	</div>
	
	<div class="section" id="section">
	
	</div>
	
		<div id="idModal" class="container mb-3">

		</div> 

	<div class="section1 mt-5" id="listaInci">
	
	</div>

	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	<script type="text/javascript" src="js/index.js"></script>
	<script type="text/javascript">
	
	let clientes = [{id: "", nombre: "", apellido: "", cuit: "", razon: ""}]
		
		<%
			int j;
			for( j=0; j < clienteLista.size(); j++) { 
				if(j==0){
			%>		
				clientes = [{id: "<%=clienteLista.get(j).getId() %>", nombre: "<%=clienteLista.get(j).getNombre() %>", apellido: "<%=clienteLista.get(j).getApellido() %>", cuit: "<%=clienteLista.get(j).getCuit() %>", razon: "<%=clienteLista.get(j).getRazonSocial() %>"}]
			<%}else{%>
			clientes.push({id: "<%=clienteLista.get(j).getId() %>", nombre: "<%=clienteLista.get(j).getNombre() %>", apellido: "<%=clienteLista.get(j).getApellido() %>", cuit: "<%=clienteLista.get(j).getCuit() %>", razon: "<%=clienteLista.get(j).getRazonSocial() %>"})
			<%}%>
		<%
	}
	%>
	
	let tecnicos = [{id: "", nombre: "", apellido: "", incidente: ""}]
	
	<%
	int k;
	for( k=0; k < tecnicoLista.size(); k++) { 
		if(k==0){
	%>		
		tecnicos = [{id: "<%=tecnicoLista.get(k).getId() %>", nombre: "<%=tecnicoLista.get(k).getNombre() %>", apellido: "<%=tecnicoLista.get(k).getApellido() %>", incidente: "<%=tecnicoLista.get(k).getIncidentesResueltos() %>"}]
	<%}else{%>
	tecnicos.push({id: "<%=tecnicoLista.get(k).getId() %>", nombre: "<%=tecnicoLista.get(k).getNombre() %>", apellido: "<%=tecnicoLista.get(k).getApellido() %>", incidente: "<%=tecnicoLista.get(k).getIncidentesResueltos() %>"})
	<%}%>
<%
}
%>	
	let incidentes = [{id: "", tipoInci: "", descripInci: "", idCliente: "", idTecnico: ""}]
			
			<%
			int i;
			for( i=0; i < incidenteLista.size(); i++) { 
				if(i==0){
			%>		
				incidentes = [{id: "<%=incidenteLista.get(i).getId() %>", tipoInci: "<%=incidenteLista.get(i).getTipoIncidente() %>", descripInci: "<%=incidenteLista.get(i).getDescripcionIncidente() %>", idCliente: "<%=incidenteLista.get(i).getIdCliente() %>", idTecnico: "<%=incidenteLista.get(i).getIdTecnico() %>"}]
			<%}else{%>
			incidentes.push({id: "<%=incidenteLista.get(i).getId() %>", tipoInci: "<%=incidenteLista.get(i).getTipoIncidente() %>", descripInci: "<%=incidenteLista.get(i).getDescripcionIncidente() %>", idCliente: "<%=incidenteLista.get(i).getIdCliente() %>", idTecnico: "<%=incidenteLista.get(i).getIdTecnico() %>"})
			<%}%>
		<%
		}
	
%>
		
		
	</script>
</body>
</html>