const evtSubmitSaveMyInfo = (e) => {
    e.preventDefault();
    funcSaveMyInfo();

}

const funcSaveMyInfo = () => {
    const url = '/myinfo/save';
    const posting = $.post(url, $('#myinfoForm').serialize());
    posting.done((data) => {
        console.log(data);
        if(data.ok){
            showMessage('Success', "정상");
            location.href='/myinfo';
        }else{
            showMessage('Error', data.msg);
        }
    })
    .fail((e) => {
        console.log(e);
    })
}

$(() => {
    $('#myinfoForm').on('submit', evtSubmitSaveMyInfo)
})