<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.vo.MemberVO, board.vo.BoardVO,java.util.*"
%>
<%@ page import="comment.vo.CommentVO"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


    <!-- jQuery에 대한 CDN -->
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    
    <!-- 수정 삭제 jQUery -->
    <script>
        $(document).ready(function() {
            // 수정 버튼 클릭 시
            $(".comment-update-btn").click(function() {
                var comment_id = $(this).closest(".card-body").find("input[name='commentid']").val();
                var post_id = $(this).closest(".card-body").find("input[name='postid']").val();                
                var content = $(this).closest(".card-body").find("textarea[name='commentupdatewrite']").val();
                
                $.ajax({
                    method: "POST",
                    url: "/board/commentupdate",
                    data: { comment_id: comment_id, content: content, post_id: post_id},
                    success: function(result) {
                    	 // 댓글 수정 성공 시 해당 댓글의 내용 업데이트
                        $("#" + comment_id).text(content);
                    }
                });

            });

            // 삭제 버튼 클릭 시
            $(".comment-delete-btn").click(function() {
                var comment_id = $(this).closest(".card-body").find("input[name='commentid']").val();
                var post_id = $(this).closest(".card-body").find("input[name='postid']").val();                
                
                $.ajax({
                    type: "POST",
                    url: "/board/commentdelete",
                    data: { comment_id: comment_id, post_id: post_id},
                    success: function(response) {
                    	comment_content = $('div[cid=' + comment_id +']');
                    	comment_content.remove();
                    },
                    error: function(xhr, status, error) {
                        console.error(xhr.responseText);
                    }
                });
            });
        });
    </script>




<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<style>

</style>

<main class="container">
 	<%
 	MemberVO membervo = (MemberVO)session.getAttribute("LOGIN_MEMBER_DATA");
 	%>
   <%
	BoardVO detailPost = (BoardVO)request.getAttribute("detailPost");
   System.out.println(detailPost);
	%>
    <header class="py-5 text-center">
        <h1><%= detailPost.getTitle() %></h1>
    </header>

    <div class="row g-5">
        <section class="col-md-3 col-lg-4 order-md-last">
            <aside>
				<div>작성자: <%= detailPost.getAuthor_id() %>
				    <span>
				        <% if(membervo.getMember_id().equals(detailPost.getAuthor_id())) { %>
				        	<form action="http://localhost:8080/board/mypost" method="post">
				        		<input type="hidden" name="postid" value="<%= detailPost.getPost_id() %>">
				            	<button class="btn btn-primary" id="comment-submit" type="submit">내 글 수정하기</button>
				            </form>
				        <% } %>
				    </span>
				</div>
            </aside>

        </section>

        <article id="article-content" class="col-md-12 col-lg-10">
        	<div class="content">
            <%= detailPost.getContent() %>
            </div>
        </article>


    </div>
    </div>
<div class="mt-3"></div> <!-- Bootstrap의 mt-3 클래스를 사용하여 위쪽 여백 추가 -->
    <div class="row 9-5">
       
            <form class="row g-3" action="http://localhost:8080/board/commentwrite" method="post">
                <div class="col-md-9 col-lg-8">
                    <label for="articleComment" hidden>댓글</label>
                    <textarea class="form-control" id="articleComment" name = "commentwrite" placeholder="댓글 쓰기.." rows="3"
                              required></textarea>
                    <input type="hidden" name="postid" value="<%= detailPost.getPost_id() %>">                 
                </div>
                <div class="col-md-3 col-lg-4">
                    <label for="comment-submit" hidden>댓글 쓰기</label>
                    <button class="btn btn-primary" id="comment-submit" type="submit">쓰기</button>
                </div>

            </form>



		<div class="container mt-4">
		    <h8>댓글</h8>
		    <hr>
    <% 
    List<CommentVO> commentList = (List<CommentVO>)request.getAttribute("commentlist");
    if (commentList != null && !commentList.isEmpty()) {
        for (CommentVO comment : commentList) {
    %>
		    <div class="card mb-3" cid= "<%= comment.getComment_id() %>">
		        <div class="card-body">
		            <h5 class="card-title"><%= comment.getAuthor_id() %></h5>
		            <p class="card-text" id= "<%= comment.getComment_id() %>" ><%= comment.getContent() %></p>
  				        <% if(membervo.getMember_id().equals(comment.getAuthor_id())) { %>
			        		<input type="hidden" name="commentid" value="<%= comment.getComment_id() %>">
			        		<input type="hidden" name="postid" value="<%= comment.getPost_id() %>">

			        		<textarea class="form-control" name = "commentupdatewrite" placeholder="댓글 수정하기..." rows="1"
                              required></textarea>
			            	<button class="btn btn-primary comment-update-btn" value="commentupdate" type="button">수정</button>
			            	<button class="btn btn-primary comment-delete-btn" value="commentdelete" type="button">삭제</button>			            	
				        <% } %>
		        </div>
		    </div>
    <% 
        } 
    } else { 
    %>
		    <p>댓글이 없습니다.</p>
    <% } %>
		</div>

        
    </div>
    <div class="row g-5">
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li class="page-item">
                    <a class="page-link" href="http://localhost:8080/board/boards">
                        <span aria-hidden="true">&laquo;</span>
                        <span class="sr-only">게시판 가기</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>