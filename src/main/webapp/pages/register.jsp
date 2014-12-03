<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Login</title>
<link rel="stylesheet" href="css/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="css/custom.css">
<title>Register</title>
</head>
<body>
	<div class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container">
				<div class="row">
					<div class="col-xs-12">
						<s:form class="form-signin" action="register">
							<s:textfield cssClass="form-control" autofocus="" require=""
								placeholder="Email" name="employee.email" />
							<s:password cssClass="form-control" placeholder="Password"
								name="employee.password" />
							<select name="geder" label="Gender">
								<option value="Male">Male</option>
								<option value="Female">Female</option>
							</select>
							<s:textfield cssClass="form-control" placeholder="Name"
								name="employee.name" />
							<s:textfield cssClass="form-control" placeholder="Lastname"
								name="employee.lastname" />
							<s:textfield cssClass="form-control" placeholder="Age"
								name="employee.age" />
							<s:textarea cssClass="form-control" placeholder="Address"
								name="employee.address" />
							<s:textfield cssClass="form-control" placeholder="Telephone"
								name="employee.telephone" />
						</s:form>
						<div class="row">
							<div class="col-xs-6">
								<button class="btn btn-md btn-primary btn-block" type="submit">Register</button>
							</div>
							<div class="col-xs-6">
								<button class="btn btn-md btn-primary btn-block" type="reset">Cancel</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="css/js/bootstrap.min.js"></script>
</body>
</html>