package at.htl_leonding.boundary

import at.htl_leonding.model.NewsLetter
import at.htl_leonding.service.NewsLetterService
import java.lang.Exception
import javax.inject.Inject
import javax.json.JsonObject
import javax.transaction.Transactional
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class NewsLetterResource {

    @Inject
    lateinit var service: NewsLetterService

    @GET
    @Path("/newsletter/{id}")
    fun getTrainerWithId(@PathParam("id") id: Long): Response {
        return Response.ok(service.getById(id)).build()
    }

    @GET
    @Path("/newsletter")
    fun getAllNewsLetters(): Response {
        return Response.ok(service.getAllNewsLetters()).build();
    }

    @POST
    @Path("/newsletter")
    @Transactional
    fun postNewsLetter(jsonObject: JsonObject): Response {
        try {
            val newNewsLetter = NewsLetter(
                    jsonObject.getString("title"),
                    jsonObject.getString("body"),
                    jsonObject.getString("imageUrl")
            )
            newNewsLetter.persist()
            return Response.accepted().build()
        } catch (e: Exception) {
            return Response.serverError().build();
        }
    }
}