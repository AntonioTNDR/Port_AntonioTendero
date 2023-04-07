package Port_GUI;

public class Hub {
    private int NUM_ROWS = 10;
    private int NUM_COLUMNS = 12;
    private int PRIORITY1_COLUMN = 0;
    private int PRIORITY2_COLUMN = 1;
    private int PRIORITY3_START_COLUMN = 2;
    private Container[][] containers;
    public Hub(){
        containers = new Container[NUM_ROWS][NUM_COLUMNS];
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
    public void displayContainer(int id){
        boolean found = false;

        for(int i = 0; i<NUM_ROWS; i++){
            for(int j = 0; j<NUM_COLUMNS; j++){
                if(containers[i][j] != null && containers[i][j].getId()==id){
                    Container container = containers[i][j];
                    System.out.println(container.toString());
                    found = true;
                    break;
                }
            }
        }
        if(found) {
            return;
        }
        if(!found) {
            System.out.println("Container with ID:" + id + " not found in the hub");
        }
    }

    public int countContainersFromCountry(String countryName){
        int count = 0;
        for(int i = 0; i<NUM_ROWS; i++){
            for(int j = 0; j<NUM_COLUMNS; j++){
                if(containers[i][j] != null && containers[i][i].getCountryOforigin().equals(countryName)){
                    count++;
                }
            }
        }
        return count;
    }

    public boolean priority1Full(){
        for(int i = 0; i<NUM_ROWS; i++){
            if(containers[PRIORITY1_COLUMN][i] == null){
                return false;
            }
        }
        return true;
    }

    public boolean priority2Full(){
        for(int i = 0; i<NUM_ROWS; i++){
            if(containers[PRIORITY2_COLUMN][i]==null){
                return false;
            }
        }
        return true;
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