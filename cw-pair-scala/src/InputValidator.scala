/**
  * 17/02/2016.
  *
  * @author lukematthews
  */
trait InputValidator {
  def validateGuess(str: String): Boolean
}


case class StandardInputValidator(palette: Palette = StandardPalette(),
                                  gameSettings: GameSettings) extends InputValidator {

  override def validateGuess(input: String): Boolean = {
    if (input.length != gameSettings.codeLength) return false
    val inputSet = input.toSet[Char]
    inputSet.intersect(palette.colourCharSet).equals(inputSet)
  }

}
