package core.utils

object idGenerator {

  private var _id = 0
  
  def id = {_id += 1; _id}
  
}