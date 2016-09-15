(function(){
    //var commonUtils = require("../../common/commonUtils");
	// Bad coding. Find a different option.
	var contextPath="/mums-poc";
    var fullpath="localhost:8095/mums-poc";
    var userApp = angular.module('user-module', []);
    userApp.service('userService', function ($http, $q, $timeout) {
    
    //$http.defaults.headers.post["Content-Type"] = "application/x-www-form-urlencoded";
    this.searchUser = function (cdsId, firstName, lastName) {
        var usersList = $http.get(contextPath+"/user/search/" + cdsId).
		success(function(data, status, headers, config) {
            return data;

	    }).
	    error(function(data, status, headers, config) {
            console.log("Error");
            return {"status": false};
      	});
        return usersList;
    };
    
    /* this.checkAndAdd = function(cdsId, firstName, lastName) {
        this.searchUser(cdsId, firstName, lastName).then(
        function(usersList) { 
                        // Need to get the data alone, as mongoose appends the entire URL also, which is not required to us.
            var userData = usersList["data"]
            return { status: function(userData) {
                if(userData.length == 0) {
                    this.addUser(cdsId, firstName, lastName);
                } else {
                    //$scope.errorMsg = "User termination is failed"; 
                }
                    } }; 
        });
    }; */
        
    this.addUser = function (cdsId, firstName, lastName) {
    	var contextPath="/mums-poc";
        
      var newUser = $http.post(contextPath + "/user/add/" + cdsId + "/" + firstName + "/" + lastName).
		success(function(data, status, headers, config) {
          return data;
	    }).
	    error(function(data, status, headers, config) {
            console.log("Error");
            return {"status": false};
      	}); 
       return newUser;
    };
    
    this.updateUser = function (cdsId, firstName, lastName) {
    	      var updatedUser = $http.post(contextPath + "/user/update/" + cdsId + "/" + firstName + "/" + lastName).
		success(function(data, status, headers, config) {

          return data;
	    }).
	    error(function(data, status, headers, config) {
            console.log("Error");
            return {"status": false};
      	}); 
       return updatedUser;
    };
    
    this.deleteUser = function (cdsId) {
    	var contextPath="/mums-poc";
      var updatedUser = $http.post(contextPath + "/user/delete/" + cdsId).
		success(function(data, status, headers, config) {
          return data;
	    }).
	    error(function(data, status, headers, config) {
            console.log("Error");
            return {"status": false};
      	}); 
       return updatedUser;
    };
        
    this.getmovies = function(i) {
        var moviedata = $q.defer();
        var movies = [];

        var someMovies = ["The Wolverine", "The Smurfs 2", "The Mortal Instruments: City of Bones", "Drinking Buddies"];

        var moreMovies = ["The Wolverine", "The Smurfs 2", "The Mortal Instruments: City of Bones", "Drinking Buddies", "All the Boys"];

        if(i && i.indexOf('T')!=-1)
            movies=moreMovies;
        else
            movies=moreMovies;

        $timeout(function(){
            moviedata.resolve(movies);
        },1000);

        return moviedata.promise;
  };
        
    
});
    
    userApp.directive("user", function() {
      return {
        restrict: "E",
        templateUrl: "Pages/user/user.html",
        controller: function(userService, $scope) {
            this.user = {};
            $scope.users_searchlist = [];
            $scope.users = [];
            this.selectedUser ="";
          
            $scope.editingUserData = [];
    
            function clearUserForm() {
                this.user = {};
            };
            
            // Bad. To be restructured.
            function deleteUserInCache(selectedUserData) {
                for (var i = 0, length = $scope.users_searchlist.length; i < length; i++) {
                    if ($scope.users_searchlist[i].cdsId == selectedUserData.cdsId) {
                        // Remove the element in search list also
                        $scope.users_searchlist.splice(i, 1);
                    }
                }
                for (var i = 0, length = $scope.editingUserData.length; i < length; i++) {
                    if ($scope.editingUserData[i].cdsId == selectedUserData.cdsId) {
                        // Remove the element in search list also
                        $scope.editingData.splice(i, 1);
                    }
                }
            }
            
            this.unsetEditableMode = function() {
                for (var i = 0, length = $scope.users_searchlist.length; i < length; i++) {
                    $scope.editingUserData[$scope.users_searchlist[i].cdsId] = false;
                }
            };

            this.modifyUserCtl = function(selectedUserData) {
                $scope.editingUserData[selectedUserData.cdsId] = true;
            }

            this.updateUserCtl = function(selectedUserData) {
            	
                $scope.editingUserData[selectedUserData.cdsId] = false;
                 userService.updateUser(selectedUserData.cdsId, selectedUserData.firstName, selectedUserData.lastName).then(
                    function(updatedUser) { 
                        // Need to get the data alone, as mongoose appends the entire URL also, which is not required to us.
                        //$scope.users_searchlist = usersList["data"]; 
                        var oprStatus = updatedUser["status"];
                        if (oprStatus == 200) {
                            $scope.successMsg = "User update is successful";
                        } else {
                            $scope.errorMsg = "User update is failed"; 
                        }
                    });
            }

            this.deleteUserCtl = function(selectedUserData) {
                bootbox.confirm("Are you sure want to delete?", function(result) {
                if (result) {
                    userService.deleteUser(selectedUserData.cdsId).then(
                    function(updatedUser) { 
                        // Need to get the data alone, as mongoose appends the entire URL also, which is not required to us.
                        //$scope.users_searchlist = usersList["data"]; 
                        var oprStatus = updatedUser["status"];
                        if (oprStatus == 200) {
                            $scope.successMsg = "User termination is successful";

                        } else {
                            $scope.errorMsg = "User termination is failed"; 
                        }
                    });
                    
                this.user = {};
                deleteUserInCache(selectedUserData);
                }
              });
        } 
            
            
            this.searchUserCtrl = function() {
                userService.searchUser(this.user.cdsId, this.user.firstName, this.user.lastName).then(
                    function(usersList) { 
                        // Need to get the data alone, as mongoose appends the entire URL also, which is not required to us.
                        $scope.users_searchlist = usersList["data"]; 
                    });
                this.unsetEditableMode();
            };
            
            this.addUserCtrl = function() {
                userService.addUser(this.user.cdsId, this.user.firstName, this.user.lastName).then(
                    function(newUser) { 
                        // Need to get the data alone, as mongoose appends the entire URL also, which is not required to us.
                        //commonUtils.setMessage("User creation is successful", "User creation is failed", newUser, "status", 200);
                        var oprStatus = newUser["status"];
                        if (oprStatus == 200) {
                            $scope.successMsg = "User creation is successful";
                        } else {
                            $scope.errorMsg = "User creation is failed"; 
                        }
                    });
                this.searchUserCtrl();
                this.user = {};
            };
           
        },
        controllerAs: "userCtl"
      };
    });
    
})();
