package core.application.configuration

import scala.language.postfixOps

import scala.io.Source

private[configuration] trait FileConfigParse extends GenConfig {
    
  def loadFromFilePath(path : String) : Option[AppConfig] = {
    var width  = -1
    var height = -1
    
    try {
      val lines = Source.fromFile(path).getLines()
      lines.foreach { 
        line => 
          {
            if(!line.contains("="))
              return None
            
            val split = line split("=")
            
            if(split.length != 2)
              return None
              
            split(0) match {
              case "" => ()
              case "fps"    => setTargetFPS(split(1) toInt)
              case "width"  => width     = split(1) toInt
              case "height" => height    = split(1) toInt
              case "title"  => setGameTitle(split(1))
            }
            
          }
      }
      
      setGameResolution(width, height)
      genConfig()
    
    } catch {
      case e : java.io.FileNotFoundException => 
        {
          return None
        }
      case e : java.lang.NumberFormatException => 
        {
          return None
        }
    }
  }
}