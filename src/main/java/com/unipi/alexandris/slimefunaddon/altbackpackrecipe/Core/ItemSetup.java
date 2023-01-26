package com.unipi.alexandris.slimefunaddon.altbackpackrecipe.Core;

import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.inventory.ItemStack;

import static org.bukkit.Material.BEDROCK;


public enum ItemSetup {
    INSTANCE;
    private boolean initialised;
    @SuppressWarnings("ConstantConditions")
    public void init() {
        if (initialised) return;

        initialised = true;

        SlimefunItems.BACKPACK_SMALL.getItem().setRecipe(new ItemStack[]{
                null, null, null,
                null, new ItemStack(BEDROCK), null,
                null, null, null
        });

        SlimefunItems.BACKPACK_SMALL.getItem().setRecipeType(RecipeType.NULL);

        SlimefunItems.BACKPACK_MEDIUM.getItem().setRecipe(new ItemStack[]{
                SlimefunItems.BACKPACK_SMALL, SlimefunItems.BACKPACK_SMALL, null,
                SlimefunItems.BACKPACK_SMALL, SlimefunItems.BACKPACK_SMALL, null,
                null, null, null
        });
        SlimefunItems.BACKPACK_LARGE.getItem().setRecipe(new ItemStack[]{
                SlimefunItems.BACKPACK_MEDIUM, SlimefunItems.BACKPACK_MEDIUM, null,
                SlimefunItems.BACKPACK_MEDIUM, SlimefunItems.BACKPACK_MEDIUM, null,
                null, null, null
        });
        SlimefunItems.WOVEN_BACKPACK.getItem().setRecipe(new ItemStack[]{
                SlimefunItems.BACKPACK_LARGE, SlimefunItems.BACKPACK_LARGE, null,
                SlimefunItems.BACKPACK_LARGE, SlimefunItems.BACKPACK_LARGE, null,
                null, null, null
        });
        SlimefunItems.GILDED_BACKPACK.getItem().setRecipe(new ItemStack[]{
                SlimefunItems.WOVEN_BACKPACK, SlimefunItems.WOVEN_BACKPACK, null,
                SlimefunItems.WOVEN_BACKPACK, SlimefunItems.WOVEN_BACKPACK, null,
                null, null, null
        });
        SlimefunItems.RADIANT_BACKPACK.getItem().setRecipe(new ItemStack[]{
                SlimefunItems.GILDED_BACKPACK, SlimefunItems.GILDED_BACKPACK, null,
                SlimefunItems.GILDED_BACKPACK, SlimefunItems.GILDED_BACKPACK, null,
                null, null, null
        });
    }
}
