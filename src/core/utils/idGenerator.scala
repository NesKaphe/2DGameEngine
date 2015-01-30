package core.utils

/**
 * idGenerator provides a way to get an unique id for anyone who needs
 */
object idGenerator {

  private var _id = 0
  
  def id = this.synchronized{_id += 1; _id}
  
}
