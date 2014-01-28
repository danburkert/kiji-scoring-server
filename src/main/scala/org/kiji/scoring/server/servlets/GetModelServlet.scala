package org.kiji.scoring.server.servlets

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import org.kiji.express.flow.util.ResourceUtil.doAndClose


/** GET the URL for a model by name. */
class GetModelServlet extends HttpServlet {
  import GetModelServlet._

  override def doGet(
      request: HttpServletRequest,
      response: HttpServletResponse
  ) {
    val model: String = request.getParameter("model")

    doAndClose(new OutputStreamWriter(response.getOutputStream, "UTF-8")) {
      osw: OutputStreamWriter => doAndClose(new BufferedWriter(osw)) {
        bw: BufferedWriter => try {
          // TODO figure out where to get the model
          val modelURL: String = "" // ???.get(model)
        } catch {
          case nsee: NoSuchElementException => {
            response.sendError(404)
            bw.write("{\"error\":\"model: %s not found.\"}".format(model))
          }
        }
      }
    }
  }
}

object GetModelServlet {
  val LOG: Logger = LoggerFactory.getLogger(classOf[GetModelServlet])
}
