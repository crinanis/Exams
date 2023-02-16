import * as dgram from "dgram";
import readline from "readline";

const client = dgram.createSocket("udp4");
let rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})

rl.on("line", (line) => {
    client.send(line, 5000, "localhost");
});

client.on("listening", () => {
    const address = client.address();
    console.log(`client listening ${address.address}:${address.port}`);
});

client.on("message", (msg, rinfo) => {
    console.log(`client got: ${msg} from ${rinfo.address}:${rinfo.port}`);
});
