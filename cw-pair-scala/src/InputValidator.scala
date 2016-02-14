/**
  * 13/02/2016.
  *
  * @author lukematthews
  */
trait InputValidator {
  def validateInput(string: String): Boolean
}

object StandardInputValidator extends InputValidator {
  val conf = StandardGameConfigurer
  override def validateInput(input: String): Boolean = {
    if(input.length != StandardGameConfigurer.getCodeLength){
      return false
    }
    val inputSet = input.toStream.toSet[Char]
    val colourCharSet = conf.getColours.keySet
    inputSet.intersect(colourCharSet).equals(inputSet)
  }
}