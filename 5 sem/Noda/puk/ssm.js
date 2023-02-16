import http from 'http';
import querystring from 'querystring';
import * as url from "url";

http.createServer((req, res) => {
    const path = url.parse(req.url).pathname;

    if (req.method === 'POST') {
        let body = '';
        let params = {};
        let result = 0;
        req.on('data', chunk => {
            body += chunk.toString();
        });
        req.on('end', () => {
            if (req.headers['content-type'] === 'application/x-www-form-urlencoded') {
                params = querystring.parse(body);
            } else if (req.headers['content-type'] === 'application/json') {
                params = JSON.parse(body);
            } else if (req.headers['content-type'] === 'text/plain') {
                const arr = body.split(' ');
                let a = arr[0].split('=');
                let b = arr[1].split('=');
                params = {a: a[1], b: b[1]};
                console.log(params);
            } else {
                console.log('Unknown content type');
            }
            if (path === '/sum') {
                result = Number(params.a) + Number(params.b);
            } else if (path === '/sub') {
                result = Number(params.a) - Number(params.b);
            } else if (path === '/mul') {
                result = Number(params.a) * Number(params.b);
            } else {
                console.log('Unknown path');
            }
            console.log('result= ' + result);
            res.setHeader('result', result);
            res.end('Calculation is done');
        });
    } else {
        res.statusCode = 405;
        res.end();
    }
}).listen(5000, () => console.log('Server is running on port 5000'));
