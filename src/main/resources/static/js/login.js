const evtSubmitLogin = (e) => {
    e.preventDefault();
    console.log('submit')
    const url = '/login';
    const posting = $.post(url, $('#loginForm').serialize());
    posting.done((data) => {
        console.log(data);
        if(data.ok){
            location.href="/";
        }else{
            location.href="/login";            
        }
    })
     
}

$(() => {
    $('#loginForm').on('submit', evtSubmitLogin);
})