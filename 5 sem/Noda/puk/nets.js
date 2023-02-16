import net from 'net';

net.createServer((socket)=>{
   socket.on("data", (data)=>{
       console.log(`Remote address: + ${socket.remoteAddress} + 
       remote port: + ${socket.remotePort}+
       data: ${data.toString()}`)

       socket.write('echo + ' + data);
   }) ;
   socket.on("close", ()=>{
       console.log("socket closed");
   })
}).listen(5000, "localhost", ()=>{
    console.log("TCP server started at 5000");
});