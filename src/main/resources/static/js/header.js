// Fixed Navbar
$(window).scroll(function () {
    if ($(window).width() < 992) {
        if ($(this).scrollTop() > 55) {
            $('.fixed-top').addClass('shadow');
        } else {
            $('.fixed-top').removeClass('shadow');
        }
    } else {
        if ($(this).scrollTop() > 55) {
            $('.fixed-top').addClass('shadow').css('top', -55);
        } else {
            $('.fixed-top').removeClass('shadow').css('top', 0);
        }
    } 
});
var btns = {
    '.homeBtn': '/',
    '#shopBtn': '/shop',
    '#shopDetailBtn': '/shop-detail',
    '#cartBtn': '/cart',
    '#chackoutBtn': '/chackout',
    '#testimonialBtn': '/testimonial',
    '#contactBtn': '/contact',
    '#404Btn': '/404'
}

$.each(btns, function(btn, url){
    $(btn).on('click', function(){
        window.location.href = url;
    });
});