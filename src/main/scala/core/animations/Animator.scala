package core.animations

import core.utils.Chain

object Animator {

  //All the animations registered for update on regular clock rate
  private var _animations = Seq[Chain[_]]()
  
  /**
   * clockTick has for effect to update all the registered chains
   */
  def clockTick() : Unit = {
    _animations.map(_ update)
  }
  
  /**
   * in order to receive an update on regular clock rate, chains must
   * register to the animator
   */
  def register(anim : Chain[_]) : Unit = {
    if( !(_animations contains anim) )
      _animations = _animations :+ anim
  }
  
  /**
   * If a chain must not be informed about updates, it can be removed
   * from the animator
   */
  def deRegister(anim : Chain[_]) : Unit = {
    if(_animations contains anim)
      _animations = _animations filter (_ != anim)
  }
  
  /**
   * All chains can be removed to get an empty state of Animator
   */
  def clear() : Unit = {
    _animations = Seq[Chain[_]]()
  }
  
}
