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
            showMessage('Error', data.msg);
            location.href="/login";            
        }
    })
     
}

$(() => {
    $('#loginForm').on('submit', evtSubmitLogin);    
})