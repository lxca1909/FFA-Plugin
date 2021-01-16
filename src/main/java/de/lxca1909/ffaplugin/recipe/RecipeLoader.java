package de.lxca1909.ffaplugin.recipe;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class RecipeLoader {

    public void registerRecipes() {
    ItemStack Soup = new ItemStack(Material.MUSHROOM_STEW);
    ItemMeta SoupMeta = Soup.getItemMeta();
    Soup.setItemMeta(SoupMeta);
    ShapelessRecipe cocoarecipe = new ShapelessRecipe(Soup);
    cocoarecipe.addIngredient(Material.BOWL);
    cocoarecipe.addIngredient(Material.COCOA_BEANS);

    ShapelessRecipe cactusrecipe = new ShapelessRecipe(Soup);
    cactusrecipe.addIngredient(Material.BOWL);
    cactusrecipe.addIngredient(Material.CACTUS);

    ShapelessRecipe nethermushrooms = new ShapelessRecipe(Soup);
    nethermushrooms.addIngredient(Material.BOWL);
    nethermushrooms.addIngredient(Material.WARPED_FUNGUS);
    nethermushrooms.addIngredient(Material.CRIMSON_FUNGUS);

    ShapelessRecipe warpedwithbrown = new ShapelessRecipe(Soup);
    warpedwithbrown.addIngredient(Material.BOWL);
    warpedwithbrown.addIngredient(Material.WARPED_FUNGUS);
    warpedwithbrown.addIngredient(Material.BROWN_MUSHROOM);

    ShapelessRecipe warpedwithred = new ShapelessRecipe(Soup);
    warpedwithred.addIngredient(Material.BOWL);
    warpedwithred.addIngredient(Material.WARPED_FUNGUS);
    warpedwithbrown.addIngredient(Material.RED_MUSHROOM);

    ShapelessRecipe crimsonwithbrown = new ShapelessRecipe(Soup);
    crimsonwithbrown.addIngredient(Material.BOWL);
    crimsonwithbrown.addIngredient(Material.CRIMSON_FUNGUS);
    crimsonwithbrown.addIngredient(Material.BROWN_MUSHROOM);

    ShapelessRecipe crimsonwithred = new ShapelessRecipe(Soup);
    crimsonwithred.addIngredient(Material.BOWL);
    crimsonwithred.addIngredient(Material.CRIMSON_FUNGUS);
    crimsonwithred.addIngredient(Material.RED_MUSHROOM);

        Bukkit.addRecipe(cocoarecipe);
        Bukkit.addRecipe(cactusrecipe);
        Bukkit.addRecipe(nethermushrooms);
        Bukkit.addRecipe(crimsonwithbrown);
        Bukkit.addRecipe(crimsonwithred);
        Bukkit.addRecipe(warpedwithbrown);
        Bukkit.addRecipe(warpedwithred);
}

}
