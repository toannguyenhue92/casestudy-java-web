package toan.furamaresort.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "genders")
@Getter
@Setter
@NoArgsConstructor
public class Gender {
    
    @Id
    private Integer id;

    @Column(name = "gender_name")
    private String genderName;
}