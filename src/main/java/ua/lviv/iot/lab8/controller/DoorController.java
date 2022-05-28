package ua.lviv.iot.lab8.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import ua.lviv.iot.lab8.entity.Door;
import ua.lviv.iot.lab8.service.DoorService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("doors")
@Produces(MediaType.APPLICATION_JSON)
public class DoorController {

    @Autowired
    private DoorService doorService;

    public DoorController() {}


    @GET
    public Iterable<Door> getAll() {
        return doorService.getAll();
    }

    @Path("{id}")
    @GET
    public Response getById(@PathParam("id") Long id) {
        Door door = doorService.getById(id).orElse(null);
        if (door == null) {
            return Response.status(404).build();
        } else {
            return Response.status(200).entity(door).build();
        }
    }

    @POST
    public Response saveDoor(@RequestBody Door door) {
        if(door.hasNullValues()) {
            return Response.status(400).entity("Please provide all mandatory inputs").build();
        }
        doorService.save(door);
        return Response.status(201).build();
    }


    @PUT
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateDoor(@PathParam("id") Long id, @RequestBody Door door) {
        Door temp = doorService.getById(id).orElse(null);
        if(temp == null || door.hasNullValues()) {
            return Response.status(404).build();
        }
        temp.setName(door.getName());
        temp.setCategory(door.getCategory());
        temp.setPrice(door.getPrice());
        temp.setTypeOfMaterial(door.getTypeOfMaterial());
        doorService.save(temp);
        return Response.status(201).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes("application/json")
    public Response deleteDoor(@PathParam("id") Long id) {
        Door temp = doorService.getById(id).orElse(null);
        if(temp == null) {
            return Response.status(404).build();
        }
        doorService.delete(id);
        return Response.status(201).build();
    }

}
