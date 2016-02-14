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

    Colours.addColour(Colour("Blue"))
    Colours.addColour(Colour("Green"))
    Colours.addColour(Colour("Orange"))
    Colours.addColour(Colour("Purple"))
    Colours.addColour(Colour("Red"))
    Colours.addColour(Colour("Yellow"))
    Colours.getColMap()
  }
}
