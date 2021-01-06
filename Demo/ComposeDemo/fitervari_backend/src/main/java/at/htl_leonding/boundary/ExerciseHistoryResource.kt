package at.htl_leonding.boundary

import at.htl_leonding.model.ExerciseHistory
import at.htl_leonding.service.ExerciseHistoryService
import javax.inject.Inject
import javax.json.JsonObject
import javax.transaction.Transactional
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class ExerciseHistoryResource {

    @Inject
    lateinit var service: ExerciseHistoryService

    @GET
    @Path("/exerciseHistory/{id}")
    fun getExerciseById(@PathParam("id") id: Long): Response {
        return Response.ok(service.getById(id)).build()
    }

    @POST
    @Path("/exerciseHistory")
    @Transactional
    fun postWorkout(jsonObject: JsonObject): Response {
        try {
            val newExerciseHistory = ExerciseHistory(
                    service.getWorkoutHistoryById(jsonObject.get("workoutHistory")?.asJsonObject()?.getInt("id")?.toLong())
            )
            newExerciseHistory.persist()
            return Response.accepted().build()
        } catch (e: Exception) {
            return Response.ok(e.message).build()
        }
    }

    @DELETE
    @Path("/exerciseHistory/{id}")
    @Transactional
    fun deleteTrainer(@PathParam("id") id: Long): Response {
        try {
            service.deleteWorkoutHistory(id)
            return Response.ok().build()
        } catch (e: Exception) {
            return Response.serverError().build()
        }
    }
}