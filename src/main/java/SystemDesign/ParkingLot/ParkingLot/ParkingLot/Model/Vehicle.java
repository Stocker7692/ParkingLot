package SystemDesign.ParkingLot.ParkingLot.ParkingLot.Model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Vehicle {
    String vehicleNumber;
    VehicleCategory vehicleCategory;

}
