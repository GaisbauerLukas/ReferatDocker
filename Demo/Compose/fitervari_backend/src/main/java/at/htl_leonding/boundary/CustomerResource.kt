package at.htl_leonding.boundary

import at.htl_leonding.model.Customer
import at.htl_leonding.service.CustomerService
import java.text.SimpleDateFormat
import javax.inject.Inject
import javax.json.JsonObject
import javax.transaction.Transactional
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/api")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class CustomerResource {
    @Inject
    lateinit var service: CustomerService

    @GET
    @Path("/customer/{id}")
    fun getCustomerById(@PathParam("id") id: Long): Response {
        return Response.ok(service.getById(id)).build()
    }

    @POST
    @Path("/customer")
    @Transactional
    fun postCustomer(jsonObject: JsonObject): Response {
        try {
            val newCustomer = Customer(
                    jsonObject.getString("name"),
                    SimpleDateFormat("yyyy-MM-dd").parse(jsonObject.getString("joinDate")),
                    service.getTrainerPerId(jsonObject["myTrainer"]?.asJsonObject()?.getInt("id")?.toLong()
                            ?: throw Exception("Wrong id")),
                    jsonObject.getBoolean("cashCostumer"),
                    SimpleDateFormat("yyyy-MM-dd").parse(jsonObject.getString("memberTill")),
                    jsonObject.getInt("pictureId")
            )
            println(newCustomer)
            service.addCustomer(newCustomer)
            return Response.accepted().build()
        } catch (e: Exception) {
            print("============================")
            print(e.message)
            return Response.ok(e.message).build()
        }
    }


    @PUT
    @Path("/customer/{id}")
    @Transactional
    fun updateWorkout(@PathParam("id") id: Long, jsonObject: JsonObject): Response {
        try {
            val newCustomer = Customer(
                    jsonObject.getString("name"),
                    SimpleDateFormat("yyyy-MM-dd").parse(jsonObject.getString("joinDate")),
                    service.getTrainerPerId(jsonObject["myTrainer"]?.asJsonObject()?.getInt("id")?.toLong()
                            ?: throw Exception("Wrong id")),
                    jsonObject.getBoolean("cashCostumer"),
                    SimpleDateFormat("yyyy-MM-dd").parse(jsonObject.getString("memberTill")),
                    jsonObject.getInt("pictureId")
            )
            service.updateCustomer(newCustomer, id)
            return Response.accepted().build()
        } catch (e: Exception) {
            return Response.ok(e.message).build()
        }
    }

    @DELETE
    @Path("/workout/{id}")
    @Transactional
    fun deleteTrainer(@PathParam("id") id: Long): Response {
        try {
            service.deleteCustomer(id)
            return Response.ok().build()
        } catch (e: Exception) {
            return Response.serverError().build()
        }
    }
}