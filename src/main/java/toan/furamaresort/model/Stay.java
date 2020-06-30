package toan.furamaresort.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "stays")
@Getter
@Setter
@NoArgsConstructor
public class Stay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "stay_service_code")
    private String stayServiceCode;

    @Column(name = "area")
    private Double area;

    @Column(name = "max_guest")
    private Integer maxGuest;

    @Column(name = "rental_cost")
    private Double rentalCost;

    @Column(name = "rental_type")
    private String rentalType;

    @Column(name = "stay_service_type")
    private String stayServiceType;

    @Column(name = "description")
    private String description;

    @Column(name = "standard")
    private String standard;

    @Column(name = "number_of_floors")
    private Integer numberOfFloors;

    @Column(name = "pool_area")
    private Double poolArea;

    @Column(name = "active")
    private Boolean active = Boolean.TRUE;

}
