package Shuffle;

import java.util.ArrayList;
import java.util.Random;

class Card{
    int num = -1;
    String name = "";
    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNum(int num) {
        this.num = num;
    }
}

public class Test {
    final static int SIZE = 60;

    static ArrayList<Card> shuffle(ArrayList<Card> listOfCards)
    {
        ArrayList<Card> shuffled = new ArrayList<Card>();

        Random rand = new Random();
        int int_random;

        for(int i = 0; i < SIZE ; i++) {
            int_random = rand.nextInt(SIZE-i);
            shuffled.add(listOfCards.get(int_random));
            listOfCards.remove(int_random);
        }
        return shuffled;
    }
    static boolean isDuplicate(ArrayList<Card> listOfCards){
        Card current;
        if(listOfCards.size() != 1){
            for(int i = 0; i<listOfCards.size(); i++){
                current = listOfCards.get(i);
                for(int j = i; j < listOfCards.size()-1 ; j++){
                    if(current == listOfCards.get(j+1)){
                        return true;
                    }
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {

        ArrayList<Card> cards = new ArrayList<Card>();
        String deckCode = "4 Soaring Thought-Thief (ZNR) 236\n" +
                "3 Swamp (M21) 311\n" +
                "4 Oona's Blackguard (JMP) 261\n" +
                "2 Brazen Borrower (ELD) 39\n" +
                "3 Into the Story (ELD) 50\n" +
                "4 Merfolk Windrobber (ZNR) 70\n" +
                "3 Thieves' Guild Enforcer (M21) 125\n" +
                "1 Rankle, Master of Pranks (ELD) 101\n" +
                "1 Watery Grave (GRN) 259\n" +
                "3 Zareth San, the Trickster (ZNR) 242\n" +
                "4 Drown in the Loch (ELD) 188\n" +
                "3 Thoughtseize (AKR) 127\n" +
                "4 Clearwater Pathway (ZNR) 260\n" +
                "4 Fabled Passage (M21) 246\n" +
                "3 Thought Erasure (GRN) 206\n" +
                "3 Island (M21) 310\n" +
                "1 Hagra Mauling (ZNR) 106\n" +
                "1 Agadeem's Awakening (ZNR) 90\n" +
                "3 Slither Blade (AKR) 79\n" +
                "4 Temple of Deceit (THB) 245\n" +
                "1 Glasspool Mimic (ZNR) 60\n" +
                "1 Sea Gate Restoration (ZNR) 76";
        String[] deck = deckCode.split("\n");

        int counter;
        for(int i = 0; i < deck.length; i++){

            counter = (deck[i].charAt(0))-48;

            for(int j = 0; j < counter; j++){
                Card tmp = new Card();
                tmp.setNum(i);
                tmp.setName(deck[i].substring(2));
                cards.add(tmp);
            }


        }
        cards = shuffle(cards);
        for(int i = 0; i < SIZE; i++){

            System.out.println(cards.get(i).getName() + "\s");

        }
        System.out.println(isDuplicate(cards));

    }
}
