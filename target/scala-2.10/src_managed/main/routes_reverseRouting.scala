// @SOURCE:/Users/ruanpingcheng/Desktop/CMS/conf/routes
// @HASH:9832bf64d8bffa2e20970afd0e55bede0416d0da
// @DATE:Sat Sep 27 22:53:18 CST 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:27
// @LINE:26
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:19
// @LINE:17
// @LINE:16
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:27
// @LINE:26
// @LINE:24
// @LINE:23
// @LINE:22
class ReverseAgencyController {
    

// @LINE:27
def solveEvent(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "agency/solveEvent")
}
                                                

// @LINE:24
def getSolvedEvents(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "agency/solvedEvents")
}
                                                

// @LINE:26
def readEvent(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "agency/readEvent")
}
                                                

// @LINE:22
def getSentEvents(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "agency/sentEvents")
}
                                                

// @LINE:23
def getReadEvents(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "agency/readEvents")
}
                                                
    
}
                          

// @LINE:17
// @LINE:16
class ReverseCallOperatorController {
    

// @LINE:17
def report(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "calloperator/report")
}
                                                

// @LINE:16
def login(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "calloperator/login")
}
                                                
    
}
                          

// @LINE:19
class ReverseAssets {
    

// @LINE:19
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:10
def getEventTypes(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "eventTypes")
}
                                                

// @LINE:7
def logout(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                                                

// @LINE:9
def getAgencies(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "agencies")
}
                                                

// @LINE:8
def getEventsBytypeID(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "events/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                                                

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          
}
                  


// @LINE:27
// @LINE:26
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:19
// @LINE:17
// @LINE:16
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:27
// @LINE:26
// @LINE:24
// @LINE:23
// @LINE:22
class ReverseAgencyController {
    

// @LINE:27
def solveEvent : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AgencyController.solveEvent",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "agency/solveEvent"})
      }
   """
)
                        

// @LINE:24
def getSolvedEvents : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AgencyController.getSolvedEvents",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "agency/solvedEvents"})
      }
   """
)
                        

// @LINE:26
def readEvent : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AgencyController.readEvent",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "agency/readEvent"})
      }
   """
)
                        

// @LINE:22
def getSentEvents : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AgencyController.getSentEvents",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "agency/sentEvents"})
      }
   """
)
                        

// @LINE:23
def getReadEvents : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AgencyController.getReadEvents",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "agency/readEvents"})
      }
   """
)
                        
    
}
              

// @LINE:17
// @LINE:16
class ReverseCallOperatorController {
    

// @LINE:17
def report : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.CallOperatorController.report",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "calloperator/report"})
      }
   """
)
                        

// @LINE:16
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.CallOperatorController.login",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "calloperator/login"})
      }
   """
)
                        
    
}
              

// @LINE:19
class ReverseAssets {
    

// @LINE:19
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:10
def getEventTypes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.getEventTypes",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "eventTypes"})
      }
   """
)
                        

// @LINE:7
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:9
def getAgencies : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.getAgencies",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "agencies"})
      }
   """
)
                        

// @LINE:8
def getEventsBytypeID : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.getEventsBytypeID",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "events/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:27
// @LINE:26
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:19
// @LINE:17
// @LINE:16
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:27
// @LINE:26
// @LINE:24
// @LINE:23
// @LINE:22
class ReverseAgencyController {
    

// @LINE:27
def solveEvent(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AgencyController.solveEvent(), HandlerDef(this, "controllers.AgencyController", "solveEvent", Seq(), "POST", """""", _prefix + """agency/solveEvent""")
)
                      

// @LINE:24
def getSolvedEvents(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AgencyController.getSolvedEvents(), HandlerDef(this, "controllers.AgencyController", "getSolvedEvents", Seq(), "POST", """""", _prefix + """agency/solvedEvents""")
)
                      

// @LINE:26
def readEvent(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AgencyController.readEvent(), HandlerDef(this, "controllers.AgencyController", "readEvent", Seq(), "GET", """TESTING SHOULD BE POST			""", _prefix + """agency/readEvent""")
)
                      

// @LINE:22
def getSentEvents(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AgencyController.getSentEvents(), HandlerDef(this, "controllers.AgencyController", "getSentEvents", Seq(), "POST", """Agency""", _prefix + """agency/sentEvents""")
)
                      

// @LINE:23
def getReadEvents(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AgencyController.getReadEvents(), HandlerDef(this, "controllers.AgencyController", "getReadEvents", Seq(), "POST", """""", _prefix + """agency/readEvents""")
)
                      
    
}
                          

// @LINE:17
// @LINE:16
class ReverseCallOperatorController {
    

// @LINE:17
def report(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.CallOperatorController.report(), HandlerDef(this, "controllers.CallOperatorController", "report", Seq(), "POST", """""", _prefix + """calloperator/report""")
)
                      

// @LINE:16
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.CallOperatorController.login(), HandlerDef(this, "controllers.CallOperatorController", "login", Seq(), "POST", """CallOperator""", _prefix + """calloperator/login""")
)
                      
    
}
                          

// @LINE:19
class ReverseAssets {
    

// @LINE:19
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:10
def getEventTypes(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.getEventTypes(), HandlerDef(this, "controllers.Application", "getEventTypes", Seq(), "GET", """""", _prefix + """eventTypes""")
)
                      

// @LINE:7
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:9
def getAgencies(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.getAgencies(), HandlerDef(this, "controllers.Application", "getAgencies", Seq(), "GET", """""", _prefix + """agencies""")
)
                      

// @LINE:8
def getEventsBytypeID(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.getEventsBytypeID(id), HandlerDef(this, "controllers.Application", "getEventsBytypeID", Seq(classOf[Long]), "GET", """""", _prefix + """events/$id<[^/]+>""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          
}
        
    