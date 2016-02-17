/**
  * 17/02/2016.
  *
  * @author lukematthews
  */
trait InputValidator {
  def validateInput(str: String): Boolean
}


case class StandardInputValidator(gs: GameSettings = StandardGameSettings()) extends InputValidator {

  override def validateInput(input: String): Boolean = {
    if (input.length != gs.codeLength) return false
    val inputSet = input.toSet[Char]
    val colourCharSet = gs.getColoursMap.keySet
    inputSet.intersect(colourCharSet).equals(inputSet)
  }
}
