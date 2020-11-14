<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="atj.CalculationsVO"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<link rel="stylesheet" href="bootstrap.min.css" >

<title>Insert title here</title>

<style>
input.button {width: 100px;
		height: 100px;
		font-size: 40px;
		margin: 5px;
		cursor: pointer;
		border: none;}
</style>

</head>
<body>
<jsp:useBean class="atj.CalculationsVO" id="vo" scope="request"/>
	<div class="container">
		<form name="form">
			<table>
				<tr>
					<td colspan=4><input class="textview" name="textview" style="width:440px;height:98px;margin:5px;font-size:30px" value="${vo.firstValue}${vo.sign}${vo.secondValue}" disabled></td>
					<td><input class="button" type="submit" name="button" value="C"></td>
				</tr>
				<tr>
					<td><input class="button" type="submit" name="button" value="7" ></td>
					<td><input class="button" type="submit" name="button" value="8" ></td>
					<td><input class="button" type="submit" name="button" value="9" ></td>
					<td><input class="button" type="submit" name="button" value="/" ></td>
					<td><input class="button" type="submit" name="button" value="√" ></td>
				</tr>
				<tr>
					<td><input class="button" type="submit" name="button" value="4" ></td>
					<td><input class="button" type="submit" name="button" value="5" ></td>
					<td><input class="button" type="submit" name="button" value="6" ></td>
					<td><input class="button" type="submit" name="button" value="*" ></td>
					<td><input class="button" type="submit" name="button" value="%" ></td>
				</tr>
				<tr>
					<td><input class="button" type="submit" name="button" value="1" ></td>
					<td><input class="button" type="submit" name="button" value="2" ></td>
					<td><input class="button" type="submit" name="button" value="3" ></td>
					<td><input class="button" type="submit" name="button" value="-" ></td>
					<td rowspan=2><input class="button" type="submit" name="button" style="height:216px" value="=" ></td>
				</tr>
				<tr>
					<td><input class="button" type="submit" name="button" value="0" ></td>
					<td><input class="button" type="submit" name="button" value="." ></td>
					<td><input class="button" type="submit" name="button" value="+/-" ></td>
					<td><input class="button" type="submit" name="button" value="+" ></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>