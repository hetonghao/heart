function sendDelete(node) {
    $.ajax({
        url: "/articles/delete/" + 4,/*url也可以是json之类的文件等等*/
        type: "delete",/*DELETE、POST */
        success: function (result) {
            window.location.reload();
        }
    })
}