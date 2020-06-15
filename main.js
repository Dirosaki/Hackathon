this.onpush = function(event) {
    console.log(event.data);
  }
  navigator.serviceWorker.register('pwabuilder-sw.js').then(
    function(serviceWorkerRegistration) {
      serviceWorkerRegistration.pushManager.subscribe().then(
        function(pushSubscription) {
          console.log(pushSubscription.subscriptionId);
          console.log(pushSubscription.endpoint);
        }, function(error) {
          console.log(error);
        }
      );
    });