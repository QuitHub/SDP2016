import sun.security.util.Length

import scala.util.Random

/**
  * 11/02/2016.
  *
  * @author lukematthews
  */

abstract class Code() {
  var vector: Vector[Char] = Vector()

  def stringToVector(s: String): Unit = {
    s.foreach(c => vector = vector :+ c)
  }

}
