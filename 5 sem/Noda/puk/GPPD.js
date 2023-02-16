import http from 'http';
import fs from 'fs';
import querystring from "querystring";

http.createServer((req, res) => {
    if (req.url === '/html') {
        res.writeHead(200, {'Content-Type': 'text/html'});
        fs.createReadStream('./GPPD.html').pipe(res);
    } else if (req.method === 'GET' || req.method === 'POST' || req.method === 'PUT' || req.method === 'DELETE') {
        res.writeHead(200, {'Content-Type': 'application/json'});
        let result = {};
        result.headers = JSON.stringify(req.headers);
        result.method = req.method;
        result.query = querystring.parse(req.url.split('?')[1]);

        let body = '';
        req.on('data', (chunk) => {
            body += chunk;
        });

        req.on('end', () => {
            res.writeHead(200, {'Content-Type': 'text/html'});
            result.body = body;
        });

        res.end(JSON.stringify(result));
    } else {
        res.writeHead(404, {'Content-Type': 'text/html'});
        res.end('404 Not Found');
    }
}).listen(5000, () => {
    console.log('Server is running on port 5000');
});