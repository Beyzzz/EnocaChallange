package kodlama.io.Kodlama.ioDevsSpring.entities.concrates;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SubTechnology {
	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="technologId")
	private int technologId;
	
	@Column(name="name")
	private String technologyName;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	
	Language language;

}
