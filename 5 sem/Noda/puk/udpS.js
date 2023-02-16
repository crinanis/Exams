import * as dgram from "dgram";

const server = dgram.createSocket("udp4").bind(5000);

server.on("listening", () => {
    const address = server.address();
    console.log(`server listening ${address.address}:${address.port}`);
});

server.on("error", (err) => {
    console.log(`server error:\n${err.stack}`);
    server.close();
});

server.on("message", (msg, rinfo) => {
    console.log(`server got: ${msg} from ${rinfo.address}:${rinfo.port}`);
    let newMsg = `Echo ${msg}`;
    server.send(newMsg, rinfo.port, rinfo.address);
});
