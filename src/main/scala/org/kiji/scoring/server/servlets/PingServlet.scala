package org.kiji.scoring.server.servlets

import javax.servlet.http.HttpServlet

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class PingServlet extends HttpServlet {
  import PingServlet._
}

object PingServlet {
  val LOG: Logger = LoggerFactory.getLogger(classOf[PingServlet])
}
