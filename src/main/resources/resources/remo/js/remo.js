$(document).ready(function() {
	setInterval(function() {
		$.ajax({
			url : "http://localhost:8080/api/version"
		}).then(function(data) {
			$('#raw_value').text(data)
		});
	}, 1000);
});