/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model_22135;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Mirindi
 */
@Entity
public class Car_22135 {
    @Id
    private String plate_Number;
    private LocalDate manafacturing_date;
    private Long cost;
    private String institution;

    public Car_22135() {
    }

    public Car_22135(String plate_Number) {
        this.plate_Number = plate_Number;
    }

    public Car_22135(String plate_Number, LocalDate manafacturing_date, Long cost, String institution) {
        this.plate_Number = plate_Number;
        this.manafacturing_date = manafacturing_date;
        this.cost = cost;
        this.institution = institution;
    }

    public String getPlate_Number() {
        return plate_Number;
    }

    public void setPlate_Number(String plate_Number) {
        this.plate_Number = plate_Number;
    }

    public LocalDate getManafacturing_date() {
        return manafacturing_date;
    }

    public void setManafacturing_date(LocalDate manafacturing_date) {
        this.manafacturing_date = manafacturing_date;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }
    
    
}
