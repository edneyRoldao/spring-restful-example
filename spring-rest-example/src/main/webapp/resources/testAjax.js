var get = function(url, callback) {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if(xhr.readyState === 4) 
			callback(xhr.responseText, xhr.status);
	};
	xhr.open('GET', url);
	xhr.send(null);
};

get("http://localhost:9090/springRestExample/customers/202", function(data) {
	document.getElementById("ajaxID").innerHTML = data;
});
