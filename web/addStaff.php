<?php
$my_dir = dirname(__FILE__);
require_once $my_dir . '/controller/Controller.php';

session_start();

$c = new Controller();
try{
	
	$c->createStaff($_POST['staff_name'], $_POST['staff_idNumber'], $_POST['staff_role']);
	$_SESSION["errorStaff"] = "";
	
} catch (Exception $e){
	$_SESSION["errorStaff"] = $e->getMessage();
}
?>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="refresh" content="0; url=index.php/" />
	</head>
</html>