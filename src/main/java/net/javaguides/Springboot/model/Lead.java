package net.javaguides.Springboot.model;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Data
@Setter
@NoArgsConstructor
@Entity
@Table(name="Employee")
public class Lead {

    @NotNull
    @Id
    @Column(name = "leadId")
    private long leadId;

    @NotBlank
    @Column(name = "firstName")
    @Pattern(regexp = "^[A-Za-z]+$",message = "no spaces allowed")
    private String firstName;

    @Column(name = "middleName")
    @Pattern(regexp = "^[A-Za-z]*$",message = "no spaces allowed")
    private String middleName;

    @NotBlank
    @Column(name = "lastName")
    @Pattern(regexp = "^[A-Za-z]+$",message = "no spaces allowed")
    private String lastName;


    @Column(name = "email")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",message = "no spaces allowed")
    private String email;

    @NotBlank
    @Column(name = "mobileNumber")
    @Pattern(regexp = "^[6-9][0-9]{0,9}$",message = "no spaces allowed-mobile")
    private String mobileNumber;

    @NotBlank
    @Column(name = "Gender")
    @Pattern(regexp = "^(male|female|others)$",message = "no spaces allowed")
    private String Gender;

    @NotBlank
    @Column(name = "DOB")
    @Pattern(regexp = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$",message = "no spaces allowed")
    private String DOB;

    public Lead(long leadId, String firstName, String middleName, String lastName, String email, String mobileNumber, String Gender, String DOB) {
        this.leadId = leadId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.Gender = Gender;
        this.DOB = DOB;
    }


    public long getLeadId() {
        return leadId;
    }

    public void setLeadId(long leadId) {
        this.leadId = leadId;
    }
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMobile() {
        return mobileNumber;
    }

    public void setMobile(String mobile) {
        this.mobileNumber = mobile;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
