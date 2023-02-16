import http from "http";
import * as url from "url";
import mp from 'multiparty';

http.createServer((req, res) => {
    if (req.method === 'POST') {
        if (url.parse(req.url).pathname === '/upload') {
            let form = new mp.Form({uploadDir: './static'});
            form.parse(req, (error, files, fields) => {
                if (error) console.log (error);
            })
        }
    }
    res.end('file uploaded');
}).listen(5000, () => {
    console.log('server started at 5000')
})