$(function(){
	
	var modal = $('#modalCadastroRapidoEstilo');
	var botaSalvar = modal.find('.js-modal-estilo-salvar-btn');
	
	var form = modal.find('form');
	form.on('submit',function(event){event.preventDefault()});
	
	var url = form.attr('action');
	var inputNomeEstilo = $('#nomeEstilo');
	var containerMensagemErro = $('.js-mensagem-cadastro-rapido-estilo');
	
	modal.on('shown.bs.modal', onModalShow);
	modal.on('hide.bs.modal', onModalClose);
	botaSalvar.on('click', onBotaSalvarClick);
	
	function onModalShow(){
		inputNomeEstilo.focus();
	}
	
	function onModalClose(){
		inputNomeEstilo.val('');
	}
	
	function onBotaSalvarClick(){
		var nomeEstilo= inputNomeEstilo.val().trim();
		
		$.ajax({
			url: url,
			method: 'POST',
			contentType: 'application/json',
			data: JSON.stringify({ nome: nomeEstilo }),
			error: onErroSalvandoEstilo,
			sucess: onEstiloSalvo
		});
	}
	
	function onErroSalvandoEstilo(obj){
		var mensagemErro = obj.responseText;
		
		containerMensagemErro.removeClass('hidden');
		containerMensagemErro.html('<span>' + mensagemErro + '</span>');
		form.find('.form-group').addClass('has-error');
	}
	
	function onEstiloSalvo(){
		
	}
});