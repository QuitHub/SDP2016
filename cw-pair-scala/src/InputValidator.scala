/**
  * 17/02/2016.
  *
  * @author lukematthews
  */
trait InputValidator {
  def validateGuess(str: String): Boolean
  def validatePlayAgain(str: String): Boolean
}


case class StandardInputValidator(palette: Palette = StandardPalette(),
                                  gameSettings: GameSettings = StandardGameSettings()) extends InputValidator {

  override def validateGuess(input: String): Boolean = {
    if (input.length != gameSettings.codeLength) return false
    val inputSet = input.toSet[Char]
    inputSet.intersect(palette.charsInUse).equals(inputSet)
  }
  override def validatePlayAgain(str: String): Boolean = {
    str == "Y"
  }
}
