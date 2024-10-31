package model;


import java.io.Serializable;

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
public class Matiere  implements Serializable{
    
 
	private static final long serialVersionUID = 1L;
	private long idMatiere;
	private String nomMatiere;
    private double coefficient;
    
    public Matiere(long idMatiere) {

		this.idMatiere = idMatiere;
	}

}
