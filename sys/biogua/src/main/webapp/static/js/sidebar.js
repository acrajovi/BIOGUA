$(document).ready(function() {
	
	var trigger = $('.hamburger'), overlay = $('.overlay'), isClosed = false;

	trigger.click(function() {
		
		hamburger_cross();
		
	});

	function hamburger_cross() {

		if (isClosed == true) {
			overlay.hide();
			trigger.removeClass('is-open');
			trigger.addClass('is-closed');
			isClosed = false;
			
		} else {
			
			overlay.show();
			trigger.removeClass('is-closed');
			trigger.addClass('is-open');
			isClosed = true;
		}
		
	}
	
	function deshabilitaRetroceso() {
		window.location.hash = "no-back-button";
		window.location.hash = "Again-No-back-button" // chrome
		window.onhashchange = function() {
			window.location.hash = "no-back-button";
		}
	}

	$('[data-toggle="offcanvas"]').click(function() {
		
		$('#wrapper').toggleClass('toggled');
		
	});
	
	$('.ir-arriba').click(function() {
		
		$('body, html').animate({
			
			scrollTop : '0px'
				
		}, 300);
		
	});

	$(window).scroll(function() {
		
		if ($(this).scrollTop() > 0) {
			
			$('.ir-arriba').slideDown(300);
			
		} else {
			
			$('.ir-arriba').slideUp(300);
			
		}
		
	});
	
	$('.pmsg').fadeOut(8000);

});