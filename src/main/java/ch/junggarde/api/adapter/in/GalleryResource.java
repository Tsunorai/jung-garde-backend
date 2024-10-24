package ch.junggarde.api.adapter.in;

import ch.junggarde.api.application.GalleryService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/gallery")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class GalleryResource {
    @Inject
    GalleryService galleryService;

    @GET
    public Response getGallery() {
        return Response.ok().entity(this.galleryService.getGallery()).build();
    }
}
