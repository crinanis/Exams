import http from 'http';
import url from 'url';
import * as fs from "fs";
import multiparty from 'multiparty';

const server = http.createServer((req, res) => {
    if (url.parse(req.url).pathname === '/form' && req.method === 'GET') {
        res.writeHead(200, {'Content-Type': 'text/html'});
        res.end(fs.readFileSync('./client.html'));
    } else if (url.parse(req.url).pathname === '/form' && req.method === 'POST') {
        let form = new multiparty.Form({uploadDir: './uploads'});
        form.parse(req, (err, fields, files) => {
            if (err) {
                console.log(err);
                res.writeHead(500, {'Content-Type': 'text/html'});
                res.end('Server error');
            } else {
                console.log(fields);
                console.log(files);
                res.writeHead(200, {'Content-Type': 'text/html'});
                res.end('Success');
            }
        });
    } else if (url.parse(req.url).pathname === '/form/get' && req.method === 'GET') {
        let file = fs.readFileSync('./myfile.txt');
        fs.createWriteStream('./downloads/downloaded_file.txt', file);

    } else {
        res.writeHead(200, {'Content-Type': 'text/html'});
        res.end('Go to localhost:5000/form using Get method');
    }

}).listen(5000, () => {
    console.log('Server is running on port 5000');
});

server.on('error', (err) => {
    console.log(err);
});

