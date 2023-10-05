import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public abstract class Recipe {
    /** The ingredients required for this recipe */
    private List<String> ingredients;

    /** Whether or not the order of the items listed in the recipe matters */
    private boolean orderMatters;

    /**
     * Creates a recipe with the given orderMatters and list of ingredients. Recipes must contain at least two ingredients
     * and each ingredient must be unique.
     * @param orderMatters whether the order the ingredients are listed in matters
     * @param ingredients the list of ingredients
     * @throws IllegalArgumentException if the recipe does not contain at least two ingredients or if the names are not unique
     */
    public Recipe(boolean orderMatters, String... ingredients) {
        if (ingredients.length < 2) {
            throw new IllegalArgumentException("Recipes must have at least two ingredients");
        }
        this.ingredients = new ArrayList<>(Arrays.asList(ingredients));
        if (new HashSet<String>(this.ingredients).size() < this.ingredients.size()) {
            throw new IllegalArgumentException("Each item name in a recipe must be unique. Ingredients: " + this.ingredients);
        }
        this.orderMatters = orderMatters;
    }

    /**
     * Returns true if the names of the items match the ingredients (including the order if it matters)
     * and false otherwise. Each item name in a recipe must be unique and each item in a room must have
     * a unique name, so we don't need to worry about multiple items or ingredients with the same name.
     * The items must be exactly the correct items with no extra items though.
     * @param items the list of items to compare with the recipe ingredients
     * @return true if the names of the items match the ingredients (including the order if it matters)
     * and false otherwise
     */
    public boolean matchesItems(List<Item> items) {
        System.out.println(items);
        System.out.println(ingredients);
        boolean counter = true;
        int count = 0;
        if(items.size() != ingredients.size()) {
            counter = false;
        }else if(orderMatters() == true) {
            for(int i = 0; i <= items.size()-1;i++) {
                if(ingredients.get(i) == items.get(i).getName()) {
                    count = count;
                }else{
                    count++;
                }
            }
            if(count == 0){
                counter = true;
            }else{
                counter = false;
            }
        }else {
            for(int i = 0; i <= items.size()-1; i++) {
                for(int j = 0; j <= items.size()-1; j++){
                    if(ingredients.get(i) == items.get(j).getName()) {
                        count++;
                    }
                }
            }
            if(count == items.size()) {
                counter = true;
            }else {
                counter = false;
            }
        }
        return counter;
        // Implement the method as described in the javadoc comment above
    }

    public abstract void combineInRoom(Room room);

    /**
     * removes the ingredients in this recipe from the given room. The combineInRoom method may call this
     * if the items are supposed to be consumed in the recipe.
     * @param room the room to remove the items from
     */
    public void removeIngredientsFromRoom(Room room) {
        for (String ingredient : ingredients) {
            room.remove(room.getItem(ingredient));
        }
    }

    /**
     * Returns a list of the ingredients in this recipe.
     * @return a list of the ingredients in this recipe.
     */
    protected List<String> getIngredients() {
        return new ArrayList<>(ingredients);
    }

    /**
     * Returns whether or not the order of the items matters in the recipe
     * @return whether or not the order of the items matters in the recipe
     */
    public boolean orderMatters() {
        return orderMatters;
    }

}
