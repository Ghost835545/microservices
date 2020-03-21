<?php
require_once __DIR__ . '/recaptcha.php';
$response = null;
 
$reCaptcha = new ReCaptcha($secret);
	if ($_POST["g-recaptcha-response"]) {
		$response = $reCaptcha->verifyResponse(
		$_SERVER["REMOTE_ADDR"],
	);
}
$post = (!empty($_POST)) ? true : false;
if($post) {
	$email = htmlspecialchars(trim($_POST['email']));
	$name = htmlspecialchars(trim($_POST['name']));
	$sub = htmlspecialchars(trim($_POST["sub"]));
	$message = htmlspecialchars(trim($_POST['message']));
	$error = '';
	if(!$response) {$error .= 'Заполните капчу';}
	if(!$name) {$error .= 'Укажите свое имя. ';}
	if(!$email) {$error .= 'Укажите электронную почту. ';}
	if(!$sub) {$error .= 'Укажите тему обращения. ';}
	if(!$message || strlen($message) < 1) {$error .= 'Введите сообщение. ';}
	if(!$error) {
		$address = "primer@example.ru";
		$mes = "Почта: ".$email."\n\nИмя: ".$name."\n\nТема: " .$sub."\n\nСообщение: ".$message."\n\n";
		$send = mail ($address,$sub,$mes,"Content-type:text/plain; charset = UTF-8\r\nReply-To:$email\r\nFrom:$name <contact>");
		if($send) {echo 'OK';}
	}
	else {echo '<div class="err">'.$error.'</div>';}
}
?>