document.addEventListener("DOMContentLoaded", function() {
	initComments(detailData, "review");
	changeDescription(detailData);
});


window.addEventListener("load", function() {

});

function changeDescription(data) {
	var target = document.querySelector(".title");
	target.innerText = data.displayInfo[0].productDescription
}