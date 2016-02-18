import StringUtils._


/**
  * 13/02/2016.
  *
  * @author lukematthews
  */

case class Board(val numberOfGuessesLeft: Int,
                 val showCode: Boolean,
                 val codeLength: Int,
                 val palette: Palette,
                 val results: Vector[String] = Vector[String]()) {

  val secretCode = StringUtils.randomStringFromCharSet(codeLength, palette.colourCharSet)

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

  def foo = (x: Int) => x * x
}
