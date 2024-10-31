package dao;

import java.util.List;

import model.Matiere;

public interface IMatiereDAO {
	
	public Matiere addMatiere(Matiere matiere);
	
	public Matiere getMatiereById(Long idMatiere);

	
	public List<Matiere> listeMatiere();
	
	public List<Matiere> searchMatiere(String nomMatiere);

	public boolean updateMatiere(Matiere matiere);
	
	public boolean deleteMatiere(Long idMatiere);
	
	

}
