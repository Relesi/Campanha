$(document).ready(function(){
	
	aplicarListeners();
	
	aplicatListenerBtnSalvar();
	
});

var limparModal = function(){
	$('#id').val('');
	$('#nome').val('');
	$('#email').val('');
	$('#dataNascimento').val('');
	$('#categoria').val('');
	$('#cadastros option').attr('selected', false);
};

var aplicatListenerBtnSalvar = function(){
	$('#btn-salvar').on('click', function(){
		var url = 'torcedor';
		var dadosTorcedor = $('#form-torcedor').serialize();
		$.post(url, dadosTorcedor)
			.done(function(pagina){
				$('#secao-torcedor').html(pagina)
				aplicarListeners();
				
			})
			.fail(function(){
				alert('Erro ao salvar!');
				
			})
			.always(function(){
				$('#modal-pizza').modal('hide');
			});
	});
}

var aplicarListeners = function(){
	
	$('#modal-torcedor').on('hide.bs.modal', limparModal);
	
	$('.btn-deletar').on('click', function(){
		var torcedorId = $(this).parents('tr').data('id');
		var csrf = $('#csrf').val();
		
		$.ajax({
			url : 'torcedor/'+torcedorId,
			type: 'DELETE',
			headers: {'X-CSRF-TOKEN': csrf},
		    success: function() {
		    	$('tr[data-id="'+pizzaId+'"]').remove();
				var pizzas = parseInt( $('#quantidade-torcedor').text() );
		    	$('#quantidade-torcedor').text(torcedor - 1);
		    }
		});
		
	});
	
	$('.btn-editar').on('click', function(){
		var torcedorId = $(this).parents('tr').data('id');
		var url = 'torcedor/'+torcedorId;
		$.get(url)
			.success(function(torcedor){
				$('#id').val(torcedor.id);
				$('#nome').val(torcedor.nome);
				$('#email').val(torcedor.email);
				$('#dataNascimento').val(torcedor.dataNascimentoemail);				
				$('#categoria').val(pizza.categoria);
				
				torcedor.cadastro.forEach(function(cadastro){
					var id = cadastro.id;
					$('#cadastro option[value='+id+']').attr('selected', true);
				});
				
				$('#modal-cadastro').modal('show');
			});;
	});
	
};