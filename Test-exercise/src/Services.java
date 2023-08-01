
import java.util.Scanner;

public class Services {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while ( i < 100 ) {

            System.out.println(" -Zapystit svoy scenariy : (1)- \n -Zapustit' simulyaciyu : (2)- \n -Ostanovit programmu : (3)- ");
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Vvedite maximalnoe kol-vo etazhey v dome:");
                int maxFloor = scanner.nextInt();

                System.out.print("Vvedite kol-vo liftov : ");
                int numElevator = scanner.nextInt();

                System.out.print("Vvedite nomer lifta : ");
                int elevatorId = scanner.nextInt();

                System.out.print("Vvedite etazh na kotorom nahoditsya lift :");
                int activeFloor = scanner.nextInt();

                System.out.print("Vvedite etazh na kotoriy vam nuzhno:");
                int floor = scanner.nextInt();

                Display display = new Display(maxFloor, numElevator);
                Elevator elevator = new Elevator(elevatorId, maxFloor, activeFloor);
                display.pressCallButton(floor);
                elevator.pressFloorButton(floor);

            } else if (choice == 2) {
                int maxFloors = 20;
                int numElevator = 2;
                Display elevatorSystem = new Display(maxFloors, numElevator);
                elevatorSystem.simulateAction();
            }
            else if (choice == 3) {
                System.exit(0);
            }
            else {
                System.out.print("1 ili 2");
            }

            i++;
        }
    }

}
