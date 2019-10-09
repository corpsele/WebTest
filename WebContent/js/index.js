document.write("<script language='javascript' src='jquery.js'></script>");

function go(){
	alert("go");
}

function postServlet(){
	var url = "http://localhost:8283/WebTest/Create";
	var data = {"scope":103,"format":"json","appid":"379020","bk_key":"d","bk_length":600};
	$.ajax({
		type: "POST",
		url: url,
		data: data,
		contentType: "application/x-www-form-urlencoded;charset=utf-8",
		success: resultCallback,
		error: errCallBack,
		dataType: "text"
	});
}

function resultCallback(response) {
	alert("success:"+response);
}

function errCallBack(err) {
	alert("err:"+JSON.stringify(err));
}