// Разработать Http-сервер, который предоставляет возможность клиенту получать данные с сервера (только с директории public) 
//посредством Get-запроса. 
// Для доступа к к файлу клиент в запросе передает некоторый параметр secret со значением XXX, иначе сообщение об ошибке.
const http = require('http.js');
const query = require('querystring.js');
const url = require('url.js');
let parm = {};
const server = http.createServer((req, res) => {
    console.log(req.url);
    if (req.method === 'GET' && url.parse(req.url).pathname === '/public') {
        parm = url.parse(req.url, true).query.yep;
        parm1=query.parse(req.url.slice(req.url.indexOf('?')+1));
        console.log(parm1);
        if (parm1.yep === 'xxx') {
            res.writeHead(200, {
                'Content-type': 'text/html'
            });
            res.end(parm);
        } else {
            res.setHeader('Bad-param', '404');
            res.writeHead(150, {
                'Content-type': 'text/plain'
            });
            res.end('Use secret: xxx');
        }

    } else {
        res.setHeader('Bad-method', '404');
        res.statusCode = 404;
        res.end('Use method: GET');
    }
});
server.listen(3000);