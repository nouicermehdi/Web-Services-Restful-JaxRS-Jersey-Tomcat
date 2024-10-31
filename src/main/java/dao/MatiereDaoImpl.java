package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Matiere;




public class MatiereDaoImpl implements IMatiereDAO {
	
	private static MatiereDaoImpl instance;

	private static Map<Long,Matiere> matieres = new HashMap<Long,Matiere>();

	
	static {
		matieres.put(1L, new Matiere(1L, "Math", 2));
		matieres.put(2L, new Matiere(2L, "Science", 3));
	}
	
	public static MatiereDaoImpl getInstance() {
		if (instance == null) {

			instance = new MatiereDaoImpl();
		}

		return instance;
	}

	
	@Override
	public Matiere addMatiere(Matiere matiere) {
		int newId = matieres.size() + 1;
		matiere.setIdMatiere(newId);
		matieres.put(matiere.getIdMatiere(), matiere);
		return matiere;
	}
	
	@Override
	public List<Matiere> searchMatiere(String nomMatiere){
		List<Matiere> mets=new ArrayList<Matiere>();
		for (Matiere m: matieres.values()) {
	        if (m.getNomMatiere().equals(nomMatiere))
				mets.add(m);
		}
			
		return mets;
	}
	
	@Override
	public List<Matiere> listeMatiere() {
	
			
		return new ArrayList<Matiere>(matieres.values());
	}

	@Override
	public boolean updateMatiere(Matiere matiere) {
		
        Long idMatiere = matiere.getIdMatiere();
        if (matieres.containsKey(idMatiere)) {
        	  matieres.put(idMatiere, matiere); 
			return true;
		}
		return false;

	}

	@Override
	public boolean deleteMatiere(Long idMatiere) {
		
		if(matieres.get(idMatiere)!=null) {
			matieres.remove(idMatiere);
			return true;
			
		}
		else throw new RuntimeException("Matiere introuvable");

	}
	
	public Matiere getMatiereById(Long idMatiere) {
		return matieres.get(idMatiere);
		
	}


}
