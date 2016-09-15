var express = require("express");

var router = express.Router();

//var teams = require("./controllers");

var user = require("../modelServices/user/userMS");
var document = require("../modelServices/document/docMS");
/*var grp = require("../modelServices/grp/grpMS");*/

module.exports = function(app){
	app.get("/user/search/:cdsId",user.search);
    app.post("/user/add/:cdsId/:firstName/:lastName",user.add);
    app.post("/user/update/:cdsId/:firstName/:lastName",user.update);
    /*app.post("/user/delete/:cdsId",user.delete)*/;
    

    /*---document---*/
    app.get("/document/search/:documentId",document.search);
    app.post("/document/add/:documentId/:documentName/:printId",document.add);
    app.post("/document/update/:documentId/:documentName/:printId",document.update);
    /*app.post("/document/delete/:documentId",document.delete);*/
    /*---document group---*/
/*    app.get("/grp/search/:grpId",grp.search);
    app.post("/grp/add/:grpId/:grpName/:cdsId/:docId",grp.add);
    app.post("/grp/update/:grpId/:grpName/:cdsId/:docId",grp.update);
    app.post("/grp/delete/:grpId",grp.delete);*/
 };
