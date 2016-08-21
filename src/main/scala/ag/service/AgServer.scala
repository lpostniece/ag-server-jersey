package ag.service

import javax.servlet.{ServletContextEvent, ServletContextListener}
import javax.ws.rs._
import javax.ws.rs.core.{MediaType, StreamingOutput}

import ag.csv.CSVTable
import io.swagger.annotations.Api
import org.glassfish.jersey.filter.LoggingFilter
import org.glassfish.jersey.media.multipart.MultiPartFeature
import org.glassfish.jersey.server.ResourceConfig
import org.slf4j.LoggerFactory

object AgServer {
  System.out.println("Server start")

  /** class configured in web.xml */
  class MyContextListener extends ServletContextListener {
    override def contextInitialized(event: ServletContextEvent) = {
    }
    override def contextDestroyed(event: ServletContextEvent) = {
    }
  }

  /** class configured in web.xml */
  @ApplicationPath("/")
  class MyApplication extends ResourceConfig(
    classOf[MultiPartFeature],
    classOf[LoggingFilter])
}

@Path("/v1")
@Api("ag-server")
class AgServer {

  System.out.println("Service start")

  val log = LoggerFactory.getLogger(getClass)
  log.debug("ctor")

  @Path("get-csv")
  @GET
  @Produces(Array(MediaType.TEXT_PLAIN))
  def getCSV() : String = {
    log.debug("getCSV")

    CSVTable.mergeFiles
  }

}
