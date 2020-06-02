const moreCount = 4;
let limit = 0;
let present = 0;
let currentId = 0;
let initFlag = 0;
let prefixUrl = "http://localhost:8080/reservationpractice/";
let moreFlag;
let prevNode;

function productInit() {
	initFlag = 1;
	var nowNode = document.querySelector(".event_tab_lst.tab_lst_min").firstElementChild;
	var id = nowNode.dataset.category;
	changeClassName(nowNode);
	currentId = id;
	url = prefixUrl + "products?categoryId=" + id + "&start=" + present; 
	sendAjax(url, "prod");
	
}
/*
 * 사실 tabInit은 jstl로 하면 될것 같은데, restAPI로 만들면서 이왕 전체를 나눠보자는 생각에 이렇게 만들었다.
 * 만들고 나니, pruductInit을 위해 tabInit이 필요한 상황에서 일부러 setTimeout를 쓸수밖에 없었고, 
 * 이런 사례들이 중복되다 보면 굉장히 난잡해 질것 같았다.
 * 차라리 그냥 controller에서 model로 넘겨주면서 jstl을 사용하는게 나아 보인다.(이걸 서버사이드 렌더링이라고 하는걸까?)
 * */
function tabInit() {
	var url = prefixUrl + "categories";
    sendAjax(url, "list");
	
}


document.addEventListener("DOMContentLoaded", function() {
	tabInit();
	setTimeout(() => {
		productInit();
	  },100);
});


function sendAjax(url, type) {
    var oReq = new XMLHttpRequest();
    oReq.addEventListener("load", function() {
        var data = JSON.parse(oReq.responseText);
        if(type === "list") {
        	makeListTemp(data);
        }
        if(type === "prod") {
        	makeProductTemp(data, initFlag);
        }
        	
    });
    oReq.open("GET", url);
    oReq.send();
}

function makeListTemp(data) {
	var html = document.getElementById("tabcontent").innerHTML;
	var resultHTML = "";
	var len = data.items.length;
	
	for(var i=0; i<len; i++) {
	    resultHTML += html.replace("{categoryId}", data.items[i].id)
	                    .replace("{categoryName}", data.items[i].name);
	}
	
	document.querySelector(".event_tab_lst").innerHTML = resultHTML;
}

function makeActive() {
	
}

function changeClassName(node) {
	if(!(typeof preNode == "undefined" || preNode == null)) {
		preNode.firstElementChild.className = "anchor";
	}
	node.firstElementChild.className = "anchor active";
	preNode = node;
}



var tabmenu = document.querySelector(".event_tab_lst.tab_lst_min");
tabmenu.addEventListener("click", function (evt) {
	present = 0;
	initFlag = 1;
	var nowNode = evt.target.closest("li")
	var id = nowNode.dataset.category;
	changeClassName(nowNode);
	currentId = id;
	url = prefixUrl + "products?categoryId=" + id + "&start=" + present; 
	sendAjax(url, "prod");
});

var more = document.querySelector(".more");
more.addEventListener("click", function (evt) {
	present += moreCount;
	var id = currentId; 
	url = prefixUrl + "products?categoryId=" + id + "&start=" + present; 
	sendAjax(url, "prod");
	if(present+moreCount >= limit) {
		var tmp = document.querySelector(".more>.btn");
		var parentTmp = tmp.parentElement;
		parentTmp.removeChild(tmp)
		moreFlag = 1;
	}
});




function makePromotionTemp(data) {
	
}

function makeProductTemp(data, init) {
	var html = document.getElementById("prodcontent").innerHTML;
	var resultHTML = "";
	var parent = document.querySelector(".wrap_event_box");
	var firstChild = parent.firstElementChild;
	var secoundChild = firstChild.nextElementSibling;

	let len = data.items.length;
	var plusNode;
	
	if(init === 1) {
		firstChild.innerHTML = resultHTML;
		secoundChild.innerHTML = resultHTML;
		initFlag = 0;
		makeListtxtTemp(data)
		limit = data.totalCount;
		makeMoreTemp(moreFlag);
	}
	
	for(var i=0; i<len; i++) {
		if(i%2 === 0) {
			plusNode = firstChild;
		}
		else {
			plusNode = secoundChild;
		}
		resultHTML = html.replace("{productDescription}", data.items[i].productDescription)
					.replace("{productImageUrl}", "../reservationpractice/img/"+ data.items[i].productImageUrl)
					.replace("{productDescription}", data.items[i].productDescription)
					.replace("{placeName}", data.items[i].placeName)
					.replace("{content}", data.items[i].productContent);
		plusNode.innerHTML += resultHTML;
	}	
}

function makeListtxtTemp(data) {﻿
	var target = document.querySelector(".pink");
	target.innerText = data.totalCount + "개";
}

function makeMoreTemp(flag) {﻿
	if(flag === 1){
		var parent = document.querySelector(".more");
		var html = document.getElementById("moretemplate").innerHTML;
		parent.innerHTML += html;
		moreFlag = 0;
	}
}
