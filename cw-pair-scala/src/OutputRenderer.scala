/**
  * 13/02/2016.
  *
  * @author lukematthews
  */
trait OutputRenderer {
  def render(s: String)
}

object StandardOutputRender extends OutputRenderer {
  override def render(s: String): Unit = {
    println(s)
  }


}