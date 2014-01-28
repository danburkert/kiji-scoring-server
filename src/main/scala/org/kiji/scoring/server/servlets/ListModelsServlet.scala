package org.kiji.scoring.server.servlets

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.kiji.express.flow.util.ResourceUtil.doAndClose

/** GET a list of the models deployed by this ScoringServer. */
class ListModelsServlet extends HttpServlet {
  import ListModelsServlet._

  override def doGet(
      request: HttpServletRequest,
      response: HttpServletResponse
  ) {
    doAndClose(new OutputStreamWriter(response.getOutputStream, "UTF-8")) {
      osw: OutputStreamWriter => doAndClose(new BufferedWriter(osw)) {
        bw: BufferedWriter => // TODO figure out what models are deployed
      }
    }
  }
}

object ListModelsServlet {
  val LOG: Logger = LoggerFactory.getLogger(classOf[ListModelsServlet])
}
