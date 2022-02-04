package com.example.Deck;

public class Card {

    private String suit;
    private int num;

    public Card(String suit, int num){
        this.suit = suit;
        this.num = num;
    }

    public String toString(){
        return suit + " " + num;
    }

    public int getNum(){
        return num;
    }

    public String getSuit(){
        return suit;
    }

}
