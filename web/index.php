<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lab Management System</title>
<style>
	.btn-default {
		background: #000;
		color: #fff;
	}
	
	.btn-default:hover {
		background: #fff;
		color: #000;
	}
	.error {color : #FF0000}
</style>
</head>
<body> 
<h2>&nbsp&nbspAdd Staff</h2>

	<form class="form-inline" action="../addStaff.php" method="post">
		<div class="form-group">
		&nbsp&nbspFull Name: <br>
		&nbsp&nbsp<input class="form-control input-lg" type="text"
				name="staff_name" required/>
		</div>
		&nbsp&nbsp
		&nbsp&nbsp <span class="error">
		
		<?php
		if (isset ( $_SESSION ['errorStaffName'] ) && ! empty ( $_SESSION ['errorStaffName'] )) {
			echo " * " . $_SESSION ["errorStaffName"];
		}
		?>
		
		</span>
		<div class="form-group">
		&nbsp&nbspEmployee Number: <br>
		&nbsp&nbsp<input class="form-control input-lg" type="number"
				name="staff_idNumber"  required/>
		</div>
		&nbsp&nbsp
		&nbsp&nbsp <span class="error">
		
		<?php
		if (isset ( $_SESSION ['errorStaffIdNumber'] ) && ! empty ( $_SESSION ['errorStaffIdNumber'] )) {
			echo " * " . $_SESSION ["errorStaffIdNumber"];
		}
		?>
		
		</span>
		<div class="form-group">
		&nbsp&nbspRole: <br>
		&nbsp&nbsp<input class="form-control input-lg" type="text"
				name="staff_role" required/>
		</div>
		&nbsp&nbsp
		&nbsp&nbsp <span class="error">
		
		<?php
		if (isset ( $_SESSION ['errorStaffRole'] ) && ! empty ( $_SESSION ['errorStaffRole'] )) {
			echo " * " . $_SESSION ["errorStaffRole"];
		}
		?>

		</span> <br>
		<br> &nbsp&nbsp
		<button type="submit" class="btn btn-default">Add Staff</button>

	</form>

</body>
</html>