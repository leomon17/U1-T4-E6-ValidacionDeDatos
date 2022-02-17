package mx.edu.utez.sda.Validation.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import org.springframework.context.annotation.PropertySource;
@PropertySource("messages.properties")

@Entity
@Table(name="solicitud")
public class Solicitud implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotBlank(message ="{user.name.notBlank}")
    @NotNull(message ="{user.name.notNull}")
    @Length(min=2, message = "{user.name.length}")
    @Column(name = "name")
	private String name;

    @NotBlank(message ="{user.lastname.notBlank}")
    @NotNull(message ="{user.lastname.notBlank}")
    @Length(min=2, message = "{user.lastname.notBlank}")
	@Column(name = "lastname")
    private String lastname;

	@Column(name = "surname")
    private String surname;

    @Past(message = "{user.name.past}")
    @NotNull(message ="{user.name.notNull}")
    @JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "date_birth")
    private Date dateBirth;

    @Email(message="{user.email.email}")
    @NotNull(message ="{user.email.notNull}")
    @NotBlank(message ="{user.email.notBlank}")
	@Column(name = "email")
    private String email;

    @NotNull(message ="{user.phone.notNull}")
    @NotBlank(message ="{user.phone.notBlank}")
    @Length(min=10, max=13, message = "{user.phone.length}")
	@Column(name = "phone")
    private String phone;

    @NotNull(message ="{user.sexo.notBlank}")
    @NotBlank(message ="{user.sexo.notNull}")
    @Column(name = "sexo")
    private String sexo;

    @NotNull(message ="{user.state.notNull}")
	@OneToOne
    @JoinColumn(name = "state")
    private State state;

    @NotNull(message ="{user.municipality.notNull}")
	@OneToOne
    @JoinColumn(name = "municipality")
    private Municipality municipality;

    @NotNull(message ="{user.address.notNull}")
    @NotBlank(message ="{user.address.notBlank}")
    @Length(min=2, message = "{user.address.length}")
	@Column(name = "address")
    private String address;

    @NotNull(message ="{user.institution.notNull}")
    @NotBlank(message ="{user.institution.notBlank}")
    @Length(min=2, message = "{user.institution.length}")
    @Column(name = "institution")
    private String institution;
    
    @NotNull(message ="{user.academicLevel.notNull}")
	@OneToOne
    @JoinColumn(name = "academic_level")
    private AcademicLevel academicLevel;

    @NotNull(message ="{user.average.notNull}")
    @Max(value=100, message ="{user.average.max}")
    @Digits(integer = 3, fraction = 2, message = "{user.average.digits}")
	@Column(name = "average")
    private float average;

    @NotNull(message ="{user.reason.notNull}")
    @NotBlank(message ="{user.reason.notBlank}")
	@Column(name = "reason")
    private String reason;

    @Column(name = "message")
    private String message;

    public Solicitud(long id, String name, String lastname, String surname, Date dateBirth, String email, String phone,
            String sexo, State state, Municipality municipality, String address, String institution,
            AcademicLevel academicLevel, float average, String reason, String message) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.surname = surname;
        this.dateBirth = dateBirth;
        this.email = email;
        this.phone = phone;
        this.sexo = sexo;
        this.state = state;
        this.municipality = municipality;
        this.address = address;
        this.institution = institution;
        this.academicLevel = academicLevel;
        this.average = average;
        this.reason = reason;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public AcademicLevel getAcademicLevel() {
        return academicLevel;
    }

    public void setAcademicLevel(AcademicLevel academicLevel) {
        this.academicLevel = academicLevel;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
