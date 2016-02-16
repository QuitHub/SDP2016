/**
  * 13/02/2016.
  *
  * @author lukematthews
  */
trait Language {

  def nextGuessStr: String

  def wellDoneStr: String

  def failStr: String

  def quitStr: String

  def introString: String

}

object EnglishLanguage extends Language {

  val gs = StandardGameSettings()

  override def nextGuessStr: String = {
    """What is your next guess?
Type in the characters for your guess and press enter.
Enter guess: """
  }

  override def wellDoneStr: String = {
    "You solved the puzzle! Good Job!\n"
  }

  override def quitStr: String = {
    "Enter Y for another game or anything else to quit: "
  }

  override def failStr: String = {
    "You did not solve the puzzle too bad.\n"
  }

  override def introString: String = {
    s"""Welcome to Mastermind.

This is a text version of the classic board game Mastermind.
The computer will think of a secret code.
The code consists of ${gs.codeLength} colored pegs.
The pegs may be one of ${gs.getColourSet.size} colors: $listColours
A color may appear more than once in the code.

You try to guess what colored pegs are in the code and what order they are in.
After making a guess the result will be displayed.
A result consists of a ${gs.perfectMatchStr} peg for each peg you have exactly correct (color and position) in your guess.
For each peg in the guess that is the correct color, but is out of position, you get a ${gs.partialMatchStr} peg.

Only the first letter of the color is displayed. $getExamples and so forth.
When entering guesses you only need to enter the first character of the color.

You have ${gs.numberOfTurns} attempts to guess the answer or you lose the game.

Generating secret code ....

"""
  }

  def listColours: String = {
    val sb = StringBuilder.newBuilder
    gs.getColourSet.
      takeWhile(col => col != gs.getColourSet.last).foreach(c => sb append s"${c.name}, ")
      sb append  s"or ${gs.getColourSet.last.name}."
     sb.toString()
  }

  def getExamples: String = {
    val firstEl = gs.getColoursMap.head
    val secondEl = gs.getColoursMap.tail.head
    s"${firstEl._1} for ${firstEl._2.name}, ${secondEl._1} for ${secondEl._2.name},"
  }
}
