/**
  * 13/02/2016.
  *
  * @author lukematthews
  */
trait Language {
  def getNextGuessString: String
}

object EnglishLanguage extends Language {
  override def getNextGuessString: String = {
    "What is your next guess?\n"+
    "Type in the characters for your guess and press enter.\n"+
    "Enter guess: "
  }

}
