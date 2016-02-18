/**
  * 13/02/2016.
  *
  * @author lukematthews
  */


case class Board(val numberOfGuessesLeft: Int,
                 val showCode: Boolean,
                 val secretCode: String,
                 val results: Vector[String] = Vector[String]()) {

  val codeLength = secretCode.length
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

  def visibleString(visible : Boolean): String ={
    if(visible)
      secretCode
     else
      rowToString
  }

}
