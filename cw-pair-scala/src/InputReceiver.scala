import scala.io.StdIn

/**
  * 13/02/2016.
  *
  * @author lukematthews
  */
trait InputReceiver {
  def getInputAsUpper: String

}

case class StandardInputReceiver() extends InputReceiver {

  override def getInputAsUpper = StdIn.readLine.toUpperCase

}
