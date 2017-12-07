<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
   <head>
      <title>File Upload Example</title>
   </head>
   <body>
      <form:form action="uploadImage" method="POST" enctype="multipart/form-data">
         Please select a file to upload : 
         <input type="file" name="file" />
         <input type="submit" value="Upload Image" />
      </form:form>
   </body>
</html>
