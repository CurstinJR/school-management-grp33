/**
 * @Author Ngonidzaishe Erica Chipato
 * 218327315
 * 17 June 2022
 * EmployeeAddressRepositoryTest.java
 */
package za.ac.cput.school_management_grp33.repository.employee;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import za.ac.cput.school_management_grp33.domain.employee.EmployeeAddress;
import za.ac.cput.school_management_grp33.domain.location.City;
import za.ac.cput.school_management_grp33.domain.lookup.Address;
import za.ac.cput.school_management_grp33.factory.employee.EmployeeAddressFactory;
import za.ac.cput.school_management_grp33.factory.lookup.AddressFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Transactional(propagation = Propagation.NOT_SUPPORTED)
class EmployeeAddressRepositoryTest {

    private final City city = City.builder().id("1").build();
    private final Address address = AddressFactory.build("50", "OceanTides", "35",
            "Sand-ville", 8002, city);
    private final EmployeeAddress employeeAddress = EmployeeAddressFactory.build("50", address);

    @Autowired
    private EmployeeAddressRepository employeeAddressRepository;

    @Test
    @Order(1)
    void save() {
        EmployeeAddress saveEmployeeAddress = employeeAddressRepository.save(employeeAddress);
        EmployeeAddress existEmployeeAddress = employeeAddressRepository.findById(saveEmployeeAddress.getStaffId()).orElseThrow();
        assertEquals(employeeAddress.getStaffId(), existEmployeeAddress.getStaffId());
    }

    @Test
    @Order(2)
    void findAll() {

        List<EmployeeAddress> employeeAddresses = employeeAddressRepository.findAll();
        assertTrue(employeeAddresses.size() >= 0);
    }

    @Test
    @Order(3)
    void findById() {
        String id = employeeAddress.getStaffId();
        // find the newly saved employee by id
        EmployeeAddress existEmployeeAddress = employeeAddressRepository.findById(id).orElseThrow();
        assertEquals(existEmployeeAddress.getStaffId(), employeeAddress.getStaffId());
    }

    @Test
    @Order(5)
    void deleteById() {
        String id = employeeAddress.getStaffId();
        EmployeeAddress existEmployeeAddress = employeeAddressRepository.findById(id).orElseThrow();

        employeeAddressRepository.deleteById(existEmployeeAddress.getStaffId());

        boolean isEmployeeAddressPresent = employeeAddressRepository.findById(id).isPresent();
        assertFalse(isEmployeeAddressPresent);
    }
}