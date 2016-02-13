import scala.io.StdIn

/**
  * 13/02/2016.
  *
  * @author lukematthews
  */
trait InputReceiver {
  def getInput(): String
  def validateInput()
}

object StandardInputReceiver extends InputReceiver {

  override def getInput(): String = {
    print(EnglishLanguage.getNextGuessString)
    StdIn.readLine()
  }

  override def validateInput(): Unit = ???
}
