/**
  * 13/02/2016.
  *
  * @author lukematthews
  */

case class Board(val numberOfGuessesLeft: Int = 12,
                 val codeLength: Int = 4,
                 val secretCode: RandomCode,
                 val results: Vector[Result] = Vector[Result]()) {

  override def toString: String = {
    val sb = StringBuilder.newBuilder
    sb.append("\n" + secretCode.toString)
    if (results.nonEmpty) {
      sb.append("\n")
    }
    sb.append(results.mkString("", "\n", "") + emptyHoles)
    sb.toString()
  }

  private def rowToString = "." * codeLength

  private def emptyHoles = "\n" + (rowToString + "\n") * numberOfGuessesLeft + "\n"

  def guessesLeftToString = s"You have $numberOfGuessesLeft guesses left."

  def updateBoard(guess: Guess): Board = {
    val result = guess.calculateResult(secretCode)
    Board(guessesLeft(result), codeLength, secretCode, this.results :+ result)
  }

  private def guessesLeft(result: Result): Int = {
    if (result.fullMatches == codeLength) 0
    else numberOfGuessesLeft - 1
  }

  def theCodeIsCracked = results.nonEmpty && results.last.fullMatches == codeLength

  def thereAreGuessesLeft = numberOfGuessesLeft > 0

}
