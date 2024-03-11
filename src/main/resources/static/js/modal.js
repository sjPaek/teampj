const msgModal = $('#msgModal');

function showMessage (_title, _msg){
    console.log('modal');
    msgModal.off('hidden.bs.modal', false);

    const modalTitle = $('#msgModalTitle');
    const modalBody = $('#msgModalBody');

    modalTitle.text(_title);
    modalBody.html(_msg);

    msgModal.modal('show');
}