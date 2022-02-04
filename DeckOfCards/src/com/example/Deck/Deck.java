package com.example.Deck;

public class Deck {

    public int num = 52;
    Card d[] = new Card[num];

    public Deck(){
        int pos = 0;
        for (int i = 1; i <= 13; i++){
            d[pos] = new Card("clubs", i);
            pos++;
        }
        for (int i = 1; i <= 13; i++){
            d[pos] = new Card("hearts", i);
            pos++;
        }
        for (int i = 1; i <= 13; i++){
            d[pos] = new Card("diamonds", i);
            pos++;
        }
        for (int i = 1; i <= 13; i++){
            d[pos] = new Card("spades", i);
            pos++;
        }
    }

    public String toString(){
        String res = "";
        for (int i = 0; i <= num-1; i++) {
            res += d[i].toString() + " " + '\n';
        }
        return res;
    }

    public String getRandom(){
        return d[(int)(Math.random()*num-1)].toString();
    }

    public Card[] getFirstN(int n){
        Card res[]= new Card[n];
        for (int i = 0; i <= n -1; i++){
            res[i] = d[i];
        }
        return res;
    }

    public void shuffle(){
        Card c1[];
        Card c2[];
        int pos;
        int ran1;
        int ran2;
        for (int i = 1; i <= 10000; i++) {
            ran1 = (int) (Math.random() * num/2);
            ran2 = (int) (Math.random() * num/2);
            if (ran1 == 0){
                ran1++;
            }
            if (ran2 == 0){
                ran2++;
            }
            c1 = new Card[ran1];
            c2 = new Card[ran2];
            pos = 0;
            for (int j = 0; j <= ran1 - 1; j++) {
                c1[pos] = new Card(d[j].getSuit(), d[j].getNum());
                pos++;
            }
            pos = 0;
            for (int j = ran1; j <= ran1 + ran2 - 1; j++) {
                c2[pos] = new Card(d[j].getSuit(), d[j].getNum());
                pos++;
            }
            pos = 0;
            for (int j = 0; j <= ran2 - 1; j++){
                d[j] = c2[pos];
                pos++;
            }
            pos = 0;
            for (int j = ran2; j <= ran2 + ran1 - 1; j++){
                d[j] = c1[pos];
                pos++;
            }
        }
    }

    public void sort(){
        Card temp;
        for (int i = 0; i <= num - 1; i++){
            for (int j = 0; j <= num - 1; j++){
                if (d[i].getNum() < d[j].getNum()){
                    temp = d[i];
                    d[i] = d[j];
                    d[j] = temp;
                }
            }
        }
    }

    public static void main(String[]args){
        Deck g = new Deck();
        System.out.println(g);
        g.getFirstN(5);
        g.getRandom();
        g.shuffle();
        System.out.println(g);
    }
}
