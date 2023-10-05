
public class WandOfKeySummoningRecipe extends Recipe{
    public WandOfKeySummoningRecipe(String ... ingredients) {
        super(false, "runed_stick", "phoenix_feather", "sapphire", "unicorn_tears");
    }

    @Override
    public void combineInRoom(Room room) {
        System.out.println("Wand of Key had been combined");
        WandOfKeySummoning wand = new WandOfKeySummoning("wand_of_key_summoning", "this is a wand of key summoning");
        room.add(wand);
        removeIngredientsFromRoom(room);
    }
}
