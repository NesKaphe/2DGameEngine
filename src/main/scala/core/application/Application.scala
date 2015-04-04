package core.application

import scala.language.postfixOps

import core.utils.Clock
import core.application.ui.GameUI
import core.application.configuration.AppConfig
import game.states.GameState
import core.application.configuration.AppConfigMaker
import java.io.FileNotFoundException

/*
 * This class is a little messy for now
 * TODO: cleaner code
 */
sealed class Application(val config: AppConfig) {
  
  private val clock = new Thread(new Clock (config.targetFPS, this))
  
  private val ui = new GameUI(this)
  
  ui openGraphics()
  
  ui render(new GameState)
  
  clock start
  
  def clockTick() = {println ("Tick")}
  
  def keyPressed(keyCode : Int) = {println("Pressed : "+keyCode)}
  
  def keyReleased(keyCode : Int) = {println("Released : "+keyCode)}
  
}


object Application {
  
  /*
   * We can get an Application object by giving the path to a file
   * containing the configuration 
   */
  def apply(pathConfigFile : String) = {
    val config = AppConfigMaker loadFromFilePath(pathConfigFile)
    config match {
      case Some(conf) => new Application(conf)
      case _          => throw new FileNotFoundException
    }
  }
  
  
  def main(args: Array[String]) {
    val app = Application(getClass.getResource("/config/config.conf").getPath)
  }
}