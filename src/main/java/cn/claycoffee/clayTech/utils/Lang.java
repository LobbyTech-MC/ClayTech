package cn.claycoffee.clayTech.utils;

import cn.claycoffee.clayTech.ClayTech;

import java.util.List;

public class Lang {
    public static String rocketPrefix = readGeneralText("RocketPrefix");
    public static String spaceSuitPrefix = readGeneralText("SpaceSuitPrefix");
    public static String oxygenDistributerPrefix = readGeneralText("OxygenDistributerPrefix");

    public static String readItemText(String name) {
        return ClayTech.getLocalizationService().getString("Items." + name);
    }

    public static List<String> readItemLore(String name) {
        return ClayTech.getLocalizationService().getStringList("Items." + name + "_LORE");
    }

    public static String readGeneralText(String name) {
        return ClayTech.getLocalizationService().getString("General." + name);
    }

    public static String readCategoriesText(String name) {
        return ClayTech.getLocalizationService().getString("Categories." + name);
    }

    public static String readResearchesText(String name) {
        return ClayTech.getLocalizationService().getString("Researches." + name);
    }

    public static String readMachinesText(String name) {
        return ClayTech.getLocalizationService().getString("Machines." + name);
    }

    public static String readMachineRecipesText(String name) {
        return ClayTech.getLocalizationService().getString("MachineRecipes." + name);
    }

    public static String readPlanetsText(String name) {
        return ClayTech.getLocalizationService().getString("Planets." + name);
    }

    public static String readResourcesText(String name) {
        return ClayTech.getLocalizationService().getString("Resources." + name);
    }

}
