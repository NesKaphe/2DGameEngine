package core.application

import core.utils.Clock
import core.application.ui.GameUI
import core.application.configuration.AppConfig
import game.states.GameState

/*
 * This class is a little messy for now
 * TODO: cleaner code
 */
class Application(config: AppConfig) {

  val title = "TODO"
  val gameWidth : Int = 640 //TODO: get from the configuration
  val gameHeight : Int = 480 //TODO: get from the configuration
  
  private val clock = new Thread(new Clock (1, this))
  
  private val ui = new GameUI(this)
  
  ui openGraphics()
  
  ui render(new GameState)
  
  clock start
  
  def clockTick() = {println ("Tick")}
  
  def keyPressed(keyCode : Int) = {println("Pressed : "+keyCode)}
  
  def keyReleased(keyCode : Int) = {println("Released : "+keyCode)}
  
}

object test {
  def main(args : Array[String]) {
    val appli = new Application(null)
  }
}
