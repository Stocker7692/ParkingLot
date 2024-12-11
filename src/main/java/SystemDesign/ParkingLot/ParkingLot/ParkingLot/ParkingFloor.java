package SystemDesign.ParkingLot.ParkingLot.ParkingLot;

import SystemDesign.ParkingLot.ParkingLot.ParkingLot.Model.ParkingSlotType;
import SystemDesign.ParkingLot.ParkingLot.ParkingLot.Model.Vehicle;
import SystemDesign.ParkingLot.ParkingLot.ParkingLot.Model.VehicleCategory;

import java.util.Map;

public class ParkingFloor {

    String name;
    Map<ParkingSlotType, Map<String, ParkingSlot>> parkingSlots; // string-ParkingSlot name, ParkingSLot->itself
    public ParkingFloor(String name, Map<ParkingSlotType,Map<String,ParkingSlot>> parkingSlots){
        this.name=name;
        this.parkingSlots=parkingSlots;
    }

    public ParkingSlot getRelevantSlotForVehicleAndPark(Vehicle vehicle){
        VehicleCategory vehicleCategory = vehicle.getVehicleCategory();
        ParkingSlotType parkingSlotType = pickCorrectSlot(vehicleCategory);
        Map<String, ParkingSlot> relevantParkingSlot = parkingSlots.get(parkingSlotType);
        ParkingSlot slot = null;
        for(Map.Entry<String,ParkingSlot> m: relevantParkingSlot.entrySet()){
            if(m.getValue().isAvailable){
                slot = m.getValue();
                slot.addVehicle(vehicle);
                break;
            }
        }
        return slot;

    }

    public ParkingSlotType pickCorrectSlot(VehicleCategory vehicleCategory){
        if(vehicleCategory.equals(VehicleCategory.TwoWheeler)) return ParkingSlotType.TwoWheeler;
        else if(vehicleCategory.equals(VehicleCategory.Hatchback) || vehicleCategory.equals(VehicleCategory.Sedan)) return ParkingSlotType.Compact;
        else if(vehicleCategory.equals(VehicleCategory.SUV)) return ParkingSlotType.Medium;
        else if(vehicleCategory.equals(VehicleCategory.Bus)) return ParkingSlotType.Large;

        return null;
    }
}
