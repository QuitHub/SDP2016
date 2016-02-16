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
    val sb = StringBuilder.newBuilder
    sb.append("\n" + secretCodeToString)
    if (results.nonEmpty) {
      sb.append("\n")
    }
    sb.append(results.mkString("", "\n", "") + emptyHoles)
    sb.toString()

  }

  def rowToString = {
    "." * gs.codeLength
  }

  def emptyHoles = {
    "\n" + (rowToString + "\n") * numberOfGuessesLeft + "\n"
  }

  def secretCodeToString = {
    val sc = " Secret Code "
    if (gs.showCode) secretCode.toString + sc
    else rowToString + sc
  }

  def guessesLeftToString = s"You have $numberOfGuessesLeft guesses left."

  def updateBoard(guess: Guess): Board = {
    val result = guess.calculateResult(secretCode)
    Board(guessesLeft(result), gs, secretCode, this.results :+ result)
  }

  def guessesLeft(result: Result): Int = {
    if (result.fullMatches == gs.codeLength) 0 else numberOfGuessesLeft - 1
  }

  def theCodeIsCracked = results.nonEmpty && results.last.fullMatches == gs.codeLength

  def thereAreGuessesLeft = numberOfGuessesLeft > 0

}
