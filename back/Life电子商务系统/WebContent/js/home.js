/**
 * @author Administrator
 */
$(function() {
	$(".accordion-header").click(function() {
		$(".accordion-header").removeClass("accordion-header-selected");
		$(this).addClass("accordion-header-selected");
	});
});
