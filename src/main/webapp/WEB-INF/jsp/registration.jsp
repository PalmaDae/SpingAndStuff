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
    <form:form method="post" modelAttribute="userForm" action="${pageContext.request.contextPath}/registration">
        <h2>
            Registration Form
        </h2>
        <div class="form-group">
            <label for="login">Login:</label>
            <form:input path="login"/>
            <form:errors path="login" cssClass="error"/>
        </div>

        <div class="form-group">
            <label for="password">Password:</label>
            <form:input path="password" type="password"/>
            <form:errors path="password" cssClass="error"/>
        </div>

        <div class="form-group">
            <label for="passCorrect">Confirm Password:</label>
            <form:input path="passCorrect" type="password"/>
            <form:errors path="passCorrect" cssClass="error"/>
        </div>

        <div class="form-group">
            <label for="email">Email:</label>
            <form:input path="email" type="email"/>
            <form:errors path="email" cssClass="error"/>
        </div>
        <button type="submit">
            Registration
        </button>
    </form:form>
</body>