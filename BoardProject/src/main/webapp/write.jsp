<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.vo.MemberVO"
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판 글쓰기</title>
    <!-- 부트스트랩 CDN 추가 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

	 <%
	 	MemberVO membervo = (MemberVO)session.getAttribute("LOGIN_MEMBER_DATA");
	 	//System.out.println(membervo);
	 %>
    <div class="container mt-5">
        <h1 class="mb-4">게시판 글쓰기</h1>
        <form action="http://localhost:8080/board/writeupload" method="POST">
            <div class="mb-3">
                <label for="post_title" class="form-label">제목:</label>
                <input type="text" class="form-control" id="post_title" name="post_title" required>
            </div>
            <input type="hidden" name="writeuploadid" value="<%= membervo.getMember_id() %>">
            <div class="mb-3">
                <label for="post_content" class="form-label">본문 내용:</label>
                <textarea class="form-control" id="post_content" name="post_content" rows="6" required></textarea>
            </div>
            <button type="submit" class="btn btn-primary">게시판 올리기</button>
        </form>
    </div>
</body>
</html>
