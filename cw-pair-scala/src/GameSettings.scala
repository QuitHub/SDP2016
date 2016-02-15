/**
  * 13/02/2016.
  *
  * @author lukematthews
  */
trait GameSettings {
  def codeLength: Int

  def numberOfTurns: Int

  def getColours: scala.collection.mutable.Map[Char, Colour]

  def setColours(colours: Vector[String])

  def perfectMatchStr: String

  def partialMatchStr: String

  def showCode: Boolean
}

case class StandardGameSettings(codeLength: Int,
                                numberOfTurns: Int,
                                showCode: Boolean,
                                perfectMatchStr: String = "black",
                                partialMatchStr: String = "white",
                                colourNames: Vector[String]
                               ) extends GameSettings {

  setColours(colourNames)

  override def setColours(colourNames: Vector[String]) = {
    for(name <- colourNames) {
      val nameCapped = name.capitalize
      Palette.addColour(Colour(nameCapped))
    }
  }

  override def getColours: scala.collection.mutable.Map[Char, Colour] = {
    Palette.colMap
  }
}
