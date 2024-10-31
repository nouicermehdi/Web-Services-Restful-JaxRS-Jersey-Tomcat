package model;

import java.io.Serializable;
import java.time.LocalDate;


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
public class Note  implements Serializable {
	
	private Long idNote;
    private double note;
    private LocalDate dateSaisie;

    private Etudiant etudiant;

    private Matiere matiere;
    
    public Note(Long id) {
    	this.idNote=id;}
}