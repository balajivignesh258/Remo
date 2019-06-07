$(document).ready(function() {
	setInterval(function() {
		$.ajax({
			url : "http://localhost:8080/api/version"
		}).then(function(data) {
			$('#raw_value').text(data)
			$('#raw_value2').value(data)
			document.getElementById("raw_value2").value = data
		});
	}, 1000);
});