/**
  * 13/02/2016.
  *
  * @author lukematthews
  */
trait GameConfigurer {
  def getCodeLength: Int

  def getNumberOfTurns: Int

  def getColours: scala.collection.mutable.Map[Char, Colour]
}

object StandardGameConfigurer extends GameConfigurer {
  override def getCodeLength: Int = 4

  override def getNumberOfTurns: Int = 12

  override def getColours: scala.collection.mutable.Map[Char, Colour] = {
    Palette.addColour(Colour("Blue"))
    Palette.addColour(Colour("Green"))
    Palette.addColour(Colour("Orange"))
    Palette.addColour(Colour("Purple"))
    Palette.addColour(Colour("Red"))
    Palette.addColour(Colour("Yellow"))
    Palette.getColMap()
  }
}
