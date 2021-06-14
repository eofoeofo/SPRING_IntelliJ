const listElem = document.querySelector('#list');
const pagingElem = document.querySelector('#paging');

function getListAjax(page= 1) { // 값이 안보내졌을 때 1값을 씀
    fetch('fav?page='+page)
        .then(res => res.json())
        .then(myJson => {
            console.log(myJson)
            makeView(myJson.list);
            makePaging(myJson.pagingCnt, page);
        });
}
// 페이징 view
function makePaging(data, selectedPage) {
    pagingElem.innerHTML = '';
    for(let i=1; i<=data; i++) {
        const span = document.createElement('span');
        if(selectedPage === i ) {
            span.classList.add('selected');
        } else {
            span.classList.add('pointer');
            span.addEventListener('click', ()=> {
                getListAjax(i);
            });
        }
        span.innerText = i;

        pagingElem.append(span);
    }
}

function makeView(data) {
    listElem.innerHTML = ''; // 이전에 값이 있었다면, 초기화 처리

    const table = document.createElement('table');
    listElem.append(table);

    table.innerHTML = `
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>글쓴이</th>
        <th>작성일시</th>
    </tr>
    `;

    data.forEach(item => {
       const tr = document.createElement('tr');
       table.append(tr);

       tr.classList.add('record');
       tr.addEventListener('click', ()=> {
           moveToDetail(item.iboard);
       });

       let imgSrc = '/res/img/no_profile.jpg'
        if(item.profileImg != null) {
            imgSrc = `/img/${item.iuser}/${item.profileImg}`;
        }

       tr.innerHTML = `
            <td>${item.iboard}</td>
            <td>${item.title}</td>
            <td>${item.writerNm}</td>
            <td>${item.regdt}</td>
       `;
    });
}

function moveToDetail(iboard) {
    location.href="/board/detail?iboard="+iboard;
}

getListAjax();