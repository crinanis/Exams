import http from "http";
import querystring from "querystring";

const person = querystring.stringify({
    name: 'John',
    age: 25
});

let options= {
    hostname: 'localhost',
    port: 5000,
    method: 'POST',
    headers: {
        'Content-Type': 'x-www-form-urlencoded',
        'Content-Length': person.length
    }
};

const req = http.request(options, (res) =>{
    res.on('data', (data) => {
        console.log(data.toString());
    });
    res.on('end', () => {
        console.log('No more data in response.');
    });
})

req.on('error', (err) => {
    console.error(`problem with request: ${err.message}`);
});

req.write(person);
req.end();