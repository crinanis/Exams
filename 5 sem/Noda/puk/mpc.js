// create axios client which send file to a server using multipart/form-data through form and post method

import axios from 'axios';
import formData from 'form-data';
import fs from "fs";

const client = axios.create({
    baseURL:'http://localhost:5000',
    headers:{'Content-Type': 'multipart/form-data'},
});

let form = new formData();
let file = fs.readFileSync('./result.json');
form.append('file', file, 'file.json');

client.post('/upload', form, {headers: form.getHeaders()}).then(r => {
    console.log('success');
});