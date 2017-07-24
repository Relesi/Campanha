
var buscar = function(){
	var nomePizza = $('#torcedor_pesquisa').val();
	var url = 'campanha/torcedor/'+nomeTorcedor;
	
	$.get(url)
	.success(function(view){
		$('#secao-campanhas').html(view);
	});;
	
};

$(document).ready(function(){
	
	$('#btn-buscar').on('click', buscar);
	
});