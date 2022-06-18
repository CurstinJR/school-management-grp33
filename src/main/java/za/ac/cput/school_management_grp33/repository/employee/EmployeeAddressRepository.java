/**
 * @Author Ngonidzaishe Erica Chipato
 * 218327315
 * 16 June 2022
 * EmployeeAddressRepository.java
 */
package za.ac.cput.school_management_grp33.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.school_management_grp33.domain.employee.EmployeeAddress;

import java.util.Optional;

public interface EmployeeAddressRepository extends JpaRepository<EmployeeAddress, String> {

    Optional<EmployeeAddress> findEmployeeAddressByStaffId(String staffId);
}