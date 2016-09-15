(function(){
    //var commonUtils = require("../../common/commonUtils");
	var contextPath="/mums-poc";
    var documentApp = angular.module('document-module', []);
    documentApp.service('documentService', function ($http, $q, $timeout) {

    this.searchDocument = function(documentId, documentName, printId) {
    
        var documentsList = $http.get(contextPath + "/document/search/" + documentId).
		success(function(data, status, headers, config) {
            return data;

	    }).
	    error(function(data, status, headers, config) {
            console.log("Error");
            return {"status": false};
      	});
        return documentsList;
    };
        
        
       /* this.validate = function(documentId) {
            alert("..1..");
  var docList =  $http.get("/document/search/" + documentId);
       $q.all([docList]).then(function(result) { 
           console.log(result);
           $scope.errorMsg = result;
           if(result.data.documentId != documentId) {
                addDocument(documentId,documentName, printId);
           } else {
            $scope.errorMsg = "doc already exist";     
           }
        });
        }; */
     
    this.addDocument = function(documentId,documentName, printId) {
      var newDocument = $http.post(contextPath + "/document/add/"  + documentId + "/" + documentName + "/" + printId).
		success(function(data, status, headers, config) {
          return data;
	    }).
	    error(function(data, status, headers, config) {
            console.log("Error");
            return {"status": false};
      	}); 
       return newDocument;
    };
    
    this.updateDocument =function(documentId, documentName, printId) {
      var updatedDocument = $http.post(contextPath + "/document/update/" + documentId + "/" + documentName + "/" + printId).
		success(function(data, status, headers, config) {
          return data;
	    }).
	    error(function(data, status, headers, config) {
            console.log("Error");
            return {"status": false};
      	}); 
       return updatedDocument;
    };
    
    this.deleteDocument = function(documentId) {
      var updatedDocument = $http.post(contextPath + "/document/delete/" + documentId).
		success(function(data, status, headers, config) {
          return data;
	    }).
	    error(function(data, status, headers, config) {
            console.log("Error");
            return {"status": false};
      	}); 
       return updatedDocument;
    };
    
});
    
    documentApp.directive("document", function() {
        return {
        restrict: "E",
        templateUrl: "Pages/document/document.html",
            scope: {
                isd : '='
            },
        controller: function(documentService, $scope, $http, $q, $timeout) {
            this.document = {};
            $scope.documents_searchlist = [];
            $scope.documents = [];
            this.selectedDocument ="";
          
            $scope.editingDocumentData = [];
            $scope.isDocExist="";
            function clearDocumentForm() {
                this.document = {};
            };
        
            // Bad. To be restructured.
            function deleteDocumentInCache(selectedDocumentData) {
                for (var i = 0, length = $scope.documents_searchlist.length; i < length; i++) {
                    if ($scope.documents_searchlist[i].documentId == selectedDocumentData.documentId) {
                        // Remove the element in search list also
                        $scope.documents_searchlist.splice(i, 1);
                    }
                }
                for (var i = 0, length = $scope.editingDocumentData.length; i < length; i++) {
                    if ($scope.editingDocumentData[i].documentId == selectedDocumentData.documentId) {
                        // Remove the element in search list also
                        $scope.editingData.splice(i, 1);
                    }
                }
            }
            
            this.unsetEditableMode = function() {
                for (var i = 0, length = $scope.documents_searchlist.length; i < length; i++) {
                    $scope.editingDocumentData[$scope.documents_searchlist[i].documentId] = false;
                }
            };

            this.modifyDocumentCtl = function(selectedDocumentData) {
                $scope.editingDocumentData[selectedDocumentData.documentId] = true;
            }

            this.updateDocumentCtl = function(selectedDocumentData) {
                $scope.editingDocumentData[selectedDocumentData.documentId] = false;
                 documentService.updateDocument(selectedDocumentData.documentId, selectedDocumentData.documentName,
                                                selectedDocumentData.printId).then(
                    function(updatedDocument) { 
                        // Need to get the data alone, as mongoose appends the entire URL also, which is not required to us.
                      
                        var oprStatus = updatedDocument["status"];
                        if (oprStatus == 200) {
                            $scope.successMsg = "Document update is successful";
                        } else {
                            $scope.errorMsg = "Document update is failed"; 
                        }
                    });
            }

            this.deleteDocumentCtl = function(selectedDocumentData) {
                bootbox.confirm("Are you sure want to delete document?", function(result) {
                if (result) {
                    documentService.deleteDocument(selectedDocumentData.documentId).then(
                    function(updatedDocument) { 
                        // Need to get the data alone, as mongoose appends the entire URL also, which is not required to us.
                      
                        var oprStatus = updatedDocument["status"];
                        if (oprStatus == 200) {
                            $scope.successMsg = "Document termination is successful";

                        } else {
                            $scope.errorMsg = "Document termination is failed"; 
                        }
                    });
                    
                this.document = {};
                deleteDocumentInCache(selectedDocumentData);
                }
              });
        } 
            
            
            this.searchDocumentCtrl = function() {
                documentService.searchDocument(this.document.documentId, this.document.documentName, this.document.printId).then(
                    function(documentsList) { 
                        // Need to get the data alone, as mongoose appends the entire URL also, which is not required to us.
                        $scope.documents_searchlist = documentsList["data"]; 
                    });
                this.unsetEditableMode();
            };
            
           /* //===============================================validate service ==================== 
             this.validateCtrl = function() {
                documentService.validate(this.document.documentId, this.document.documentName, this.document.printId).then(
                    function(validateDocument) { 
                        // Need to get the data alone, as mongoose appends the entire URL also, which is not required to us.
                        $scope.documents_validate = validateDocument["data"]; 
                    });
                this.unsetEditableMode();
            };
            
            
           //===============================================validate service ==================== */
            this.addDocument = function addDocument() {
                documentService.addDocument(this.document.documentId,this.document.documentName, this.document.printId).then(
                    function(newDocument) { 
                        // Need to get the data alone, as mongoose appends the entire URL also, which is not required to us.
                      
                        var oprStatus = newDocument["status"];
                        if (oprStatus == 200) {
                            $scope.successMsg = "Document creation is successful";
                            // Dirty solution. Need to find a better way.
                            $scope.errorMsg ="";
                        } else {
                            $scope.errorMsg = "Document creation is failed"; 
                        }
                    });
                this.searchDocumentCtrl();
                this.document = {};
            };
           
            this.validateDocument = function() {
                var deferred = $q.defer();
               var docs = documentService.searchDocument(this.document.documentId,this.document.documentName, this.document.printId).then(
                function(docs) {
                    if (docs["data"].length == 0) {
                        deferred.resolve({ ds: "N" });
                    } else {
                        deferred.resolve({ ds: "Y" });
                    }
                }
                );
             return deferred.promise;
            };
            
             this.appendDoc = function() {
                 var c = this;
                 this.validateDocument().then(function(data) {
                     if (data.ds == "N") {
                         c.addDocument();
                     } else {
                         $scope.errorMsg = "Document already exists, Please try different Document Id";
                         // Dirty solution. Need to find a better way.
                         $scope.successMsg = "";
                     }
                 });
             };
            
 
        },
        controllerAs: "documentCtl"
      };
    });
    
})();
