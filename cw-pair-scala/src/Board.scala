import StringUtils._


/**
  * 13/02/2016.
  *
  * @author lukematthews
  */

/**
  * Models the board and provides a toString method
  * @param numberOfGuessesLeft how many guesses empty rows the board has
  * @param showCode whether the toString method should reveal the code
  * @param codeLength how many pegs make up one code
  * @param secretCode the code the player needs to guess
  * @param results the previous guesses and the associated results
  */
case class Board(val numberOfGuessesLeft: Int,
                 val showCode: Boolean,
                 val codeLength: Int,
                 val secretCode: String,
                 val results: Vector[String] = Vector[String]()) {

  /**
    * a string representation of the board
    * @return a string representation of the board
    */
  override def toString: String = {
    val sb = StringBuilder.newBuilder
    sb.append("\n" + visibleString(showCode) + " Secret Code ")
    if (results.nonEmpty) {
      sb.append("\n")
    }
    sb.append(results.mkString("", "\n", "") + emptyHoles)
    sb.toString()
  }

  private def rowToString = "." * codeLength

  private def emptyHoles = "\n" + (rowToString + "\n") * numberOfGuessesLeft + "\n"

  private def visibleString(visible : Boolean): String ={
    if(visible)
      secretCode
     else
      rowToString
  }
}
