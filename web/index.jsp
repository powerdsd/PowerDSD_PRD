<%-- 
    Document   : index
    Created on : 07/03/2013, 06:06:04 AM
    Author     : JHLM
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css" />
<title>Módulo de Alertas y Monitoreo en el Tansporte PowerDSD</title>
</head>
<body>
	<!-- Begin Wrapper -->
	<div id="wrapper">
		<!-- Begin Header -->
		<div id="header">
			<h1>Módulo de Alertas y Monitoreo en el Tansporte PowerDSD</h1>
		</div>
		<!-- End Header -->
		<!-- Begin Navigation -->
		<div id="navtop" style="color: white;">
			<ul>
				<li><a href="LogoutServlet">Salir del sistema</a></li>
				<li><a href="index.jsp">Contáctenos</a></li>
				<li><a href="bienvenida.html" target="iframe">Inicio</a></li>
				&nbsp;&nbsp;Bienvenido al sistema:
				<b>${sessionScope.USUARIO_ACTUAL.no_Persona }
					${sessionScope.USUARIO_ACTUAL.ap_Paterno }</b>
			</ul>
		</div>
		<!-- End Navigation -->
		<!-- Begin Left Column -->
		<div id="leftcolumn">
			<div id="navigation">
				<ul>
					<li><a href="#">Registrar</a>
						<ul class="sub-menu">
							<li><a href="RegistrarPasajeros.jsp" target="iframe">Pasajeros</a></li>
							<%--
                                                        <li><a href="RegistroLocal.jsp" target="iframe">Local</a></li>
							<li><a href="RegistrarCancha.jsp" target="iframe">Canchas
									de Fulbito</a></li>
							<li><a href="RegistroServicio.jsp" target="iframe">Servicios
									Adicionales</a></li>
							<li><a href="Publicidad.jsp" target="iframe">Publicidad</a></li>
							<li><a href="powerdev_evento_insertar.jsp" target="iframe">Eventos
									Deportivos</a></li>
                                                        --%>                
						</ul></li>
					<li><a href="#">Consultas</a>
					<li><a href="#">Reportes</a>
					<li><a href="#">Mantenimiento</a>
                                        <%--                
					<li><a href="registrarComentario.jsp" target="iframe">
							Comentar las canchas</a></li>
                                        --%>
				</ul>
			</div>
			
			
			<div class="tableleft">
				<form action="LoginServlet" method="post">
					<table style="align: top; padding-top: 0px;" border="0"
						cellspacing="5" cellpadding="5">
						<tr>
							<td colspan="2" style="text-align: center;">Login</td>
						</tr>
						<tr>
							<td>Usuario:</td>
							<td><input name="usuario" style="width: 80px;"></td>
						</tr>
						<tr>
							<td>Password:</td>
							<td><input name="clave" style="width: 80px;"></td>
						</tr>
						<tr>
							<td colspan="2" style="text-align: center;"><input
								type="submit" value="Entrar" style="width: 80px; height: 20px" /></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<!-- End Left Column -->
		<!-- Begin Right Column -->
		<div class="maincolumn">
			<iframe src="bienvenida.html" name="iframe" height="800" width="890"
				scrolling="yes" style="background: #ffffff;"></iframe>
		</div>
		<!-- End Right Column -->
		<div class="clear"></div>
		<div id="footer">
			&copy; Copyright 2013 by Power DSD <br />
		</div>
	</div>
	<!-- End Wrapper -->
</body>
</html>