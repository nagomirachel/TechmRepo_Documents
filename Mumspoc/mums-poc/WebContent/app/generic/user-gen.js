// Remote Source
  function suggest_state_remote(term) {
    var deferred = $q.defer();
    // Fake remote source using timeout
    $timeout(function () {
      deferred.resolve(suggest_state(term));
    }, 500);
    return deferred.promise;
  }

  $scope.ac_option_remote = {
    suggest: suggest_state_remote,
    on_error: console.log
  };

  function suggest_state(term) {
    var q = term.toLowerCase().trim(),
        results = [];

    for (var i = 0; i < states.length && results.length < 10; i++) {
      var state = states[i];
      if (state.toLowerCase().indexOf(q) == 0)
        results.push({ label: state, value: state });
    }

    return results;
  }