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
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="solicitud")
public class Solicitud implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotBlank(message ="El nombre no puede estar vacío")
    @NotNull(message ="El nombre no puede estar vacío")
    @Length(min=2, message = "La longitud minima del nombre real es 2")
    @Column(name = "name")
	private String name;

    @NotBlank(message ="El Apellido no puede estar vacío")
    @NotNull(message ="El Apellido no puede estar vacío")
    @Length(min=2, message = "La longitud minima del apellido paterno es 2")
	@Column(name = "lastname")
    private String lastname;

	@Column(name = "surname")
    private String surname;

    @Past(message = "La fecha no es valida")
    @NotNull(message ="La fecha de nacimiento no puede estar vacía")
	@Column(name = "date_birth")
    private Date dateBirth;

    @Email(message="El correo debe de ser valido")
    @NotNull(message ="El correo no puede estar vacío")
    @NotBlank(message ="El correo no puede estar vacío")
	@Column(name = "email")
    private String email;

    @NotNull(message ="El numero debe ser de 10 dígitos")
    @NotBlank(message ="El numero debe ser de 10 dígitos")
    @Length(min=10, max=13, message = "La longitud es incorrecta")
	@Column(name = "phone")
    private String phone;

    @NotNull(message ="El sexo no puede estar vacío")
    @NotBlank(message ="El sexo no puede estar vacío")
    @Column(name = "sexo")
    private String sexo;

    @NotNull(message ="El estado no puede estar vacío")
	@OneToOne
    @JoinColumn(name = "state")
    private State state;

    @NotNull(message ="El municipio no puede estar vacío")
	@OneToOne
    @JoinColumn(name = "municipality")
    private Municipality municipality;

    @NotNull(message ="La dirección no puede estar vacía")
    @NotBlank(message ="La dirección no puede estar vacía")
    @Length(min=2, message = "La longitud minima de la dirección es 2")
	@Column(name = "address")
    private String address;

    @NotNull(message ="La institution no puede estar vacía")
    @NotBlank(message ="La institution no puede estar vacía")
    @Length(min=2, message = "La longitud minima de la institution es 2")
    @Column(name = "institution")
    private String institution;
    
    @NotNull(message ="Grado academico no puede estar vacío")
	@OneToOne
    @JoinColumn(name = "academic_level")
    private AcademicLevel academicLevel;

    @NotNull(message ="El Promedio no puede estar vacío")
    @Max(value=100, message ="El Promedio no puedes ser mayor a 100")
    @Digits(integer = 3, fraction = 2, message = "La longitud máxima del Numero es 100")
	@Column(name = "average")
    private float average;

    @NotNull(message ="La razon no puede estar vacía")
    @NotBlank(message ="La razon no puede estar vacía")
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
