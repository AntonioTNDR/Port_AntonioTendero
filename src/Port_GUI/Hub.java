package Port_GUI;

import java.util.Objects;

public class Hub {
    private final int NUM_ROWS = 10;
    private final int NUM_COLUMNS = 12;
    private final int PRIORITY1_COLUMN = 0;
    private final int PRIORITY2_COLUMN = 1;
    private final int PRIORITY3_START_COLUMN = 2;
    private Container[][] containers;
    public Hub(){
        containers = new Container[NUM_ROWS][NUM_COLUMNS];
    }

    public String displayHub(){
        String output = " ";
        for(int i = 0; i<NUM_ROWS; i++){
            for(int j = 0; j<NUM_COLUMNS; j++){
                output += containers[i][j];
            }
            output += "\n";
        }
        return output;
    }

    public void stackContainer(Container container){
        if(container.getPriority() == 1){
            for(int i = 0; i< NUM_COLUMNS; i++){
                if(containers[PRIORITY1_COLUMN][i] == null){
                    containers[PRIORITY1_COLUMN][i] = container;
                    break;
                }
            }
        }
        else if(container.getPriority() == 2){
            for(int i = 0; i< NUM_COLUMNS; i++){
                if(containers[PRIORITY2_COLUMN][i] == null){
                    containers[PRIORITY2_COLUMN][i] = container;
                    break;
                }
            }
        }
        else{
            for(int i = PRIORITY3_START_COLUMN; i<NUM_COLUMNS; i++){
                for(int j = 0; j<NUM_ROWS; j++){
                    if(containers[j][i] == null){
                        containers[j][i] = container;
                        return;
                    }
                }
            }
        }
    }

    public void removeContainer(int column){
        for(int i = 0; i<NUM_ROWS; i++){
            if(containers[i][column] != null){
                containers[i][column] = null;
            }
        }
    }
    public String displayContainer(int id){
        boolean found = false;
        String output = "";
        for(int i = 0; i<NUM_ROWS; i++){
            for(int j = 0; j<NUM_COLUMNS; j++){
                if(containers[i][j] != null && containers[i][j].getId()==id){
                    Container container = containers[i][j];
                    output += container.toString();
                    found = true;
                    break;
                }
            }
        }
        if(found) {
            return output;
        }
        if(!found) {
            return "Container with ID:" + id + " not found in the hub";
        }
        return "";
    }

    public int countContainersFromCountry(String countryName){
        int count = 0;
        for(int i = 0; i<NUM_ROWS; i++){
            for(int j = 0; j<NUM_COLUMNS; j++){
                if(containers[i][j] != null && Objects.requireNonNull(containers[i][i]).getCountryOforigin().equals(countryName)){
                    count++;
                }
            }
        }
        return count;
    }

    public boolean priority1Full(){
        for(int i = 0; i<NUM_ROWS; i++){
            if(containers[PRIORITY1_COLUMN][i] == null){
                return false; //if there is a space, it returns false
            }
        }
        return true; // if there isn't, it returns true
    }

    public boolean priority2Full(){
        for(int i = 0; i<NUM_ROWS; i++){
            if(containers[PRIORITY2_COLUMN][i]==null){
                return false;//if there is a space, it returns false
            }
        }
        return true;// if there isn't, it returns true
    }
    public boolean isHubFull(){
        for(int i = 0; i<NUM_ROWS; i++){
            for(int j = 0; j<PRIORITY3_START_COLUMN; j++){
                if(containers[i][j] == null){
                    return false; //if any space is empty, the hub is not full
                }
            }
        }
        return true; //all spaces are occupied
    }
}