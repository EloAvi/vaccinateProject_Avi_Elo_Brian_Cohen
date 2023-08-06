package hac;

import hac.entity.Citizen;


public class CitizenSummary {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String address;
    private String city;
    private String zipCode;
    private String landLine;
    private String cellularPhone;
    private boolean hasCovidBefore;
    private String previousConditionsString;

    public CitizenSummary(Citizen citizen, String previousConditionsString) {
        this.firstName = citizen.getFirstName();
        this.lastName = citizen.getLastName();
        this.dateOfBirth = citizen.getDateOfBirth().toString();
        this.address = citizen.getAddress();
        this.city = citizen.getCity().toString();
        this.zipCode = citizen.getZipCode();
        this.landLine = citizen.getLandLine();
        this.cellularPhone = citizen.getCellularPhone();
        this.hasCovidBefore = citizen.isCovid19Infected(); // This is now correct
        this.previousConditionsString = previousConditionsString != null ? previousConditionsString : citizen.getOtherConditions();
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
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

    public boolean isHasCovidBefore() {
        return hasCovidBefore;
    }

    public void setHasCovidBefore(boolean hasCovidBefore) {
        this.hasCovidBefore = hasCovidBefore;
    }

    public String getPreviousConditionsString() {
        return previousConditionsString;
    }

    public void setPreviousConditionsString(String previousConditionsString) {
        this.previousConditionsString = previousConditionsString;
    }
}
