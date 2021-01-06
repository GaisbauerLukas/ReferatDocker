package at.htl_leonding.boundary

import at.htl_leonding.model.Exercise
import at.htl_leonding.model.ExerciseSet
import at.htl_leonding.service.ExerciseSetService
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
class ExerciseSetResource {

    @Inject
    lateinit var service: ExerciseSetService

    @GET
    @Path("/exerciseSet/{id}")
    fun getExerciseById(@PathParam("id") id: Long): Response {
        return Response.ok(service.getById(id)).build()
    }

    @POST
    @Path("/exerciseSet")
    @Transactional
    fun postWorkout(jsonObject: JsonObject): Response {
        try {
            val newExerciseSet = ExerciseSet(
                    jsonObject.getJsonNumber("repeditions").intValue(),
                    jsonObject.getJsonNumber("distance").doubleValue(),
                    jsonObject.getJsonNumber("weight").doubleValue(),
                    jsonObject.getJsonNumber("time").doubleValue(),
                    jsonObject.getJsonNumber("setNumber").intValue(),
                    jsonObject.getString("type"),
                    service.gerExerciseById(jsonObject.get("exercise")?.asJsonObject()?.getJsonNumber("id")?.longValue())
            )
            newExerciseSet.persist()
            return Response.accepted().build()
        } catch (e: Exception) {
            return Response.ok(e.message).build()
        }
    }

    @PUT
    @Path("/exerciseSet/{id}")
    @Transactional
    fun updateWorkout(@PathParam("id") id: Long, jsonObject: JsonObject): Response {
        try {
            val newExerciseSet = ExerciseSet(
                    jsonObject.getJsonNumber("repeditions").intValue(),
                    jsonObject.getJsonNumber("distance").doubleValue(),
                    jsonObject.getJsonNumber("weight").doubleValue(),
                    jsonObject.getJsonNumber("time").doubleValue(),
                    jsonObject.getJsonNumber("setNumber").intValue(),
                    jsonObject.getString("type"),
                    service.gerExerciseById(jsonObject.get("exercise")?.asJsonObject()?.getJsonNumber("id")?.longValue())
            )
            service.updateExerciseSet(newExerciseSet, id)
            return Response.accepted().build()
        } catch (e: Exception) {
            return Response.serverError().build()
        }
    }

    @DELETE
    @Path("/exerciseSet/{id}")
    @Transactional
    fun deleteTrainer(@PathParam("id") id: Long): Response {
        try {
            service.deleteExerciseSet(id)
            return Response.ok().build()
        } catch (e: Exception) {
            return Response.serverError().build()
        }
    }
}