package at.htl_leonding.boundary

import at.htl_leonding.model.Exercise
import at.htl_leonding.model.SetHistory
import at.htl_leonding.service.SetHistoryService
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
class SetHistoryResource {

    @Inject
    lateinit var service: SetHistoryService

    @GET
    @Path("/setHistory/{id}")
    fun getSetHistoryById(@PathParam("id") id: Long): Response {
        return Response.ok(service.getById(id)).build()
    }

    @POST
    @Path("/setHistory")
    @Transactional
    fun postSetHistory(jsonObject: JsonObject): Response {
        try {
            val newSetHistory = SetHistory(
                    service.getExerciseHistoryById(
                            jsonObject.get("exerciseHistory")?.asJsonObject()?.getInt("id")?.toLong()),
                    jsonObject.getJsonNumber("time").doubleValue(),
                    jsonObject.getJsonNumber("distance").doubleValue(),
                    jsonObject.getJsonNumber("weight").doubleValue(),
                    jsonObject.getJsonNumber("repetitions").intValue(),
                    jsonObject.getJsonNumber("setNumber").intValue()
            )
            newSetHistory.persist()
            return Response.accepted().build()
        } catch (e: Exception) {
            return Response.ok(e.message).build()
        }
    }

    @PUT
    @Path("/setHistory/{id}")
    @Transactional
    fun updateWorkout(@PathParam("id") id: Long, jsonObject: JsonObject): Response {
        try {
            val newSetHistory = SetHistory(
                    service.getExerciseHistoryById(
                            jsonObject.get("exerciseHistory")?.asJsonObject()?.getInt("id")?.toLong()),
                    jsonObject.getJsonNumber("time").doubleValue(),
                    jsonObject.getJsonNumber("distance").doubleValue(),
                    jsonObject.getJsonNumber("weight").doubleValue(),
                    jsonObject.getJsonNumber("repetitions").intValue(),
                    jsonObject.getJsonNumber("setNumber").intValue()
            )
            service.updateSetHistory(newSetHistory, id)
            return Response.accepted().build()
        } catch (e: Exception) {
            return Response.serverError().build()
        }
    }

    @DELETE
    @Path("/setHistory/{id}")
    @Transactional
    fun deleteTrainer(@PathParam("id") id: Long): Response {
        try {
            service.deleteSetHistory(id)
            return Response.ok().build()
        } catch (e: Exception) {
            return Response.serverError().build()
        }
    }
}