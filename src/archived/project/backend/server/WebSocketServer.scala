package archived.project.backend.server

import akka.actor.{Actor, ActorSystem, Props}
import com.corundumstudio.socketio.{Configuration, SocketIOServer}
import archived.project.backend.Update

import scala.concurrent.duration


class WebSocketServer() extends Actor {

  // Very little starter code is provided for the web server part of the archived.project. To complete this part
  // you are expected to understand how the 3 systems and the front end all interact with each other and
  // communication between the three. This will require you to implement 3 test systems and a test front end
  // in order to demo that all the functionality is working

  val config: Configuration = new Configuration {
    setHostname("localhost")
    setPort(8080)
  }

  val server: SocketIOServer = new SocketIOServer(config)


  server.start()

  override def receive: Receive = {

    case _ =>
  }

  override def postStop(): Unit = {
    println("stopping server")
    server.stop()
  }
}



object WebSocketServer {

  def main(args: Array[String]): Unit = {
    val actorSystem = ActorSystem()

    import actorSystem.dispatcher

    import scala.concurrent.duration._

    val server = actorSystem.actorOf(Props(classOf[WebSocketServer]))

    actorSystem.scheduler.scheduleAtFixedRate(FiniteDuration(0, duration.MILLISECONDS), FiniteDuration(33, duration.MILLISECONDS), server, Update(System.nanoTime()))
  }
}


