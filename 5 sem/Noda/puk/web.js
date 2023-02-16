import WebSocket, {WebSocketServer} from 'ws';
import http from "http";
import * as url from "url";
import fs from "fs";

const httpServer = http.createServer((req, res) => {
    if (req.method === 'GET' && url.parse(req.url).pathname === '/html') {
        res.writeHead(200, { 'Content-Type': 'text/html; charset=utf-8' });
        res.end(fs.readFileSync('./web.html'));
    }
    else {
        res.writeHead(400, { 'Content-Type': 'text/html; charset=utf-8' });
        res.end('<h1>[ERROR] Visit localhost:5000/start using GET method. </h1>');
    }
}).listen(5000, () => console.log('Running at localhost:5000'));


const ws = new WebSocketServer({ port: 3000, host: 'localhost', path: '/server'});
ws.on('connection', wsc => {
    console.log('[INFO] Client connected.');
    wsc.on('message', message => {
        console.log(`[Received]  ${message}`);
        ws.clients.forEach(client => {
            if (client.readyState === WebSocket.OPEN) {
                client.send('Server: ' + message);
            }
        });
    })})

ws.on('error', error => { console.log('[ERROR] WebSocket: ', error.message); })
