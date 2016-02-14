/**
  * 13/02/2016.
  *
  * @author lukematthews
  */
case class Colour(colour: String) {

  def getFirstChar(): Char = {
    colour.charAt(0)
  }
}

//How should we handle this error????????????
object Colours {

  private var colMap = scala.collection.mutable.Map[Char, Colour]()

  def addColour(col: Colour): Boolean = {
    if(colMap.keySet.contains(col.getFirstChar())){
      false
    } else {
      colMap.+=(col.getFirstChar() -> col)
      true
    }
  }
  def getColMap(): scala.collection.mutable.Map[Char, Colour] = {
    colMap
  }
}