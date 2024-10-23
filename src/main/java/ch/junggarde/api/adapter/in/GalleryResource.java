package ch.junggarde.api.adapter.in;

import ch.junggarde.api.application.GalleryService;
import ch.junggarde.api.application.dto.GalleryImageDTO;
import ch.junggarde.api.model.ImageNotFound;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/gallery/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class GalleryResource {
    @Inject
    GalleryService galleryService;

    @GET
    @Path("/{year}/{event}/{page}")
    public Response getGallery(
            @PathParam("year") int year,
            @PathParam("event") String event,
            @PathParam("page") int page
    ) {
        try {
            return Response.ok().entity(this.galleryService.getGallery(year, event, page)).build();
        } catch (ImageNotFound e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @POST
    public Response addImages(List<GalleryImageDTO> images) {
        return Response.ok().entity(galleryService.addImages(images)).build();
    }
}
