window.onload = function () {
    $('#content').summernote({
        height: 250
    });
    let username = document.getElementById("username").value;
    if ("WebSocket" in window) {
        let webSocket = new WebSocket("ws://localhost/websocket/" + username);
        window.onbeforeunload = function () {
            webSocket.close();
        }
        document.getElementById("send").onclick = function (ev) {
            let content = $('#content').code();
            let date = new Date();
            let time = date.getHours() + ':' + date.getMinutes();
            let data = '{"username":"' + username + '","content":"' + content + '","time":"' + time + '"}';
            webSocket.send(data);
            let myHtml = '<li class="mar-btm">' +
                '<div class="media-right">' +
                '<img src="img/av4.png" class="img-circle img-sm" alt="Profile Picture">' +
                '</div>' +
                '<div class="media-body pad-hor speech-right">' +
                '<div class="speech">' +
                '<a href="#" class="media-heading">' + username + '</a>' +
                '<p>' + content + '</p>' +
                '<p class="speech-time">' +
                '<i class="fa fa-clock-o fa-fw"></i> ' + time + '' +
                '</p>' +
                '</div>' +
                '</div>' +
                '</li>'
            document.getElementsByClassName("top")[0].innerHTML += myHtml
            document.getElementById("content").value = "";
            let scrollDiv = document.getElementsByClassName('top')[0];
            scrollDiv.scrollTop = scrollDiv.scrollHeight;
        }
        webSocket.onmessage = function (ev) {
            let obj = eval('(' + ev.data + ')');
            console.log(obj);
            let type = obj.type;
            if (type == 0) {
                let yourHtml = '<li class="mar-btm">' +
                    '<div class="media-left">' +
                    '<img src="img/av1.png" class="img-circle img-sm" alt="Profile Picture">' +
                    '</div>' +
                    '<div class="media-body pad-hor">' +
                    '<div class="speech">' +
                    '<a href="#" class="media-heading">' + obj.username + '</a>' +
                    '<p>' + obj.content + '</p>' +
                    '<p class="speech-time">' +
                    '<i class="fa fa-clock-o fa-fw"></i>' + obj.time +
                    '</p>' +
                    '</div>' +
                    '</div>' +
                    '</li>'
                document.getElementsByClassName("top")[0].innerHTML += yourHtml;
                let scrollDiv = document.getElementsByClassName('top')[0];
                scrollDiv.scrollTop = scrollDiv.scrollHeight;
            } else if (type == 1) {
                $("#count").html("Chatroom, online count: " + obj.count);
            }
        }
    }
}