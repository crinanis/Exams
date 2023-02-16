const WebSocket = require('ws');
const ws = new WebSocket('ws://localhost:3000');
const readline = require('readline');
let rdl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
let info = '';
ws.on('open', () => {
    rdl.on('line', line => {
        let interval = setInterval(() => {
            ws.send(info.toString());
        }, 1500);
        setTimeout(() => {
            clearInterval(interval);
            ws.close();
        }, 20000);
    });
    ws.on('message', (msg) => {
        console.log(msg.toString());
    });
});