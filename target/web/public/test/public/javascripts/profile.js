(function() {
  $(function() {
    var ws;
    ws = new WebSocket($("body").data("ws-url"));
    return ws.onmessage = function(event) {
      var message;
      message = JSON.parse(event.data);
      var keys = Object.values(message);
      let text = ""
      for (let x in keys)
      {
        var test = JSON.parse([keys[x]]);
        for (k in test)
        {
            console.log(test[k]);
            var test21 = test[k];

            text +='<div align="center"><b>'+test21["title"]+'</b></div>';
            text +='<div align="center"><i>'+test21["self_text"]+'</i></div>';
            text +='<table style="text-align:center;margin:auto;max-width:500px">';
            text +='<tbody><tr><th scope="row" align="left">subreddit</th>';
            text +='<td align="left">'+test21["subreddit"]+'</td>';
            text +='</tr><tr>'
            text +='<th scope="row" align="left">post_date</th>';
            text +='<td align="left">'+test21["date"]+'</td>';
            text +='</tr></tbody></table></br></br>';

        }
      }
      return $('#time').html(text);
    };
  });
}).call(this);