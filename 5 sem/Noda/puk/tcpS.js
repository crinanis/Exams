import net from "net";
import fs from "fs";

let file = fs.createWriteStream('./new.txt')

net.createServer((socket)=>{
   socket.on('data', (data)=>{
       file.write(`Echo from client: ${data}`)
   })
    socket.on('end', ()=>{
        console.log('client disconnected');
    })
}).listen(5000);