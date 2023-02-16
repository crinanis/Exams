import net from 'net';
const port = 5000;
const host = 'localhost';

let msg = process.argv[2];

let client = net.Socket();

client.connect(port, host, () => {
    console.log('Client connected');
});

client.on('data', data => {
    console.log('data from server' + data);
});

client.on('close', () => {
    console.log('Connection closed');
});

let interval = setInterval(() => {
    console.log(msg);
    client.write(msg);
}, 1000);

setTimeout(() => {
    clearInterval(interval);
    console.log('Time out');
    client.destroy();
    process.exit();
}, 12000);