package at.htl_leonding.boundary

import at.htl_leonding.service.GreetingService
import javax.inject.Inject
import javax.enterprise.inject.Default
import javax.enterprise.context.ApplicationScoped

import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/")
class GreetingResource {

    @Inject
    @field: Default
    lateinit var service: GreetingService

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting")
    fun greeting(): String {
        return service.greeting("")
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    fun greeting(@PathParam("name") name: String): String {
        return service.greeting(name)
    }

}