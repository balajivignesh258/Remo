var stompClient = null;

function setConnected(connected) {
	$("#connect").prop("disabled", connected);
	$("#disconnect").prop("disabled", !connected);
	if (connected) {
		$("#conversation").show();
	} else {
		$("#conversation").hide();
	}
	$("#greetings").html("");
}

function connect() {
	var socket = new SockJS('/remo-endpoint-socket');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		setConnected(true);
		console.log('Connected: ' + frame);
		stompClient.subscribe('/topic/evalresult', function(evalresult) {
			showEvalResultValue(JSON.parse(evalresult.body).evalResultValue);
		});
	});
}

function disconnect() {
	if (stompClient !== null) {
		stompClient.disconnect();
	}
	setConnected(false);
	console.log("Disconnected");
}

function sendFormula() {
	stompClient.send("/app/formula", {}, JSON.stringify({
		'formula' : $("#formula").val()
	}));
	showAlert();
	setTimeout(hideAlert, 2000)
}

function hideAlert() {
	$(".alert").hide()
}

function showAlert() {
	$(".alert").show()
}

function showEvalResultValue(message) {
	$("#monitor").append("<tr><td>" + message + "</td></tr>");
}

$(function() {
	$(".alert").hide();
	$("form").on('submit', function(e) {
		e.preventDefault();
	});
	$("#connect").click(function() {
		connect();
	});
	$("#disconnect").click(function() {
		disconnect();
	});
	$("#send").click(function() {
		sendFormula();
	});
});
