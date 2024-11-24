package pe.edu.i202123054.cl1_jpa_data_lavandera_joaquin.entities;

import lombok.Data;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "country")
@Data
public class Country {

    @Id
    @Column(name = "Code", length = 3)
    private String code;

    @Column(name = "Name", nullable = false, length = 52)
    private String name;

    @Column(name = "Continent", nullable = false, length = 20)
    private String continent;

    @Column(name = "Region", nullable = false, length = 26)
    private String region;

    @Column(name = "SurfaceArea", precision = 10, scale = 2)
    private BigDecimal surfaceArea;

    @Column(name = "IndepYear")
    private Short indepYear;

    @Column(name = "Population")
    private int population;

    @Column(name = "LifeExpectancy", precision = 3, scale = 1)
    private BigDecimal lifeExpectancy;

    @Column(name = "GNP", precision = 10, scale = 2)
    private BigDecimal gnp;

    @Column(name = "GNPOld", precision = 10, scale = 2)
    private BigDecimal gnpOld;

    @Column(name = "LocalName", length = 45)
    private String localName;

    @Column(name = "GovernmentForm", length = 45)
    private String governmentForm;

    @Column(name = "HeadOfState", length = 60)
    private String headOfState;

    @Column(name = "Capital")
    private Integer capital;

    @Column(name = "Code2", length = 2)
    private String code2;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<City> cities;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Language> languages;
}