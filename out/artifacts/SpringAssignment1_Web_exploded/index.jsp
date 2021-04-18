<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书店</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/index" method="get" id="redirect">

</form>

<script type="text/javascript">
    const form = document.querySelector("form");
    form.submit();
</script>
</body>
</html>
