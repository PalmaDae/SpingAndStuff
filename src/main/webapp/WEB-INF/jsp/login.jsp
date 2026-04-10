<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <style>
        .form-group {
            margin-bottom: 15px;
        }
        .error {
            color: red;
            font-size: 12px;
            display: block;
            margin-top: 5px;
        }
        .error-block {
            border: 1px solid red;
            background-color: #ffeeee;
            padding: 10px;
            margin-bottom: 10px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input {
            display: block;
            width: 100%;
            max-width: 300px;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button {
            margin-top: 10px;
            padding: 10px 20px;
        }
    </style>
</head>

<body>

<h2>Login</h2>

<c:if test="${param.error != null}">
    <div class="error-block">
        Incorrect login or password.
    </div>
</c:if>

<c:if test="${param.logout != null}">
    <div class="error-block" style="border-color: green; background-color: #eaffea;">
        You have been logged out.
    </div>
</c:if>

<form method="post" action="${pageContext.request.contextPath}/process_login">

    <div class="form-group">
        <label for="username">Login:</label>
        <input name="username" type="text" required/>
    </div>

    <div class="form-group">
        <label for="password">Password:</label>
        <input name="password" type="password" required/>
    </div>

    <button type="submit">
        Login
    </button>
</form>

</body>