
var correntistaData = require('./correntista-data');

module.exports.consultar = function(cpf, callbackResposta){
    console.log('consultar');
    return correntistaData.consultar(cpf, callbackResposta);
};

module.exports.cadastrar2 = function(){
    console.log('cadastrar2');
};


