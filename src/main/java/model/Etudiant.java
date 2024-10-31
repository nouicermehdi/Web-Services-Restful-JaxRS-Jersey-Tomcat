package model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@XmlRootElement
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Etudiant implements Serializable{

    private Long idEtudiant;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String dateInscription;
    private String statut;

    private List<Note> notes;

	public Etudiant(Long id) {
		this.idEtudiant = id;
	}


    
}
