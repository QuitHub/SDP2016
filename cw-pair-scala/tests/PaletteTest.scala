import org.scalacheck.Gen
import org.scalatest._
import org.scalatest.prop.PropertyChecks
import org.scalatest.{FlatSpec, Matchers}
import scala.collection.immutable.ListSet


abstract class UnitSpec extends FlatSpec with Matchers with PropertyChecks


class PaletteTest extends UnitSpec {


  val standardPalette = StandardPalette()
  "The formatted line" should "start with 30 characters " in {
    standardPalette.colourNames should equal (standardPalette.colourNames)
  }


}
//  val indexes = Gen.choose(0, 66)
//  val lines = for {alpha <- Gen.alphaStr} yield alpha.take(100)
//  val keywords = for {alpha <- Gen.alphaStr} yield alpha.take(15)

//  "The formatted line" should "start with 30 characters " +
//    "then have a space, then the keyword, and then another 30 " +
//    "characters" in {
//    forAll(lines, indexes, keywords) {
//      (line: String, index: Int, keyword: String) =>
//        whenever(line.length > keyword.length
//          && index >= 0
//          && index < line.length
//          && keyword.length > 0
//          && keyword.length + index < line.length) {
//          val kwicFormatter = KWICLineFormatter(line, index, keyword)
//          val rgx = (s"^.{30} $keyword.{30}" + "$").r
//          s"$kwicFormatter" should fullyMatch regex rgx
//        }
//    }
//  }
//
//
//  val abc123 = KWICLineFormatter("acbdefghij1234567890", 10, "XYZ")
//
//  s"$abc123" should "have 20 blank characters at the start" in {
//    s"$abc123" should startWith(" " * 20)
//  }
//
//  s"$abc123" should "have 17 blank characters at the end" in {
//    s"$abc123" should endWith(" " * 20)
//  }


//class InputRetrieverSpec extends UnitSpec {
//
//  val resultBothEmpty = InputRetriever.buildSetFromInput("", ListSet[String]())
//  s"$resultBothEmpty" should "be an empty set" in {
//    resultBothEmpty shouldBe empty
//  }
//}