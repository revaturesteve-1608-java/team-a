
var $width = $(window).width();
var $height = $(window).height();
$height = $height - $(".jumbotron").height();
$height = $height - $("#InfoBar").height();

window.onresize = resizeContent($width, $height);

function resizeContent(width, height) {

	var $content = $(".plane");
	console.log($content[0]);
	
	var scale;
	scale = Math.min(width / 1920, height / 971);

	console.log(scale);

	$content.css({
		transform : "scale(" + scale + ")"
	});
}