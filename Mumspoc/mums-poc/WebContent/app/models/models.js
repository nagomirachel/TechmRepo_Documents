var mongoose = require("mongoose");

Schema = mongoose.Schema;

var UserSchema = new Schema({
	cdsId : String,
	firstName : String,
    lastName : String
});

mongoose.model("User",UserSchema);