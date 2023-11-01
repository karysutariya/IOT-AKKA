
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
/*2.2*/import java.util.stream.IntStream

object stats extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[play.mvc.Http.Request,util.Map[String, Integer],util.Map[String, Long],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*3.2*/(request: play.mvc.Http.Request,Words:util.Map[String,Integer],wordCount:util.Map[String,Long]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*4.1*/("""
"""),format.raw/*5.1*/("""<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Search</title>
        <link rel="stylesheet" type="text/css" href='"""),_display_(/*9.55*/routes/*9.61*/.Assets.versioned("stylesheets/bootstrap.min.css")),format.raw/*9.111*/("""' />
        <link rel="stylesheet" type="text/css" href='"""),_display_(/*10.55*/routes/*10.61*/.Assets.versioned("stylesheets/style.css")),format.raw/*10.103*/("""' />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script type='text/javascript' src='"""),_display_(/*12.46*/routes/*12.52*/.Assets.versioned("js/jquery-3.6.0.min.js")),format.raw/*12.95*/("""'></script>
        <script type='text/javascript' src='"""),_display_(/*13.46*/routes/*13.52*/.Assets.versioned("js/custom.js")),format.raw/*13.85*/("""'></script>
        <script type='text/javascript' src='"""),_display_(/*14.46*/routes/*14.52*/.Assets.versioned("js/bootstrap.min.js")),format.raw/*14.92*/("""'></script>
        <script type='text/javascript' src='"""),_display_(/*15.46*/routes/*15.52*/.Assets.versioned("javascripts/stats.js")),format.raw/*15.93*/("""'></script>
        <script type='text/javascript' src='https://code.jquery.com/jquery-3.3.1.min.js'></script>

    </head>
    <body data-ws-url=""""),_display_(/*19.25*/routes/*19.31*/.HomeController.ws4.webSocketURL(request)),format.raw/*19.72*/("""">
        <h2 style="text-align:center">Stats</h2>
        <div style="margin-top:3%"></div>
        <form  class="example" action="/" method="GET" style="margin:auto;max-width:300px">
            <input type="text" placeholder="Search........" name="msearch">
            <button type="submit"><i class="fa fa-search"></i></button>
        </form>

        <br>
        The most used words:

        <br>
        <table style="margin: 3px">
            <tr style="background-color: #7cc3a97d">
                <th style="color: white">Word</th>
                """),_display_(/*34.18*/for((keys,value) <- Words) yield /*34.44*/ {_display_(Seq[Any](format.raw/*34.46*/("""
                    """),format.raw/*35.21*/("""<th style="color: white">"""),_display_(/*35.47*/keys),format.raw/*35.51*/("""</th>""")))}),format.raw/*35.57*/("""
            """),format.raw/*36.13*/("""</tr>

            <tr style="background-color: aliceblue">
                <td style="padding: 1rem">Count</td>
                """),_display_(/*40.18*/for((keys,value) <- Words) yield /*40.44*/ {_display_(Seq[Any](format.raw/*40.46*/("""
                    """),format.raw/*41.21*/("""<td style="padding: 1rem">"""),_display_(/*41.48*/value),format.raw/*41.53*/("""</td>""")))}),format.raw/*41.59*/("""
            """),format.raw/*42.13*/("""</tr>
        </table>

        """),format.raw/*45.25*/("""
        """),format.raw/*46.30*/("""
        """),format.raw/*47.58*/("""
        """),format.raw/*48.30*/("""
        """),format.raw/*49.31*/("""
        """),format.raw/*50.9*/("""The rest of the words:

        <br>
        <table style="margin: 10px">
            <tr style="background-color: #F5DEB3">
                <th style="color: white">Word</th>
                <th style="color: white">Count</th>
            """),_display_(/*57.14*/for((keys,value) <- wordCount) yield /*57.44*/ {_display_(Seq[Any](format.raw/*57.46*/("""

                """),format.raw/*59.17*/("""<tr>

                    <th>"""),_display_(/*61.26*/keys),format.raw/*61.30*/("""</th>
                    <td>"""),_display_(/*62.26*/value),format.raw/*62.31*/("""</td>

                </tr>

                <th style="color: white">"""),_display_(/*66.43*/keys),format.raw/*66.47*/("""</th>""")))}),format.raw/*66.53*/("""

            """),format.raw/*68.13*/("""<tr>


        </table>

    </body>
</html>"""))
      }
    }
  }

  def render(request:play.mvc.Http.Request,Words:util.Map[String, Integer],wordCount:util.Map[String, Long]): play.twirl.api.HtmlFormat.Appendable = apply(request,Words,wordCount)

  def f:((play.mvc.Http.Request,util.Map[String, Integer],util.Map[String, Long]) => play.twirl.api.HtmlFormat.Appendable) = (request,Words,wordCount) => apply(request,Words,wordCount)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/stats.scala.html
                  HASH: 403f93656edc715e99db500d49764a408def0325
                  MATRIX: 610->1|634->19|1036->54|1225->150|1252->151|1421->294|1435->300|1506->350|1592->409|1607->415|1671->457|1870->629|1885->635|1949->678|2033->735|2048->741|2102->774|2186->831|2201->837|2262->877|2346->934|2361->940|2423->981|2598->1129|2613->1135|2675->1176|3266->1740|3308->1766|3348->1768|3397->1789|3450->1815|3475->1819|3512->1825|3553->1838|3710->1968|3752->1994|3792->1996|3841->2017|3895->2044|3921->2049|3958->2055|3999->2068|4059->2116|4096->2146|4133->2204|4170->2234|4207->2265|4243->2274|4511->2515|4557->2545|4597->2547|4643->2565|4701->2596|4726->2600|4784->2631|4810->2636|4909->2708|4934->2712|4971->2718|5013->2732
                  LINES: 23->1|24->2|29->3|34->4|35->5|39->9|39->9|39->9|40->10|40->10|40->10|42->12|42->12|42->12|43->13|43->13|43->13|44->14|44->14|44->14|45->15|45->15|45->15|49->19|49->19|49->19|64->34|64->34|64->34|65->35|65->35|65->35|65->35|66->36|70->40|70->40|70->40|71->41|71->41|71->41|71->41|72->42|75->45|76->46|77->47|78->48|79->49|80->50|87->57|87->57|87->57|89->59|91->61|91->61|92->62|92->62|96->66|96->66|96->66|98->68
                  -- GENERATED --
              */
          