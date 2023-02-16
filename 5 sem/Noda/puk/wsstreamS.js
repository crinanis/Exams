import WebSocket, {WebSocketServer} from "ws";
import fs from "fs";
import {createWebSocketStream} from "ws";
import * as stream from "stream";

const wsss = new WebSocketServer({port: 5000, host: 'localhost'});

wsss.on('connection', client => {
    const duplex = createWebSocketStream(client, {encoding: 'utf8'});
    let wfile = fs.createWriteStream('a.txt');
    duplex.pipe(wfile);
})