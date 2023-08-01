import java.util.concurrent.TimeUnit;

public class Elevator {
    private int elevatorId; // Идентификатор кабины лифта
    private int maxFloor; // Максимальное кол-во этажей
    private int activeFloor; // Этаж на котором нах-ся лифт
    private String elevatorState; // Состояние лифта


    public Elevator(int elevatorId, int maxFloor, int activeFloor) {
        this.elevatorId = elevatorId;
        this.maxFloor = maxFloor;
        this.activeFloor = activeFloor;
        this.elevatorState = " Stoit zakritiy ";
    }

    //Метод перемещения лифта на необходимый этаж
    private void moveToFloor (int floor){
        while (activeFloor != floor){
            double crackDouble = Math.random() * 50; // Вероятность застрять в лифте
            int crack = (int) crackDouble;
            if (crack == 6){
                System.out.println(" Lift zastryal ");
                callDispatcher();
                crack++;
            }
            else if (activeFloor < floor ){
                activeFloor++;
            }
            else{
                activeFloor--;
            }
            System.out.println(" V danniy moment nahoditsya na " + activeFloor + " etazhe ");
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            elevatorState = " Stoit zakritiy ";
        }
        System.out.println(" Lift " + elevatorId + " priehal na nyzhniy " + activeFloor + " etazh ");
        pressButtonOpen();
        motionSensorOn();
        motionSensorOff();
        pressButtonClose();
    }

    //Закрытие дверей
    public void pressButtonClose(){
        System.out.println(" Dveri zakrivautsya ");
        elevatorState = " Dveri zakrivautsya ";
    }

    //Открытие дверей
    public void pressButtonOpen(){
        System.out.println(" Dveri otkrivautsya ");
        elevatorState = " Dveri otkrivautsya ";
    }

    //Датчик присутствия движения
    public void motionSensorOn(){
        System.out.println(" Datchik zafixiroval prisutsvie dvizheniya ");
    }

    //Датчик отсутствия движения
    public void motionSensorOff(){
        System.out.println(" Datchik zafixiroval otsutstvie dvizheniya ");
    }

    //Вызов диспетчера
    public void callDispatcher(){
        System.out.println(" Vizov dispetchera ");
    }

    //Метод, изменения состояние лифта, в зависимости от того, на каком этаже его вызывают
    //Тут можно было использовать тернарник, дабы убрать нагромождение ифами:
    // "elevatorState = floor > activeFloor ? "Поднимается вверх" : "Спускается вниз";"
    public void pressFloorButton (int floor) {
        if (floor >= 1 && floor <= maxFloor) {
            if (elevatorState.equals(" Stoit zakritiy ")){
                pressButtonOpen();
                if(floor > activeFloor){
                    elevatorState = " Podnimaetsya vverh ";
                }
                else if (floor < activeFloor){
                    elevatorState = " Spykaetsya vniz ";
                }
                motionSensorOn();
                motionSensorOff();
                System.out.println(" Lift " + elevatorId + elevatorState + " na " + floor + " etazh ");
                pressButtonClose();
                moveToFloor(floor);
            }
        };
    }
}
