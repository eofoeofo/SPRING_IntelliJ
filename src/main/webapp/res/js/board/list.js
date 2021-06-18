const frmElem = document.querySelector('#frm');
const selectElem = frmElem.recordCnt;





selectElem.addEventListener('change', function (){
	frmElem.page.value = 1;
	frmElem.submit();
	console.log(selectElem.value);
})

function moveToDetail(iboard) {
	location.href="/board/detail?iboard="+iboard;
}

function checkForm(Join) {

	let isSeasonChk = false;
	let arr_Season = document.getElementsByName("SEASON[]");
	for(let i=0; i<arr_Season.length; i++) {
		if(arr_Season[i].checked == true) {
			isSeasonChk = true;
			break;
		}
	}
	console.log()
	if(!isSeasonChk) {
		alert('계절 한개 이상 선택');
		return false;
	}
}