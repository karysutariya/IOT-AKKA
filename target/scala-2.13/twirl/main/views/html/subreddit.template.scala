
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.data._
import play.core.j.PlayFormsMagicForJava._
import scala.jdk.CollectionConverters._

object subreddit extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[play.mvc.Http.Request,String,List[Models.Reddit],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(request: play.mvc.Http.Request,subname:String,Reds: List[Models.Reddit]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Search</title>
    <link rel="stylesheet" type="text/css" href='"""),_display_(/*6.51*/routes/*6.57*/.Assets.versioned("stylesheets/bootstrap.min.css")),format.raw/*6.107*/("""' />
    <link rel="stylesheet" type="text/css" href='"""),_display_(/*7.51*/routes/*7.57*/.Assets.versioned("stylesheets/style.css")),format.raw/*7.99*/("""' />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script type='text/javascript' src='"""),_display_(/*9.42*/routes/*9.48*/.Assets.versioned("js/jquery-3.6.0.min.js")),format.raw/*9.91*/("""'></script>
    <script type='text/javascript' src='"""),_display_(/*10.42*/routes/*10.48*/.Assets.versioned("js/custom.js")),format.raw/*10.81*/("""'></script>
    <script type='text/javascript' src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
    <script type='text/javascript' src='"""),_display_(/*12.42*/routes/*12.48*/.Assets.versioned("javascripts/subreddit.js")),format.raw/*12.93*/("""'></script>
</head>

<body  data-ws-url=""""),_display_(/*15.22*/routes/*15.28*/.HomeController.ws3.webSocketURL(request)),format.raw/*15.69*/("""">
<h2 style="text-align:center">Welcome to RedditLytics</h2>
<div style="margin-top:3%"></div>
<form class="example" action="/" method="GET" style="margin:auto;max-width:300px">
    <input type="text" placeholder="Search.." name="search">
    <button type="submit"><i class="fa fa-search"></i></button>
</form>
<br>

<h2 style="text-align:left; margin-left:20%;">"""),_display_(/*24.48*/subname),format.raw/*24.55*/("""</h2>
    <div id="time"> </div>
    <br>

</body>
</html>"""))
      }
    }
  }

  def render(request:play.mvc.Http.Request,subname:String,Reds:List[Models.Reddit]): play.twirl.api.HtmlFormat.Appendable = apply(request,subname,Reds)

  def f:((play.mvc.Http.Request,String,List[Models.Reddit]) => play.twirl.api.HtmlFormat.Appendable) = (request,subname,Reds) => apply(request,subname,Reds)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/subreddit.scala.html
                  HASH: a5702aba3bd381078516390b3b8c56246f02140e
                  MATRIX: 953->1|1120->75|1273->202|1287->208|1358->258|1439->313|1453->319|1515->361|1705->525|1719->531|1782->574|1862->627|1877->633|1931->666|2106->814|2121->820|2187->865|2256->907|2271->913|2333->954|2725->1319|2753->1326
                  LINES: 27->1|32->2|36->6|36->6|36->6|37->7|37->7|37->7|39->9|39->9|39->9|40->10|40->10|40->10|42->12|42->12|42->12|45->15|45->15|45->15|54->24|54->24
                  -- GENERATED --
              */
          