package toan.furamaresort.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Pattern(regexp = "^KH-[0-9]{4}$", message = "Bad format!")
    @Column(name = "customer_code")
    private String customerCode;

    @NotBlank
    @Column(name = "first_name")
    private String firstName;

    @NotBlank
    @Column(name = "middle_name")
    private String middleName;

    @NotBlank
    @Column(name = "last_name")
    private String lastName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @ManyToOne
    @JoinColumn(name = "gender_id")
    private Gender gender;

    @Pattern(regexp = "(^09[01][0-9]{7}$)|(^\\(84\\)\\+9[01][0-9]{7}$)", message = "Wrong format!")
    @Column(name = "phone_number")
    private String phoneNumber;

    @Email
    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "customer_type_id")
    private CustomerType customerType;

    @NotBlank
    @Column(name = "address")
    private String address;

    @Column(name = "active")
    private Boolean active = Boolean.TRUE;

    public String getFullName() {
        return lastName + " " + middleName + " " + firstName;
    }
}
