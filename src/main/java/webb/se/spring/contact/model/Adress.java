package webb.se.spring.contact.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ADRESS")
public class Adress {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(max=50)
    @Column(name = "MUNICIPALITY")
	private String municipality;
	
	@Size(max=20)
    @Column(name = "ZIP")
	private String zip;
	
	@Size(max=50)
	@Column(name = "ADRESS")
	private String adress;
	
	@Size(max=50)
    @Column(name = "COUNTRY")
	private String country;
	
	@Size(max=50)
    @Column(name = "COUNTY")
	private String county;

	public String getMunicipality() {
		return municipality;
	}

	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}



	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Adress [id=" + id + ", country=" + country + ", county=" + county

				+ ", municipality=" + municipality + ", adress=" + adress + ", zip=" + zip + "]";
	}
}
