const funcGetMembersList = () => {
    const url = "/members/list";
    const getting = $.get(url);
    getting.done((data) => {
        console.log(data);
    })
    getting.fail(() => {
        showMessage('Error', '통신 에러 관리자에게 문의해주세요');
    })
}
$(() => {
    funcGetMembersList();
})