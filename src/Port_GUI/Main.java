package Port_GUI;

public class Main {
    public static void main(String[] args){
        new Interface();
        Hub hub1 = new Hub();
        boolean hub1Full = hub1.isHubFull();
        System.out.println("Hub full: "+ hub1Full);
        Hub hub2 = new Hub();
        boolean hub2Full = hub2.isHubFull();
        System.out.println("Hub full: "+ hub2Full);
        Hub hub3 = new Hub();
        boolean hub3Full = hub3.isHubFull();
        System.out.println("Hub full: "+ hub3Full);
    }
}
