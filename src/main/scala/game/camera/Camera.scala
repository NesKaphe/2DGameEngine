package game.camera

final class Camera (val visibleWidth: Int, val visibleHeight: Int) {

  private var positionX = 0
  private var positionY = 0
  
  def offsetX = positionX
  def offsetY = positionY
    
  def moveTo(xPosition : Int, yPosition : Int) : Unit = {
    moveXTo(xPosition)
    moveYTo(yPosition)
  }
  
  def moveXTo(xPosition : Int) : Unit = {
    if(xPosition > 0)
      positionX = xPosition
  }
  
  def moveYTo(yPosition : Int) : Unit = {
    if(yPosition > 0)
      positionY = yPosition
  }
  
  def moveFrom(xOffset : Int, yOffset : Int) : Unit = {
    moveXFrom(xOffset)
    moveYFrom(yOffset)
  }
  
  def moveXFrom(xOffset : Int) : Unit = {
    positionX += xOffset
    
    if(positionX < 0)
      positionX = 0
  }
  
  def moveYFrom(yOffset : Int) : Unit = {
    positionY += yOffset
    
    if(positionY < 0)
      positionY = 0
  }
  
}