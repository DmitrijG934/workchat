const url = 'http://localhost:8090';
let stompClient;

function connectToChat(user) {
    console.log('Connecting to the chat...');
    let socket = new SockJS(url + '/chat/' + user);
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
        console.log('Connected to: ' + frame);
        stompClient.subscribe('/topic/messages-topic/' + user, function(response) {
           let data = JSON.parse(response.body);
           console.log('Received data from server: ' + data);
        });
    });
}