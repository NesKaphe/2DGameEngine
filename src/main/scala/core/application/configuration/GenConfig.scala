package core.application.configuration

private[configuration] trait GenConfig extends MakerAttributes {
  
  def genConfig() : Option[AppConfig] = {
    (gameTitle, gameResolution, targetFPS) match {
      
      /* if some content is still None, the configuration is incomplete
       * and should not be returned 
       */
      case (None, _ ,_  )| (_ , None, _ )| (_ ,_ , None) => None
      
      /*
       * otherwise, the configuration can be returned
       */
      case (Some(title), Some((widthRes, heightRes)), Some(fps)) =>
        {
          val config = new AppConfig(title, widthRes, heightRes, fps)
          Some(config)
        }
    } 
  }
  
}