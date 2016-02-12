/**
  * 11/02/2016.
  *
  * @author lukematthews
  */
class MastermindGame() extends GameAbstractImpl(){

  /**
    * Run a one or more game sof mastermind, until the player
    * quits.
    */
  override def runGames: Unit = {
    var code = new Guess("BBCB")
    println(code.vector)
    var randomCode = new RandomCode(10)
    println("randomCode: "+ randomCode.vector)

    super.display()



  }

}
