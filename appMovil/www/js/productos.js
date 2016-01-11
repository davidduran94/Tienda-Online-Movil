//////////////RENDER//////////////////
var listaDeProductos;
var idTienda;
$(document).ready(function(){
	idTienda = document.URL.substring((document.URL.length-3, document.URL.length-2))[0];
	//console.log(idTienda);
	getProductos(idTienda);
	return false;
});


function getProductos(idTienda){
	$.ajax({
	    	type: "POST",
	    	url: urlServer.concat("ServidorApp/Tiendas"),
	    	data: { 
	      		peticion : "PRODUCTOS",
	      		idTienda : idTienda
	      	},
	  success : function(data){
	    listaDeProductos = JSON.parse(data);
	    //console.log(data);
	    insertData();
	  }
	});
}

function insertData(){
	var productosRender = "";
	for(var i=0; i<listaDeProductos.length; i++){		
		productosRender = productosRender + '<div class="thumbnail">'
                    +'<img src="'+urlServer+'ServidorApp/img/'+ listaDeProductos[i].imagen+'" alt="">'
                    +'<div class="caption-full">'
                        +'<h4 class="pull-right">$'+listaDeProductos[i].precio+'.00</h4>'
                        +'<h4><a href="#">'+listaDeProductos[i].nombre+'</a>'
                        +'</h4>'
                        +'<p>'+listaDeProductos[i].descripsion+' </p>'
                    +'</div>'
                    +'<div class="ratings">'
                        +'<div class="col-md-3">'
                        +'<div class="list-group">'
                            +'<a href="#" class="list-group-item active">Lo quiero</a>'
                        +'</div>'
                        +'</div>'
                        +'<div class="text-left">'
                        +'<a class="btn btn-success">Comentar</a>'
                        +'</div>'
                        +'<p>'
                            +'<span class="glyphicon glyphicon-star"></span>'
                            +'<span class="glyphicon glyphicon-star"></span>'
                            +'<span class="glyphicon glyphicon-star"></span>'
                            +'<span class="glyphicon glyphicon-star"></span>'
                            +'<span class="glyphicon glyphicon-star-empty"></span>'
                            +'4.0 estrellas'
                        +'</p>'
                    +'</div>'
                +'</div>';
	}
	//console.log(productosRender);
	$(".listaProductos").append(productosRender);
}


//////////////EVENTOS//////////////////











//////////////FUNCIONES//////////////////
