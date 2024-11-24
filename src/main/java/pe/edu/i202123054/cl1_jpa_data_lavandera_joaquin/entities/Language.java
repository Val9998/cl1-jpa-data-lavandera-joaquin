package pe.edu.i202123054.cl1_jpa_data_lavandera_joaquin.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;


@Entity
@Table(name = "countrylanguage")
@Data
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "Language", nullable = false, length = 30)
    private String language;

    @Column(name = "IsOfficial", nullable = false, length = 1)
    private String isOfficial;

    @Column(name = "Percentage", precision = 4, scale = 1)
    private BigDecimal percentage;

    @ManyToOne
    @JoinColumn(name = "CountryCode", referencedColumnName = "Code", nullable = false)
    private Country country;
}