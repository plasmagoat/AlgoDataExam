package com.company;

public class EggThrow {

    private int floors, f;

    EggThrow(int floors, int f){
        this.floors = floors;
        this.f = f;
    }

    public boolean throwEgg(int floor){
        if(floor > floors){
            return false;
        }
        return floor < f;
    }

    public int find(){
        int max = this.floors;
        int min = 0;
        boolean running = true;
        while (running){
            System.out.println(max + " : " + throwEgg(max));
            if(throwEgg(max)){
                running = false;
            } else {
                if(throwEgg(max) == false){
                    max = max/2;
                } else {
                    max += max/2;
                    //min = min + ((max-min)/2);
                }
            }
        }
        return max;
    }


}
