package pe.edu.i202123054.cl1_jpa_data_lavandera_joaquin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.edu.i202123054.cl1_jpa_data_lavandera_joaquin.entities.Country;
import pe.edu.i202123054.cl1_jpa_data_lavandera_joaquin.entities.Language;
import pe.edu.i202123054.cl1_jpa_data_lavandera_joaquin.repositories.CountryRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

    @Autowired
    private CountryRepository countryRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Eliminando países: COL y ARG...");
        countryRepository.deleteAllById(Arrays.asList("COL", "ARG"));
        System.out.println("Eliminación completada.");


        System.out.println("\nConsultando lenguajes del país 'ARG' (Argentina)...");
        Optional<Country> argentina = countryRepository.findById("ARG");

        argentina.ifPresentOrElse(
                country -> {

                    List<Language> languages = country.getLanguages();
                    System.out.println("Lenguajes hablados en Argentina:");
                    languages.forEach(language -> System.out.println(language.getLanguage()));
                },
                () -> {

                    System.out.println("No se encontraron lenguajes para Argentina. Buscando lenguajes para Perú...");
                    Optional<Country> peru = countryRepository.findById("PER");

                    peru.ifPresent(peruCountry -> {
                        List<Language> languages = peruCountry.getLanguages();
                        System.out.println("Lenguajes hablados en Perú:");
                        languages.forEach(language -> System.out.println(language.getLanguage()));
                    });
                }
        );
    }
}
