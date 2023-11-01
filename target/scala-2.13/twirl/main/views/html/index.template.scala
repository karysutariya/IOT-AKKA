
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
/*1.2*/import java.util

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[play.mvc.Http.Request,String,HashMap[String, util.ArrayList[Models.Reddit]],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(request: play.mvc.Http.Request, MSearch: String, Reds: HashMap[String,util.ArrayList[Models.Reddit]]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.1*/("""<html>
<head>
    <title>Search</title>
    <link rel="stylesheet" type="text/css" href='"""),_display_(/*6.51*/routes/*6.57*/.Assets.versioned("stylesheets/bootstrap.min.css")),format.raw/*6.107*/("""' />
    <link rel="stylesheet" type="text/css" href='"""),_display_(/*7.51*/routes/*7.57*/.Assets.versioned("stylesheets/style.css")),format.raw/*7.99*/("""' />
    <script type='text/javascript' src='"""),_display_(/*8.42*/routes/*8.48*/.Assets.versioned("js/jquery-3.6.0.min.js")),format.raw/*8.91*/("""'></script>
    <script type='text/javascript' src='"""),_display_(/*9.42*/routes/*9.48*/.Assets.versioned("js/custom.js")),format.raw/*9.81*/("""'></script>
    <script type='text/javascript' src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
    <script type='text/javascript' src='"""),_display_(/*11.42*/routes/*11.48*/.Assets.versioned("javascripts/index.js")),format.raw/*11.89*/("""'></script>
</head>
<body data-ws-url=""""),_display_(/*13.21*/routes/*13.27*/.HomeController.ws.webSocketURL(request)),format.raw/*13.67*/("""">
    <h2 style="text-align:center">Welcome to RedditLytics</h2>
    <div style="margin-top:3%"></div>
    <form  class="example" action="/" method="GET" style="margin:auto;max-width:300px">
        <input type="text" placeholder="Search........" name="msearch">
        <button type="submit">click</button>
    </form>
    <br>
    <br>

    <div id="time"> </div>

</body>
</html>"""))
      }
    }
  }

  def render(request:play.mvc.Http.Request,MSearch:String,Reds:HashMap[String, util.ArrayList[Models.Reddit]]): play.twirl.api.HtmlFormat.Appendable = apply(request,MSearch,Reds)

  def f:((play.mvc.Http.Request,String,HashMap[String, util.ArrayList[Models.Reddit]]) => play.twirl.api.HtmlFormat.Appendable) = (request,MSearch,Reds) => apply(request,MSearch,Reds)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/index.scala.html
                  HASH: 56413f89dccf4b577769d67265e9f2b9fe678891
                  MATRIX: 610->1|1000->19|1196->122|1312->212|1326->218|1397->268|1478->323|1492->329|1554->371|1626->417|1640->423|1703->466|1782->519|1796->525|1849->558|2024->706|2039->712|2101->753|2168->793|2183->799|2244->839
                  LINES: 23->1|28->2|33->3|36->6|36->6|36->6|37->7|37->7|37->7|38->8|38->8|38->8|39->9|39->9|39->9|41->11|41->11|41->11|43->13|43->13|43->13
                  -- GENERATED --
              */
          