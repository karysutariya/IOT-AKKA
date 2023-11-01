// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def profile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.profile",
      """
        function(search0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "profile" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("search", search0)])})
        }
      """
    )
  
    // @LINE:8
    def searchsubreddit: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.searchsubreddit",
      """
        function(subredditID0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "subreddit/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("subredditID", subredditID0))})
        }
      """
    )
  
    // @LINE:11
    def ws: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.ws",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ws"})
        }
      """
    )
  
    // @LINE:12
    def ws2: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.ws2",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ws2"})
        }
      """
    )
  
    // @LINE:9
    def wordStats: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.wordStats",
      """
        function(path0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "stats/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("path", path0))})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function(msearch0) {
          return _wA({method:"GET", url:"""" + _prefix + """" + _qS([(msearch0 == null ? null : (""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("msearch", msearch0))])})
        }
      """
    )
  
    // @LINE:13
    def ws3: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.ws3",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ws3"})
        }
      """
    )
  
    // @LINE:14
    def ws4: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.ws4",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ws4"})
        }
      """
    )
  
  }

  // @LINE:16
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
