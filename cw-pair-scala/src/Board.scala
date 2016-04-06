import StringUtils._


/**
  * 13/02/2016.
  *
  * @author lukematthews
  */

/**
  * Models the board and provides a toString method
  * @param showCode whether the toString method should reveal the code
  * @param secretCode the code the player needs to guess
  * @param results the previous guesses and the associated results
  */
case class Board(val showCode: Boolean,
                 val gameSettings: GameSettings,
                 val secretCode: String,
                 val results: Results) {

  /**
    * a string representation of the board
    * @return a string representation of the board
    */
  override def toString: String = {
    val sb = StringBuilder.newBuilder
    sb.append("\n" + visibleString(showCode) + " Secret Code ")
    if (results.vec.nonEmpty) {
      sb.append("\n")
    }
    sb.append(results.vec.mkString("", "\n", "") + emptyHoles)
    sb.toString()
  }

  private def rowToString = "." * gameSettings.codeLength

  private def emptyHoles = "\n" + (rowToString + "\n") * gameSettings.numberOfTurns + "\n"

  private def visibleString(visible : Boolean): String ={
    if(visible)
      secretCode
     else
      rowToString
  }
}
