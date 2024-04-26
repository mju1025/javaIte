<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <!-- 부트스트랩 CSS 가져오기 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* 추가적인 스타일링 */
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f8f9fa;
        }
        .card {
            width: 350px;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
    </style>
</head>
<body>
	<div class="container d-flex justify-content-center align-items-center vh-100">
	    <div class="text-center">
	        <h1 style="margin-bottom: 20px;">BOARD</h1>
	        <div class="card">
	            <h2 class="text-center mb-4">회원가입</h2>
	            <form action="http://localhost:8080/board/signup" method="post">
	                <div class="mb-3">
	                    <label for="id" class="form-label">아이디</label>
	                    <input type="text" class="form-control" id="signupid" name="signupid" placeholder="아이디를 입력하세요" required>
	                </div>
	                <div class="mb-3">
	                    <label for="password" class="form-label">비밀번호</label>
	                    <input type="text" class="form-control" id="signuppassword" name="signuppassword" placeholder="비밀번호를 입력하세요" required>
	                </div>
	                <div class="mb-3">
	                    <label for="name" class="form-label">이름</label>
	                    <input type="text" class="form-control" id="signupname" name="signupname" placeholder="이름를 입력하세요" required>
	                </div>
	                <button type="submit" class="btn btn-primary w-100">회원가입하기</button>
	                <br>
	            </form>

	        </div>
	    </div>
	</div>

</body>
</html>
