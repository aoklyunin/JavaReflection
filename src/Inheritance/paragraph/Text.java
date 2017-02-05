package Inheritance.paragraph;

/**
 * Created by teacher on 05.02.17.
 */
public class Text {
    String text;

    public Text(String text) {
        this.text = text;
    }

    public Text() {
        this.text = "";
    }

    public void appendText(String s){
        this.text+=s;
    }

    @Override
    public String toString() {
        return "text: " + text;
    }

    public Text myClone(){
        return new Text(text);
    }
}
