
var express = require('express');
var app = express();
//var bodyParser = require('body-parser');

//app.use(bodyParser.json());
var routerApp = require('./correntista-routes')


app.use('/correntista', routerApp);

app.listen(3000, function(){

    console.log('teste');
})




function log(req, res, next){
    console.log(req.method);
    next();
}

app.get('/', log, function(req, res){
    res.send('resultado');
})


