package Inheritance.paragraph;

/**
 * Created by teacher on 05.02.17.
 */
public class Paragraph extends Text{
    String caption;

    public Paragraph(String text, String caption) {
        super(text);
        this.caption = caption;
    }

    public Paragraph(String caption) {
        super();
        this.caption = caption;
    }
    public Paragraph(){
        super();
        this.caption = "MyCaption";
    }

    public void changeCaption(String caption){
        this.caption = caption;
    }

    @Override
    public String toString() {
        return "caption: " + caption + "\n" + super.toString();
    }

    public Paragraph myClone(){
        return new Paragraph(text,caption);
    }
}
