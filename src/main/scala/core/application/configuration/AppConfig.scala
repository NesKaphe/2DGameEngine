package core.application.configuration

class AppConfig private [configuration] (val gameTitle : String,
                                         val widthRes : Int, 
                                         val heightRes : Int, 
                                         val targetFPS : Int)