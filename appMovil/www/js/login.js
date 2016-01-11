

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
      url: urlServer.concat("ServidorApp/loginApp"),
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
        txtNombreRegistro : $("#nombreRegistro").val(),
        txtCorreoRegistro : $("#emailRegistro").val(),
        txtDireccionRegistro : $("#direccionRegistro").val(),
        txtPassRegistro : $("#passwordRegistro").val(),
      },
  success : function(data){
    var string = data.concat(" ");
    if(string.indexOf("Registro realizado")!= -1){
       console.log(data);
       navigator.notification.alert(
        'Se ha creado tu cuenta, puede iniciar sesion',  // message
        alertDismissed,         // callback
        'Exito',            // title
        'Iniciar Sesion'                  // buttonName
        );
        function alertDismissed() {
          window.location.href="index.html";
        }
    }
    else{
            var res = '<div class="alert alert-danger" role="alert"><a href="#" class="alert-link">'.concat(data);
            res = res.concat('</a></div>');
            $('.alertas').append(res);
        }
    }
    
  });
}

function sendDataLogin(){
$.ajax({
    type: "POST",
    url: urlServer.concat("ServidorApp/loginApp"),
    data: { 
      form : "LOGIN",
      txtNombreLogin : $("#txtEmail").val(),
      txtPassLogin : $("#txtPass").val()
      },
  success : function(data){
    var string = data.concat(" ");
    if( string.indexOf("Login realizado") != -1){
      console.log("login realizado");
      window.location.href="shops.html";
    }
        else{
            console.log(data);
            var res = '<div class="alert alert-danger" role="alert"><a href="#" class="alert-link">'.concat(data);
            res = res.concat('</a></div>');
            $('.alertas').append(res);
        }
  }
  });
}


function sendDataRecuperacion(){
$.ajax({
    type: "POST",
    url: urlServer.concat("ServidorApp/loginApp"),
    data: { form : "RECUPERACION",
        txtEmail : $("#txtMailRecup").val()
      },
  success : function(data){
    navigator.notification.alert(
        'Se ha enviado la contraseña',  // message
        alertDismissed,         // callback
        'Exito',            // title
        'OK'                  // buttonName
    );
    function alertDismissed() {
      window.location.href="index.html";
    }
  }
  });
}






















