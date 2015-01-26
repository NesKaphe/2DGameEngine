package core.utils

import core.application._
import scala.swing._
import swing._

//TODO:  Faire en sorte que le travail du clock soit de faire une 
//fonction donnée plutot que ça ?
class Clock(private var _targetFPS : Int, private val app: Application) 
  extends Runnable {

  private var delay = 1000 / _targetFPS
   
  def targetFPS = _targetFPS
  
  def targetFPS_=(newTargetFPS: Int) = {
    if(newTargetFPS < 0)
      _targetFPS = 1
    else
      _targetFPS = newTargetFPS
      
    delay = 1000 / _targetFPS
  }
      
  def run () : Unit = {
    while(true){
      app clockTick
      
      try {
        Thread.sleep(delay)
      }
      catch {
        case e : InterruptedException => e printStackTrace()
      }
    }
  }
  
}