// JavaScript Document
 function esFechaValida(fecha){
    
	   if (fecha != undefined && fecha.value != "" ){
           if (!/^\d{2}\/\d{2}\/\d{4}$/.test(fecha.value)){
               alert("El formato de fecha debe ser (dd/mm/aaaa)");
               return false;
           }
           var dia  =  parseInt(fecha.value.substring(0,2),10);
           var mes  =  parseInt(fecha.value.substring(3,5),10);
           var anio =  parseInt(fecha.value.substring(6),10);
 
		   switch(mes){
		       case 1:
		       case 3:
		       case 5:
		       case 7:
		       case 8: 
		       case 10:
		       case 12:
		          numDias=31;
		           break;
		       case 4: case 6: case 9: case 11:
		          numDias=30;
		           break;
		       case 2:
		            if (comprobarSiBisisesto(anio)){ numDias=29 }else{ numDias=28};
		            break;
		       default:
		           alert("Fecha introducida errÃ³nea");
		            return false;
		    }
		
		    if (dia>numDias || dia==0){
		            alert("Fecha introducida errÃ³nea");
		           return false;
		    }
		    
			   return true;
      }
  }
 // *********************************************************************
  function comprobarSiBisisesto(anio){
      if ( ( anio % 100 != 0) && ((anio % 4 == 0) || (anio % 400 == 0))) {
          return true;
      } 
      else {
          return false;
      }
  }
  // *********************************************************************
  function comparaFechas(fecha, fecha2) {
        var xMonth = fecha.substring(3, 5);
        var xDay = fecha.substring(0, 2);
        var xYear = fecha.substring(6, 10);
        var yMonth = fecha2.substring(3, 5);
        var yDay = fecha2.substring(0, 2);
        var yYear = fecha2.substring(6, 10);
        if (xYear > yYear) {
            return (true)
        }
        else {
            if (xYear == yYear) {
                if (xMonth > yMonth) {
                    return (true)
                }
                else {
                    if (xMonth == yMonth) {
                        if (xDay > yDay)
                            return (true);
                        else
                            return (false);
                    }
                    else
                        return (false);
                }
            }
            else
                return (false);
        }
    }  

//Edgar Lopez
  
  function validar_usuario()
  {
	  var varNom=document.getElementById("txtNom").value;
	  var varApePater=document.getElementById("txtApePaterno").value;
	  var varApeMaten=document.getElementById("txtApeMaterno").value;
	  var varNro=document.getElementById("txtNroDocumento").value;
	  var varClave01=document.getElementById("txtClave01").value;
	  var varClave02=document.getElementById("txtClave02").value;
	  var varFecha=document.getElementById("txtFecNac").value;
	  
	  
	  
	  
	  if(varNom==""){
		  alert('El campo nombre es obligatorio');
		  document.getElementById("txtNom").focus();
		  return false;
	  }
	  
	  if(varApePater==""){
		  alert('El campo Apellido Paterno es obligatorio');
		  document.getElementById("txtApePaterno").focus();
		  return false;
	  }
	  
	  if(varApeMaten==""){
		  alert('El campo Apellido Materno es obligatorio');
		  document.getElementById("txtApeMaterno").focus();
		  return false;
	  }
	  
	  if(document.getElementById("cboSexo").selectedIndex==0)
	  {
		  alert('El campo Sexo es obligatorio');
		  document.getElementById("cboSexo").focus();
		  return false;
	  }
	  
	  
	  if(document.getElementById("cboTipo").selectedIndex==0)
	  {
		  alert('El campo Tipo es obligatorio');
		  document.getElementById("cboTipo").focus();
		  return false;
	  }
	  
	  
	  if(varNro==""){
		  alert('El campo Nro de Documento es obligatorio');
		  document.getElementById("txtNroDocumento").focus();
		  return false;
	  }
	  
	  if(varClave01=="" || varClave02==""){
		  alert('Los campos de contraseña son obligatorio');
		  document.getElementById("txtClave01").focus();
		  return false;
	  }
	  
	  if(varClave01!=varClave02){
		  alert('Las contraseñas son diferentes');
		  document.getElementById("txtClave01").focus();
		  return false;
	  }
	  
	  
	  if(varFecha==""){
		  alert('El campo Fecha de Nacimiento es obligatorio');
		  document.getElementById("txtFecNac").focus();
		  return false;
	  }	  
	  
  
	  return true;
  }
  
  function validar_local()
  {
	  
	  
	  var varNom=document.getElementById("txtNom").value;
	  var varDireccion=document.getElementById("txtDireccion").value;
	  var varDistrict=document.getElementById("txtDistrito").value;
	  var varURL=document.getElementById("localURL").value;
	  var varTelefono=document.getElementById("txtNroCel").value;	  
	  
	  
	  
	  
	  if(varNom==""){
		  alert('El campo nombre es obligatorio');
		  document.getElementById("txtNom").focus();
		  return false;
	  }
	  
	  if(varDireccion==""){
		  alert('El campo Direcion es obligatorio');
		  document.getElementById("txtDireccion").focus();
		  return false;
	  }
	  
	  if(varDistrict==""){
		  alert('El campo Distrito es obligatorio');
		  document.getElementById("txtDistrito").focus();
		  return false;
	  }
	  
	  if(varURL==""){
		  alert('El campo URL es obligatorio');
		  document.getElementById("localURL").focus();
		  return false;
	  }
	  
	  if(varTelefono==""){
		  alert('El campo Telefono es obligatorio');
		  document.getElementById("txtNroCel").focus();
		  return false;
	  }
	  
	  
	 
	  
	  if(document.getElementById("cboDueno").selectedIndex==0)
	  {
		  alert('El campo Tipo es obligatorio');
		  document.getElementById("cboDueno").focus();
		  return false;
	  }  
	  
	 
	  
  
	  return true;
  }