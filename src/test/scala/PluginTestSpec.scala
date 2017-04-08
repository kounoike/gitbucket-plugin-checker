import org.scalatest._
import org.scalatest.selenium.Firefox
import org.scalatest.time.{Seconds, Span}

class PluginTestSpec extends FlatSpec with Matchers with Firefox {
  val base = "http://localhost:8080"
  "plugins page" should "contains this plugin" in {
    go to base + "/signin?redirect=%2Fadmin%2Fplugins"
    textField("userName").value = "root"
    pwdField("password").value = "root"
    submit()
    implicitlyWait(Span(10, Seconds))
    val ele = find(XPathQuery("""//a[@href="#ipynb"]"""))
    ele should not be None
    ele.get.text should be ("ipynb:0.1.1")
  }
}
