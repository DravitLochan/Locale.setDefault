var main = function(){
	$('.search').click(function(){
		$('.screen1').animate({
			top: '0px',
			display: 'block'
		},500);
		$('.screen1').css('display', 'block');
	});
	$('.search1').click(function(){
		$('.screen1').animate({
			top: '750px'
		},800);
		setTimeout(function(){$('.screen1').css('display', 'none');}, 1200);
	});
}
var main= function(){
	$(window).scroll(function(){
		var wind = $(this).scrollTop();
		if(wind>=100){
			$('.menu').addClass('new');
			$('.logo').addClass('newlog');
			$('.item').addClass('newit');
			$('.newit').removeClass('item');
		}
		if(wind<100){
			$('.menu').removeClass('new');
			$('.logo').removeClass('newlog');
			$('.newit').addClass('item');
			$('.item').removeClass('newit');
		}
	});
	$('.down').click(function(){
			$('html, body').animate({
				scrollTop: $('.main2').offset().top
			},700);
	});
}


$(document).ready(main);

particlesJS.load('particles-js', 'assets/particles.json', function() {
  console.log('callback - particles.js config loaded');
});

$(document).ready(main);