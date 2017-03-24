var Brewer = Brewer || {};

Brewer.Formatar = (function(){
	
	function Formatar(){
		this.decimal = $('.js-decimal');
		this.plain = $('.js-plain');
	}
	
	Formatar.prototype.iniciar = function(){
		this.decimal.maskMoney();
		
		this.plain.maskMoney({ precision: 0 });
	}

	return Formatar;
})();

$(function() {
	var decimal = new Brewer.Formatar();
	decimal.iniciar();
});


/*$(function() {
	var decimal = $('.js-decimal');
	decimal.maskMoney();
	
	var plain = $('.js-plain');
	plain.maskMoney({ precision: 0 });
});*/