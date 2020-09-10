var express = require('express');
var app = express();

app.set('views', __dirname + '/public');
app.use(express.static(__dirname + '/public'));
app.set('view engine','ejs')

app.get('/', function(req, res){
    res.render('UI', {
      title: 'Home'
    });
});
  
app.get('/next1', function(req, res){
res.render('next1', {
    title: 'Two Dates Operations'
});
});
  
app.get('/next2', function(req, res){
res.render('next2', {
    title: 'Operation on date'
});
});
  
app.get('/next3', function(req, res){
res.render('next3', {
    title: 'Phrase'
});
});
  
var server = app.listen(3000, function () {
    console.log('Node server is running on 3000');
});