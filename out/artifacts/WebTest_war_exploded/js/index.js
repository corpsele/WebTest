

function go(){
	alert("go");
}

function postServlet1() {
	var name = document.getElementById("inputUsername");
	var pass = document.getElementById("inputPassword");
	alert(name.value);
	alert(pass.value);
	postServlet(name.value,pass.value);
}

function postServlet(name,pass){
	var url = "http://localhost:8080/WebTest/Create";
	var data = {"username":name,"password":pass};
	jQuery.ajax({
		type: "POST",
		url: url,
		data: data,
		processData:false,
		contentType: "application/x-www-form-urlencoded;charset=utf-8",
		success: resultCallback,
		error: errCallBack,
		dataType: "text"
	});
	// $.post({
	// 		type: "POST",
	// 		url: url,
	// 		data: data,
	// 		contentType: "application/x-www-form-urlencoded;charset=utf-8",
	// 		success: resultCallback,
	// 		error: errCallBack,
	// 		dataType: "text"
	// 	}
	//
	// );
	
}

function resultCallback(response) {
	alert("success:"+response);
}

function errCallBack(err) {
	alert("err:"+JSON.stringify(err));
}