<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link type="text/css" href="calendario/css/jquery-ui.css" rel="stylesheet" />    
<link type="text/css" href="css/general.css" rel="stylesheet" />  
<link type="text/css" href="css/panelEmergente.css" rel="stylesheet" /> 
<title>Registrar Pasajeros</title>
<style type="text/css">
.blanco {
	color: #FFF;
	text-align: right;
	font-weight: bold;
}

.letra {
	font-family: Calibri;
	font-size: 12px;
}

.anaranjado {
	color: #FF8000;
	text-align: right;
	font-weight: bold;
	font-size: 9px
}

.rojo {
	color: #F00;
}
</style>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="js/ui.datepicker-es.js"></script>
    <script type="text/javascript" src="js/funciones.js"></script> 
    <script type="text/javascript">
        $(document).ready(function () {
	      $("#txtFechaPartida").datepicker({ 
             showOn: 'button', 
             buttonImageOnly: true, 
             buttonImage: 'calendario/images/calendar.gif',  //poner ruta completa
		     //buttonImage:'images/datepicker.png',
		     changeMonth: true,
		     changeYear: true  
           });
		   
	   $("#txtFechaLlegada").datepicker({ 
             showOn: 'button', 
             buttonImageOnly: true, 
             buttonImage: 'calendario/images/calendar.gif',  //poner ruta completa
		     changeMonth: true,
		     changeYear: true  
           });             
		   
	   $("#txtFechaEmision").datepicker({ 
             showOn: 'button', 
             buttonImageOnly: true, 
             buttonImage: 'calendario/images/calendar.gif',  //poner ruta completa
		     changeMonth: true,
		     changeYear: true  
           });             
        });
   </script>
</head>
<body>
<form action="RegistrarPasajeroServlet" method="post">	
    

    <!--   <input type="hidden" name="hddaccion" id="hddaccion" value="operacion" />
           <Input type="hidden" name="boton" id="boton" value = "" />  -->
     
    <!-- <form action="">
    <table width="643" height="214" border="0" class="letra"> -->
		<table width="643" border="0" class="letra">
                    
<tr>
    <td colspan="4" bgcolor="#360"><div align="left">
        <span class="letra2"><em class="blanco">Registro de Pasajeros</em></span>
	</div></td>
</tr>
 <tr>
    <td width="234">&nbsp;</td>
    <td width="234">&nbsp;</td>
</tr>
<tr>
    <td><span class="letra2"><em>Tipo de Documento de Identidad:</em><em class="rojo">*</em></span></td>
    <td><span class="letra2"> 
        <select name="cboTipDni" id="cboTipDni">
            <option value="1">DNI</option>
            <option value="2">PASAPORTE</option>
            <option value="3">CARNET DE EXTRANJERIA</option>
	</select>
    </span></td>
</tr>
<tr>
    <td><em>N&uacute;mero de Documento de Identidad:</em><em class="rojo">*</em></td>
    <td><span class="letra2"> <input type="text" name="txtNumDoc" id="txtNumDoc" value="<%=request.getAttribute("TXTNumDoc")%>" /></span></td>
    <td><input type="submit" name="Reniec" id="Reniec" value="Consulta Reniec" class="boton" onclick="a"/></td>

</tr>

<tr>
    <td><span class="letra2"><em>Nombres:</em><em class="rojo">*</em></span></td>
    <td><span class="letra2"> <input type="text" name="txtNombre" id="txtNombre" value="<%=request.getAttribute("TXTNombre")%>"/></span></td>
</tr>
<tr>
    <td><span class="letra2"><em>Apellido Paterno:</em><em class="rojo">*</em></span></td>
    <td><span class="letra2"> <input type="text" name="txtApePaterno" id="txtApePaterno" value="<%=request.getAttribute("TXTApePaterno")%>"/></span></td>
</tr>
<tr>
    <td><em>Apellido Materno:</em><em class="rojo">*</em></td>
        <td><span class="letra2"> <input type="text" name="txtApeMaterno" id="txtApeMaterno" value="<%=request.getAttribute("TXTApeMaterno")%>"/></span></td>
</tr>
			
<tr>
    <td><em>Edad</em><em class="rojo">*</em></td>
        <td><span class="letra2"> <input type="text" name="txtEdad" id="txtEdad" value="<%=request.getAttribute("TXTEdad")%>"/></span></td>
        <%--<td><input type="submit" name="Confirmar" id="Confirmar" value="Confirmar" class="boton" onclick="a;"/></td> --%>
        <%--<td><input type="submit" name="Rechazar" id="Rechazar" value="Rechazar" class="boton" onclick="a;"/></td>  --%>
</tr>
<tr></tr>
<tr></tr>
                        <%--
                        <tr>
				<td><em>Direcci&oacuten:</em><em
					class="rojo">*</em></td>
				<td><span class="letra2"> <input type="text"
						name="txtDireccion" id="txtDireccion" />
				</span></td>
			</tr>
                        <tr>
				<td><span class="letra2"><em>DNI:</em><em
						class="rojo">*</em></span></td>
				<td><span class="letra2"> <input type="text"
						name="txtDNI" id="txtDNI" />
				</span></td>
			</tr>
                        
                        <tr>
				<td><em>Hora de Emision:</em><em class="rojo">*</em></td>
				<td><span class="letra2"> <input type="text"
						name="txtHoraEmision" id="txtHoraEmision" />
				</span></td>
			</tr>
			<tr>
				<td><em>Hora Emisión:</em><em class="rojo">*</em></td>
				<td><span class="letra2"> <input type="password"
						name="txtPassword" id="txtPassword" />
				</span></td>
			</tr>
			<tr>
			
			<tr>
				<td><em>Agencia:</em></td>
				<td><span class="letra2"> <input type="text"
						name="txtAgencia" id="txtAgencia" />
				</span></td>
			</tr>
                        <tr>
				<td><em>Origen:</em></td>
				<td><span class="letra2"> <input type="text"
						name="txtOrigen" id="txtOrigen" />
				</span></td>
			</tr>
                        <tr>
				<td><em>Destino:</em></td>
				<td><span class="letra2"> <input type="text"
						name="txtDestino" id="txtDestino" />
				</span></td>
			</tr>
                        <tr>
				<td><em>Fecha de Viaje:</em><em class="rojo">*</em></td>
				<td><span class="letra2"> <input type="text"
						name="txtFechaViaje" id="txtFechaViaje" />
				</span></td>
			</tr>
                        --%>
    <!-- W.Wong Inicio Seleccion de Agencia Origen -->
    <tr> 
        <td width="234" height="30"><strong>Agencia Origen:</strong></td>
            <td>
                <%@page import="java.util.ArrayList, java.util.Collection, powerdsd.modelo.Agencia, powerdsd.modelo.Bus"%>
                    <%
                    Collection<Agencia> agencias = (ArrayList<Agencia>) session.getAttribute("AGENCIAS");
                    if (agencias != null) {
                    %>
                    <select name="codAgeOrigen" id="codAgeOrigen">
                    <%
                    if (session.getAttribute("CODAgeOrigen")!=null){
                        for (Agencia xAgencia : agencias) {
                            if (String.valueOf(xAgencia.getCodAgencia()).equals(session.getAttribute("CODAgeOrigen"))){
                                out.println("<OPTION value=\""+xAgencia.getCodAgencia()+ "\"> "+xAgencia.getDescripcion() + "</OPTION>");
                            }  
                        }				                
                        }
                        else{
                            out.println("<OPTION value=\""+ session.getAttribute("CODAgeOrigen")+"\"> - Seleccione - </OPTION>");
                        }
                        for (Agencia x : agencias) {
                            out.print("<OPTION value=\""+x.getCodAgencia()+ "\"> "+x.getDescripcion()+"</OPTION>");  
                        }                    
                            out.println("</SELECT >");
                        } else {                    
                        out.println("<font color=red>La variable AGENCIAS no tiene valor</font>");
                        }
                %>
	</td>   
						                    
<!-- W.Wong Fin Seleccion de Agencias Origen -->
<!-- W.Wong Inicio Seleccion de Agencia Destino -->
        <td width="234" height="30"><strong>Agencia Destino:</strong></td>
            <td>
                    <%
                    Collection<Agencia> yAgencias = (ArrayList<Agencia>) session.getAttribute("AGENCIAS");
                    if (agencias != null) {
                    %>
                    <select name="codAgeDestino" id="codAgeDestino"> 
                    <% 
                    if (session.getAttribute("CODAgeDestino")!=null){
                        for (Agencia yAgencia : yAgencias) {
                            if (String.valueOf(yAgencia.getCodAgencia()).equals(session.getAttribute("CODAgeDestino"))){
                                out.println("<OPTION value=\""+yAgencia.getCodAgencia()+ "\"> "+yAgencia.getDescripcion()+"</OPTION>");
                            }  
                        }				                
                        }
                        else{
                            out.println("<OPTION value=\""+ session.getAttribute("CODAgeDestino")+"\"> - Seleccione - </OPTION>");
                        }
                        for (Agencia y : yAgencias) {
                            out.print("<OPTION value=\""+y.getCodAgencia()+ "\"> "+y.getDescripcion()+"</OPTION>");  
                        }                    
                            out.println("</SELECT >");
                        }
                %>
	</td>   
    </tr>
<!-- W.Wong Fin Seleccion de Agencias -->
                        
        <tr>
            <td><em>Fecha de Partida:</em><em class="rojo">*</em></td>
            <td><input name="txtFechaPartida" type="text" id="txtFechaPartida" size="15" maxlength="10" value="<%=request.getAttribute("REQFechaPartida")%>"/></td>
            <td><em>Fecha de Partida:</em><em class="rojo">*</em></td>
            <td><input name="txtFechaLlegada" type="text" id="txtFechaLlegada" size="15" maxlength="10" value="<%=request.getAttribute("REQFechaLlegada")%>"/></td>
        </tr>
        <tr>
                <td><em>Hora de Partida:</em><em class="rojo">*</em></td>
		<td><span class="letra2"> <input type="text" name="txtHoraPartida" id="txtHoraPartida" />
                </span></td>
                <td><em>Hora de Llegada:</em><em class="rojo">*</em></td>
		<td><span class="letra2"> <input type="text" name="txtHoraLlegada" id="txtHoraLlegada" />
                </span></td>
	</tr>
                    <%--
                    <tr>
                      <td height="30"><strong>Fecha Inicio:</strong></td>                      
                      <td><input name="txtfechaini" type="text" id="txtfechaini" size="15" maxlength="10" value="<%=request.getAttribute("REQfechaini")%>"/></td>
                      <td><strong>Fecha Fin:</strong></td>
                      <td><input name="txtfechafin" type="text" id="txtfechafin" size="15" maxlength="10" value="<%=request.getAttribute("REQfechafin")%>"/></td>
				<td><span class="letra2"> <input type="text"
						name="txtFechaPartida" id="txtFechaPartida" />
				</span></td>
                    </tr>
                        <tr>
				<td><em>Fecha de Llegada:</em><em class="rojo">*</em></td>
				<td><span class="letra2"> <input type="text"
						name="txtFechaLlegada" id="txtFechaLlegada" />
				</span></td>
			</tr>
                    --%>
                    
<!-- W.Wong Inicio Seleccion de Buses -->
    <tr> 
        <td width="234" height="30"><strong>Bus :</strong></td>
            <td>
                    <%
                    Collection<Bus> buses = (ArrayList<Bus>) session.getAttribute("BUSES");
                    if (buses != null) {
                    %>
                    <select name="nu_Placa" id="nu_Placa">
                    <%
                    if (session.getAttribute("NUPlaca")!=null){
                        for (Bus bus : buses) {
                            if (String.valueOf(bus.getNu_Placa()).equals(session.getAttribute("NUPlaca"))){
                                out.println("<OPTION value=\""+bus.getNu_Placa()+ "\"> "+bus.getNu_Placa()+"</OPTION>");
                            }  
                        }				                
                        }
                        else{
                            out.println("<OPTION value=\""+ session.getAttribute("NUPlaca")+"\"> - Seleccione - </OPTION>");
                        }
                        for (Bus w : buses) {
                            out.print("<OPTION value=\""+w.getNu_Placa()+ "\"> "+w.getNu_Placa()+"</OPTION>");  
                        }                    
                            out.println("</SELECT >");
                        } else {                    
                        out.println("<font color=red>No hay VEHICULOS registrados</font>");
                        }
                %>
	</td>   
    </tr>
<!-- W.Wong Fin Seleccion de Bus -->
                        
<tr>
        <%--
        <td><em>Numero de Boleto:</em><em class="rojo">*</em></td>
        <td><span class="letra2"> <input type="text" name="txtBoleto" id="txtBoleto" /></span></td>
        --%>
        <td><em>Numero de Asiento:</em><em class="rojo">*</em></td>
        <td><span class="letra2"> <input type="text" name="txtAsiento" id="txtAsiento" /> </span></td>
						                    
    </tr>
    <tr>
        <td><em>Fecha de Emision:</em><em class="rojo">*</em></td>
        <td><input name="txtFechaEmision" type="text" id="txtFechaEmision" size="15" maxlength="10" value="<%=request.getAttribute("REQFechaEmision")%>"/></td>
    </tr>
    <tr>
        <td><em>Sub Total:</em><em class="rojo">*</em></td>
        <td><span class="letra2"> <input type="text" name="txtSubTotal" id="txtSubTotal" /></span></td>
    </tr>
    <tr>
        <td><em>IGV:</em><em class="rojo">*</em></td>
	<td><span class="letra2"> <input type="text" name="txtIGV" id="txtIGV" /></span></td>
    </tr>
    <tr>
        <td><em>Total:</em><em class="rojo">*</em></td>
	<td><span class="letra2"> <input type="text" name="txtTotal" id="txtTotal" /></span></td>
    </tr>
                        
    <tr>
        <td>&nbsp;</td>
	<td>&nbsp;</td>
    </tr>
    <tr>
        <td>&nbsp;</td>
            <td><span class="letra2"> 
                <label> 
                    <input type="submit" name="btnCancelar" id="btnCancelar" value="Cancelar" /> 
                    <input type="submit" name="Grabar" id="Grabar" value="Grabar" class="boton" onclick="b"/> 
                </label> 
            </span></td>
    </tr>
  </table>
</form>

</body>
</html>