import net from 'net';
import readline from 'readline';

const rl = readline.createInterface({
    input:process.stdin,
    output:process.stdout
});

let msg='';
rl.on("line", (line)=>{
    msg=line.toString();
});

const client = net.Socket();

client.connect(5000, 'localhost', ()=>{
   console.log("client connected");
});

client.on("data", data =>{
    console.log(data.toString());
});

setInterval(()=>{
    client.write(msg);
}, 1000);

setTimeout(()=>{
    client.destroy();
}, 10000);