package toan.furamaresort.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "customer_types")
@Getter
@Setter
@NoArgsConstructor
public class CustomerType {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "type_name")
    private String typeName;
}