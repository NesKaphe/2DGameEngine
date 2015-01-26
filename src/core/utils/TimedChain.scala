package core.utils

/*
 * A TimedChain defines the logic of a succession of elements that needs to be 
 * accessed in a given order during a certain clock rate.
 */
trait TimedChain[A] extends Chain[A] {

  private var _clockRate : Int = 1
  private var _counted : Int = 0
  private var _animationSpeed : Double = 0
  
  def animationSpeed = _animationSpeed
  
  def animationSpeed_=(newSpeed: Double) : Unit = {
    if(newSpeed > 0) {
      _animationSpeed = newSpeed
    }
  }
  
  private def framesBetweenElements() = (animationSpeed / len) * _clockRate
  
  def clockRate_=(newClockRate: Int) : Unit = {
    if(newClockRate > 0)
      _clockRate = newClockRate
  }
  
  override def reset() : Unit = super.reset ; _counted = 0
  
  override def update() : Unit = {
    if(running) {
      val framesBetween = framesBetweenElements
      
      framesBetween < 1 match {
        case true => {
          val elemsInOneTick = (len * framesBetween).asInstanceOf[Int]
          currentIndex = currentIndex + elemsInOneTick
          if(repeatable)
            currentIndex = currentIndex % len
          else if(currentIndex > len - 1)
            currentIndex = len - 1
        }
        case false => {
          _counted += 1
          if(_counted > framesBetween) {
            if(currentIndex < len - 1)
              currentIndex += 1
            else if(repeatable)
              reset
            else
              stop
          }
        }
      }
    }
  }
  
}