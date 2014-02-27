<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
<form:form method="post" action="contactMe">
    <h1>${contactMe}</h1>
    <table>
        <tr>
            <td><form:label path="name">Full Name: </form:label></td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td><form:label path="email">Email: </form:label></td>
            <td><form:input path="email" /></td>
        </tr>
        <tr>
            <td><form:label path="contact">Telephone: </form:label></td>
            <td><form:input path="contact" /></td>
        </tr>
        <tr>
            <td><form:label path="message">Message: </form:label></td>
            <td><form:textarea path="message" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>