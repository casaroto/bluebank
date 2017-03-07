
var Sequelize = require('sequelize');


var correntistaModel = {
    nome: '',
    cpf: ''
};

var sequelize = new Sequelize('bluebank', 'blue', '6945', {
  host: 'localhost',
  dialect: 'mysql',

  pool: {
    max: 5,
    min: 0,
    idle: 10000
  },

});

var Correntista = sequelize.define('correntista', {
     createdAt: false,
     updatedAt: false,
    idcorrentista: {
        type: Sequelize.INTEGER,
        primaryKey: true
    },
    nome: Sequelize.STRING,
    cpfCnpj: Sequelize.STRING
});

Correntista.removeAttribute('createdAt');
Correntista.removeAttribute('updatedAt');

module.exports.consultar = function consultar(cpf, callbackResposta){

     Correntista.findOne({
        where: {
            cpfCnpj: cpf
        }
        }).then(function (correntista) {
        console.log(correntista.get('nome'));
        correntistaModel.cpf = cpf;
        correntistaModel.nome = correntista.get('nome');
        callbackResposta(correntistaModel);
        });

}

/*
    Correntista.findOne({
        where: {
            cpfCnpj: cpf
        }
    }).then(function (correntista) {
        console.log(correntista.get('nome'));
        correntistaModel.cpf = cpf;
        correntistaModel.nome = correntista.get('nome');
       
    });
*/   


module.exports.todas = function todas(){
     Correntista.findOne().then(function (correntista) {
        console.log(correntista.get('nome'));
    });

    Correntista.findOne({
        where: {
            idcorrentista: 3
        }
    }).then(function (correntista) {
        console.log(correntista.get('nome'));
    });

    Correntista.findOne({
        where: {
            idcorrentista: {$gt: 1}
        }
    }).then(function (correntista) {
        console.log(correntista.get('nome'));
    });

    Correntista.findOne({
        where: {
            nome: {$like: '%Silva'}
        }
    }).then(function (correntista) {
        console.log(correntista.get('nome'));
    });

    Correntista.findOne({
        where: {
            nome: {$like: '%Silva'}
        }
    }).then(function (correntista) {
        console.log(correntista.get('nome'));
    });

    Correntista.findAll({
        where: {
            nome: {$like: '%a'}
        }
    }).then(function (correntista) {
        console.log(JSON.stringify(correntista));
    });

}