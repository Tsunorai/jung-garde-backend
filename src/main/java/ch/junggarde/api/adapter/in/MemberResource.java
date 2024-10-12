package ch.junggarde.api.adapter.in;

import ch.junggarde.api.application.MemberService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/members")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class MemberResource {
    @Inject
    MemberService memberService;

    @GET
    public Response getMembers() {
        return Response.ok(memberService.getMembers()).build();
    }

    @Path("/administrative")
    @GET
    public Response getAdministrative() {
        return Response.ok().entity(memberService.getAdministrativeMembers()).build();
    }
}
