// @SOURCE:/Users/ruanpingcheng/Desktop/CMS/conf/routes
// @HASH:9224972e5878cd6fa89ef4483ff967093593817e
// @DATE:Sun Sep 28 21:19:29 CST 2014


import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString

object Routes extends Router.Routes {

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:7
private[this] lazy val controllers_Application_logout1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
        

// @LINE:8
private[this] lazy val controllers_Application_getEventsBytypeID2 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("events"))))
        

// @LINE:9
private[this] lazy val controllers_Application_getAgencies3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("getAgencies"))))
        

// @LINE:10
private[this] lazy val controllers_Application_getEventTypes4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("getEventTypes"))))
        

// @LINE:17
private[this] lazy val controllers_CallOperatorController_login5 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("calloperator/login"))))
        

// @LINE:18
private[this] lazy val controllers_CallOperatorController_report6 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("calloperator/report"))))
        

// @LINE:21
private[this] lazy val controllers_ServiceOperatorController_login7 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("serviceoperator/login"))))
        

// @LINE:22
private[this] lazy val controllers_ServiceOperatorController_updateEvent8 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("serviceoperator/updateEvent"))))
        

// @LINE:23
private[this] lazy val controllers_ServiceOperatorController_getUnclassifiedEvents9 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("serviceoperator/unhandledEvents"))))
        

// @LINE:24
private[this] lazy val controllers_ServiceOperatorController_getPriorityOneEvents10 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("serviceoperator/priorityOneEvents"))))
        

// @LINE:25
private[this] lazy val controllers_ServiceOperatorController_smsEvent11 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("serviceoperator/broadcastSMS"))))
        

// @LINE:26
private[this] lazy val controllers_ServiceOperatorController_emailEvent12 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("serviceoperator/sendReport"))))
        

// @LINE:27
private[this] lazy val controllers_ServiceOperatorController_getEventsStatus13 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("serviceoperator/eventsStatus"))))
        

// @LINE:28
private[this] lazy val controllers_ServiceOperatorController_getEventByID14 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("serviceoperator/eventFromID"))))
        

// @LINE:32
private[this] lazy val controllers_AgencyController_login15 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("agency/login"))))
        

// @LINE:33
private[this] lazy val controllers_AgencyController_getSentEvents16 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("agency/sentEvents"))))
        

// @LINE:34
private[this] lazy val controllers_AgencyController_getReadEvents17 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("agency/readEvents"))))
        

// @LINE:35
private[this] lazy val controllers_AgencyController_getSolvedEvents18 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("agency/solvedEvents"))))
        

// @LINE:36
private[this] lazy val controllers_AgencyController_readEvent19 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("agency/readEvent"))))
        

// @LINE:37
private[this] lazy val controllers_AgencyController_solveEvent20 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("agency/solveEvent"))))
        

// @LINE:40
private[this] lazy val controllers_Assets_at21 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.Application.logout()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """events""","""controllers.Application.getEventsBytypeID()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """getAgencies""","""controllers.Application.getAgencies()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """getEventTypes""","""controllers.Application.getEventTypes()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """calloperator/login""","""controllers.CallOperatorController.login()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """calloperator/report""","""controllers.CallOperatorController.report()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """serviceoperator/login""","""controllers.ServiceOperatorController.login()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """serviceoperator/updateEvent""","""controllers.ServiceOperatorController.updateEvent()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """serviceoperator/unhandledEvents""","""controllers.ServiceOperatorController.getUnclassifiedEvents()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """serviceoperator/priorityOneEvents""","""controllers.ServiceOperatorController.getPriorityOneEvents()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """serviceoperator/broadcastSMS""","""controllers.ServiceOperatorController.smsEvent()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """serviceoperator/sendReport""","""controllers.ServiceOperatorController.emailEvent()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """serviceoperator/eventsStatus""","""controllers.ServiceOperatorController.getEventsStatus()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """serviceoperator/eventFromID""","""controllers.ServiceOperatorController.getEventByID()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """agency/login""","""controllers.AgencyController.login()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """agency/sentEvents""","""controllers.AgencyController.getSentEvents()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """agency/readEvents""","""controllers.AgencyController.getReadEvents()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """agency/solvedEvents""","""controllers.AgencyController.getSolvedEvents()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """agency/readEvent""","""controllers.AgencyController.readEvent()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """agency/solveEvent""","""controllers.AgencyController.solveEvent()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_index0(params) => {
   call { 
        invokeHandler(controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
   }
}
        

// @LINE:7
case controllers_Application_logout1(params) => {
   call { 
        invokeHandler(controllers.Application.logout(), HandlerDef(this, "controllers.Application", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
   }
}
        

// @LINE:8
case controllers_Application_getEventsBytypeID2(params) => {
   call { 
        invokeHandler(controllers.Application.getEventsBytypeID(), HandlerDef(this, "controllers.Application", "getEventsBytypeID", Nil,"POST", """""", Routes.prefix + """events"""))
   }
}
        

// @LINE:9
case controllers_Application_getAgencies3(params) => {
   call { 
        invokeHandler(controllers.Application.getAgencies(), HandlerDef(this, "controllers.Application", "getAgencies", Nil,"GET", """""", Routes.prefix + """getAgencies"""))
   }
}
        

// @LINE:10
case controllers_Application_getEventTypes4(params) => {
   call { 
        invokeHandler(controllers.Application.getEventTypes(), HandlerDef(this, "controllers.Application", "getEventTypes", Nil,"GET", """""", Routes.prefix + """getEventTypes"""))
   }
}
        

// @LINE:17
case controllers_CallOperatorController_login5(params) => {
   call { 
        invokeHandler(controllers.CallOperatorController.login(), HandlerDef(this, "controllers.CallOperatorController", "login", Nil,"POST", """CallOperator""", Routes.prefix + """calloperator/login"""))
   }
}
        

// @LINE:18
case controllers_CallOperatorController_report6(params) => {
   call { 
        invokeHandler(controllers.CallOperatorController.report(), HandlerDef(this, "controllers.CallOperatorController", "report", Nil,"POST", """""", Routes.prefix + """calloperator/report"""))
   }
}
        

// @LINE:21
case controllers_ServiceOperatorController_login7(params) => {
   call { 
        invokeHandler(controllers.ServiceOperatorController.login(), HandlerDef(this, "controllers.ServiceOperatorController", "login", Nil,"POST", """ServiceOperator""", Routes.prefix + """serviceoperator/login"""))
   }
}
        

// @LINE:22
case controllers_ServiceOperatorController_updateEvent8(params) => {
   call { 
        invokeHandler(controllers.ServiceOperatorController.updateEvent(), HandlerDef(this, "controllers.ServiceOperatorController", "updateEvent", Nil,"POST", """""", Routes.prefix + """serviceoperator/updateEvent"""))
   }
}
        

// @LINE:23
case controllers_ServiceOperatorController_getUnclassifiedEvents9(params) => {
   call { 
        invokeHandler(controllers.ServiceOperatorController.getUnclassifiedEvents(), HandlerDef(this, "controllers.ServiceOperatorController", "getUnclassifiedEvents", Nil,"GET", """""", Routes.prefix + """serviceoperator/unhandledEvents"""))
   }
}
        

// @LINE:24
case controllers_ServiceOperatorController_getPriorityOneEvents10(params) => {
   call { 
        invokeHandler(controllers.ServiceOperatorController.getPriorityOneEvents(), HandlerDef(this, "controllers.ServiceOperatorController", "getPriorityOneEvents", Nil,"GET", """""", Routes.prefix + """serviceoperator/priorityOneEvents"""))
   }
}
        

// @LINE:25
case controllers_ServiceOperatorController_smsEvent11(params) => {
   call { 
        invokeHandler(controllers.ServiceOperatorController.smsEvent(), HandlerDef(this, "controllers.ServiceOperatorController", "smsEvent", Nil,"GET", """""", Routes.prefix + """serviceoperator/broadcastSMS"""))
   }
}
        

// @LINE:26
case controllers_ServiceOperatorController_emailEvent12(params) => {
   call { 
        invokeHandler(controllers.ServiceOperatorController.emailEvent(), HandlerDef(this, "controllers.ServiceOperatorController", "emailEvent", Nil,"GET", """""", Routes.prefix + """serviceoperator/sendReport"""))
   }
}
        

// @LINE:27
case controllers_ServiceOperatorController_getEventsStatus13(params) => {
   call { 
        invokeHandler(controllers.ServiceOperatorController.getEventsStatus(), HandlerDef(this, "controllers.ServiceOperatorController", "getEventsStatus", Nil,"GET", """""", Routes.prefix + """serviceoperator/eventsStatus"""))
   }
}
        

// @LINE:28
case controllers_ServiceOperatorController_getEventByID14(params) => {
   call { 
        invokeHandler(controllers.ServiceOperatorController.getEventByID(), HandlerDef(this, "controllers.ServiceOperatorController", "getEventByID", Nil,"GET", """""", Routes.prefix + """serviceoperator/eventFromID"""))
   }
}
        

// @LINE:32
case controllers_AgencyController_login15(params) => {
   call { 
        invokeHandler(controllers.AgencyController.login(), HandlerDef(this, "controllers.AgencyController", "login", Nil,"POST", """Agency""", Routes.prefix + """agency/login"""))
   }
}
        

// @LINE:33
case controllers_AgencyController_getSentEvents16(params) => {
   call { 
        invokeHandler(controllers.AgencyController.getSentEvents(), HandlerDef(this, "controllers.AgencyController", "getSentEvents", Nil,"POST", """""", Routes.prefix + """agency/sentEvents"""))
   }
}
        

// @LINE:34
case controllers_AgencyController_getReadEvents17(params) => {
   call { 
        invokeHandler(controllers.AgencyController.getReadEvents(), HandlerDef(this, "controllers.AgencyController", "getReadEvents", Nil,"POST", """""", Routes.prefix + """agency/readEvents"""))
   }
}
        

// @LINE:35
case controllers_AgencyController_getSolvedEvents18(params) => {
   call { 
        invokeHandler(controllers.AgencyController.getSolvedEvents(), HandlerDef(this, "controllers.AgencyController", "getSolvedEvents", Nil,"POST", """""", Routes.prefix + """agency/solvedEvents"""))
   }
}
        

// @LINE:36
case controllers_AgencyController_readEvent19(params) => {
   call { 
        invokeHandler(controllers.AgencyController.readEvent(), HandlerDef(this, "controllers.AgencyController", "readEvent", Nil,"POST", """""", Routes.prefix + """agency/readEvent"""))
   }
}
        

// @LINE:37
case controllers_AgencyController_solveEvent20(params) => {
   call { 
        invokeHandler(controllers.AgencyController.solveEvent(), HandlerDef(this, "controllers.AgencyController", "solveEvent", Nil,"POST", """""", Routes.prefix + """agency/solveEvent"""))
   }
}
        

// @LINE:40
case controllers_Assets_at21(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     