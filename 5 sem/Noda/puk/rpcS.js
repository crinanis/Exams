import rpc from 'rpc-websockets';

const server = new rpc.Server({port: 5000, host: 'localhost'});

server.setAuth(puk => puk.login === 'admin' && puk.pass === 'admin');
server.register('sum', (params) => {
    return params.length === 2 ? params[0] + params[1] : console.log('error');
}).public();

server.register('mul', (params) => {
    return params.length === 2 ? params[0] * params[1] : console.log('error');
}).protected();
