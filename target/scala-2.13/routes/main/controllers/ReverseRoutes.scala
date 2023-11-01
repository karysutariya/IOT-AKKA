// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def profile(search:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "profile" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("search", search)))))
    }
  
    // @LINE:8
    def searchsubreddit(subredditID:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "subreddit/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("subredditID", subredditID)))
    }
  
    // @LINE:11
    def ws: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ws")
    }
  
    // @LINE:12
    def ws2: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ws2")
    }
  
    // @LINE:9
    def wordStats(path:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "stats/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("path", path)))
    }
  
    // @LINE:6
    def index(msearch:String = null): Call = {
      
      Call("GET", _prefix + play.core.routing.queryString(List(if(msearch == null) None else Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("msearch", msearch)))))
    }
  
    // @LINE:13
    def ws3: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ws3")
    }
  
    // @LINE:14
    def ws4: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "ws4")
    }
  
  }

  // @LINE:16
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
