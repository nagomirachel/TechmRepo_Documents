var mongoose = require("mongoose");

var User = mongoose.model("User");

exports.search = function(req,res){
    User.find({"cdsId" : req.params["cdsId"]}, function(err, data) {
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
    var user = new User({"cdsId":req.params["cdsId"],"firstName":req.params["firstName"],"lastName":req.params["lastName"]});
	user.save(function(err, data) {
	if (err) {
			console.log('err in xprs' + err);	
			return res.send(400, {
				message: "Error while fetching all the data"
			});
		} else {
            console.log(data);
			res.jsonp(user);
		}
	});
 
};

exports.update = function(req,res){
   var queryCond = {"cdsId":req.params["cdsId"]};
    var updateVal = {"firstName":req.params["firstName"], "lastName":req.params["lastName"]};
    var options = {new: true};
    User.findOneAndUpdate(queryCond, updateVal, options, function(err, doc) {
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
   var queryCond = {"cdsId":req.params["cdsId"]};
    User.remove(queryCond, function(err, doc) {
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