import org.scalatest._
import org.scalatest.selenium.Chrome
import org.scalatest.time.{Seconds, Span}

class PluginTestSpec extends FlatSpec with Matchers with Chrome {
  val base = "http://localhost:8080"
  val targetPlugin = System.getProperty("targetPlugin")
  val targetVersion = System.getProperty("targetVersion")
  "plugins page" should "contains this plugin" in {
    go to base + "/signin?redirect=%2Fadmin%2Fplugins"
    textField("userName").value = "root"
    pwdField("password").value = "root"
    submit()
    implicitlyWait(Span(10, Seconds))
    val ele = find(XPathQuery(s"""//a[@href="#$targetPlugin"]"""))
    ele should not be None
    ele.get.text should be (s"$targetPlugin:$targetVersion")
  }
}
