<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <script>
    function show(state) {
      document.getElementById('window').style.display = state;
      document.getElementById('wrap').style.display = state;
    }
  </script>
  <link href="/css/menu.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div id="menu">
  <ul>
    <li><a href="/">Timetable</a></li>
    ${login}
    <FORM ACTION="/closeSession" METHOD="GET" NAME="form">
    </FORM>
  </ul>
</div>

<!--WINDOW-->
<div onclick="show('none')" id="wrap"></div>
<div id="window">
  <form action="login" method="post">
    <div class="logincontainer">
      <div id="login">
        <table>
          <tr>
            <td><input type='text' name='name' value="Login" onfocus="this.value=''"/>
            </td>
          </tr>
          <tr>
            <td><input type='password' name='password' value="Password" onfocus="this.value=''"/>
            </td>
          </tr>
        </table>
        <br/> <input name="submit" type="submit" value="Enter"/> <br/>
      </div>
    </div>
  </form>
</div>
<!--/WINDOW-->
</body>
</html>