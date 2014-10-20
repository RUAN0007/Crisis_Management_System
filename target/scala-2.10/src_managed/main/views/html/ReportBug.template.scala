
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

Seq[Any](format.raw/*1.1*/("""<form method="post" action="recordBug" id="bugReport" enctype="multipart/form-data" style="text-align:center">
	<fieldset>
	<legend><h2>Report Bug:</h2></legend>
  Subject: <input type="text" name="subject" /><br/><br/>
  Screen Capture:<input type="file" name="screenCapture"/><br/><br/>
  <textarea rows="4" cols="50" name="description" 	form="bugReport">
Enter detailed bug Descrption here...
  </textarea><br/><br/>
  <input type="submit" value="Submit"/>
<.fieldset>
</form>
"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Oct 20 14:39:10 CST 2014
                    SOURCE: /Users/ruanpingcheng/Desktop/CMS/app/views/ReportBug.scala.html
                    HASH: 263d9f59adf53084d0783c169d493616a53e29e3
                    MATRIX: 859->0
                    LINES: 29->1
                    -- GENERATED --
                */
            