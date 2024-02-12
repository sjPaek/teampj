const msgModal = $('#msgModal');

let msgLink;
function showMessage (_title, _msg, ){
    msgModal.off('hidden.bs.modal', msgLink, false);

    const modalTitle = $('#msgModalTitle');
    const modalBody = $('#msgModalBody');

    modalTitle.text(_title);
    modalBody.html(_msg);

    msgModal.modal('show');
}