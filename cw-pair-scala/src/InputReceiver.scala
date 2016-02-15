import scala.io.StdIn

/**
  * 13/02/2016.
  *
  * @author lukematthews
  */
trait InputReceiver {
  def getInput(): String

}

object StandardInputReceiver extends InputReceiver {

  override def getInput = StdIn.readLine.toUpperCase


}
