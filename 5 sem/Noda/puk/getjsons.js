import http from "http";
import * as url from "url";
import fs from "fs";

http.createServer((req, res) => {
    let path = url.parse(req.url).pathname;
    let query = url.parse(req.url,true).query;

    if (path === '/twopar') {
        res.writeHead(200, {'Content-Type': 'javascript/json'});
        let result = JSON.stringify({
            name:query.name,
            age:query.age
        });
        console.log(result);
        fs.writeFileSync('result.json', result, (err) => {
            if (err) {
                console.log(err);
            }
        });
        res.end('Done.');
    } else {
        res.writeHead(404, {'Content-Type': 'text/html'});
        res.end('404 Not Found');
    }
}).listen(5000, () => {
    console.log('Server is running on port 5000');
});