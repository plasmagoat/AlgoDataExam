package analysis;

public class Egg {

    private int nooffloors;
    private int secretfloor;
    private int flowbuilding;
    private int fhighbuilding;
    private int egglowbuilding = 0;
    private int egghighbuilding = 0;
    private int low, high;

    public Egg(int nooffloors, int secretfloor){
        this.nooffloors = nooffloors;
        this.secretfloor = secretfloor;
        egg1();
        System.out.println("Low; N = " + nooffloors + " F = " + secretfloor + ". Eggs used = " + egglowbuilding);
        egg2();
        System.out.println("High; N = " + nooffloors + " F = " + secretfloor + ". Eggs used = " + egghighbuilding);
    }

    public void egg1(){
        low = 1;
        high = nooffloors;
        while (high - low > 1){
            flowbuilding = (low + high) / 2;
            if(flowbuilding >= secretfloor) {
                egglowbuilding++;
                high = flowbuilding;

            } else {
                low = flowbuilding;
            }
        }
        flowbuilding = high;
    }

    public void egg2(){
        low = 0;
        high = 1;
        while (high < secretfloor){
            low = high;
            high = 2 * high;
            if(high > nooffloors) high = nooffloors;
        }
        egghighbuilding++;
        while (high - low > 1){
            fhighbuilding = (low + high) / 2;
            if(fhighbuilding >= secretfloor) {
                egghighbuilding++;
                high = fhighbuilding;

            } else {
                low = fhighbuilding;
            }
        }
        fhighbuilding = high;

    }
}
