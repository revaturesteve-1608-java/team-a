var $content = $(".plane");

var $wrapper = $(".wrapper");

window.onresize = resizeContent($(window).width(), $(window).height());

function resizeContent(width, height) {

	var scale, origin;
	scale = Math.min(width / 1920, height / 971);

	console.log(scale);

	$content.css({
		transform : "scale(" + scale + ")"
	});
}