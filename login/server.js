
// var express = require('express'); 
// var bodyParser = require('body-parser');
// var app = express();

// app.use(bodyParser.json());
// app.use(bodyParser.urlencoded({extended:true}));
// app.use(express.static('public'));
// app.use('/images', express.static(__dirname + '/public/images'));

// app.get('/', function(req, resp) {
//     resp.sendFile(__dirname + "/public/index.html");
// });

// app.post('/login', function(req, resp) {
//     if (req.body.username === 'admin' && req.body.password === 'admin123') {
//         console.log('Logged in successfully');
//         resp.sendFile(__dirname + "/public/success.html");
//     }
    
// 	if (req.body.username !== 'admin' && req.body.password !== 'admin123') {
//         console.log('invalid credentials');
//         resp.sendFile(__dirname + "/public/error.html");
//     }

//     if (req.body.username !== 'admin') {
//         console.log('username is not valid');
//         resp.sendFile(__dirname + "/public/usernameError.html");
//     }

//     if (req.body.password !== 'admin123') {
//         console.log('password is not valid');
//         resp.sendFile(__dirname + "/public/passwordError.html");
//     }

    
// });

// app.listen(6789, function() {
//     console.log('Listening at port 6789');
// });
var express = require('express');
var bodyParser = require('body-parser');
var app = express();
var server = null;

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));
app.use(express.static('public'));
app.use('/images', express.static(__dirname + '/public/images'));

app.get('/', function (req, resp) {
    resp.sendFile(__dirname + "/public/index.html");
});

app.post('/login', function (req, resp) {
    if (server === null) {
        console.log('Server is offline');
        resp.status(500).send('Server is offline');
        return;
    }

    if (req.body.username === 'admin' && req.body.password === 'admin123') {
        console.log('Logged in successfully');
        resp.sendFile(__dirname + "/public/success.html");
    } else if (req.body.username !== 'admin') {
        console.log('username is not valid');
        resp.sendFile(__dirname + "/public/usernameError.html");
    } else if (req.body.password !== 'admin123') {
        console.log('password is not valid');
        resp.sendFile(__dirname + "/public/passwordError.html");
    } else {
        console.log('invalid credentials');
        resp.sendFile(__dirname + "/public/error.html");
    }
});

server = app.listen(6789, function () {
    console.log('Listening at port 6789');
});

// To simulate offline functionality, you can stop the server after some time
setTimeout(() => {
    server.close(() => {
        console.log('Server stopped');
        server = null;
    });
}, 5000); // Stop the server after 5 seconds
