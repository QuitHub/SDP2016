/**
  * 13/02/2016.
  *
  * @author lukematthews
  */
trait Language {
  def getNextGuessString: String
  def getWellDoneString: String
  def getFailString: String
  def getQuitString: String
}

object EnglishLanguage extends Language {
  override def getNextGuessString: String = {
    "What is your next guess?\n"+
    "Type in the characters for your guess and press enter.\n"+
    "Enter guess: "
  }

  override def getWellDoneString: String = {
    "You solved the puzzle! Good Job!\n"
  }

  override def getQuitString: String = {
    "Enter Y for another game or anything else to quit: "
  }

  override def getFailString: String = {
    "You did not solve the puzzle too bad."
  }
}
