public class Display {
    private int numFloors;
    private int numElevator;
    private Elevator[] elevators;
    private boolean[] callButtons;

    public Display(int numFloors, int numElevator) {
        this.numFloors = numFloors;
        this.numElevator = numElevator;
        this.elevators = new Elevator[numElevator];
        for(int i = 0 ; i < numElevator ; i++){
            this.elevators[i] = new Elevator(i+1, numFloors, 1);
        }
        this.callButtons = new boolean[numFloors];
    }

    public void pressCallButton(int floor) {
        if (floor >= 1 && floor <= numFloors) {
            callButtons[floor - 1] = true;
            System.out.println(" Lift vizvali na " + floor + " etazhe ");
        }
    }

    public void simulateAction(){
        int passangerA = 1;
        int destinationA = 18;
        pressCallButton(passangerA);
        elevators[0].pressFloorButton(destinationA);
    }
}
