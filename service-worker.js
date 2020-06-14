// PWA
  
  if ('serviceWorker' in navigator) {
    window.addEventListener('load', () => {
      navigator.serviceWorker.register('/service-worker.js')
          .then((reg) => {
            console.log('Service worker registered.', reg);
          });
    });
  }

// CODELAB: Add list of files to cache here.
const FILES_TO_CACHE = [
  '/',
  '/index.html',
  '/listagem.html',
  '/postos.html',
  '/casadousuario.html',
  '/js/app.js',
  '/js/install.js',
  '/js/luxon-1.11.4.js',
  '/js/postos.js',
  '/css/style.css',
  '/css/casadousuario.css',
  '/css/listagem.css',
  '/css/postos.css',
  '/img/atalho.svg',
  '/img/atalho-ativo.svg',
  '/img/cadaDoUsuario.svg',
  '/img/etc.svg',
  '/img/gps.svg',
  '/img/home.svg',
  '/img/microfone.svg',
  '/img/microfone-ativo.svg',
  '/img/nao.svg',
  '/img/podcast.svg',
  '/img/postos.svg',
  '/img/proximo.svg',
  '/img/proximo-inativo.svg',
  '/img/sim.svg',
  '/img/speaker.svg',
  '/img/telemedicine.svg',
  '/img/Cia-Consulta_logo-baixa.png',
  '/img/background.png',
  '/img/logotipo.png',
];

// CODELAB: Precache static resources here.
evt.waitUntil(
  caches.open(CACHE_NAME).then((cache) => {
    console.log('[ServiceWorker] Pre-caching offline page');
    return cache.addAll(FILES_TO_CACHE);
  })
);

// CODELAB: Remove previous cached data from disk.
evt.waitUntil(
  caches.keys().then((keyList) => {
    return Promise.all(keyList.map((key) => {
      if (key !== CACHE_NAME ) {
        console.log('[ServiceWorker] Removing old cache', key);
        return caches.delete(key);
      }
    }));
  })
);

// CODELAB: Add fetch event handler here.
if (evt.request.mode !== 'navigate') {
  // Not a page navigation, bail.
  return;
}
evt.respondWith(
    fetch(evt.request)
        .catch(() => {
          return caches.open(CACHE_NAME)
              .then((cache) => {
                return cache.match('offline.html');
              });
        })
);

// CODELAB: Update cache names any time any of the cached files change.
const CACHE_NAME = 'static-cache-v2';
const DATA_CACHE_NAME = 'data-cache-v1';

// CODELAB: Add fetch event handler here.
if (evt.request.url.includes('/forecast/')) {
  console.log('[Service Worker] Fetch (data)', evt.request.url);
  evt.respondWith(
      caches.open(DATA_CACHE_NAME).then((cache) => {
        return fetch(evt.request)
            .then((response) => {
              // If the response was good, clone it and store it in the cache.
              if (response.status === 200) {
                cache.put(evt.request.url, response.clone());
              }
              return response;
            }).catch((err) => {
              // Network request failed, try to get it from the cache.
              return cache.match(evt.request);
            });
      }));
  return;
}
evt.respondWith(
    caches.open(CACHE_NAME).then((cache) => {
      return cache.match(evt.request)
          .then((response) => {
            return response || fetch(evt.request);
          });
    })
);