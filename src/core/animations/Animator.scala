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
  
  def register(anim : Chain[_]) : Unit = {
    if( !(_animations contains anim) )
      _animations = _animations :+ anim
  }
  
  def deRegister(anim : Chain[_]) : Unit = {
    if(_animations contains anim)
      _animations = _animations filter (_ != anim)
  }
  
  def clear() : Unit = {
    _animations = Seq[Chain[_]]()
  }
  
}