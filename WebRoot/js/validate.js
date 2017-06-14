//检查数据
/*
 * elementId：被检查元素ID 
 * msg：检查有误  提示消息
 */
function test(elementId, msg) {
	if ($("#" + elementId).val() == "" || $("#" + elementId).val().trim() == "") {
		$("#" + elementId).css("color", "red");
		$("#" + elementId).val(msg);
		return 0;
	}
}

//清除提示
/*
 * elementId：被检查元素ID 
 * color:还原颜色
 * msg：清楚的消息
 */
function clearmsg(elementId, color, msg) {
	$("#" + elementId).focus(function() {
		$("#" + elementId).css("color", color);
		if ($("#" + elementId).val() == msg) {
			$("#" + elementId).val("")
		}
	});
}