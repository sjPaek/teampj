const funcGetMembersList = () => {
    const url = "/members/list";
    const getting = $.get(url);
    getting.done((data) => {
        if(data.ok){
            console.log(data);
            funcAppendMember(data.object);
        }else{
            showMessage('Error', data.msg);
        }
    })
    getting.fail(() => {
        showMessage('Error', '통신 에러 관리자에게 문의해주세요');
    })
}

const funcAppendMember = (data) => {
    if(data == null || data.size == 0){
        return;
    }

    console.log(data);

    $('#memberList').empty();
    let _tr = ``;
    $.each(data, (idx, item) => {
        console.log(item);
        _tr = `
                <tr class="text-center">
                    <td>${idx + 1}</td>
                    <td>${item.userId}</td>
                    <td>${item.userName}</td>
                    <td>${item.userEmail}</td>
                    <td>${item.userTel == null ? "-" : item.userTel}</td>
                    <td>${item.userLevel}</td>
                </tr>
                `;
        $('#memberList').append(_tr);
    })
} 


const evtClickInsertMember = (e) =>{
    e.preventDefault();
    console.log('insert');
    $('#memberModal').show();    

}
$(() => {
    funcGetMembersList();
    $('#memberInsert').on('click', evtClickInsertMember);
})