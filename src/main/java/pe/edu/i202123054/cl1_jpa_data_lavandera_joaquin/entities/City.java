package pe.edu.i202123054.cl1_jpa_data_lavandera_joaquin.entities;

import lombok.Data;
import jakarta.persistence.*;


@Entity
@Table(name = "city")
@Data
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "Name", nullable = false, length = 35)
    private String name;

    @Column(name = "District", nullable = false, length = 20)
    private String district;

    @Column(name = "Population")
    private int population;

    @ManyToOne
    @JoinColumn(name = "CountryCode", referencedColumnName = "Code", nullable = false)
    private Country country;
}