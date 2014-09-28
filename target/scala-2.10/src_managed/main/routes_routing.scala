// @SOURCE:/Users/ruanpingcheng/Desktop/CMS/conf/routes
// @HASH:52136414f8a8248c391a127767ab10a57c7eba7a
// @DATE:Sun Sep 28 13:56:40 CST 2014


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
        

// @LINE:11
private[this] lazy val controllers_Application_getAgencies3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("agencies"))))
        

// @LINE:12
private[this] lazy val controllers_Application_getEventTypes4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("eventTypes"))))
        

// @LINE:19
private[this] lazy val controllers_CallOperatorController_login5 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("calloperator/login"))))
        

// @LINE:20
private[this] lazy val controllers_CallOperatorController_report6 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("calloperator/report"))))
        

// @LINE:22
private[this] lazy val controllers_Assets_at7 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        

// @LINE:25
private[this] lazy val controllers_AgencyController_getSentEvents8 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("agency/sentEvents"))))
        

// @LINE:26
private[this] lazy val controllers_AgencyController_getReadEvents9 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("agency/readEvents"))))
        

// @LINE:27
private[this] lazy val controllers_AgencyController_getSolvedEvents10 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("agency/solvedEvents"))))
        

// @LINE:28
private[this] lazy val controllers_AgencyController_readEvent11 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("agency/readEvent"))))
        

// @LINE:29
private[this] lazy val controllers_AgencyController_solveEvent12 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("agency/solveEvent"))))
        
def documentation = List(("""GET""", prefix,"""controllers.Application.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.Application.logout()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """events""","""controllers.Application.getEventsBytypeID()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """agencies""","""controllers.Application.getAgencies()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """eventTypes""","""controllers.Application.getEventTypes()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """calloperator/login""","""controllers.CallOperatorController.login()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """calloperator/report""","""controllers.CallOperatorController.report()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """agency/sentEvents""","""controllers.AgencyController.getSentEvents()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """agency/readEvents""","""controllers.AgencyController.getReadEvents()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """agency/solvedEvents""","""controllers.AgencyController.getSolvedEvents()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """agency/readEvent""","""controllers.AgencyController.readEvent()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """agency/solveEvent""","""controllers.AgencyController.solveEvent()""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
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
        

// @LINE:11
case controllers_Application_getAgencies3(params) => {
   call { 
        invokeHandler(controllers.Application.getAgencies(), HandlerDef(this, "controllers.Application", "getAgencies", Nil,"GET", """""", Routes.prefix + """agencies"""))
   }
}
        

// @LINE:12
case controllers_Application_getEventTypes4(params) => {
   call { 
        invokeHandler(controllers.Application.getEventTypes(), HandlerDef(this, "controllers.Application", "getEventTypes", Nil,"GET", """""", Routes.prefix + """eventTypes"""))
   }
}
        

// @LINE:19
case controllers_CallOperatorController_login5(params) => {
   call { 
        invokeHandler(controllers.CallOperatorController.login(), HandlerDef(this, "controllers.CallOperatorController", "login", Nil,"POST", """CallOperator""", Routes.prefix + """calloperator/login"""))
   }
}
        

// @LINE:20
case controllers_CallOperatorController_report6(params) => {
   call { 
        invokeHandler(controllers.CallOperatorController.report(), HandlerDef(this, "controllers.CallOperatorController", "report", Nil,"POST", """""", Routes.prefix + """calloperator/report"""))
   }
}
        

// @LINE:22
case controllers_Assets_at7(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        

// @LINE:25
case controllers_AgencyController_getSentEvents8(params) => {
   call { 
        invokeHandler(controllers.AgencyController.getSentEvents(), HandlerDef(this, "controllers.AgencyController", "getSentEvents", Nil,"POST", """Agency""", Routes.prefix + """agency/sentEvents"""))
   }
}
        

// @LINE:26
case controllers_AgencyController_getReadEvents9(params) => {
   call { 
        invokeHandler(controllers.AgencyController.getReadEvents(), HandlerDef(this, "controllers.AgencyController", "getReadEvents", Nil,"POST", """""", Routes.prefix + """agency/readEvents"""))
   }
}
        

// @LINE:27
case controllers_AgencyController_getSolvedEvents10(params) => {
   call { 
        invokeHandler(controllers.AgencyController.getSolvedEvents(), HandlerDef(this, "controllers.AgencyController", "getSolvedEvents", Nil,"POST", """""", Routes.prefix + """agency/solvedEvents"""))
   }
}
        

// @LINE:28
case controllers_AgencyController_readEvent11(params) => {
   call { 
        invokeHandler(controllers.AgencyController.readEvent(), HandlerDef(this, "controllers.AgencyController", "readEvent", Nil,"POST", """""", Routes.prefix + """agency/readEvent"""))
   }
}
        

// @LINE:29
case controllers_AgencyController_solveEvent12(params) => {
   call { 
        invokeHandler(controllers.AgencyController.solveEvent(), HandlerDef(this, "controllers.AgencyController", "solveEvent", Nil,"POST", """""", Routes.prefix + """agency/solveEvent"""))
   }
}
        
}

}
     