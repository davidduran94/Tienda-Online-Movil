

var $login          =  $('#login');
    $createAccount  =  $('#nuevaCuenta');
    $formOlvidoPass =  $('#olvidoPass');
  


function mostrarOcultarFormularioLogin (arg){
  arg.preventDefault();
  arg.stopPropagation();
  $createAccount.css("display", "none");
  $formOlvidoPass.css("display", "none");
  $login.slideToggle();
  return false;
}


function mostrarOcultarFormularioCreateAccount (arg){
  arg.preventDefault();
  arg.stopPropagation();
  $login.css("display", "none");
  $formOlvidoPass.css("display", "none");
  $createAccount.slideToggle();
  return false;
}

function mostrarOcultarFormularioOlvidoPass(arg){
  arg.preventDefault();
  arg.stopPropagation();
  $login.css("display", "none");
  $createAccount.css("display", "none");
  $formOlvidoPass.css("display", "block");
  return false;
}

// Eventos
$('.alogin').click(mostrarOcultarFormularioLogin);
$('.createAccount').click(mostrarOcultarFormularioCreateAccount);
$('.forgotPass').click(mostrarOcultarFormularioOlvidoPass);

$('.boton-recuperacion').click(function(){
  alert("Se ha enviado su contraseña a su corrreo");
});




/*Envio de los datos para el login por medio de ajax */

$('#botonRegistro').click(function(){
  sendDataRegistro();
  return false;
});

$('#botonLogin').click(function(){
  console.log("iniciando sesion...");
  sendDataLogin();
  return false;
});

$('#botonRecuperacion').click(function(){
  sendDataRecuperacion();
  return false;
});


$('#botonSalir').click(function(){
  cerrarSesion();
  return false;
});

function cerrarSesion (){
  $.ajax({
    type: 'POST',
      url: "/ProyectoFinalPaint/ControladorLogin",
      data: {
        form : "SALIR"
      },
      success : function (data){
        alert ("Sesion cerrada");
        window.location.href="index.html";  
      }
  }); 
}



function sendDataRegistro(){
$.ajax({
    type: "POST",
    url: urlServer.concat("ServidorApp/loginApp"),
    data: { 
        form : "REGISTRO",
        txtNombreRegistro : $("#txtNombreUsuario").val(),
        txtCorreoRegistro : $("#txtEmail").val(),
        txtPassRegistro : $("#txtPass").val(),
        
      },
  success : function(data){
    console.log(data);
    if(data == "Login realizado"){
      window.location.href="index.html";
    }
    else{
            alert(data);
        }
    }
    
  });
}

function sendDataLogin(){
  console.log("Haciedno login");
  var mail = $("#txtEmail").val();
  var pass = $("#txtPass").val();
  var urlActual = urlServer.concat("loginApp?mail=").concat(mail).concat("&pass=").concat(pass);
  $.get( urlActual , function( data ) {
    console.log(data);
    alert( "Load was performed." );
    window.location.href="shops.html";
  });
// $.ajax({
//     type: "POST",
//     url: urlServer.concat("ServidorApp/loginApp"),
//     data: { 
//       form : "LOGIN",
//       txtNombreLogin : $("#txtEmail").val(),
//       txtPassLogin : $("#txtPass").val()
//       },
//   success : function(data){
//     console.log(data);
//     if(data == "Login realizado"){
//       window.location.href="shops.html";
//     }
//     else{
//         console.log(data);
//         alert(data);
//     }
//   }
//   });
}


function sendDataRecuperacion(){
$.ajax({
    type: "POST",
    url: "/ProyectoFinalPaint/ControladorLogin",
    data: { form : "RECUPERACION",
        txtEmail : $("#txtMailRecup").val()
      },
  success : function(data){
    alert(data);
  }
  });
}






















