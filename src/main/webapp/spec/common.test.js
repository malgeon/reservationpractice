function changeAnchorClass(node, prevNode) {
	if(!(typeof prevNode == "undefined" || prevNode == null)) {
		prevNode.firstElementChild.className = "anchor";
	}
	node.firstElementChild.className = "anchor active";
	return node;
}

function initComments(data, pageInfo) {
	var commentData = makeCommentData(data);
	changeGradeValue(data);
	makeComments(commentData, pageInfo);
}


function makeCommentData(objectArray) {
	return objectArray.comments.reduce(function (acc, cur) {
		var obj = {};
		obj.comment = cur.comment;
		var date = new Date(cur.reservationDate);
		obj.reservationDate = date.toLocaleDateString();
		obj.email = cur.reservationEmail.substr(0,4) + "****";
		obj.score = cur.score.toFixed(1);
		obj.imageFlag = false;
		if(!(cur.commentImages == null || cur.commentImages == 0)) {
			obj.imageFlag = true;
			obj.image = cur.commentImages[0].saveFileName;
			obj.imageCount = cur.commentImages.length;
		}
		acc.push(obj);
		return acc;
	}, []);
}

function makeComments(data, pageInfo) {
	if(data == null || data == 0) {
		eraseReviewMore();
		return;
	}
	var imageTemplate = document.querySelector("#commentImageTemplate").innerText;
	var template = document.querySelector("#commentTemplate").innerText;
	//pre-complie
	var bindTemplate = Handlebars.compile(template);
	var bindImageTemplate = Handlebars.compile(imageTemplate);

	var resultHTML = "";

	if(pageInfo === "detail"){
		let len = 3;
		if(data.length <= 3) {
			len = data.length;
			eraseReviewMore();
		}
		for(var i=0; i<len; i++) {
			if(data[i].imageFlag){
				resultHTML += bindImageTemplate(data[i]);
			}
			else{
				resultHTML += bindTemplate(data[i]);
			}
		}
	}

	if(pageInfo === "review") {
		data.forEach(function(item) {
			if(item.imageFlag){
				resultHTML += bindImageTemplate(item);
			}
			else{
				resultHTML += bindTemplate(item);
			}
		})
	}
	var show = document.querySelector(".list_short_review");
	show.innerHTML = resultHTML;
}

function eraseReviewMore() {
	document.querySelector(".btn_review_more").style.display = "none";
}

function changeGradeValue(data) {
	var parent = document.querySelector(".grade_area");
	var graphMaskParent = parent.firstElementChild;
	var textValue = graphMaskParent.nextElementSibling;
	var commentCount = parent.lastElementChild;
	var value = data.averageScore;
	var rateValue = value/5 * 100;
	graphMaskParent.firstElementChild.style.width = rateValue.toFixed(0) + "%";
	textValue.firstElementChild.innerText = value.toFixed(1);
	commentCount.firstElementChild.innerText = data.comments.length+ "건";
}