<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.vo.MemberVO"
%>
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
	 <%
	 	MemberVO membervo = (MemberVO)session.getAttribute("LOGIN_MEMBER_DATA");
	 	//System.out.println(membervo);
	 %>
	<div class="container d-flex justify-content-center align-items-center vh-100">
	    <div class="text-center">
	        <h1 style="margin-bottom: 20px;">MY Page</h1>
	        <div class="card">
	            <h2 class="text-center mb-4">내 정보 수정</h2>
	            	
	            	<form action="http://localhost:8080/board/update" method="post">
		                <div class="mb-3">
		                    <label for="id" class="form-label">아이디</label>
		                    <input type="text" class="form-control" id="updateid" name="updateid" value="<%= membervo.getMember_id() %>" readonly>

		                </div>
		                <div class="mb-3">
		                    <label for="password" class="form-label">비밀번호</label>
		                    <input type="password" class="form-control" id="password" name="updatepassword" placeholder="비밀번호를 수정하세요" required>
		                </div>
		                
		                <div><button type="submit" class="btn btn-primary w-100">수정하기</button></div>
	                </form>
	                <br>
	     			<form action="http://localhost:8080/board/delete" method="post">
	                <%-- MemberVO 객체를 숨겨진 input 필드에 저장 --%>
    					<input type="hidden" name="deleteid" value="<%= membervo.getMember_id() %>">
	                
	                <button type="submit" class="btn btn-primary w-100">탈퇴하기</button>
					</form>
	        </div>
	    </div>
	</div>
</body>
</html>
