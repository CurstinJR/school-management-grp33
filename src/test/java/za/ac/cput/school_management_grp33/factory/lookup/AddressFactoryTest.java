/*
Author: Kevin Lionel Mombo Ndinga (218180500)
AddressFactoryTest.java
 */
package za.ac.cput.school_management_grp33.factory.lookup;

import org.junit.jupiter.api.Test;
import za.ac.cput.school_management_grp33.domain.location.City;
import za.ac.cput.school_management_grp33.domain.lookup.Address;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AddressFactoryTest {

    @Test
    void testingAddressOne() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            AddressFactory.build("500", "Thelighter", "15",
                    "playa", 100, new City());
        });
        String expectedMessage = "Postal code 100 is invalid.";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testingAddressTwo() {
        Address address2 = AddressFactory.build("150", "Greenpack", "20",
                "AvonMonth", 1200, new City());
        assertTrue(1000 <= address2.getPostalCode() && address2.getPostalCode() <= 9999);
    }

    @Test
    void testingAddressThree() {
        Address address3 = AddressFactory.build("475", "AvonSands", "20",
                "AvonMonth", 9500, new City());
        assertTrue(1000 <= address3.getPostalCode() && address3.getPostalCode() <= 9999);
    }
}