<%--
  Created by IntelliJ IDEA.
  User: KAI
  Date: 10/28/17
  Time: 7:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    this is upload page

    <form action="handleUpload" method="post" enctype="multipart/form-data">

        <input type="file" name="file"  />
        <input type="submit" value="UPLOAD FILE"/>

    </form>

</body>
</html>
