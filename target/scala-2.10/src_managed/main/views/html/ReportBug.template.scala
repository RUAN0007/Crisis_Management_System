
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object ReportBug extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.1*/("""<h1>Bug Report for Crisis Management System</h1>
<form method="post" action="recordBug" id="bugReport" enctype="multipart/form-data">
  Subject: <input type="text" name="subject" /><br/>
  Screen Capture:<input type="file" name="screenCapture"/><br/>
  <textarea rows="4" cols="50" name="description" 	form="bugReport">
Enter detailed bug Descrption here...
  </textarea><br/>
  <input type="submit">
</form>
"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Sep 26 21:50:15 CST 2014
                    SOURCE: /Users/ruanpingcheng/Desktop/CMS/app/views/ReportBug.scala.html
                    HASH: e91e41b364deafe0a1eb821bcb6412db42a9f99c
                    MATRIX: 859->0
                    LINES: 29->1
                    -- GENERATED --
                */
            