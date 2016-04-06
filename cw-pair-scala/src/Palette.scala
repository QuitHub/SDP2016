/**
  * 13/02/2016.
  *
  * @author lukematthews
  */

trait Palette {

  var colourSet = scala.collection.immutable.Set[Colour]()

  var validChars = ('A' to 'Z').toSet

  def getColourSet: scala.collection.immutable.Set[Colour] = colourSet

  def colourCharSet: Set[Char] = colourSet.flatMap(_.toString().headOption)

  def addColour(colour: Colour)  = {
    if (!colourCharSet.contains(colour.toString.head toUpper) && validChars.contains(colour.toString.head toUpper)) {
      colourSet = colourSet + colour
    }
  }


}

case class StandardPalette() extends Palette {


  val colourNames: Vector[Colour] =
  Vector(Red, Blue, Orange, Green, Purple, Yellow, Brown, ºaroon)

  colourNames.foreach(name => {
    addColour(name: Colour)
  })

}

sealed trait Colour

case object Red extends Colour
case object Blue extends Colour
case object Orange extends Colour
case object Green extends Colour
case object Yellow extends Colour
case object Purple extends Colour
case object Brown extends Colour
case object ºaroon extends Colour


