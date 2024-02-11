const evtSubmitSaveMyInfo = (e) => {
    e.preventDefault();
    funcSaveMyInfo();

}

const funcSaveMyInfo = () => {
    const url = '/myinfo/save';
    const posting = $.post(url, $('#myinfoForm').serialize());
    posting.done((data) => {
        if(data.ok){

        }else{

        }
    })
}

$(() => {
    $('#myinfoForm').on('submit', evtSubmitSaveMyInfo)
})