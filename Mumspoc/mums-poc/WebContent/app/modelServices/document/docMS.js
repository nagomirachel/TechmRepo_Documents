var mongoose = require("mongoose");

var Document = mongoose.model("Document");

exports.search = function(req,res){
    Document.find({"documentId" : req.params["documentId"]}, function(err, data) {
        if (err) {
			console.log('err in xprs' + err);	
			return res.send(400, {
				message: "Error while fetching all the data"
			});
		} else {
            console.log(data);
			res.jsonp(data);
		}
	});
 
};

exports.add = function(req,res){
    var document = new Document({"documentId":req.params["documentId"],"documentName":req.params["documentName"],"printId":req.params["printId"]});
	document.save(function(err, data) {
	if (err) {
			console.log('err in xprs' + err);	
			return res.send(400, {
				message: "Error while fetching all the data"
			});
		} else {
            console.log(data);
			res.jsonp(document);
		}
	});
 
};

exports.update = function(req,res){
   var queryCond = {"documentId":req.params["documentId"]};
    var updateVal = {"documentName":req.params["documentName"], "printId":req.params["printId"]};
    var options = {new: true};
    Document.findOneAndUpdate(queryCond, updateVal, options, function(err, doc) {
      if (err) {
                console.log('err in xprs' + err);	
                return res.send(400, {
                    message: "Error while fetching all the data"
                });
      } else {
          res.jsonp(doc);
      }
    });   
};

exports.delete = function(req,res){
   var queryCond = {"documentId":req.params["documentId"]};
    Document.remove(queryCond, function(err, doc) {
      if (err) {
                console.log('err in xprs' + err);	
                return res.send(400, {
                    message: "Error while fetching all the data"
                });
      } else {
          res.jsonp(doc);
      }
    });   
};