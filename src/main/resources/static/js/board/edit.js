$(document).ready(function () {
	/**
	 * 1. 전역 변수 선언
	 */

	/**
	 * 2. 초기 선언
	 */
	(function () {
		init();
		EventListener();
	})();

	/**
	 * 3. 페이지 초기 영역
	 */
	function init() {
		
	}

	/**
	 * 4. 이벤트 리스너 영역
	 */
	function EventListener() {
		document.getElementById('boardSubmit').addEventListener('click', function(e){
			e.preventDefault();

			let data = $("#boardSaveForm").serializeObject();
            console.log(data);
			let result = validation(data);

			if(result){
				if(confirm('등록하시겠습니까?')){
					data = JSON.stringify(data);
					httpRequest('/board/insert', data, 'POST', 'insert');
				}
			}
		});

	}

	/**
	 * 5. 사용자 함수 영역
	 */
    $.fn.serializeObject = function() {
        var o = {};
        var a = this.serializeArray();
        $.each(a, function() {
            if (o[this.name]) {
                if (!o[this.name].push) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    };

    function c_isEmpty(value) {
        if(typeof value === 'string') {
            value = value.trim();
        }
        return value === undefined || value === null || value === "";
    }

	function validation(data){
		if(c_isEmpty(data.title)){
			alert('제목을 입력해주세요');
			return false;
		}
		if(c_isEmpty(data.content)){
			alert('내용을 입력해주세요');
			return false;
		}

		return true;
	}

	// AJAX 설공시
	function successHttpRequest(data, status, flag) {
		if(flag == 'insert'){
			alert('등록이 완료되었습니다');
		    location.reload(true);
		}
	}

	// AJAX 실패시
	function errorHttpRequest(request, status, error, flag) {
		var errorMsgs = request.responseJSON;
		swal_error(errorMsgs.error);
		console.log(errorMsgs);
		console.log(error);
	}

	// AJAX 요청
	function httpRequest(url, data, method, flag, asyncOption) {
		if (c_isEmpty(asyncOption)) {
	    	asyncOption = true;
	    }
		$.ajax({
			url: g_context + url,
			method: method,
			data: data,
			dataType: "json",
			contentType: "application/json;charset=UTF-8",
			async: asyncOption,
			success: function (data, status) {
				successHttpRequest(data, status, flag);
			},
			error: function (request, status, error) {
				errorHttpRequest(request, status, error, flag);
			}
		});
	}

});