
public class WandOfKeySummoning extends Item{
    String name;
    String description;
    public WandOfKeySummoning(String name, String description) {
        super(name, description);
    }
    
    @Override
    public void use() {
        System.out.println("Gold sparkles burst from the wand! A gold key appears. This appears to be the key to the door.");
        room.escaped();
        UselessItem gold_key = new UselessItem("gold_key", getDescription());
        room.add(gold_key);
    }
}
