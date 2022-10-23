import java.util.Date;
import  java.util.Random;
public class CardMain {
    static Random rnd = new Random();

    public static void main(String[] args) {
        //תרגיל 2
        System.out.println("------------exercise 2 ---------------------");
        Card card1 = getCard();
        Card card2 = getCard();

        //prints the 2 cards
        System.out.println("card 1= "+ card1);
        System.out.println("card 2= "+ card2);

        //prints the stronger card
        System.out.println("the wining card is "+stronger(card1,card2));

        //תרגיל 3
        System.out.println("------------exercise 3 ---------------------");
        //initialize for the variables
        Card[] tenCards=new Card[10];
        Card newCardForTenCards = getCard();
        int tenCardsIndex=1;

        //enter the first card to the array so the array won't be empty
        tenCards[0]=newCardForTenCards;


        while (tenCards[9]==null){//works until the last card in the array is not empty
            newCardForTenCards=getCard();
            if(!exist(tenCards,tenCardsIndex,newCardForTenCards)){//work only if the new card is not in the array
                tenCards[tenCardsIndex]=newCardForTenCards;//enter the new card to the array
                tenCardsIndex++;
            }
        }

        //initialize for the variables
        Card biggestCard=tenCards[0];
        int biggestCardIndex=0;

        //checks what is the strongest card in the array
        for (int i=1;i<tenCards.length;i++){
            biggestCard=stronger(tenCards[biggestCardIndex],tenCards[i]);
            if(tenCards[i]==biggestCard){
                biggestCardIndex=i;
            }
        }

        //prints the entire array
        for(int i=0;i<tenCards.length;i++){
            System.out.print(tenCards[i].toString()+" ");
        }
        System.out.println();
        System.out.println(tenCards[biggestCardIndex].toString());//prints the strongest card in the array

        //תרגיל 4
        System.out.println("------------exercise 4 ---------------------");
        //initialize for the variables
        Card[] deckOfCards=new Card[52];
        Card newCardForDeck = getCard();
        int deckOfCardsIndex=1;

        //enter the first card to the array so the array won't be empty
        deckOfCards[0]=newCardForDeck;

        while (deckOfCards[51]==null){//works until the last card in the array is not empty
            newCardForDeck=getCard();
            if(!exist(deckOfCards,deckOfCardsIndex,newCardForDeck)){//work only if the new card is not in the array
                deckOfCards[deckOfCardsIndex]=newCardForDeck;//enter the new card to the array
                deckOfCardsIndex++;
            }
        }

        for(int i=0;i<deckOfCards.length;i++){//prints the deck of cards
            System.out.println(deckOfCards[i].toString()+" ");
        }

        //DECK תרגיל 2
        //פעולה המגרילה מספר בין 2 ל14 ומעבירה את הקלף הראשון בחבילה עם הערך הזה לסוף החבילה
        System.out.println("------------exercise Deck 2 ---------------------");
        //initialize for the variables
        Deck deck1=new Deck();
        fillArrCard(deck1);

        System.out.println(deck1.toString());
        int val= rnd.nextInt(12)+2;
        Card temp = deck1.getCard(val);
        if(temp!=null){
            deck1.add(temp);
        }

        System.out.println(deck1.toString());


        //chkCard
        System.out.println("------------exercise chkCard ---------------------");
        Card[] arr = new Card[10];
        fillArrCard(arr);
        System.out.println(showArrCard(arr));
        Card c=winCard(arr);
        System.out.println("stronger card is: "+c.toString());

        //chkDeck
        System.out.println("------------exercise chkDeck ---------------------");
        Deck deck = new Deck();
        deck.fillArrDeck();
        System.out.println(deck.toString());
        Card c1 = deck.winCard();
        System.out.println("stronger card is:"+c1.toString());


        System.out.println("------------exercise isTerza ---------------------");
        Deck deck3 = new Deck();
        deck3.fillArrDeck();
        System.out.println(deck3.toString());
        Card card3 = getCard();
        System.out.println(card3.toString());
        if (deck3.isTerza(card3))
            System.out.println("terza is possible");
        else System.out.println("terza is not possible");
    }

    public static Card winCard(Card[] arr){//פעולה המקבלת צערך ומחזירה את הקלף הכי חזק במערך
        Card biggestCard=arr[0];
        int biggestCardIndex=0;
        for (int i=1;i<arr.length-1;i++){
            biggestCard=stronger(arr[biggestCardIndex],arr[i]);
            if(arr[i]==biggestCard){
                biggestCardIndex=i;
            }
        }
        return biggestCard;
    }
    public static void fillArrCard(Card[] arr){// פעולה שמקבלת מערך וממלאת אותו בקלפים אקראיים
        int arrIndex=01;
        Card newCard=getCard();
        arr[0]=newCard;

        while (arr[arr.length-1]==null){//works until the last card in the array is not empty
            newCard=getCard();
            if(!exist(arr,arrIndex,newCard)){//work only if the new card is not in the array
                arr[arrIndex]=newCard;//enter the new card to the array
                arrIndex++;
            }
        }
    }

    public static String showArrCard(Card[] arr){//פעולה המקבלת מערך קלפים ומחזירה מחרוזת של כל הקלפים במערך
        String str="";
        for(int i=0;i<arr.length-1;i++){
            str+=String.valueOf(arr[i].getValue())+"-"+arr[i].getShape()+" ";
        }
        return str;
    }

    public static Card getCard(){//creating a random card
        String[] shapes = {"Spade","Hearts","Diamond","Club"};
        int cardValue = rnd.nextInt(13)+2;
        int shapeInt = rnd.nextInt(4);
        String shapeString=shapes[shapeInt];
        return new Card(shapeString,cardValue);
    }

    public  static void fillArrCard(Deck deck1){
        deck1.add(getCard());
        int deck1Index=1;
        Card newCardForDeck1=getCard();
        for (int i=1;i<11;i++){
            newCardForDeck1=getCard();
            while (deck1.exist(newCardForDeck1)){
                newCardForDeck1=getCard();
            }
            deck1.add(newCardForDeck1);
        }
    }

    public  static Card stronger(Card card1,Card card2){//checking what card is stronger
        int card1Shape=0;
        int card2Shape=0;


        if(card1.getValue()>card2.getValue()) {
            return card1;
        }
        else  if(card2.getValue()>card1.getValue()){
            return card2;
        }

        //assigning a value to the cards shape
        if(card1.getShape()=='S')card1Shape=1;
        if(card1.getShape()=='H')card1Shape=2;
        if(card1.getShape()=='D')card1Shape=3;
        if(card1.getShape()=='C')card1Shape=4;

        if(card2.getShape()=='S')card1Shape=1;
        if(card2.getShape()=='H')card1Shape=2;
        if(card2.getShape()=='D')card1Shape=3;
        if(card2.getShape()=='C')card1Shape=4;

        if(card1Shape>card2Shape){
            return card1;
        }

        return card2;
    }

    //check if the card already exist in the array
    public static boolean exist(Card[] deckOfCards,int deckOfCardsIndex, Card card){
        for(int i=0;i<deckOfCardsIndex;i++){
            if(deckOfCards[i]!=null) {
                if (card.equals(deckOfCards[i])) {
                    return true;
                }
            }
        }
        return false;
    }
}
