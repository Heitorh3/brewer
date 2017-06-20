Brewer = Brewer || {}

Brewer.BotaoSubmit = (function(){
	
	function BotaoSubmit(){
		this.submitBtn = $('.js-submit-btn');
		this.formulario = $('.js-formulario-principal');
	}
	
	BotaoSubmit.prototype.iniciar = function(){
		this.submitBtn.on('click',onSubmit.bind(this));
		
	}
	
	function onSubmit(evento){
		evento.preventDefault();
		
		var botaoClicato = $(evento.target);
		var acao = botaoClicato.data('acao');
		
		var acaoImput = $('<input>');
		acaoImput.attr('name',acao);
		
		this.formulario.append(acaoImput);
		this.formulario.submit();
	}
	
	return BotaoSubmit;
}());

$(function(){
	
	var botaoSubmit = new Brewer.BotaoSubmit();
	botaoSubmit.iniciar();
	
});