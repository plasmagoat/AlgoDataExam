package datastructure;

import java.util.Random;

public class FlagBuckets {
    private COLOR[] buckets;
    private int n;
    private enum COLOR {RED, WHITE, BLUE}


    public FlagBuckets(int n){
        this.buckets = new COLOR[n];
        this.n = n;
        fill();
    }

    public void sort(){
        //blue goes to the end
        //red stays
        //white moves to first white+1
        int counter = 0, end = n-1, firstwhite = -1;
        COLOR presentColor;
        while (counter <= end) {
            presentColor = color(counter);
            if(presentColor == COLOR.BLUE){
                swap(counter, end);
                end--;
            } else if(presentColor == COLOR.WHITE){
                if(firstwhite == -1) firstwhite = counter;
                counter++;
            } else {
                if(firstwhite != -1){
                    swap(counter, firstwhite);
                    firstwhite++;
                }
                counter++;
            }
        }
    }

    public COLOR color(int i){
        return buckets[i];
    }

    public void swap(int i, int j){
        COLOR c = buckets[i];
        buckets[i] = buckets[j];
        buckets[j] = c;
    }

    private void fill(){
        for (int i = 0; i < this.n; i++) {
            this.buckets[i] = randomColor();
        }
    }

    private COLOR randomColor(){
        int i = new Random().nextInt(COLOR.values().length);
        return COLOR.values()[i];
    }

    public void print(){
        for (int i = 0; i < this.n; i++) {
            System.out.print("{" + i + " : " + buckets[i] + "} ");
        }
    }
}
