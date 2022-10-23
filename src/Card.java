
public class Card {
    private int value;
     private String shape;

    public Card(String shape, int value){//פעולה בונה
        this.shape = shape;
        this.value = value;
    }
    public String getFullShape(){
        return this.shape;
    }

    public char getShape() {//returns the cards shape
        return this.shape.charAt(0);
    }

    public int getValue() {//returns the cards value
        return this.value;
    }

    public String toString(){//returns the cards shape and value
        return this.value+"-"+this.shape.charAt(0);
    }

    public boolean equals(Card card){//פעולה המקבלת קלף ומחזירה ובודקת האם הקלף שהתקבל הוא אותו הקלף כמו הקלף שעליו מופעלת הפעולה
        return card.value == this.value && card.shape.equals(this.shape);
    }
}