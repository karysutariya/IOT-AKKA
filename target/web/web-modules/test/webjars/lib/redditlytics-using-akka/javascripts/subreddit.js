(function() {
    $(function() {
        var ws;
        ws = new WebSocket($("body").data("ws-url"));
        return ws.onmessage = function(event) {
            var message;
            message = JSON.parse(event.data);
            var keys = Object.keys(message);
            let text = ""
            for (let x in keys) {
                var test = JSON.parse(message[keys[x]]);
                for (k in test)
                {
                    var test21 = test[k];
                    console.log(test21['author'],test21['reddit'],test21['title'])
                    var SProfile = test21["author"];
                    var RSubreddit = test21["reddit"];
                    text += '<b><a href="/profile?search='+test21["author"]+'">'+test21["author"]+"</a></b>";
                    text += '&emsp;<b><a href="/subreddit/'+test21["reddit"]+'">'+test21["reddit"]+"</a></b>";
                    text += '&emsp;<i>'+test21["title"]+"</i><br>";
                }
            }
            return $('#time').html(text);
        };
    });
}).call(this);