import WebSocket,{WebSocketServer} from 'ws';

const wss = new WebSocketServer({port: 3000, host: 'localhost'});

wss.on('connection', (ws) => {
    console.log('Client connected');
    ws.on('message', (msg) => {
        console.log(msg.toString());
        wss.clients.forEach((client) => {
            if (client.readyState === WebSocket.OPEN) {
                client.send('from server:' + msg);
            }
        });
    });
});