// @SOURCE:/Users/ruanpingcheng/Desktop/CMS/conf/routes
// @HASH:5b8002279d778d6bda35edfcac805608dcdbadca
// @DATE:Fri Oct 31 13:03:59 CST 2014


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
private[this] lazy val controllers_AdminController_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:7
private[this] lazy val controllers_Application_logout1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
        

// @LINE:8
private[this] lazy val controllers_Application_getEventsBytypeID2 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("events"))))
        

// @LINE:9
private[this] lazy val controllers_Application_getAgencies3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("getAgencies"))))
        

// @LINE:10
private[this] lazy val controllers_Application_getEventTypes4 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("getEventTypes"))))
        

// @LINE:12
private[this] lazy val controllers_Application_reportBug5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("bug"))))
        

// @LINE:13
private[this] lazy val controllers_Application_recordBug6 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("recordBug"))))
        

// @LINE:16
private[this] lazy val controllers_AdminController_main7 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("main"))))
        

// @LINE:18
private[this] lazy val controllers_AdminController_validateAdmin8 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("validateAdmin"))))
        

// @LINE:20
private[this] lazy val controllers_AdminController_manageAgencyEventTypeRelationship9 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("relationship"))))
        

// @LINE:21
private[this] lazy val controllers_AdminController_manageRelationship10 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("manageRelationShip"))))
        

// @LINE:23
private[this] lazy val controllers_AdminController_renderManageUserView11 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("manageUser"))))
        

// @LINE:24
private[this] lazy val controllers_AdminController_addUser12 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("addUser"))))
        

// @LINE:25
private[this] lazy val controllers_AdminController_deleteUser13 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deleteUser"))))
        

// @LINE:27
private[this] lazy val controllers_AdminController_renderManageEventTypesView14 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("manageEventType"))))
        

// @LINE:28
private[this] lazy val controllers_AdminController_addEventType15 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("addEventType"))))
        

// @LINE:29
private[this] lazy val controllers_AdminController_deleteEventType16 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deleteEventType"))))
        

// @LINE:33
private[this] lazy val controllers_CallOperatorController_login17 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("calloperator/login"))))
        

// @LINE:34
private[this] lazy val controllers_CallOperatorController_report18 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("calloperator/report"))))
        

// @LINE:37
private[this] lazy val controllers_ServiceOperatorController_login19 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("serviceoperator/login"))))
        

// @LINE:38
private[this] lazy val controllers_ServiceOperatorController_updateEvent20 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("serviceoperator/updateEvent"))))
        

// @LINE:39
private[this] lazy val controllers_ServiceOperatorController_getUnclassifiedEvents21 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("serviceoperator/unhandledEvents"))))
        

// @LINE:40
private[this] lazy val controllers_ServiceOperatorController_getPriorityOneEvents22 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("serviceoperator/priorityOneEvents"))))
        

// @LINE:41
private[this] lazy val controllers_ServiceOperatorController_smsEvent23 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("serviceoperator/broadcastSMS"))))
        

// @LINE:42
private[this] lazy val controllers_ServiceOperatorController_emailEvent24 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("serviceoperator/sendReport"))))
        

// @LINE:43
private[this] lazy val controllers_ServiceOperatorController_getEventsStatus25 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("serviceoperator/eventsStatus"))))
        

// @LINE:44
private[this] lazy val controllers_ServiceOperatorController_getEventByID26 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("serviceoperator/eventFromID"))))
        

// @LINE:48
private[this] lazy val controllers_AgencyController_login27 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("agency/login"))))
        

// @LINE:49
private[this] lazy val controllers_AgencyController_getSentEvents28 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("agency/sentEvents"))))
        

// @LINE:50
private[this] lazy val controllers_AgencyController_getReadEvents29 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("agency/readEvents"))))
        

// @LINE:51
private[this] lazy val controllers_AgencyController_getSolvedEvents30 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("agency/solvedEvents"))))
        

// @LINE:52
private[this] lazy val controllers_AgencyController_readEvent31 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("agency/readEvent"))))
        

// @LINE:53
private[this] lazy val controllers_AgencyController_solveEvent32 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("agency/solveEvent"))))
        

// @LINE:56
private[this] lazy val controllers_Assets_at33 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
        
def documentation = List(("""GET""", prefix,"""controllers.AdminController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""controllers.Application.logout()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """events""","""controllers.Application.getEventsBytypeID()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """getAgencies""","""controllers.Application.getAgencies()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """getEventTypes""","""controllers.Application.getEventTypes()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """bug""","""controllers.Application.reportBug()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """recordBug""","""controllers.Application.recordBug()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """main""","""controllers.AdminController.main()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """validateAdmin""","""controllers.AdminController.validateAdmin()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """relationship""","""controllers.AdminController.manageAgencyEventTypeRelationship()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """manageRelationShip""","""controllers.AdminController.manageRelationship()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """manageUser""","""controllers.AdminController.renderManageUserView()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """addUser""","""controllers.AdminController.addUser()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deleteUser""","""controllers.AdminController.deleteUser()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """manageEventType""","""controllers.AdminController.renderManageEventTypesView()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """addEventType""","""controllers.AdminController.addEventType()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deleteEventType""","""controllers.AdminController.deleteEventType()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """calloperator/login""","""controllers.CallOperatorController.login()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """calloperator/report""","""controllers.CallOperatorController.report()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """serviceoperator/login""","""controllers.ServiceOperatorController.login()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """serviceoperator/updateEvent""","""controllers.ServiceOperatorController.updateEvent()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """serviceoperator/unhandledEvents""","""controllers.ServiceOperatorController.getUnclassifiedEvents()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """serviceoperator/priorityOneEvents""","""controllers.ServiceOperatorController.getPriorityOneEvents()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """serviceoperator/broadcastSMS""","""controllers.ServiceOperatorController.smsEvent()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """serviceoperator/sendReport""","""controllers.ServiceOperatorController.emailEvent()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """serviceoperator/eventsStatus""","""controllers.ServiceOperatorController.getEventsStatus()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """serviceoperator/eventFromID""","""controllers.ServiceOperatorController.getEventByID()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """agency/login""","""controllers.AgencyController.login()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """agency/sentEvents""","""controllers.AgencyController.getSentEvents()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """agency/readEvents""","""controllers.AgencyController.getReadEvents()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """agency/solvedEvents""","""controllers.AgencyController.getSolvedEvents()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """agency/readEvent""","""controllers.AgencyController.readEvent()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """agency/solveEvent""","""controllers.AgencyController.solveEvent()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_AdminController_index0(params) => {
   call { 
        invokeHandler(controllers.AdminController.index(), HandlerDef(this, "controllers.AdminController", "index", Nil,"GET", """ Home page""", Routes.prefix + """"""))
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
        

// @LINE:12
case controllers_Application_reportBug5(params) => {
   call { 
        invokeHandler(controllers.Application.reportBug(), HandlerDef(this, "controllers.Application", "reportBug", Nil,"GET", """For Bug Report""", Routes.prefix + """bug"""))
   }
}
        

// @LINE:13
case controllers_Application_recordBug6(params) => {
   call { 
        invokeHandler(controllers.Application.recordBug(), HandlerDef(this, "controllers.Application", "recordBug", Nil,"POST", """""", Routes.prefix + """recordBug"""))
   }
}
        

// @LINE:16
case controllers_AdminController_main7(params) => {
   call { 
        invokeHandler(controllers.AdminController.main(), HandlerDef(this, "controllers.AdminController", "main", Nil,"GET", """""", Routes.prefix + """main"""))
   }
}
        

// @LINE:18
case controllers_AdminController_validateAdmin8(params) => {
   call { 
        invokeHandler(controllers.AdminController.validateAdmin(), HandlerDef(this, "controllers.AdminController", "validateAdmin", Nil,"POST", """""", Routes.prefix + """validateAdmin"""))
   }
}
        

// @LINE:20
case controllers_AdminController_manageAgencyEventTypeRelationship9(params) => {
   call { 
        invokeHandler(controllers.AdminController.manageAgencyEventTypeRelationship(), HandlerDef(this, "controllers.AdminController", "manageAgencyEventTypeRelationship", Nil,"GET", """""", Routes.prefix + """relationship"""))
   }
}
        

// @LINE:21
case controllers_AdminController_manageRelationship10(params) => {
   call { 
        invokeHandler(controllers.AdminController.manageRelationship(), HandlerDef(this, "controllers.AdminController", "manageRelationship", Nil,"POST", """""", Routes.prefix + """manageRelationShip"""))
   }
}
        

// @LINE:23
case controllers_AdminController_renderManageUserView11(params) => {
   call { 
        invokeHandler(controllers.AdminController.renderManageUserView(), HandlerDef(this, "controllers.AdminController", "renderManageUserView", Nil,"GET", """""", Routes.prefix + """manageUser"""))
   }
}
        

// @LINE:24
case controllers_AdminController_addUser12(params) => {
   call { 
        invokeHandler(controllers.AdminController.addUser(), HandlerDef(this, "controllers.AdminController", "addUser", Nil,"POST", """""", Routes.prefix + """addUser"""))
   }
}
        

// @LINE:25
case controllers_AdminController_deleteUser13(params) => {
   call { 
        invokeHandler(controllers.AdminController.deleteUser(), HandlerDef(this, "controllers.AdminController", "deleteUser", Nil,"POST", """""", Routes.prefix + """deleteUser"""))
   }
}
        

// @LINE:27
case controllers_AdminController_renderManageEventTypesView14(params) => {
   call { 
        invokeHandler(controllers.AdminController.renderManageEventTypesView(), HandlerDef(this, "controllers.AdminController", "renderManageEventTypesView", Nil,"GET", """""", Routes.prefix + """manageEventType"""))
   }
}
        

// @LINE:28
case controllers_AdminController_addEventType15(params) => {
   call { 
        invokeHandler(controllers.AdminController.addEventType(), HandlerDef(this, "controllers.AdminController", "addEventType", Nil,"POST", """""", Routes.prefix + """addEventType"""))
   }
}
        

// @LINE:29
case controllers_AdminController_deleteEventType16(params) => {
   call { 
        invokeHandler(controllers.AdminController.deleteEventType(), HandlerDef(this, "controllers.AdminController", "deleteEventType", Nil,"POST", """""", Routes.prefix + """deleteEventType"""))
   }
}
        

// @LINE:33
case controllers_CallOperatorController_login17(params) => {
   call { 
        invokeHandler(controllers.CallOperatorController.login(), HandlerDef(this, "controllers.CallOperatorController", "login", Nil,"POST", """CallOperator""", Routes.prefix + """calloperator/login"""))
   }
}
        

// @LINE:34
case controllers_CallOperatorController_report18(params) => {
   call { 
        invokeHandler(controllers.CallOperatorController.report(), HandlerDef(this, "controllers.CallOperatorController", "report", Nil,"POST", """""", Routes.prefix + """calloperator/report"""))
   }
}
        

// @LINE:37
case controllers_ServiceOperatorController_login19(params) => {
   call { 
        invokeHandler(controllers.ServiceOperatorController.login(), HandlerDef(this, "controllers.ServiceOperatorController", "login", Nil,"POST", """ServiceOperator""", Routes.prefix + """serviceoperator/login"""))
   }
}
        

// @LINE:38
case controllers_ServiceOperatorController_updateEvent20(params) => {
   call { 
        invokeHandler(controllers.ServiceOperatorController.updateEvent(), HandlerDef(this, "controllers.ServiceOperatorController", "updateEvent", Nil,"POST", """""", Routes.prefix + """serviceoperator/updateEvent"""))
   }
}
        

// @LINE:39
case controllers_ServiceOperatorController_getUnclassifiedEvents21(params) => {
   call { 
        invokeHandler(controllers.ServiceOperatorController.getUnclassifiedEvents(), HandlerDef(this, "controllers.ServiceOperatorController", "getUnclassifiedEvents", Nil,"GET", """""", Routes.prefix + """serviceoperator/unhandledEvents"""))
   }
}
        

// @LINE:40
case controllers_ServiceOperatorController_getPriorityOneEvents22(params) => {
   call { 
        invokeHandler(controllers.ServiceOperatorController.getPriorityOneEvents(), HandlerDef(this, "controllers.ServiceOperatorController", "getPriorityOneEvents", Nil,"GET", """""", Routes.prefix + """serviceoperator/priorityOneEvents"""))
   }
}
        

// @LINE:41
case controllers_ServiceOperatorController_smsEvent23(params) => {
   call { 
        invokeHandler(controllers.ServiceOperatorController.smsEvent(), HandlerDef(this, "controllers.ServiceOperatorController", "smsEvent", Nil,"POST", """""", Routes.prefix + """serviceoperator/broadcastSMS"""))
   }
}
        

// @LINE:42
case controllers_ServiceOperatorController_emailEvent24(params) => {
   call { 
        invokeHandler(controllers.ServiceOperatorController.emailEvent(), HandlerDef(this, "controllers.ServiceOperatorController", "emailEvent", Nil,"POST", """""", Routes.prefix + """serviceoperator/sendReport"""))
   }
}
        

// @LINE:43
case controllers_ServiceOperatorController_getEventsStatus25(params) => {
   call { 
        invokeHandler(controllers.ServiceOperatorController.getEventsStatus(), HandlerDef(this, "controllers.ServiceOperatorController", "getEventsStatus", Nil,"GET", """""", Routes.prefix + """serviceoperator/eventsStatus"""))
   }
}
        

// @LINE:44
case controllers_ServiceOperatorController_getEventByID26(params) => {
   call { 
        invokeHandler(controllers.ServiceOperatorController.getEventByID(), HandlerDef(this, "controllers.ServiceOperatorController", "getEventByID", Nil,"POST", """""", Routes.prefix + """serviceoperator/eventFromID"""))
   }
}
        

// @LINE:48
case controllers_AgencyController_login27(params) => {
   call { 
        invokeHandler(controllers.AgencyController.login(), HandlerDef(this, "controllers.AgencyController", "login", Nil,"POST", """Agency""", Routes.prefix + """agency/login"""))
   }
}
        

// @LINE:49
case controllers_AgencyController_getSentEvents28(params) => {
   call { 
        invokeHandler(controllers.AgencyController.getSentEvents(), HandlerDef(this, "controllers.AgencyController", "getSentEvents", Nil,"POST", """""", Routes.prefix + """agency/sentEvents"""))
   }
}
        

// @LINE:50
case controllers_AgencyController_getReadEvents29(params) => {
   call { 
        invokeHandler(controllers.AgencyController.getReadEvents(), HandlerDef(this, "controllers.AgencyController", "getReadEvents", Nil,"POST", """""", Routes.prefix + """agency/readEvents"""))
   }
}
        

// @LINE:51
case controllers_AgencyController_getSolvedEvents30(params) => {
   call { 
        invokeHandler(controllers.AgencyController.getSolvedEvents(), HandlerDef(this, "controllers.AgencyController", "getSolvedEvents", Nil,"POST", """""", Routes.prefix + """agency/solvedEvents"""))
   }
}
        

// @LINE:52
case controllers_AgencyController_readEvent31(params) => {
   call { 
        invokeHandler(controllers.AgencyController.readEvent(), HandlerDef(this, "controllers.AgencyController", "readEvent", Nil,"POST", """""", Routes.prefix + """agency/readEvent"""))
   }
}
        

// @LINE:53
case controllers_AgencyController_solveEvent32(params) => {
   call { 
        invokeHandler(controllers.AgencyController.solveEvent(), HandlerDef(this, "controllers.AgencyController", "solveEvent", Nil,"POST", """""", Routes.prefix + """agency/solveEvent"""))
   }
}
        

// @LINE:56
case controllers_Assets_at33(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        invokeHandler(controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
   }
}
        
}

}
     