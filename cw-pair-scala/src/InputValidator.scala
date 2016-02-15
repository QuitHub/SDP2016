/**
  * 13/02/2016.
  *
  * @author lukematthews
  */
trait InputValidator {
  def validateInput(string: String): Boolean
  def playAgain(str: String): Boolean
}

object StandardInputValidator extends InputValidator {
  val conf = Factory.getGameSettings(Factory.bo)

  override def validateInput(input: String): Boolean = {
    if (input.length != conf.codeLength) {
      return false
    }
    val inputSet = input.toStream.toSet[Char]
    val colourCharSet = conf.getColours.keySet
    inputSet.intersect(colourCharSet).equals(inputSet)
  }

  override def playAgain(str: String): Boolean = {
    str == "Y"
  }
}