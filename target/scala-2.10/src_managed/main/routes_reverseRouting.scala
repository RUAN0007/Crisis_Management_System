// @SOURCE:/Users/ruanpingcheng/Desktop/CMS/conf/routes
// @HASH:9224972e5878cd6fa89ef4483ff967093593817e
// @DATE:Sun Sep 28 21:19:29 CST 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:40
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:18
// @LINE:17
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:40
class ReverseAssets {
    

// @LINE:40
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
class ReverseServiceOperatorController {
    

// @LINE:24
def getPriorityOneEvents(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "serviceoperator/priorityOneEvents")
}
                                                

// @LINE:23
def getUnclassifiedEvents(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "serviceoperator/unhandledEvents")
}
                                                

// @LINE:28
def getEventByID(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "serviceoperator/eventFromID")
}
                                                

// @LINE:25
def smsEvent(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "serviceoperator/broadcastSMS")
}
                                                

// @LINE:27
def getEventsStatus(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "serviceoperator/eventsStatus")
}
                                                

// @LINE:22
def updateEvent(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "serviceoperator/updateEvent")
}
                                                

// @LINE:26
def emailEvent(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "serviceoperator/sendReport")
}
                                                

// @LINE:21
def login(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "serviceoperator/login")
}
                                                
    
}
                          

// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
class ReverseAgencyController {
    

// @LINE:37
def solveEvent(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "agency/solveEvent")
}
                                                

// @LINE:35
def getSolvedEvents(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "agency/solvedEvents")
}
                                                

// @LINE:36
def readEvent(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "agency/readEvent")
}
                                                

// @LINE:33
def getSentEvents(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "agency/sentEvents")
}
                                                

// @LINE:34
def getReadEvents(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "agency/readEvents")
}
                                                

// @LINE:32
def login(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "agency/login")
}
                                                
    
}
                          

// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:8
def getEventsBytypeID(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "events")
}
                                                

// @LINE:10
def getEventTypes(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "getEventTypes")
}
                                                

// @LINE:7
def logout(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                                                

// @LINE:9
def getAgencies(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "getAgencies")
}
                                                

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          

// @LINE:18
// @LINE:17
class ReverseCallOperatorController {
    

// @LINE:18
def report(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "calloperator/report")
}
                                                

// @LINE:17
def login(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "calloperator/login")
}
                                                
    
}
                          
}
                  


// @LINE:40
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:18
// @LINE:17
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:40
class ReverseAssets {
    

// @LINE:40
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
class ReverseServiceOperatorController {
    

// @LINE:24
def getPriorityOneEvents : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ServiceOperatorController.getPriorityOneEvents",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "serviceoperator/priorityOneEvents"})
      }
   """
)
                        

// @LINE:23
def getUnclassifiedEvents : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ServiceOperatorController.getUnclassifiedEvents",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "serviceoperator/unhandledEvents"})
      }
   """
)
                        

// @LINE:28
def getEventByID : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ServiceOperatorController.getEventByID",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "serviceoperator/eventFromID"})
      }
   """
)
                        

// @LINE:25
def smsEvent : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ServiceOperatorController.smsEvent",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "serviceoperator/broadcastSMS"})
      }
   """
)
                        

// @LINE:27
def getEventsStatus : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ServiceOperatorController.getEventsStatus",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "serviceoperator/eventsStatus"})
      }
   """
)
                        

// @LINE:22
def updateEvent : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ServiceOperatorController.updateEvent",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "serviceoperator/updateEvent"})
      }
   """
)
                        

// @LINE:26
def emailEvent : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ServiceOperatorController.emailEvent",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "serviceoperator/sendReport"})
      }
   """
)
                        

// @LINE:21
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ServiceOperatorController.login",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "serviceoperator/login"})
      }
   """
)
                        
    
}
              

// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
class ReverseAgencyController {
    

// @LINE:37
def solveEvent : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AgencyController.solveEvent",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "agency/solveEvent"})
      }
   """
)
                        

// @LINE:35
def getSolvedEvents : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AgencyController.getSolvedEvents",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "agency/solvedEvents"})
      }
   """
)
                        

// @LINE:36
def readEvent : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AgencyController.readEvent",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "agency/readEvent"})
      }
   """
)
                        

// @LINE:33
def getSentEvents : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AgencyController.getSentEvents",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "agency/sentEvents"})
      }
   """
)
                        

// @LINE:34
def getReadEvents : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AgencyController.getReadEvents",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "agency/readEvents"})
      }
   """
)
                        

// @LINE:32
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AgencyController.login",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "agency/login"})
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
    

// @LINE:8
def getEventsBytypeID : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.getEventsBytypeID",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "events"})
      }
   """
)
                        

// @LINE:10
def getEventTypes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.getEventTypes",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getEventTypes"})
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
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getAgencies"})
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
              

// @LINE:18
// @LINE:17
class ReverseCallOperatorController {
    

// @LINE:18
def report : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.CallOperatorController.report",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "calloperator/report"})
      }
   """
)
                        

// @LINE:17
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.CallOperatorController.login",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "calloperator/login"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:40
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:18
// @LINE:17
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:40
class ReverseAssets {
    

// @LINE:40
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
class ReverseServiceOperatorController {
    

// @LINE:24
def getPriorityOneEvents(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ServiceOperatorController.getPriorityOneEvents(), HandlerDef(this, "controllers.ServiceOperatorController", "getPriorityOneEvents", Seq(), "GET", """""", _prefix + """serviceoperator/priorityOneEvents""")
)
                      

// @LINE:23
def getUnclassifiedEvents(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ServiceOperatorController.getUnclassifiedEvents(), HandlerDef(this, "controllers.ServiceOperatorController", "getUnclassifiedEvents", Seq(), "GET", """""", _prefix + """serviceoperator/unhandledEvents""")
)
                      

// @LINE:28
def getEventByID(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ServiceOperatorController.getEventByID(), HandlerDef(this, "controllers.ServiceOperatorController", "getEventByID", Seq(), "GET", """""", _prefix + """serviceoperator/eventFromID""")
)
                      

// @LINE:25
def smsEvent(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ServiceOperatorController.smsEvent(), HandlerDef(this, "controllers.ServiceOperatorController", "smsEvent", Seq(), "GET", """""", _prefix + """serviceoperator/broadcastSMS""")
)
                      

// @LINE:27
def getEventsStatus(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ServiceOperatorController.getEventsStatus(), HandlerDef(this, "controllers.ServiceOperatorController", "getEventsStatus", Seq(), "GET", """""", _prefix + """serviceoperator/eventsStatus""")
)
                      

// @LINE:22
def updateEvent(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ServiceOperatorController.updateEvent(), HandlerDef(this, "controllers.ServiceOperatorController", "updateEvent", Seq(), "POST", """""", _prefix + """serviceoperator/updateEvent""")
)
                      

// @LINE:26
def emailEvent(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ServiceOperatorController.emailEvent(), HandlerDef(this, "controllers.ServiceOperatorController", "emailEvent", Seq(), "GET", """""", _prefix + """serviceoperator/sendReport""")
)
                      

// @LINE:21
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ServiceOperatorController.login(), HandlerDef(this, "controllers.ServiceOperatorController", "login", Seq(), "POST", """ServiceOperator""", _prefix + """serviceoperator/login""")
)
                      
    
}
                          

// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
class ReverseAgencyController {
    

// @LINE:37
def solveEvent(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AgencyController.solveEvent(), HandlerDef(this, "controllers.AgencyController", "solveEvent", Seq(), "POST", """""", _prefix + """agency/solveEvent""")
)
                      

// @LINE:35
def getSolvedEvents(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AgencyController.getSolvedEvents(), HandlerDef(this, "controllers.AgencyController", "getSolvedEvents", Seq(), "POST", """""", _prefix + """agency/solvedEvents""")
)
                      

// @LINE:36
def readEvent(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AgencyController.readEvent(), HandlerDef(this, "controllers.AgencyController", "readEvent", Seq(), "POST", """""", _prefix + """agency/readEvent""")
)
                      

// @LINE:33
def getSentEvents(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AgencyController.getSentEvents(), HandlerDef(this, "controllers.AgencyController", "getSentEvents", Seq(), "POST", """""", _prefix + """agency/sentEvents""")
)
                      

// @LINE:34
def getReadEvents(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AgencyController.getReadEvents(), HandlerDef(this, "controllers.AgencyController", "getReadEvents", Seq(), "POST", """""", _prefix + """agency/readEvents""")
)
                      

// @LINE:32
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AgencyController.login(), HandlerDef(this, "controllers.AgencyController", "login", Seq(), "POST", """Agency""", _prefix + """agency/login""")
)
                      
    
}
                          

// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {
    

// @LINE:8
def getEventsBytypeID(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.getEventsBytypeID(), HandlerDef(this, "controllers.Application", "getEventsBytypeID", Seq(), "POST", """""", _prefix + """events""")
)
                      

// @LINE:10
def getEventTypes(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.getEventTypes(), HandlerDef(this, "controllers.Application", "getEventTypes", Seq(), "GET", """""", _prefix + """getEventTypes""")
)
                      

// @LINE:7
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:9
def getAgencies(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.getAgencies(), HandlerDef(this, "controllers.Application", "getAgencies", Seq(), "GET", """""", _prefix + """getAgencies""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          

// @LINE:18
// @LINE:17
class ReverseCallOperatorController {
    

// @LINE:18
def report(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.CallOperatorController.report(), HandlerDef(this, "controllers.CallOperatorController", "report", Seq(), "POST", """""", _prefix + """calloperator/report""")
)
                      

// @LINE:17
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.CallOperatorController.login(), HandlerDef(this, "controllers.CallOperatorController", "login", Seq(), "POST", """CallOperator""", _prefix + """calloperator/login""")
)
                      
    
}
                          
}
        
    