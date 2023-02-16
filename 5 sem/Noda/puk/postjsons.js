import http from "http";
import querystring from "querystring";
import fs from "fs";

http.createServer((req, res) => {
    req.on('data', (chunk) => {
        let body = querystring.parse(chunk.toString());
        fs.writeFileSync('person1.json', JSON.stringify(body));
    });

    req.on('end', () => {
        res.writeHead(200, {'Content-Type': 'text/plain'});
        res.end('Data received');
    });

}).listen(5000, () => console.log('Server is running...'))
    .on('error', (err) => console.log(err));