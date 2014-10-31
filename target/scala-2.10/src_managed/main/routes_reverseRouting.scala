// @SOURCE:/Users/ruanpingcheng/Desktop/CMS/conf/routes
// @HASH:5b8002279d778d6bda35edfcac805608dcdbadca
// @DATE:Fri Oct 31 13:03:59 CST 2014

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:56
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:34
// @LINE:33
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:21
// @LINE:20
// @LINE:18
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:56
class ReverseAssets {
    

// @LINE:56
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:37
class ReverseServiceOperatorController {
    

// @LINE:40
def getPriorityOneEvents(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "serviceoperator/priorityOneEvents")
}
                                                

// @LINE:39
def getUnclassifiedEvents(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "serviceoperator/unhandledEvents")
}
                                                

// @LINE:44
def getEventByID(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "serviceoperator/eventFromID")
}
                                                

// @LINE:41
def smsEvent(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "serviceoperator/broadcastSMS")
}
                                                

// @LINE:43
def getEventsStatus(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "serviceoperator/eventsStatus")
}
                                                

// @LINE:38
def updateEvent(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "serviceoperator/updateEvent")
}
                                                

// @LINE:42
def emailEvent(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "serviceoperator/sendReport")
}
                                                

// @LINE:37
def login(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "serviceoperator/login")
}
                                                
    
}
                          

// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:21
// @LINE:20
// @LINE:18
// @LINE:16
// @LINE:6
class ReverseAdminController {
    

// @LINE:24
def addUser(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "addUser")
}
                                                

// @LINE:16
def main(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "main")
}
                                                

// @LINE:28
def addEventType(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "addEventType")
}
                                                

// @LINE:21
def manageRelationship(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "manageRelationShip")
}
                                                

// @LINE:23
def renderManageUserView(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "manageUser")
}
                                                

// @LINE:25
def deleteUser(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "deleteUser")
}
                                                

// @LINE:20
def manageAgencyEventTypeRelationship(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "relationship")
}
                                                

// @LINE:18
def validateAdmin(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "validateAdmin")
}
                                                

// @LINE:29
def deleteEventType(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "deleteEventType")
}
                                                

// @LINE:27
def renderManageEventTypesView(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "manageEventType")
}
                                                

// @LINE:6
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          

// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
class ReverseAgencyController {
    

// @LINE:53
def solveEvent(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "agency/solveEvent")
}
                                                

// @LINE:51
def getSolvedEvents(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "agency/solvedEvents")
}
                                                

// @LINE:52
def readEvent(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "agency/readEvent")
}
                                                

// @LINE:49
def getSentEvents(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "agency/sentEvents")
}
                                                

// @LINE:50
def getReadEvents(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "agency/readEvents")
}
                                                

// @LINE:48
def login(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "agency/login")
}
                                                
    
}
                          

// @LINE:13
// @LINE:12
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
class ReverseApplication {
    

// @LINE:8
def getEventsBytypeID(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "events")
}
                                                

// @LINE:12
def reportBug(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "bug")
}
                                                

// @LINE:10
def getEventTypes(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "getEventTypes")
}
                                                

// @LINE:13
def recordBug(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "recordBug")
}
                                                

// @LINE:7
def logout(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                                                

// @LINE:9
def getAgencies(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "getAgencies")
}
                                                
    
}
                          

// @LINE:34
// @LINE:33
class ReverseCallOperatorController {
    

// @LINE:34
def report(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "calloperator/report")
}
                                                

// @LINE:33
def login(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "calloperator/login")
}
                                                
    
}
                          
}
                  


// @LINE:56
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:34
// @LINE:33
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:21
// @LINE:20
// @LINE:18
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {

// @LINE:56
class ReverseAssets {
    

// @LINE:56
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:37
class ReverseServiceOperatorController {
    

// @LINE:40
def getPriorityOneEvents : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ServiceOperatorController.getPriorityOneEvents",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "serviceoperator/priorityOneEvents"})
      }
   """
)
                        

// @LINE:39
def getUnclassifiedEvents : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ServiceOperatorController.getUnclassifiedEvents",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "serviceoperator/unhandledEvents"})
      }
   """
)
                        

// @LINE:44
def getEventByID : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ServiceOperatorController.getEventByID",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "serviceoperator/eventFromID"})
      }
   """
)
                        

// @LINE:41
def smsEvent : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ServiceOperatorController.smsEvent",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "serviceoperator/broadcastSMS"})
      }
   """
)
                        

// @LINE:43
def getEventsStatus : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ServiceOperatorController.getEventsStatus",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "serviceoperator/eventsStatus"})
      }
   """
)
                        

// @LINE:38
def updateEvent : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ServiceOperatorController.updateEvent",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "serviceoperator/updateEvent"})
      }
   """
)
                        

// @LINE:42
def emailEvent : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ServiceOperatorController.emailEvent",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "serviceoperator/sendReport"})
      }
   """
)
                        

// @LINE:37
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.ServiceOperatorController.login",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "serviceoperator/login"})
      }
   """
)
                        
    
}
              

// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:21
// @LINE:20
// @LINE:18
// @LINE:16
// @LINE:6
class ReverseAdminController {
    

// @LINE:24
def addUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AdminController.addUser",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addUser"})
      }
   """
)
                        

// @LINE:16
def main : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AdminController.main",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "main"})
      }
   """
)
                        

// @LINE:28
def addEventType : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AdminController.addEventType",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addEventType"})
      }
   """
)
                        

// @LINE:21
def manageRelationship : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AdminController.manageRelationship",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "manageRelationShip"})
      }
   """
)
                        

// @LINE:23
def renderManageUserView : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AdminController.renderManageUserView",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "manageUser"})
      }
   """
)
                        

// @LINE:25
def deleteUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AdminController.deleteUser",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteUser"})
      }
   """
)
                        

// @LINE:20
def manageAgencyEventTypeRelationship : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AdminController.manageAgencyEventTypeRelationship",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "relationship"})
      }
   """
)
                        

// @LINE:18
def validateAdmin : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AdminController.validateAdmin",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "validateAdmin"})
      }
   """
)
                        

// @LINE:29
def deleteEventType : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AdminController.deleteEventType",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "deleteEventType"})
      }
   """
)
                        

// @LINE:27
def renderManageEventTypesView : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AdminController.renderManageEventTypesView",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "manageEventType"})
      }
   """
)
                        

// @LINE:6
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AdminController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              

// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
class ReverseAgencyController {
    

// @LINE:53
def solveEvent : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AgencyController.solveEvent",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "agency/solveEvent"})
      }
   """
)
                        

// @LINE:51
def getSolvedEvents : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AgencyController.getSolvedEvents",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "agency/solvedEvents"})
      }
   """
)
                        

// @LINE:52
def readEvent : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AgencyController.readEvent",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "agency/readEvent"})
      }
   """
)
                        

// @LINE:49
def getSentEvents : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AgencyController.getSentEvents",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "agency/sentEvents"})
      }
   """
)
                        

// @LINE:50
def getReadEvents : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AgencyController.getReadEvents",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "agency/readEvents"})
      }
   """
)
                        

// @LINE:48
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.AgencyController.login",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "agency/login"})
      }
   """
)
                        
    
}
              

// @LINE:13
// @LINE:12
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
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
                        

// @LINE:12
def reportBug : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.reportBug",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "bug"})
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
                        

// @LINE:13
def recordBug : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.recordBug",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "recordBug"})
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
                        
    
}
              

// @LINE:34
// @LINE:33
class ReverseCallOperatorController {
    

// @LINE:34
def report : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.CallOperatorController.report",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "calloperator/report"})
      }
   """
)
                        

// @LINE:33
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
        


// @LINE:56
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:37
// @LINE:34
// @LINE:33
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:21
// @LINE:20
// @LINE:18
// @LINE:16
// @LINE:13
// @LINE:12
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:56
class ReverseAssets {
    

// @LINE:56
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:37
class ReverseServiceOperatorController {
    

// @LINE:40
def getPriorityOneEvents(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ServiceOperatorController.getPriorityOneEvents(), HandlerDef(this, "controllers.ServiceOperatorController", "getPriorityOneEvents", Seq(), "GET", """""", _prefix + """serviceoperator/priorityOneEvents""")
)
                      

// @LINE:39
def getUnclassifiedEvents(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ServiceOperatorController.getUnclassifiedEvents(), HandlerDef(this, "controllers.ServiceOperatorController", "getUnclassifiedEvents", Seq(), "GET", """""", _prefix + """serviceoperator/unhandledEvents""")
)
                      

// @LINE:44
def getEventByID(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ServiceOperatorController.getEventByID(), HandlerDef(this, "controllers.ServiceOperatorController", "getEventByID", Seq(), "POST", """""", _prefix + """serviceoperator/eventFromID""")
)
                      

// @LINE:41
def smsEvent(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ServiceOperatorController.smsEvent(), HandlerDef(this, "controllers.ServiceOperatorController", "smsEvent", Seq(), "POST", """""", _prefix + """serviceoperator/broadcastSMS""")
)
                      

// @LINE:43
def getEventsStatus(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ServiceOperatorController.getEventsStatus(), HandlerDef(this, "controllers.ServiceOperatorController", "getEventsStatus", Seq(), "GET", """""", _prefix + """serviceoperator/eventsStatus""")
)
                      

// @LINE:38
def updateEvent(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ServiceOperatorController.updateEvent(), HandlerDef(this, "controllers.ServiceOperatorController", "updateEvent", Seq(), "POST", """""", _prefix + """serviceoperator/updateEvent""")
)
                      

// @LINE:42
def emailEvent(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ServiceOperatorController.emailEvent(), HandlerDef(this, "controllers.ServiceOperatorController", "emailEvent", Seq(), "POST", """""", _prefix + """serviceoperator/sendReport""")
)
                      

// @LINE:37
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.ServiceOperatorController.login(), HandlerDef(this, "controllers.ServiceOperatorController", "login", Seq(), "POST", """ServiceOperator""", _prefix + """serviceoperator/login""")
)
                      
    
}
                          

// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:21
// @LINE:20
// @LINE:18
// @LINE:16
// @LINE:6
class ReverseAdminController {
    

// @LINE:24
def addUser(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AdminController.addUser(), HandlerDef(this, "controllers.AdminController", "addUser", Seq(), "POST", """""", _prefix + """addUser""")
)
                      

// @LINE:16
def main(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AdminController.main(), HandlerDef(this, "controllers.AdminController", "main", Seq(), "GET", """""", _prefix + """main""")
)
                      

// @LINE:28
def addEventType(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AdminController.addEventType(), HandlerDef(this, "controllers.AdminController", "addEventType", Seq(), "POST", """""", _prefix + """addEventType""")
)
                      

// @LINE:21
def manageRelationship(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AdminController.manageRelationship(), HandlerDef(this, "controllers.AdminController", "manageRelationship", Seq(), "POST", """""", _prefix + """manageRelationShip""")
)
                      

// @LINE:23
def renderManageUserView(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AdminController.renderManageUserView(), HandlerDef(this, "controllers.AdminController", "renderManageUserView", Seq(), "GET", """""", _prefix + """manageUser""")
)
                      

// @LINE:25
def deleteUser(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AdminController.deleteUser(), HandlerDef(this, "controllers.AdminController", "deleteUser", Seq(), "POST", """""", _prefix + """deleteUser""")
)
                      

// @LINE:20
def manageAgencyEventTypeRelationship(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AdminController.manageAgencyEventTypeRelationship(), HandlerDef(this, "controllers.AdminController", "manageAgencyEventTypeRelationship", Seq(), "GET", """""", _prefix + """relationship""")
)
                      

// @LINE:18
def validateAdmin(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AdminController.validateAdmin(), HandlerDef(this, "controllers.AdminController", "validateAdmin", Seq(), "POST", """""", _prefix + """validateAdmin""")
)
                      

// @LINE:29
def deleteEventType(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AdminController.deleteEventType(), HandlerDef(this, "controllers.AdminController", "deleteEventType", Seq(), "POST", """""", _prefix + """deleteEventType""")
)
                      

// @LINE:27
def renderManageEventTypesView(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AdminController.renderManageEventTypesView(), HandlerDef(this, "controllers.AdminController", "renderManageEventTypesView", Seq(), "GET", """""", _prefix + """manageEventType""")
)
                      

// @LINE:6
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AdminController.index(), HandlerDef(this, "controllers.AdminController", "index", Seq(), "GET", """ Home page""", _prefix + """""")
)
                      
    
}
                          

// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
class ReverseAgencyController {
    

// @LINE:53
def solveEvent(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AgencyController.solveEvent(), HandlerDef(this, "controllers.AgencyController", "solveEvent", Seq(), "POST", """""", _prefix + """agency/solveEvent""")
)
                      

// @LINE:51
def getSolvedEvents(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AgencyController.getSolvedEvents(), HandlerDef(this, "controllers.AgencyController", "getSolvedEvents", Seq(), "POST", """""", _prefix + """agency/solvedEvents""")
)
                      

// @LINE:52
def readEvent(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AgencyController.readEvent(), HandlerDef(this, "controllers.AgencyController", "readEvent", Seq(), "POST", """""", _prefix + """agency/readEvent""")
)
                      

// @LINE:49
def getSentEvents(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AgencyController.getSentEvents(), HandlerDef(this, "controllers.AgencyController", "getSentEvents", Seq(), "POST", """""", _prefix + """agency/sentEvents""")
)
                      

// @LINE:50
def getReadEvents(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AgencyController.getReadEvents(), HandlerDef(this, "controllers.AgencyController", "getReadEvents", Seq(), "POST", """""", _prefix + """agency/readEvents""")
)
                      

// @LINE:48
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.AgencyController.login(), HandlerDef(this, "controllers.AgencyController", "login", Seq(), "POST", """Agency""", _prefix + """agency/login""")
)
                      
    
}
                          

// @LINE:13
// @LINE:12
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
class ReverseApplication {
    

// @LINE:8
def getEventsBytypeID(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.getEventsBytypeID(), HandlerDef(this, "controllers.Application", "getEventsBytypeID", Seq(), "POST", """""", _prefix + """events""")
)
                      

// @LINE:12
def reportBug(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.reportBug(), HandlerDef(this, "controllers.Application", "reportBug", Seq(), "GET", """For Bug Report""", _prefix + """bug""")
)
                      

// @LINE:10
def getEventTypes(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.getEventTypes(), HandlerDef(this, "controllers.Application", "getEventTypes", Seq(), "GET", """""", _prefix + """getEventTypes""")
)
                      

// @LINE:13
def recordBug(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.recordBug(), HandlerDef(this, "controllers.Application", "recordBug", Seq(), "POST", """""", _prefix + """recordBug""")
)
                      

// @LINE:7
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:9
def getAgencies(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.getAgencies(), HandlerDef(this, "controllers.Application", "getAgencies", Seq(), "GET", """""", _prefix + """getAgencies""")
)
                      
    
}
                          

// @LINE:34
// @LINE:33
class ReverseCallOperatorController {
    

// @LINE:34
def report(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.CallOperatorController.report(), HandlerDef(this, "controllers.CallOperatorController", "report", Seq(), "POST", """""", _prefix + """calloperator/report""")
)
                      

// @LINE:33
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.CallOperatorController.login(), HandlerDef(this, "controllers.CallOperatorController", "login", Seq(), "POST", """CallOperator""", _prefix + """calloperator/login""")
)
                      
    
}
                          
}
        
    