package pe.edu.i202123054.cl1_jpa_data_lavandera_joaquin.repositories;

import org.springframework.data.repository.CrudRepository;
import pe.edu.i202123054.cl1_jpa_data_lavandera_joaquin.entities.Country;

public interface CountryRepository  extends CrudRepository <Country, String>{
}
