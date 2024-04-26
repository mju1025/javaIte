<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.vo.MemberVO, board.vo.BoardVO,java.util.*"
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <title>게시판</title>
    <!-- 부트스트랩 CSS 가져오기 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* 추가적인 스타일링 */

		.search-form {
		  width: 80%;
		  margin: 0 auto;
		  margin-top: 1rem;
		  margin-left: 1rem;
		}
		
		.search-form input {
		  height: 100%;
		  background: transparent;
		  border: 0;
		  display: block;
		  width: 100%;
		  padding: 1rem;
		  height: 100%;
		  font-size: 1rem;
		}
		
		.search-form select {
		  background: transparent;
		  border: 0;
		  padding: 1rem;
		  height: 100%;
		  font-size: 1rem;
		}
		
		.search-form select:focus {
		  border: 0;
		}
		
		.search-form button {
		  height: 100%;
		  width: 100%;
		  font-size: 1rem;
		}
		
		.search-form button svg {
		  width: 24px;
		  height: 24px;
		}
		
		.card-margin {
		  margin-bottom: 1.875rem;
		}
		
		@media (min-width: 992px) {
		  .col-lg-2 {
		    flex: 0 0 16.66667%;
		    max-width: 16.66667%;
		  }
		}
		
		.card {
		  border: 0;
		  box-shadow: 0px 0px 10px 0px rgba(82, 63, 105, 0.1);
		  -webkit-box-shadow: 0px 0px 10px 0px rgba(82, 63, 105, 0.1);
		  -moz-box-shadow: 0px 0px 10px 0px rgba(82, 63, 105, 0.1);
		  -ms-box-shadow: 0px 0px 10px 0px rgba(82, 63, 105, 0.1);
		}
		
		.card {
		  position: relative;
		  display: flex;
		  flex-direction: column;
		  min-width: 0;
		  word-wrap: break-word;
		  background-color: #ffffff;
		  background-clip: border-box;
		  border: 1px solid #e6e4e9;
		  border-radius: 8px;
		}
    </style>
</head>
<body>

<header class="p-3 text-bg-dark">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">


            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="#" class="nav-link px-2 text-secondary">Board Project</a></li>
            </ul>

				 <%
				 	MemberVO membervo = (MemberVO)session.getAttribute("LOGIN_MEMBER_DATA");
				 	//System.out.println(membervo);
				 %>
            <div class="d-flex justify-content-end">

			    <a href="http://localhost:8080/board/logout" class="btn btn-warning">Logout</a>
			    
			    <form action="http://localhost:8080/board/mypage.jsp" method="post" style="margin-left: 10px;">
			        <button type="submit" class="btn btn-warning">My Page</button>
			    </form>
			</div>
			        </div>
    </div>
</header>

<div class="row">

    <div class="card card-margin search-form text-center">
  
        <div class="card-body p-0">
            <div class="row">
                <div class="col-12">
                    <form action="http://localhost:8080/board/search" method="post">
                       
                        <div class="row no-gutters">
                            <div class="col-lg-3 col-md-3 col-sm-12 p-0">
                                <input type="text" class="form-control" value="제목 검색" disabled>
                            </div>
                            
                            <div class="col-lg-8 col-md-6 col-sm-12 p-0">
                                <label for="search-value" hidden>검색어</label>
                                <input type="text" placeholder="검색어..." class="form-control" id="search-value"
                                       name="searchValue">
                            </div>
                            <div class="col-lg-1 col-md-3 col-sm-12 p-0">
                                <button type="submit" class="btn btn-base">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
                                         viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2"
                                         stroke-linecap="round" stroke-linejoin="round"
                                         class="feather feather-search">
                                        <circle cx="11" cy="11" r="8"></circle>
                                        <line x1="21" y1="21" x2="16.65" y2="16.65"></line>
                                    </svg>
                                </button>
                            </div>
                        </div>
                        
                    </form>
                </div>
            </div>
        </div>
    </div>
 
</div>


    <div class="row">
        <table class="table" id="article-table">
            <thead>
            <tr>
                <th class="title col-3"  style="padding-left: 20px;" ><a>글 번호</a></th>
                <th class="hashtag col-5"><a>제목</a></th>
                <th class="user-id"><a>작성자</a></th>
            </tr>
            </thead>
            <tbody>
                    <!-- 게시글 목록 -->
        <%
		    List<BoardVO> allPosts = (List<BoardVO>)request.getAttribute("allPosts");
		    if (allPosts != null) {
		        for (BoardVO post : allPosts) {
		%>
		        <tr onclick="submitForm('<%= post.getPost_id() %>')" >
				    <td class="title" style="padding-left: 20px;"><%= post.getPost_id() %></td>
				    <td class="hashtag" style="width: 200px;"><%= post.getTitle() %></td>
				    <td class="user-id"><%= post.getAuthor_id() %></td>
				</tr>
		<%
		        }
		    } else {
		        System.out.println("게시물이 없습니다!");
		    }
		%>
		
		<script>
		    function submitForm(postId) {
		        location.href = '/board/detail?postId=' + postId;
		    }
		</script>

            </tbody>
        </table>
    </div>

    <div class="row">
	    <form action="http://localhost:8080/board/write" method="post">
	        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
	            <button type="submit" class="btn btn-primary me-md-2" id="write-article">글쓰기</button>
	        </div>
        </form>
    </div>

    <div class="row">
        <nav id="pagination" aria-label="Page navigation">
            <ul class="pagination justify-content-center">
                <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">Next</a></li>
            </ul>
        </nav>
    </div>
    
    
    <footer class=" container d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
    <p class="col-md-4 mb-0 text-muted">&copy; 2024 04 BoardProject, 김도연</p>
    <ul class="nav col-md-4 justify-content-end">
        <li class="nav-item"><a href="#" class="nav-link px-2 text-muted">Board</a></li>
    </ul>
</footer>
    
    <!-- 부트스트랩 JS 가져오기 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>
