//////////////RENDER//////////////////
$(document).ready(function(){
	getTiendas();
	return false;
});
var listaDeTiendas;

function getTiendas(){
	$.ajax({
	    	type: "POST",
	    	url: urlServer.concat("ServidorApp/Tiendas"),
	    	data: { 
	      		peticion : "TIENDAS"
	      	},
	  success : function(data){
	    listaDeTiendas = JSON.parse(data);
	    //console.log(data);
	    insertData();
	  }
	});
}

function insertData(){
	var tiendasRender = "";
	for(var i=0; i<listaDeTiendas.length; i++){		
		//console.log("hola"+listaDeTiendas[i].nombre);
		tiendasRender = tiendasRender + '<div class="row"><div class="col-sm-4 col-lg-4 col-md-4"><div class="thumbnail">'
                            +'<img src="'+urlServer+'ServidorApp/img/'+ listaDeTiendas[i].imagen+'" alt="">'
                            +'<div class="caption">'
                            +'<h4><a href="producto.html?id='+listaDeTiendas[i].idTienda+'">'+listaDeTiendas[i].nombre+'</a>'
                            +'</h4>    <p>Lorem ipsum dolor sit amet, conse, temporibus doloribus! Architecto, odit, labore!</p>'
                            +'</div>'
                            +'<div class="ratings">'
                            +'<p class="pull-right">15 reviews</p>'
                            +'<p>';
                        for(var j=0; j<listaDeTiendas[i].estrellas; j++){
                            tiendasRender = tiendasRender+'<span class="glyphicon glyphicon-star"></span>';
                        } 
                        tiendasRender = tiendasRender + '</p></div></div></div></div>';
	}
	//console.log(tiendasRender);
	$(".listaTiendas").append(tiendasRender);
}


//////////////EVENTOS//////////////////











//////////////FUNCIONES//////////////////
