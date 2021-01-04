let stompClient = null;
let uid = randString(32);           // Player ID
let gid = null;                            // Game ID

function connect() {
    let socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
}

function disconect() {}

function create() {}

function join(id) {}

function gameStatus() {}

function updateGamestate(data) {
    gamestate = data;
}



// Helper Functions
function randString(length) {
    let text = "";
    let alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    for (let i = 0; i < length; i++) {
        text += alpha.charAt(Math.floor(Math.random() * alpha.length));
    }

    return text;
}