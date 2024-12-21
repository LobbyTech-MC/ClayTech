package cn.claycoffee.ClayTech.utils;

import cn.claycoffee.ClayTech.ClayTech;

import java.util.List;

public class Lang {
    public static String rocketPrefix = readGeneralText("RocketPrefix");
    public static String spaceSuitPrefix = readGeneralText("SpaceSuitPrefix");
    public static String oxygenDistributerPrefix = readGeneralText("OxygenDistributerPrefix");

    public static String readItemText(String name) {
        ClayTech.getLocalizationService().getString("Items." + name);
        return ClayTech.getLocalizationService().getString("Items." + name);
    }

    public static List<String> readItemLore(String name) {
        ClayTech.getLocalizationService().getString("Items." + name + "_LORE");
        return ClayTech.getLocalizationService().getStringList("Items." + name + "_LORE");
    }

    public static String readGeneralText(String name) {
        ClayTech.getLocalizationService().getString("General." + name);
        return ClayTech.getLocalizationService().getString("General." + name).replaceAll("&", "§");
    }

    public static String readCategoriesText(String name) {
        ClayTech.getLocalizationService().getString("Categories." + name);
        return ClayTech.getLocalizationService().getString("Categories." + name).replaceAll("&", "§");
    }

    public static String readResearchesText(String name) {
        ClayTech.getLocalizationService().getString("Researches." + name);
        return ClayTech.getLocalizationService().getString("Researches." + name).replaceAll("&", "§");
    }

    public static String readMachinesText(String name) {
        ClayTech.getLocalizationService().getString("Machines." + name);
        return ClayTech.getLocalizationService().getString("Machines." + name).replaceAll("&", "§");
    }

    public static String readMachineRecipesText(String name) {
        ClayTech.getLocalizationService().getString("MachineRecipes." + name);
        return ClayTech.getLocalizationService().getString("MachineRecipes." + name).replaceAll("&", "§");
    }

    public static String readPlanetsText(String name) {
        ClayTech.getLocalizationService().getString("Planets." + name);
        return ClayTech.getLocalizationService().getString("Planets." + name).replaceAll("&", "§");
    }

    public static String readResourcesText(String name) {
        ClayTech.getLocalizationService().getString("Planets." + name);
        return ClayTech.getLocalizationService().getString("Planets." + name).replaceAll("&", "§");
    }

}
