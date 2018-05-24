var stompClient = null;

function connect() {
	var socket = new SockJS('/dbmonitor-websocket');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		stompClient.subscribe('/topic/dbmonitor-websocket', function(wsMessage) {
			console.log('got message: ' + wsMessage);
			showDbInserts(wsMessage.body);
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

function showDbInserts(message) {
	$("#dbInserts").append("<tr><td>" + message + "</td></tr>");
}

window.onload = connect;
window.onbeforeunload = disconnect;
console.log('started dbMonitor');
