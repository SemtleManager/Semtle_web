<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "com.Book.*" %>
<%@ page import = "java.util.List" %>
<%

	ServletContext context = request.getSession().getServletContext();
	String downaloadPath = context.getRealPath("bookIMG");
	 
	bookListDAO dao = bookListDAO.getInstance();

	List<bookListDTO> lists = dao.getBookList();
	request.setAttribute("path", downaloadPath);
	request.setAttribute("list", lists);

%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>SemtleWeb</title>
  </head>

<body>

	
      <div class="swiper book-box">
        <div class="swiper-wrapper book-wrapper">
        <c:forEach items="${ list }" var="dto" varStatus="i">
          <div class="swiper-slide slide">
            <div class="image">
              <img src="${pageContext.request.contextPath}/bookIMG/${ dto.bookImage }" alt="" />
            </div>
            <div class="content">
            <h3>${ dto.bookImage }</h3>
              <h3>${ dto.bookName }</h3>
              <div class="content_info">
                <h2>${ dto.bookAuthor }</h2>
                <h2>/</h2>
                <h2>${ dto.bookCount }권</h2>
              </div>
            </div>
          </div>
		</c:forEach>
        </div>
      </div>
</body>
</html>