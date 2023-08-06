package hac.entity;

import hac.ConditionsConverter;
import hac.service.City;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Citizens")
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First Name is mandatory")
    private String firstName;

    @NotBlank(message = "Last Name is mandatory")
    private String lastName;

    @NotNull(message = "Date of Birth is mandatory")
    private LocalDate dateOfBirth;

    @NotBlank(message = "Address is mandatory")
    private String address;

    @Enumerated(EnumType.STRING)
    private City city;

    private String zipCode;

    @NotBlank(message = "Land Line is mandatory")
    private String landLine;

    @NotBlank(message = "Cellular Phone is mandatory")
    private String cellularPhone;

    private boolean covid19Infected;

    @Column(name = "previous_conditions")
    @Convert(converter = ConditionsConverter.class)
    private Set<Condition> previousConditions;

    private String otherConditions;

    public Citizen() {
    }
    public Citizen(String firstName, String lastName, LocalDate dateOfBirth, String address, City city, String zipCode, String landLine, String cellularPhone, boolean covid19Infected, Set<Condition> previousConditions, String otherConditions) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        this.landLine = landLine;
        this.cellularPhone = cellularPhone;
        this.covid19Infected = covid19Infected;
        this.previousConditions = previousConditions;
        this.otherConditions = otherConditions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getLandLine() {
        return landLine;
    }

    public void setLandLine(String landLine) {
        this.landLine = landLine;
    }

    public String getCellularPhone() {
        return cellularPhone;
    }

    public void setCellularPhone(String cellularPhone) {
        this.cellularPhone = cellularPhone;
    }

    public boolean isCovid19Infected() {
        return covid19Infected;
    }

    public void setCovid19Infected(boolean covid19Infected) {
        this.covid19Infected = covid19Infected;
    }

    public Set<Condition> getPreviousConditions() {
        return previousConditions;
    }

    public void setPreviousConditions(Set<Condition> previousConditions) {
        this.previousConditions = previousConditions;
    }

    public String getOtherConditions() {
        return otherConditions;
    }

    public void setOtherConditions(String otherConditions) {
        this.otherConditions = otherConditions;
    }
}
