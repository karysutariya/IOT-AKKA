
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

object profile extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[play.mvc.Http.Request,String,List[Models.User],List[Models.Article],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(request: play.mvc.Http.Request, search: String, profiles : List[Models.User], Arts: List[Models.Article] ):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.1*/("""<html lang="en">
<head>
    <title>Search</title>
    <link rel="stylesheet" type="text/css" href='"""),_display_(/*6.51*/routes/*6.57*/.Assets.versioned("stylesheets/bootstrap.min.css")),format.raw/*6.107*/("""' />
    <link rel="stylesheet" type="text/css" href='"""),_display_(/*7.51*/routes/*7.57*/.Assets.versioned("stylesheets/style.css")),format.raw/*7.99*/("""' />
    <script type='text/javascript' src='"""),_display_(/*8.42*/routes/*8.48*/.Assets.versioned("js/jquery-3.6.0.min.js")),format.raw/*8.91*/("""'></script>
    <script type='text/javascript' src='"""),_display_(/*9.42*/routes/*9.48*/.Assets.versioned("js/custom.js")),format.raw/*9.81*/("""'></script>
    <script type='text/javascript' src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
    <script type='text/javascript' src='"""),_display_(/*11.42*/routes/*11.48*/.Assets.versioned("javascripts/profile.js")),format.raw/*11.91*/("""'></script>
</head>

<body data-ws-url=""""),_display_(/*14.21*/routes/*14.27*/.HomeController.ws2.webSocketURL(request)),format.raw/*14.68*/("""">
<h2 style="text-align:center">Welcome to RedditLytics</h2>
<button id="myButton" class="float-left submit-button" >Home</button>
<div style="margin-top:3%"></div>
<form class="example" action="/" method="GET" style="margin:auto;max-width:300px">
    <input type="text" placeholder="Search.." name="search">
    <button type="submit">click</button>
</form>
<br>
<h2 style="text-align:left; margin-left:20%;">"""),_display_(/*23.48*/search),format.raw/*23.54*/("""</h2>
<br>

"""),_display_(/*26.2*/for(profile <- profiles) yield /*26.26*/{_display_(Seq[Any](format.raw/*26.27*/("""
"""),format.raw/*27.1*/("""<table style="text-align:center;margin:auto;max-width:500px">
    <tbody>
    <tr>
        <th scope="row" align="left">Name</th>
        <td align="left">"""),_display_(/*31.27*/profile/*31.34*/.Name),format.raw/*31.39*/("""</td>
    </tr>
    <tr>
        <th scope="row" align="left">Profile Name</th>
        <td align="left">"""),_display_(/*35.27*/profile/*35.34*/.Profile),format.raw/*35.42*/("""</td>
    </tr>
    <tr>
        <th scope="row" align="left">Verified User</th>
        <td align="left">"""),_display_(/*39.27*/profile/*39.34*/.Verified),format.raw/*39.43*/("""</td>
    </tr>
    <tr>
        <th scope="row" align="left">Reddit profile</th>
        <td align="left"><a href=""""),_display_(/*43.36*/profile/*43.43*/.Reddit_profile),format.raw/*43.58*/("""" target="_blank">"""),_display_(/*43.77*/profile/*43.84*/.Reddit_profile),format.raw/*43.99*/("""</a></td>
    </tr>
    <tr>
        <th scope="row" align="left">Subscribers</th>
        <td align="left">"""),_display_(/*47.27*/profile/*47.34*/.Subscribers),format.raw/*47.46*/("""</td>
    </tr>
    <tr>
        <th scope="row" align="left">Reddit user since</th>
        <td align="left">"""),_display_(/*51.27*/profile/*51.34*/.Reddit_user),format.raw/*51.46*/("""</td>
    </tr>
    <tr>
        <th scope="row" align="left">Total Karma</th>
        <td align="left">"""),_display_(/*55.27*/profile/*55.34*/.Total_Karma),format.raw/*55.46*/("""</td>
    </tr>
    </tbody>
</table>
""")))}),format.raw/*59.2*/("""

"""),format.raw/*61.1*/("""<br>
<h2 style="text-align:left; margin-left:20%;">Articles</h2>
<br>

<div id="time"> </div>


<script type="text/javascript">
    document.getElementById("myButton").onclick = function () """),format.raw/*69.63*/("""{"""),format.raw/*69.64*/("""
        """),format.raw/*70.9*/("""location.href = "/";
    """),format.raw/*71.5*/("""}"""),format.raw/*71.6*/(""";
</script>
</body>
</html>"""))
      }
    }
  }

  def render(request:play.mvc.Http.Request,search:String,profiles:List[Models.User],Arts:List[Models.Article]): play.twirl.api.HtmlFormat.Appendable = apply(request,search,profiles,Arts)

  def f:((play.mvc.Http.Request,String,List[Models.User],List[Models.Article]) => play.twirl.api.HtmlFormat.Appendable) = (request,search,profiles,Arts) => apply(request,search,profiles,Arts)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/profile.scala.html
                  HASH: 08ffd8ee5e55807a58f70e6e72943622bf780dea
                  MATRIX: 970->1|1171->109|1198->110|1324->210|1338->216|1409->266|1490->321|1504->327|1566->369|1638->415|1652->421|1715->464|1794->517|1808->523|1861->556|2036->704|2051->710|2115->753|2183->794|2198->800|2260->841|2698->1252|2725->1258|2764->1271|2804->1295|2843->1296|2871->1297|3054->1453|3070->1460|3096->1465|3229->1571|3245->1578|3274->1586|3408->1693|3424->1700|3454->1709|3598->1826|3614->1833|3650->1848|3696->1867|3712->1874|3748->1889|3884->1998|3900->2005|3933->2017|4071->2128|4087->2135|4120->2147|4252->2252|4268->2259|4301->2271|4370->2310|4399->2312|4617->2502|4646->2503|4682->2512|4734->2537|4762->2538
                  LINES: 27->1|32->2|33->3|36->6|36->6|36->6|37->7|37->7|37->7|38->8|38->8|38->8|39->9|39->9|39->9|41->11|41->11|41->11|44->14|44->14|44->14|53->23|53->23|56->26|56->26|56->26|57->27|61->31|61->31|61->31|65->35|65->35|65->35|69->39|69->39|69->39|73->43|73->43|73->43|73->43|73->43|73->43|77->47|77->47|77->47|81->51|81->51|81->51|85->55|85->55|85->55|89->59|91->61|99->69|99->69|100->70|101->71|101->71
                  -- GENERATED --
              */
          