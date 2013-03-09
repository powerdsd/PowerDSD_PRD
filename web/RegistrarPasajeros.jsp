<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
</head>
<body>
	<form action="">
		<table width="443" height="214" border="0" class="letra">
			<tr>
				<td colspan="2" bgcolor="#360"><div align="left">
						<span class="letra2"><em class="blanco">Registro de Pasajeros</em></span>
					</div></td>
			</tr>
			<tr>
				<td width="199">&nbsp;</td>
				<td width="234">&nbsp;</td>
			</tr>
                        
                        <tr>
				<td><span class="letra2"><em>DNI:</em><em
						class="rojo">*</em></span></td>
				<td><span class="letra2"> <input type="text"
						name="txtDNI" id="txtDNI" />
				</span></td>
			</tr>
                        
			<tr>
				<td><span class="letra2"><em>Nombres:</em><em
						class="rojo">*</em></span></td>
				<td><span class="letra2"> <input type="text"
						name="txtNombre" id="txtNombre" />
				</span></td>
			</tr>
			<tr>
				<td><span class="letra2"><em>Apellido Paterno:</em><em
						class="rojo">*</em></span></td>
				<td><span class="letra2"> <input type="text"
						name="txtApePaterno" id="txtApePaterno" />
				</span></td>
			</tr>
			<tr>
				<td><em>Apellido Materno:</em><em class="rojo">*</em></td>
				<td><span class="letra2"> <input type="text"
						name="txtApeMaterno" id="txtApeMaterno" />
				</span></td>
			</tr>
			
			<tr>
				<td><span class="letra2"><em>Tipo de Documento de
							Identidad:</em><em class="rojo">*</em></span></td>
				<td><span class="letra2"> <select name="cboTipDni"
						id="cboTipDni">
							<option value="1">DNI</option>
							<option value="2">PASAPORTE</option>
							<option value="3">CARNET DE EXTRANJERIA</option>
					</select>
				</span></td>
			</tr>
			<tr>
				<td><em>N&uacute;mero de Documento de Identidad:</em><em
					class="rojo">*</em></td>
				<td><span class="letra2"> <input type="text"
						name="txtTipDni" id="txtTipDni" />
				</span></td>
			</tr>
                        <tr>
				<td><em>Direcci&oacuten:</em><em
					class="rojo">*</em></td>
				<td><span class="letra2"> <input type="text"
						name="txtDireccion" id="txtDireccion" />
				</span></td>
			</tr>
                        <tr>
				<td><em>Edad</em><em
					class="rojo">*</em></td>
				<td><span class="letra2"> <input type="text"
						name="txtEdad" id="txtEdad" />
				</span></td>
			</tr>
                        
			<tr>
				<td><em>Numero de Boleta:</em><em
					class="rojo">*</em></td>
				<td><span class="letra2"> <input type="text"
						name="txtEmail" id="txtEmail" />
				</span></td>
			</tr>
			<tr>
				<td><em>Fecha de Emision:</em><em class="rojo">*</em></td>
				<td><span class="letra2"> <input type="text"
						name="txtFechaEmision" id="txtFechaEmision" />
				</span></td>
			</tr>
                        <tr>
				<td><em>Hora de Emision:</em><em class="rojo">*</em></td>
				<td><span class="letra2"> <input type="text"
						name="txtHoraEmision" id="txtHoraEmision" />
				</span></td>
			</tr>
                        <%--
			<tr>
				<td><em>Hora Emisión:</em><em class="rojo">*</em></td>
				<td><span class="letra2"> <input type="password"
						name="txtPassword" id="txtPassword" />
				</span></td>
			</tr>
                        --%>
			<tr>
			
			<tr>
				<td><em>Agencia:</em></td>
				<td><span class="letra2"> <input type="text"
						name="txtAgencia" id="txtAgencia" />
				</span></td>
			</tr>
                        <tr>
				<td><em>Bus:</em></td>
				<td><span class="letra2"> <input type="text"
						name="txtBus" id="txtBus" />
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
                        <tr>
				<td><em>Fecha de Partida:</em><em class="rojo">*</em></td>
				<td><span class="letra2"> <input type="text"
						name="txtFechaPartida" id="txtFechaPartida" />
				</span></td>
			</tr>
                        <tr>
				<td><em>Hora de Partida:</em><em class="rojo">*</em></td>
				<td><span class="letra2"> <input type="text"
						name="txtHoraPartida" id="txtHoraPartida" />
				</span></td>
			</tr>
                        <tr>
				<td><em>Sub Total:</em><em class="rojo">*</em></td>
				<td><span class="letra2"> <input type="text"
						name="txtSubTotal" id="txtSubTotal" />
				</span></td>
			</tr>
                        <tr>
				<td><em>IGV:</em><em class="rojo">*</em></td>
				<td><span class="letra2"> <input type="text"
						name="txtIGV" id="txtIGV" />
				</span></td>
			</tr>
                        <tr>
				<td><em>Total:</em><em class="rojo">*</em></td>
				<td><span class="letra2"> <input type="text"
						name="txtTotal" id="txtTotal" />
				</span></td>
			</tr>
                        
			<tr>
				<td>&nbsp;</td>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><span class="letra2"> <label> <input
							type="submit" name="btnCancelar" id="btnCancelar"
							value="Cancelar" /> <input type="submit" name="btnGuardar"
							id="btnGuardar" value="Grabar" />
					</label>
				</span></td>
			</tr>
		</table>
	</form>

</body>
</html>