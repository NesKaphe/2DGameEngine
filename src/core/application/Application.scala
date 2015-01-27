package core.application

import core.utils.Clock

class Application {

  private val clock = new Thread(new Clock (1, this))
  
  clock start
  
  def clockTick() = {println ("Tick")}
  
}

object test {
  def main(args : Array[String]) {
    val appli = new Application
  }
}
