/**
 * 어차피 이건 연습이니, 새로 배워가는 코딩 스킬은 이전 연습에도 적용시키지는 않으려고 한다.(지금 연습기준 mainpage.js)
 * 발전과정을 기록으로 남기는 것도 있으며, 어차피 지금 하는 것에 적용 잘 시키면 되는 것 아닌가(반복작업일 터)
 */
let curPageNum = 1;
let maxPageNum = 0;
var paginationRight = document.querySelector(".spr_book2.ico_arr6_rt");
var paginationLeft = document.querySelector(".spr_book2.ico_arr6_lt");
var contentMore = document.querySelectorAll(".bk_more");
var tabmenu = document.querySelectorAll(".info_tab_lst .item");

/**
 * 객체 리터럴로 웹페이지를 관리하는건 어려워 보인다. 아마도 잘 다룬 예시를 아직 보지 않아서 그런지 몰라도
 * jstl로 데이터가 오면 그냥 reduce와 map을 이용해 원하는 data로 가공하고 이용하면 되니까 굳이 객체리터럴을 사용할 이유를 못찾겠다. 앱을 만든다면 모를까
 * 이 프로젝트를 다 만들어보고, 웹사이트 js를 찾아 읽어봐야 겠다.
 */


document.addEventListener("DOMContentLoaded", function() {
	initPagination(detailData);
	initDescription(detailData);
	initComments(detailData, "detail");
	initDetails(detailData);
});


window.addEventListener("load", function() {

});

function makePaginationData(objectArray, bringArray) {
    return objectArray.reduce(function (acc, cur) {
        if (!acc["item"]) {
			acc["item"] = []; 	//item을 사용한 이유는 나중에 추가적인 data를 이용할수도 있게끔 만들의도였는데, (예를들면 item항목, 기타등등 항목..)
								//추가적으로 만들어야 하므로 함수에 key값을 매개변수로 받아야 하는데 만들고 나니 여기서 추가적인 data를 굳이 다뤄야 하나 싶어서
								//그 이후 에는 쓰지 않았다. (makeComment에서는 item을 사용하지 않았다.)
		}
		if (cur.type === "ma" || cur.type === "et") {
			var rObj = {};
			rObj.saveFileName = cur.saveFileName;
			rObj.productDescription = bringArray.productDescription;
			acc["item"].push(rObj);
		}
        return acc;
    }, {});
}

function initPagination(data) {
	var paginationData = makePaginationData(data.productImages, data.displayInfo[0]);
	makePagination(paginationData);
	var initFlag = true;
	setPageNum(paginationData.item, initFlag);
	changeGradeValue(data);
}

function initDescription(data) {
	document.querySelector(".dsc").innerText = data.displayInfo[0].productContent;
}

function makePagination(data){
	var template = document.querySelector("#paginationItem").innerText;
	//pre-complie
	var bindTemplate = Handlebars.compile(template);
	var resultHTML = "";

	data.item.forEach(function (item) {
		resultHTML += bindTemplate(item);
	})
	var show = document.querySelector(".visual_img.detail_swipe");
	show.innerHTML = resultHTML;
}

function setPageNum(data, initFlag) {
	var parent = document.querySelector(".figure_pagination");
	if(initFlag) {
		const len = data.length;
		maxPageNum = len;
		parent.lastElementChild.firstElementChild.innerText = len;
		if(len === 1) {
			var target = document.querySelector(".spr_book2.ico_arr6_rt");
			target.className += " off";
		}
	}
}

function changePageNum(curNum) {
	var parent = document.querySelector(".figure_pagination");
	parent.firstElementChild.innerText = curNum;
}

paginationRight.addEventListener("click", function () {
	var orderCorrection = 1;
	var nowPage = curPageNum-orderCorrection;
	
	if(nowPage === maxPageNum-orderCorrection){
		return;
	}
	
	var target = document.querySelector(".visual_img.detail_swipe");
	target.style.transition = '1s';
	target.style.transform = "translate3d(-" + 414 * (nowPage+1) + "px, 0px, 0px";
	
	nowPage++;
	
	if(nowPage === 1) {
		pointerOnOff("left", "on")
	}
	if(nowPage === maxPageNum-orderCorrection) {
		pointerOnOff("right", "off")
	}
	curPageNum = nowPage+orderCorrection;
	changePageNum(curPageNum);
});

paginationLeft.addEventListener("click", function () {

	var orderCorrection = 1;
	var nowPage = curPageNum-orderCorrection;
	
	if(nowPage === 0) {
		return;
	}
	
	var target = document.querySelector(".visual_img.detail_swipe");
	target.style.transition = '1s';
	target.style.transform = "translate3d(-" + 414 * (nowPage-1) + "px, 0px, 0px";
	
	nowPage--;
	if(nowPage === 0) {
		pointerOnOff("left", "off")
	}
	if(nowPage === maxPageNum-orderCorrection-1) {
		pointerOnOff("right", "on")
	}
	curPageNum = nowPage+orderCorrection;
	changePageNum(curPageNum);
});


function pointerOnOff(dir, onOff) {
	if(dir === "right") {
		var pointer = document.querySelector(".spr_book2.ico_arr6_rt");
		switch (onOff) {
			case "on":
				pointer.className = "spr_book2 ico_arr6_rt on";
				break;
			case "off":
				pointer.className = "spr_book2 ico_arr6_rt off";
				break;
		}
	}

	if(dir === "left") {
		var pointer = document.querySelector(".spr_book2.ico_arr6_lt");
		switch (onOff) {
			case "on":
				pointer.className = "spr_book2 ico_arr6_lt on";
				break;
			case "off":
				pointer.className += "spr_book2 ico_arr6_lt off";
				break;
		}
	}
}

contentMore.forEach(function(item){
	item.addEventListener("click", function(evt) {
		var nowNode = evt.target.closest("a");
		nowNode.style.display = "none";
		changeBkMore(nowNode.className);
	});
})

function changeBkMore(className) {
	if( className === "bk_more _open") {
		var nowNode = document.querySelector(".bk_more._close");
		nowNode.style.display = "";
		nowNode.parentNode.firstElementChild.className = "store_details";
	}

	if( className === "bk_more _close") {
		var nowNode = document.querySelector(".bk_more._open");
		nowNode.style.display = "";
		nowNode.parentNode.firstElementChild.className += " close3";
	}
}

tabmenu.forEach(function(item) {
	item.addEventListener("click", function (evt) {
		var nowNode = evt.target.closest("li");
		var parent = nowNode.parentElement;
		var pointer;
		if(parent.firstElementChild == nowNode) {
			prevNode = parent.lastElementChild;
			pointer = "left"
		}
		if(parent.lastElementChild == nowNode) {
			prevNode = parent.firstElementChild;
			pointer = "right"
		}
		changeHideClass(pointer);
		changeAnchorClass(nowNode, prevNode);
	});
})

function changeHideClass(pointer) {
	var left = document.querySelector(".detail_area_wrap");
	var right = document.querySelector(".detail_location");

	if(pointer == "left") {
		left.className = "detail_area_wrap";
		right.className = "detail_location hide";
		return;
	}
	if(pointer == "right") {
		left.className = "detail_area_wrap hide";
		right.className = "detail_location";
		return;
	}
}

function makeDetailData(objectArray) {
	return objectArray.reduce(function (acc, cur) {
		//사실 아마도, 전시 항목 입력시 공지사항과 관련된 image, 공연정보와 관련된 image를 db에서 가지고 있는것으로 추측된다.
		//그래서 단순히 description 하나 만을 가지고 오는 건데도 Data를 만드는 함수를 굳이 만들었고,
		//여러 이미지를 가지고 있을 경우 를 대비해서 reduce를 사용해 따로 객체를 만들었다. 
		//근데 어차피 이것도 설계하기 나름인지라, 그냥 확장성! 생각하며 만들긴 했는데, 확장성에 맞는지도 사실 잘 모르겠다. ㅋㅋ
		acc.productDescription = cur.productContent;
		return acc;
	}, {});
}

function makeLocationData(objectArray) {
	return objectArray.reduce(function (acc, cur) {
		acc.placeLot = cur.placeLot;
		acc.placeName = cur.placeName;
		acc.placeStreet = cur.placeStreet;
		acc.telephone = cur.telephone;
		return acc;
	}, {});
}

function initDetails(data) {
	/**
	 * 여기서 좀 data를 어떻게 넣어주고 어떤걸 쓸지 기준을 정해 놔야겠다. 어떠건 그냥 생 데이타 들어가게 만들고
	 * 어떤건 가공된 data 집어 넣도록 만들어 주니 계속 디버깅하면서 조정해야하는 불편함이 생긴다.
	 */
	var detailData = makeDetailData(data.displayInfo);
	var locationData = makeLocationData(data.displayInfo);
	makeDetail(detailData);
	makeLocation(locationData);
	changeStoreName(data.displayInfo[0]);
	changeLoactionImage(data.displayInfoImage[0]);
}

function makeDetail(data) {
	var template = document.querySelector("#detailInfoTemplate").innerText;
	//pre-complie
	var bindTemplate = Handlebars.compile(template);
	var resultHTML = bindTemplate(data);

	var show = document.querySelector(".detail_info_group");
	show.innerHTML = resultHTML;
}

function makeLocation(data) {
	var template = document.querySelector("#detailLocationTemplate").innerText;
	//pre-complie
	var bindTemplate = Handlebars.compile(template);
	var resultHTML = bindTemplate(data);
	/**
	 * Location은 지도 + 위치정보 이다.
	 * 정확히는   지도 
	 * 		    회사이름
	 *          위치정보
	 * 근데 지도 와 회사이름은 각각 data하나씩이다. 그리고 위치정보만 template로 가져오는게 DomTree구조상 위치잡기 편했다.
	 * 그래서 그냥 나머지는 함수로 해결
	 */ 

	var show = document.querySelector(".store_info");
	show.innerHTML = resultHTML;
}

function changeStoreName(data) {
	document.querySelector(".store_name").innerText = data.placeName;
}

function changeLoactionImage(data) {
	document.querySelector(".store_map").src = data.saveFileName;

}