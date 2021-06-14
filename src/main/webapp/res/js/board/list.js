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