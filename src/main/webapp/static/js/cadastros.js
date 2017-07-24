$(document).ready(function(){
	
	aplicarListeners();
	
	aplicatListenerBtnSalvar();
	
});

var aplicatListenerBtnSalvar = function(){
	$('#btn-salvar').on('click', function(){
		var url = 'cadastros';
		var dadosCadastros = $('#form-cadastro').serialize();
		
		$.post(url, dadosCadastro)
			.done(function(pagina){
				$('#secao-cadastros').html(pagina)
				aplicarListeners();
				
			})
			.fail(function(){
				alert('Erro ao salvar!');
				
			})
			.always(function(){
				$('#modal-cadastro').modal('hide');
			});
	});
}


var limparModal = function(){
	$('#id').val('');
	$('#nome').val('');
	$('#categoria').val('');
};


var aplicarListeners = function(){
	$('#modal-cadastro').on('hide.bs.modal', limparModal);
	
	$('.btn-editar').on('click', function(){
		var id = $(this).parents('tr').data('id');
		var url = 'cadastros/'+id;
		
		$.get(url)
			.success(function(cadastro){
				$('#id').val(cadastro.id);
				$('#nome').val(cadastro.nome);
				$('#categoria').val(cadastro.categoria);
				
				$('#modal-cadastro').modal('show');
			});
	});
	
	
	$('.btn-deletar').on('click', function(){
		var id = $(this).parents('tr').data('id');
		var csrf = $('#csrf').val();
		
		$.ajax({
			url : "cadastros/"+id,
			type: 'DELETE',
			headers: {'X-CSRF-TOKEN': csrf},
		    success: function(result) {
		    	$('tr[data-id="'+id+'"]').remove();
				var cadastros = parseInt( $('#quantidade-cadastros').text() );
		    	$('#quantidade-cadastros').text(cadastros - 1);
		    }
		});
		
		
	});
	
}