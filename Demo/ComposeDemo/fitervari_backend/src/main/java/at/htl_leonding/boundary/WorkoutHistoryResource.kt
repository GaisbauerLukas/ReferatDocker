package at.htl_leonding.boundary

import at.htl_leonding.model.Exercise
import at.htl_leonding.model.WorkoutHistory
import at.htl_leonding.service.WorkoutHistoryService
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
class WorkoutHistoryResource {

    @Inject
    lateinit var service: WorkoutHistoryService

    @GET
    @Path("/workoutHistory/{id}")
    fun getWorkoutHistoryById(@PathParam("id") id: Long): Response {
        return Response.ok(service.getById(id)).build()
    }

    @POST
    @Path("/workoutHistory")
    @Transactional
    fun postWorkoutHistory(jsonObject: JsonObject): Response {
        try {
            val newWorkoutHistory = WorkoutHistory(
                    LocalDateTime.parse(jsonObject.getString("date")),
                    service.getWorkoutById(jsonObject.get("workout")?.asJsonObject()?.getInt("id")?.toLong()),
                    service.getCustomerById(jsonObject.get("customer")?.asJsonObject()?.getInt("id")?.toLong())
            )
            newWorkoutHistory.persist()
            return Response.accepted().build()
        } catch (e: Exception) {
            return Response.ok(e.message).build()
        }
    }

    @PUT
    @Path("/workoutHistory/{id}")
    @Transactional
    fun updateWorkoutHistory(@PathParam("id") id: Long, jsonObject: JsonObject): Response {
        try {
            val newWorkoutHistory = WorkoutHistory(
                    LocalDateTime.parse(jsonObject.getString("date")),
                    service.getWorkoutById(jsonObject.get("workout")?.asJsonObject()?.getInt("id")?.toLong()),
                    service.getCustomerById(jsonObject.get("customer")?.asJsonObject()?.getInt("id")?.toLong())
            )
            service.updateWorkoutHistory(newWorkoutHistory, id)
            return Response.accepted().build()
        } catch (e: Exception) {
            return Response.serverError().build()
        }
    }

    @DELETE
    @Path("/workoutHistory/{id}")
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