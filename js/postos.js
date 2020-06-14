let input = document.querySelector('input');
let nextImagem = document.querySelector('.next img');
let nextAncora = document.querySelector('.next');

function verify() {
    if(input.value.trim() == ""){
        nextImagem.src = "img/proximo-inativo.svg";
        nextAncora.style.pointerEvents = 'none';
    }
    else{
        nextImagem.src = "img/proximo.svg";
        nextAncora.style.pointerEvents = 'auto';
    }
}

input.addEventListener('keyup', verify);

let microAncora = document.querySelector('.micro');
let microImagem = document.querySelector('.micro img');
let microAnimation = document.querySelector('.micro svg');

microAncora.addEventListener('click', function(event){
    event.preventDefault();
    if(microImagem.src.indexOf("microfone.svg") >= 0){
        microImagem.src = "img/microfone-ativo.svg";
        microAnimation.style.display = "inline";
    }
    else{
        microImagem.src = "img/microfone.svg";
        microAnimation.style.display = "none";
    }
});

let atalhoAncora = document.querySelector('.atalho');
let atalhoImagem = document.querySelector('.atalho img');
let modalAtalho = document.querySelector('.opacity');

atalhoAncora.addEventListener('click', function(event){
    event.preventDefault();
    if(atalhoImagem.src.indexOf("atalho.svg") >= 0){
        atalhoImagem.src = "img/atalho-ativo.svg";
        modalAtalho.style.display = 'flex';
    }
    else{
        atalhoImagem.src = "img/atalho.svg";
    }
});
let modal = document.querySelector('.modal-atalho');
let buttonNot = document.querySelector('.button-not');
let buttonYes = document.querySelector('.button-yes');
let buttonYes2 = document.querySelector('.button-yes2');
let notConfirm = document.querySelector('.not-confirm');
let yesConfirm = document.querySelector('.confirm');

buttonNot.addEventListener('click', function(event) {
    event.preventDefault();
    modalAtalho.style.display = 'none';
    atalhoImagem.src = 'img/atalho.svg';
});

buttonYes.addEventListener('click', function(event) {
    event.preventDefault();
    notConfirm.style.display = 'none';
    yesConfirm.style.display = 'inline';
    modal.style.backgroundColor = 'white';
    buttonNot.style.display = 'none';
    buttonYes.style.display = 'none';
    buttonYes2.style.display = 'inline';
});

buttonYes2.addEventListener('click', function(event){
    event.preventDefault();
    modalAtalho.style.display = 'none';
    notConfirm.style.display = 'inline';
    yesConfirm.style.display = 'none';
    modal.style.backgroundColor = '#fdc325';
    buttonNot.style.display = 'inline';
    buttonYes.style.display = 'inline';
    buttonYes2.style.display = 'none';

});