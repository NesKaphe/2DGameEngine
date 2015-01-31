package core.application.configuration

private[configuration] trait MakerAttributes {
  
  private var _gameTitle : Option[String] = None
  private var _gameResolution : Option[(Int,Int)] = None
  private var _targetFPS : Option[Int] = None
    
  def setGameTitle (title: String) : Unit = {
    
    title match {
      case null | "" => ()
      case _         => _gameTitle = Some(title)
    }
    
  }
  
  def setGameResolution (widthRes : Int, heightRes : Int) : Unit = {
    
    if(widthRes > 0 && heightRes > 0)
      _gameResolution = Some(widthRes, heightRes)
    
  }
  
  def setTargetFPS (fps : Int) : Unit = {
    
    if(fps > 0)
      _targetFPS = Some(fps)
      
  }
  
  def gameTitle      = _gameTitle
  def gameResolution = _gameResolution
  def targetFPS      = _targetFPS
}