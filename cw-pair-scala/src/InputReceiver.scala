import scala.io.StdIn

/**
  * 13/02/2016.
  *
  * @author lukematthews
  */
trait InputReceiver {
  def getInputAsUpper(): String

}

object StandardInputReceiver extends InputReceiver {

  override def getInputAsUpper = StdIn.readLine.toUpperCase

}
