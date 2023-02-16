import rpc from 'rpc-websockets';

const client = new rpc.Client('ws://localhost:5000');

client.on('open', () => {
    client.call('sum', [1, 2]).then(result => console.log(result));
    client.login({login: 'admin', pass: 'admin'}).then(() => {
        client.call('mul', [2, 3]).then(result => console.log(result));
    });
});