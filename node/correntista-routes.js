
var express = require('express');
var router = express.Router();
var correntista = require('./correntista-controller');
var multer = require('multer');

var upload = multer();

router.route('/').get(function(req, res){

        res.status(200).json('ok');
});



router.post('/:cpf', upload.array(), function(req, res){
    console.log(JSON.stringify(req.body));
    console.log(JSON.stringify(req.params));
        

    var callbackResposta = function callbackResposta(resultado){
        console.log(resultado);
        res.json(resultado);
    };
        correntista.consultar(req.params.cpf, callbackResposta);

   //res.json({teste: 1000});
})



module.exports = router;





