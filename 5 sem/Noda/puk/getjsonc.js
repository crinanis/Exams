import http from "http";
import querystring from "querystring";

const person = querystring.stringify({
    name: 'John',
    age: 30
})

let path = `/twopar?${person}`;

const options= {
    host: 'localhost',
    port: 5000,
    method: 'GET',
    path: path
}

const req = http.request(options, (res) => {
    res.on('data', (chunk) => {
        console.log(chunk.toString());
    });
    res.on('end', () => {
        console.log('Done.');
    });
});

req.on('error', (err) => {
    console.log(err);
});

req.end();