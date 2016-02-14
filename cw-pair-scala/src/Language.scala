/**
  * 13/02/2016.
  *
  * @author lukematthews
  */
trait Language {
  def getNextGuessStr: String

  def getWellDoneStr: String

  def getFailStr: String

  def getQuitStr: String
}

object EnglishLanguage extends Language {
  override def getNextGuessStr: String = {
    "What is your next guess?\n" +
      "Type in the characters for your guess and press enter.\n" +
      "Enter guess: "
  }

  override def getWellDoneStr: String = {
    "You solved the puzzle! Good Job!\n"
  }

  override def getQuitStr: String = {
    "Enter Y for another game or anything else to quit: "
  }

  override def getFailStr: String = {
    "You did not solve the puzzle too bad."
  }
}
