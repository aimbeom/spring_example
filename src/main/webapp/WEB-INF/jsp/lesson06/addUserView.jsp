<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 추가</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>회원 정보 추가</h1>

		<form method="post" action="/lesson06/add_user">
			<div class="form-group">
				<label for="name">이름</label> <input type="text" id="name"
					name="name" class="form-control col-3" placeholder="이름을 입력하세요">
			</div>
			<div class="form-group">
				<label for="yyyymmdd">생년월일</label> <input type="text" id="yyyymmdd"
					name="yyyymmdd" class="form-control col-3"
					placeholder="예) 19961116">
			</div>
			<div class="form-group">
				<label for="email">email</label> <input type="text" id="email"
					name="email" class="form-control col-3" placeholder="이메일 주소를 입력하세요">
			</div>
			<div class="form-group">
				<label for="introduce">introduce</label>
				<textarea id="introduce" name="introduce" class="form-control col-5"
					rows="10"></textarea>
			</div>

			<input type="button" id="addBtn" class="btn btn-success" value="회원가입">
		</form>
	</div>

	<script>
		//AJAX와 submit은 공존불가!!

		$(document).ready(function() {
			/* 	// 1) jquery의 submit기능 이용하기
			 $('form').on('submit', function(e) {
			 e.preventDefault();  //submit 되는것을 막는다.
			
			 //alert("추가 버튼 클릭");
			
			 // validation (유효성 체크, 값이 잘 들어있나 확인)
			 let name = $('#name').val().trim(); 
			 //alert(name);
			 if(name == ""){
			 alert("이름을 입력하세요");
			 return false; //submit을 안하고 끝내버리겠다는 의미
			 }
			
			 let yyyymmdd = $('#yyyymmdd').val().trim();
			 if(yyyymmdd == ""){
			 alert("생년월일을 입력하세요");
			 return false; //return false는 form태그가 있을때만 사용
			 }
			
			 // 여기까지 도달하면 submit
			
			 }); */

			//2) jquery의 ajax 통신을 이용하기
			$('#addBtn').on('click', function() {
				alert("test");

				// validation (유효성 체크, 값이 잘 들어있나 확인)
				let name = $('#name').val().trim();
				//alert(name);
				if (name == "") {
					alert("이름을 입력하세요");
					return; //submit을 안하고 끝내버리겠다는 의미
				}

				let yyyymmdd = $('#yyyymmdd').val().trim();
				if (yyyymmdd == "") {
					alert("생년월일을 입력하세요");
					return;
				}

				// 모두 숫자인지 확인
				if (isNaN(yyyymmdd)) { //숫자가 아닌 값이 섞여있을 때 참이 된다.
					alert("숫자만 입력해주세요");
					return;
				}

				let email = $('#email').val().trim();
				let introduce = $('textarea[name=introduce]').val(); //안의 자기소개 내용을 가져온다

				alert(email);
				alert(introduce);
				
				//AJAX: 폼태그와 상관없이 비동기로 별도 요청(request)
				$.ajax({
					// request
					type:"POST"		//Request Method
					, url:"/lesson06/add_user"	//Action URL
					, data: {"name": name, "yyyymmdd":yyyymmdd, "email":email, "introduce":introduce} //key와 value
					 
					// response
					, success: function(data){
						alert(data);
					}
					, complete: function(data) {
						alert("완료");
					}
					, error: function(e){
						alert("error" + e);
					}
				}); 
			});
		});
	</script>

</body>
</html>