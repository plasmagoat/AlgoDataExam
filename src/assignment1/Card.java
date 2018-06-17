package com.company;

public class Card implements Comparable<Card>{

    private int rank;
    private SUIT suit;



    public enum SUIT {SPADE, CLUB, HEART, DIAMOND};

    public Card(int rank, SUIT suit){
        this.rank = rank;
        this.suit = suit;

    }

    public String showCard(){
        return "|" + this.suit + " : " + this.rank + "|";
    }

    @Override
    public int compareTo(Card o) {
        if(o.suit == this.suit){
            return Integer.compare(this.rank, o.rank);
        } else if(o.suit == SUIT.SPADE){
            return 1;
        } else if(o.suit == SUIT.HEART){
            if(this.suit == SUIT.SPADE){
                return -1;
            } else return 1;
        } else if(o.suit == SUIT.CLUB){
            if(this.suit == SUIT.DIAMOND){
                return 1;
            } else return -1;
        } else return -1;
    }


    //SPADES;HEARTS;CLUBS;DIAMONDS
    //♠♠♠♠♠;♥♥♥♥♥;♣♣♣♣♣;♦♦♦♦♦♦

}