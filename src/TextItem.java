
public class TextItem extends Item{
    String text;
    public TextItem(String name, String description, String txt) {
        super(name, description);
        text = txt;
    }
    @Override
    public void use() {
        System.out.println(text);
    }
}
