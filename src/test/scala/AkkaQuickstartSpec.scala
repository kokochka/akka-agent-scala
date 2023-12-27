import akka.actor.Actor
import akka.actor.ActorSystem
import akka.actor.Props

case class Greet(message: String)

class HelloActor extends Actor {
  def receive = {
    case "hello" => println("hello back at you")
    case Greet(message) => println(s"Hello, $message")
    case _       => println("huh?")
  }
}

object Main extends App {
  val system = ActorSystem("HelloSystem")
  // default Actor constructor
  val actor1 = system.actorOf(Props[HelloActor], name = "Burnie")
  val actor2 = system.actorOf(Props[HelloActor], name = "David")

  actor1 ! "hello"
  actor2 ! "bonjoir"
  actor1 ! Greet("o")
}