package core.utils

/*
 * A Chain defines the logic of a succession of elements that needs to be 
 * accessed in a given order.
 */
trait Chain[A] {

  private var _running : Boolean = false
  private var _currentIndex : Int = 0
    
  val repeatable : Boolean
  
  def currentIndex = _currentIndex
  
  def currentIndex_=(newIndex: Int) =  {
    if(newIndex >= 0 && newIndex < len)
      _currentIndex = newIndex
  }
  
  def running = _running
  
  def add(element: A) : Unit
  
  def addSet(elemSet : Seq[A]) : Unit
  
  def current() : Option[A]
  
  def start() : Unit = _running = true
  
  def pause() : Unit = _running = false
  
  def stop() : Unit = pause ; reset
  
  def update() : Unit = {
    if(running) {
      if(_currentIndex < len - 1)
        _currentIndex += 1
      else if(repeatable)
        reset
      else
        stop
    }
  }
  
  def reset() : Unit = _currentIndex = 0
  
  def copy() : Chain[A]
  
  def toSeq() : Seq[A]
  
  def len() : Int
  
  //syntaxic sugar
  
  def :+(elem: A) = add(elem)
  def ++(elemSet: Seq[A]) = addSet(elemSet)
}