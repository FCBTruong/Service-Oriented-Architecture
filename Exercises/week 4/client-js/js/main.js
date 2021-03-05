(function ($) {

	"use strict";

})(jQuery);

var data;
var requestOptions = {
	method: 'GET',
	redirect: 'follow'
};

fetch("http://localhost:9999/api/student", requestOptions)
	.then(response => response.text())
	.then(result => {
		data = result;
		loadDataToPage();
	})
	.catch(error => console.log('error', error));


async function  loadStudentInfo(mssv){
	var requestOptions = {
		method: 'GET',
		redirect: 'follow'
	  };
	var student;
	  
    await fetch("http://localhost:9999/api/student?mssv=" + mssv, requestOptions)
		.then(response => response.text())
		.then(result => student = result)
		.catch(error => console.log('error', error));
	console.log(student);
    return student;
}

function loadDataToPage() {
	var table = document.getElementById('table_id');
	data = JSON.parse(data).data;
	console.log(data);
	data.forEach(function (object) {

		var tr = document.createElement('tr');
		console.log(data)
		tr.innerHTML = '<td>' + object.mssv + '</td>' +
			'<td>' + object.fullName + '</td>' +
			'<td>' + object.birthDay + '</td>' +
			'<td>' + object.university + '</td>' +
			'<td>' + object.gender + '</td>' +
			'<td>' + object.email + '</td>';
		table.getElementsByTagName('tbody')[0].appendChild(tr);
	});
	loadStudentInfo('18021001');
}