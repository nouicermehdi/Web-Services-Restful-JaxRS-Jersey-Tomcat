package services;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.MatiereDaoImpl;
import model.Matiere;

@Path("/matiere")
public class mateireService {
	private MatiereDaoImpl dao = MatiereDaoImpl.getInstance();
	
	// tester avec http://localhost:8080/Projet/rest/matiere

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Matiere> consulterMatiere(){
		return dao.listeMatiere();	
		}
	
//http://localhost:8080/Projet/rest/matiere/1
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMatiereById(@PathParam("id") Long id) {
		Matiere matiere = dao.getMatiereById(id);
		if (matiere != null) {
			return Response.ok(matiere).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	
	// http://localhost:8080/Projet/rest/matiere/search?nomMatiere=Math
	
	@GET
	@Path("/search")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Matiere> matieresParMot(@QueryParam(value="nomMatiere") String nomMatiere){
		return dao.searchMatiere(nomMatiere);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Matiere addMtiere(Matiere matiere) {
		return dao.addMatiere(matiere);
	}

	
	@DELETE
	@Path("/{id}")
	public Response deleteMatiere(@PathParam("id") Long idMatiere) {
		if (dao.deleteMatiere(idMatiere)) {
			return Response.ok().build();
		} else {
			return Response.notModified().build();
		}
	}
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response updateMatiere(@PathParam("id") Long id, Matiere matiere) {
		matiere.setIdMatiere(id);
		if (dao.updateMatiere(matiere)) {
			return Response.ok().build();
		} else {
			return Response.notModified().build();
		}
	}
}
