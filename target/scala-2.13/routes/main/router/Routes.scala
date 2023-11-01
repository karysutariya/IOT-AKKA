// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_1: controllers.HomeController,
  // @LINE:16
  Assets_0: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_1: controllers.HomeController,
    // @LINE:16
    Assets_0: controllers.Assets
  ) = this(errorHandler, HomeController_1, Assets_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_1, Assets_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index(request:Request, msearch:String ?= null)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """profile""", """controllers.HomeController.profile(request:Request, search:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """subreddit/""" + "$" + """subredditID<[^/]+>""", """controllers.HomeController.searchsubreddit(request:Request, subredditID:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """stats/""" + "$" + """path<[^/]+>""", """controllers.HomeController.wordStats(request:Request, path:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ws""", """controllers.HomeController.ws"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ws2""", """controllers.HomeController.ws2"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ws3""", """controllers.HomeController.ws3"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """ws4""", """controllers.HomeController.ws4"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      HomeController_1.index(fakeValue[play.mvc.Http.Request], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Seq(classOf[play.mvc.Http.Request], classOf[String]),
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_HomeController_profile1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("profile")))
  )
  private[this] lazy val controllers_HomeController_profile1_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      HomeController_1.profile(fakeValue[play.mvc.Http.Request], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "profile",
      Seq(classOf[play.mvc.Http.Request], classOf[String]),
      "GET",
      this.prefix + """profile""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_HomeController_searchsubreddit2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("subreddit/"), DynamicPart("subredditID", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_searchsubreddit2_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      HomeController_1.searchsubreddit(fakeValue[play.mvc.Http.Request], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "searchsubreddit",
      Seq(classOf[play.mvc.Http.Request], classOf[String]),
      "GET",
      this.prefix + """subreddit/""" + "$" + """subredditID<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_HomeController_wordStats3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("stats/"), DynamicPart("path", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_wordStats3_invoker = createInvoker(
    
    (req:play.mvc.Http.Request) =>
      HomeController_1.wordStats(fakeValue[play.mvc.Http.Request], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "wordStats",
      Seq(classOf[play.mvc.Http.Request], classOf[String]),
      "GET",
      this.prefix + """stats/""" + "$" + """path<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_HomeController_ws4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ws")))
  )
  private[this] lazy val controllers_HomeController_ws4_invoker = createInvoker(
    HomeController_1.ws,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "ws",
      Nil,
      "GET",
      this.prefix + """ws""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_HomeController_ws25_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ws2")))
  )
  private[this] lazy val controllers_HomeController_ws25_invoker = createInvoker(
    HomeController_1.ws2,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "ws2",
      Nil,
      "GET",
      this.prefix + """ws2""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_HomeController_ws36_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ws3")))
  )
  private[this] lazy val controllers_HomeController_ws36_invoker = createInvoker(
    HomeController_1.ws3,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "ws3",
      Nil,
      "GET",
      this.prefix + """ws3""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_HomeController_ws47_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("ws4")))
  )
  private[this] lazy val controllers_HomeController_ws47_invoker = createInvoker(
    HomeController_1.ws4,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "ws4",
      Nil,
      "GET",
      this.prefix + """ws4""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_Assets_versioned8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned8_invoker = createInvoker(
    Assets_0.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params@_) =>
      call(params.fromQuery[String]("msearch", Some(null))) { (msearch) =>
        controllers_HomeController_index0_invoker.call(
          req => HomeController_1.index(req, msearch))
      }
  
    // @LINE:7
    case controllers_HomeController_profile1_route(params@_) =>
      call(params.fromQuery[String]("search", None)) { (search) =>
        controllers_HomeController_profile1_invoker.call(
          req => HomeController_1.profile(req, search))
      }
  
    // @LINE:8
    case controllers_HomeController_searchsubreddit2_route(params@_) =>
      call(params.fromPath[String]("subredditID", None)) { (subredditID) =>
        controllers_HomeController_searchsubreddit2_invoker.call(
          req => HomeController_1.searchsubreddit(req, subredditID))
      }
  
    // @LINE:9
    case controllers_HomeController_wordStats3_route(params@_) =>
      call(params.fromPath[String]("path", None)) { (path) =>
        controllers_HomeController_wordStats3_invoker.call(
          req => HomeController_1.wordStats(req, path))
      }
  
    // @LINE:11
    case controllers_HomeController_ws4_route(params@_) =>
      call { 
        controllers_HomeController_ws4_invoker.call(HomeController_1.ws)
      }
  
    // @LINE:12
    case controllers_HomeController_ws25_route(params@_) =>
      call { 
        controllers_HomeController_ws25_invoker.call(HomeController_1.ws2)
      }
  
    // @LINE:13
    case controllers_HomeController_ws36_route(params@_) =>
      call { 
        controllers_HomeController_ws36_invoker.call(HomeController_1.ws3)
      }
  
    // @LINE:14
    case controllers_HomeController_ws47_route(params@_) =>
      call { 
        controllers_HomeController_ws47_invoker.call(HomeController_1.ws4)
      }
  
    // @LINE:16
    case controllers_Assets_versioned8_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned8_invoker.call(Assets_0.versioned(path, file))
      }
  }
}
