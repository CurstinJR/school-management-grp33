/**
 * @Author CHANTAL NIYONZIMA
 * 217267815
 * 14 June 2022
 * EmployeeAddressController.java
 */
package za.ac.cput.school_management_grp33.factory.location;

import org.junit.jupiter.api.Test;
import za.ac.cput.school_management_grp33.domain.location.City;
import za.ac.cput.school_management_grp33.domain.location.Country;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CityFactoryTest {
    @Test
    void getCity() {
        Country country = CountryFactory.build("5678", "South Africa");
        City city = CityFactory.getCity("1234", "DODOMA", country);
        System.out.println(city.toString());
        assertEquals(city.getId(), "1234");
    }
}