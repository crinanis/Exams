import WebSocket, {WebSocketServer} from "ws";
import fs from "fs";
import {createWebSocketStream} from "ws";

const client = new WebSocket("ws://localhost:5000");

client.on("open", () => {
    let file = fs.createReadStream("./result.json");
    // duplex._write(wsss, {encoding: 'utf8'});
    // duplex.write('sd');
    let duplex = createWebSocketStream(client, {encoding: "utf8"});
    file.pipe(duplex);
});