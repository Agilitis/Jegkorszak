import java.util.HashMap;

public class Field {
    public Thing getThingOnField() {
        return thingOnField;
    }

    private Thing thingOnField = null;

    HashMap<Direction, Field> getNeighboors() {
        return neighboors;
    }

    private HashMap<Direction, Field> neighboors = null;


    Field(){
        neighboors = new HashMap<>();
    }

    void setThingOnField(Thing thingToAdd){
        thingOnField = thingToAdd;
    }

    Field getNeighboor(Direction d){
        return neighboors.get(d);
    }

    void addNeighboor(Direction direction, Field neighboorField){
        neighboors.put(direction,neighboorField);
    }
    void remove(Thing t){
        thingOnField = null;
    }

    void accept(Thing incomingThing, Direction direction){
        if(thingOnField != null){
            incomingThing.collideWith(thingOnField, direction);
        }else{
            thingOnField = incomingThing;
            incomingThing.replaceField(this);
        }
    }


    void announceIceCube() {
        neighboors.forEach((direction,field)->{
            if(field != null && field.thingOnField != null){
                field.thingOnField.handleIceCubeNeighborArrival();
            }
        });
    }


}
