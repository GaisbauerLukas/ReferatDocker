package at.htl_leonding.boundary

import at.htl_leonding.model.Exercise
import at.htl_leonding.service.ExerciseService
import java.time.LocalDateTime
import javax.inject.Inject
import javax.json.JsonObject
import javax.transaction.Transactional
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class ExerciseResource {

    @Inject
    lateinit var service: ExerciseService

    @GET
    @Path("/exercise/{id}")
    fun getExerciseById(@PathParam("id") id: Long): Response {
        return Response.ok(service.getById(id)).build()
    }

    @POST
    @Path("/exercise")
    @Transactional
    fun postWorkout(jsonObject: JsonObject): Response {
        try {
            val newExercise = Exercise(
                    jsonObject.getString("name"),
                    LocalDateTime.parse(jsonObject.getString("creationDate")),
                    jsonObject.getString("exerciseType"),
                    jsonObject.getInt("standardSetNr"),
                    jsonObject.getBoolean("officialFlag"),
                    service.getPersonById(jsonObject.get("creator")?.asJsonObject()?.getInt("id")?.toLong())
            )
            newExercise.persist()
            return Response.accepted().build()
        } catch (e: Exception) {
            return Response.ok(e.message).build()
        }
    }

    @PUT
    @Path("/exercise/{id}")
    @Transactional
    fun updateWorkout(@PathParam("id") id: Long, jsonObject: JsonObject): Response {
        try {
            val newExercise = Exercise(
                    jsonObject.getString("name"),
                    LocalDateTime.parse(jsonObject.getString("creationDate")),
                    jsonObject.getString("exerciseType"),
                    jsonObject.getInt("standardSetNr"),
                    jsonObject.getBoolean("officialFlag"),
                    service.getPersonById(jsonObject.get("creator")?.asJsonObject()?.getInt("id")?.toLong())
            )
            service.updateExercise(newExercise, id)
            return Response.accepted().build()
        } catch (e: Exception) {
            return Response.serverError().build()
        }
    }

    @DELETE
    @Path("/exercise/{id}")
    @Transactional
    fun deleteTrainer(@PathParam("id") id: Long): Response {
        try {
            service.deleteExercise(id)
            return Response.ok().build()
        } catch (e: Exception) {
            return Response.serverError().build()
        }
    }
}