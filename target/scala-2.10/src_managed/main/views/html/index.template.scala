
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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(message: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.19*/("""

<h1>"""),_display_(Seq[Any](/*3.6*/message)),format.raw/*3.13*/("""</h1>
<form style="text-align:center" action="validateAdmin" method="post">
	<fieldset>
	<legend><h2>Log in As System Administrator:</h2></legend>
<p>UserID: </p>
<input type="textfield" name="userID"/>
<p>Password: </p>
<input type="password" name="password"/>
</br>
</br>

<input type="submit" value="Log in">
</fieldset>

</form>"""))}
    }
    
    def render(message:String): play.api.templates.HtmlFormat.Appendable = apply(message)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (message) => apply(message)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Mon Oct 20 14:39:10 CST 2014
                    SOURCE: /Users/ruanpingcheng/Desktop/CMS/app/views/index.scala.html
                    HASH: f6423ef22bf2c255d9c4b155335ca762c8545400
                    MATRIX: 774->1|885->18|926->25|954->32
                    LINES: 26->1|29->1|31->3|31->3
                    -- GENERATED --
                */
            