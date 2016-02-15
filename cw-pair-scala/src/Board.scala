/**
  * 13/02/2016.
  *
  * @author lukematthews
  */

case class Board(numberOfGuessesLeft: Int,
                 gs: GameSettings,
                 secretCode: Code,
                 results: Vector[Result]) {

  override def toString: String = {

    secretCodeToString +
    results.mkString("","\n","\n") +
    emptyHoles

  }

  def rowToString = { "." * gs.codeLength }

  def emptyHoles = {(rowToString + "\n") * numberOfGuessesLeft + "\n"}

  def secretCodeToString = {
    val sc = " Secret Code "
    if (gs.showCode) secretCode.toString + sc
     else rowToString + sc
  }

  def guessesLeftToString = s"You have $numberOfGuessesLeft guesses left."

  def updateBoard(guess: Guess): Board = {
    val result = guess.calculateResult(secretCode)
    var guessesLeft = this.numberOfGuessesLeft - 1
    if (result.fullMatches == gs.codeLength) {
      guessesLeft = 0
    }
    Board(guessesLeft, gs, secretCode, this.results :+ result)
  }

  def theCodeIsCracked = results.nonEmpty && results.last.fullMatches == gs.codeLength

  def thereAreGuessesLeft = numberOfGuessesLeft > 0

}
