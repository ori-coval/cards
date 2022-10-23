public class Deck {
    private Card[] arr;
    private static final int SIZE=20;
    private int lastCard;

    public Deck(){//פעולה בונה
        this.arr=new Card[SIZE];
        this.lastCard=0;
    }

    public int getSIZE() {// arr מחזיר את גודל המערך
        return SIZE;
    }

    public boolean isEmpty(){//בודק האם המערך arr ריק
        if(this.lastCard==0){
            return true;
        }
        return false;
    }

    public void add(Card c){//מקבל קלף ומכניס את הקלף למערך arr
        this.arr[this.lastCard]=c;
        this.lastCard++;
    }

    public Card getCard(){//הפעולה מוציאה את הקלף הראשון במערך ומחזירה אותו
        Card temp=this.arr[0];
        for (int i=0;i<this.lastCard-1;i++){

            this.arr[i]=this.arr[i+1];
        }
        this.arr[SIZE-1]=null;
        this.lastCard--;
        return temp;
    }

    public Card getCard(int value){//הפעולה מקבלת מספר שלם ומוציאה ומחזירה את הקלף הראשון במערך שהשווי שלו שווה למספר
        Card temp=null;
        for(int i=0;i<this.lastCard;i++){
            if(this.arr[i].getValue()==value){
                temp=this.arr[i];
                for (int j=i;j<this.lastCard-1;j++){
                    this.arr[j]=this.arr[j+1];
                }
                this.arr[SIZE-1]=null;
                lastCard=lastCard-1;
            }
        }
        return temp;
    }

    public Card getCard(String shape){//הפעולה מקבלת מחרוזת של צורה ומוציאה ומחזירה את הקלף הראשון שהצורה שלו היא אותה צורה כמו המחרוזת
        for (int i=0;i<this.lastCard;i++){
            if (this.arr[i].getShape()==shape.charAt(0)){
                Card temp=this.arr[i];
                this.arr[i]=null;
                return this.arr[i];
            }
        }
        return null;
    }

    public Card winCard(){//פעולה המחזירה את הקלף הכי חזק במערך
        return CardMain.winCard(this.arr);
    }

    public void fillArrDeck(){//פעולה שממלאת את המערך arr
        Card newCard=CardMain.getCard();
        this.arr[0]=newCard;

        while (this.arr[this.getSIZE()-1]==null){//works until the last card in the array is not empty
            newCard=CardMain.getCard();
            if(!CardMain.exist(this.arr,this.lastCard,newCard)){//work only if the new card is not in the array
                this.arr[this.lastCard]=newCard;//enter the new card to the array
                this.lastCard++;
            }
        }
    }

    public String toString(){//הפעולה מחזירה מחרוזת של השווי והצורה של כל הקלפים במערך
        //return CardMain.showArrCard(this.arr);

        String str="";
        for(int i=0;i<this.lastCard;i++){
            if(arr[i]!=null)
                str+=String.valueOf(this.arr[i].getValue())+" - "+this.arr[i].getShape();
        }
        return str;
    }

    public boolean exist(Card c){//פעולה המקבלת קלף ומחזירה האם הקלף כבר קיים במערך
        for (int i=0;i<this.lastCard;i++){
            if (this.arr.equals(c)){
                return true;
            }
        }
        return false;
    }

    public boolean exist(int value, char shape){//פעולה המקבלת ערך וצורה של קלף ובודקת האם יש במערך קלף דומה
        for (int i=0;i<this.lastCard;i++){
            if (this.arr[i].getValue()==value&&this.arr[i].getShape()==shape){
                return true;
            }
        }
        return false;
    }

    public boolean isTerza(Card c){//פעולה שמקבלת קלף ובודקת האם יש במערך קלפים שיכולים להשלם בעזרתו לשלישייה
        int sameValue=0,
                sameShape=0;
        if(exist(c.getValue()-2, c.getShape())&&exist(c.getValue()-1, c.getShape()))
            return true;
        if(exist(c.getValue()-1, c.getShape())&&exist(c.getValue()+1, c.getShape()))
            return true;
        if(exist(c.getValue()+1, c.getShape())&&exist(c.getValue()+2, c.getShape()))
            return true;


        for(int i=0;i<this.lastCard;i++){
            if(this.arr[i].getValue()==c.getValue())
                sameValue++;
        }
        return sameValue>=2;
    }
}
