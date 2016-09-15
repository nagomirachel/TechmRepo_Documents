(function() {
  var app = angular.module('mumsApp', ['user-module','ngAnimate','autocomplete','document-module']);/*,'grp-module'*/
    //var app = angular.module('mumsApp', ['user-module']);
    app.directive("tabs", function() {
      return {
        restrict: "E",
        templateUrl: "Pages/tab/tabs.html",
        controller: function() {
          this.tab = 1;

          this.isSet = function(checkTab) {
            return this.tab === checkTab;
          };

          this.setTab = function(activeTab) {
            this.tab = activeTab;
          };
        },
        controllerAs: "tab"
      };
    });
    
})();
