let addLocal = document.querySelector('.add-local');
let modalAdd = document.querySelector('.modal-add');
let notConfirm = document.querySelector('.not-confirm');
let yesConfirm = document.querySelector('.confirm');

let modalVisible = false;
function verifyModal(){
    if(modalVisible == true){
        modalAdd.style.display = 'flex';
    }
    else{
        modalAdd.style.display = 'none';
    }
}
addLocal.addEventListener('click', function(event) {
    event.preventDefault();
    if(modalVisible == false) {
        modalVisible = true;
    }
    verifyModal();
});
notConfirm.addEventListener('click', (event) => {
    event.preventDefault();
    modalVisible = false;
    verifyModal();
})
yesConfirm.addEventListener('click', (event) => {
    event.preventDefault();
    modalVisible = false;
    verifyModal();
});


