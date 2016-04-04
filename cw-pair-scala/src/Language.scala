/**
  * 13/02/2016.
  *
  * @author lukematthews
  */
trait Language {

  def introString: String

  def nextGuessStr = {
    """What is your next guess?
Type in the characters for your guess and press enter.
Enter guess: """
  }

  def wellDoneStr = "You solved the puzzle! Good Job!\n"

  def failStr = "You did not solve the puzzle too bad.\n"

  def quitStr = "Enter Y for another game or anything else to quit: "

  def perfectMatchStr = "Black"

  def partialMatchStr = "White"

  def noMatchStr = "No pegs"

  def playAgainStr = "Y"
}

case class EnglishLanguage(gs: GameSettings = StandardGameSettings(),
                           palette: Palette = StandardPalette()) extends Language {

  override def introString: String = {
    s"""Welcome to Mastermind.

This is a text version of the classic board game Mastermind.
The computer will think of a secret code.
The code consists of ${gs.codeLength} colored pegs.
The pegs may be one of ${palette.colourSet.size} colors: $listColours
A color may appear more than once in the code.

You try to guess what colored pegs are in the code and what order they are in.
After making a guess the result will be displayed.
A result consists of a $perfectMatchStr peg for each peg you have exactly correct (color and position) in your guess.
For each peg in the guess that is the correct color, but is out of position, you get a $partialMatchStr peg.

Only the first letter of the color is displayed. $getExamples and so forth.
When entering guesses you only need to enter the first character of the color.

You have ${gs.numberOfTurns} attempts to guess the answer or you lose the game.

Generating secret code ....

"""
  }

  def listColours: String = {
    val sb = StringBuilder.newBuilder
    palette.colourSet.
      takeWhile(col => col != palette.colourSet.last).foreach(c => sb append s"$c, ")
    sb append s"or ${palette.colourSet.last}."
    sb.toString()
  }

  def getExamples: String = {
    val firstEl = palette.getColourSet.head
    val secondEl = palette.getColourSet.tail.head
    s"${firstEl.toString.head} for $firstEl, ${secondEl.toString.head} for $secondEl,"
  }
}
