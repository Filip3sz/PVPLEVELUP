package pl.filipesz.pvplevelup.manager;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import pl.filipesz.pvplevelup.utils.UtilManager;

public class LevelManager {

    public static void levelStart(Player p) {
        level1(p);
        p.setLevel(1);
        UtilManager.sendTitle(p, "&8* &3Filipesz &8*");
        UtilManager.sendSubTitle(p, "&7Zaczynasz z &31 &7levelem, zyczymy powodzenia :)");
    }

    public static void levelStartAfterDeath(Player p) {
        level1(p);
        p.setLevel(1);
        UtilManager.sendTitle(p, "&8* &3Filipesz &8*");
        UtilManager.sendSubTitle(p, "&7Wracasz na &31 &7level, zyczymy powodzenia :)");
    }

    public static void levelUp(Player p) {
        if (p.getLevel() == 0) {
            level2(p);
            p.setLevel(2);
            UtilManager.sendTitle(p, "&8* &3Filipesz &8*");
            UtilManager.sendSubTitle(p, "&7Awansowales na &32 &7level!");
            Bukkit.broadcastMessage(UtilManager.fixColor("&8[&6✫&8] &8» &7" + p.getName() + " awansowal na &32 &7level!"));
        }
        if (p.getLevel() == 1) {
            level2(p);
            p.setLevel(2);
            UtilManager.sendTitle(p, "&8* &3Filipesz &8*");
            UtilManager.sendSubTitle(p, "&7Awansowales na &32 &7level!");
            Bukkit.broadcastMessage(UtilManager.fixColor("&8[&6✫&8] &8» &7" + p.getName() + " awansowal na &32 &7level!"));
        }
        if (p.getLevel() == 2) {
            level3(p);
            p.setLevel(3);
            UtilManager.sendTitle(p, "&8* &3Filipesz &8*");
            UtilManager.sendSubTitle(p, "&7Awansowales na &33 &7level!");
            Bukkit.broadcastMessage(UtilManager.fixColor("&8[&6✫&8] &8» &7" + p.getName() + " awansowal na &33 &7level!"));
        }
        if (p.getLevel() == 3) {
            level4(p);
            p.setLevel(4);
            UtilManager.sendTitle(p, "&8* &3Filipesz &8*");
            UtilManager.sendSubTitle(p, "&7Awansowales na &34 &7level!");
            Bukkit.broadcastMessage(UtilManager.fixColor("&8[&6✫&8] &8» &7" + p.getName() + " awansowal na &34 &7level!"));
        }
        if (p.getLevel() == 4) {
            level5(p);
            p.setLevel(5);
            UtilManager.sendTitle(p, "&8* &3Filipesz &8*");
            UtilManager.sendSubTitle(p, "&7Awansowales na &35 &7level!");
            Bukkit.broadcastMessage(UtilManager.fixColor("&8[&6✫&8] &8» &7" + p.getName() + " awansowal na &35 &7level!"));
        }
        if (p.getLevel() == 5) {
            level6(p);
            p.setLevel(6);
            UtilManager.sendTitle(p, "&8* &3Filipesz &8*");
            UtilManager.sendSubTitle(p, "&7Awansowales na &36 &7level!");
            Bukkit.broadcastMessage(UtilManager.fixColor("&8[&6✫&8] &8» &7" + p.getName() + " awansowal na &36 &7level!"));
        }
        if (p.getLevel() == 6) {
            level7(p);
            p.setLevel(7);
            UtilManager.sendTitle(p, "&8* &3Filipesz &8*");
            UtilManager.sendSubTitle(p, "&7Awansowales na &37 &7level!");
            Bukkit.broadcastMessage(UtilManager.fixColor("&8[&6✫&8] &8» &7" + p.getName() + " awansowal na &37 &7level!"));
        }
        if (p.getLevel() == 7) {
            level8(p);
            p.setLevel(8);
            UtilManager.sendTitle(p, "&8* &3Filipesz &8*");
            UtilManager.sendSubTitle(p, "&7Awansowales na &38 &7level!");
            Bukkit.broadcastMessage(UtilManager.fixColor("&8[&6✫&8] &8» &7" + p.getName() + " awansowal na &38 &7level!"));
        }
        if (p.getLevel() == 8) {
            level9(p);
            p.setLevel(9);
            UtilManager.sendTitle(p, "&8* &3Filipesz &8*");
            UtilManager.sendSubTitle(p, "&7Awansowales na &39 &7level!");
            Bukkit.broadcastMessage(UtilManager.fixColor("&8[&6✫&8] &8» &7" + p.getName() + " awansowal na &39 &7level!"));
        }
        if (p.getLevel() == 9) {
            level10(p);
            p.setLevel(10);
            UtilManager.sendTitle(p, "&8* &3Filipesz &8*");
            UtilManager.sendSubTitle(p, "&3Osiagnales maksymalny level!");
            Bukkit.broadcastMessage(UtilManager.fixColor("&8[&6✫&8] &8» &7" + p.getName() + " awansowal na &310 &7level! (&3MAKSYMALNY LEVEL!&7)"));
        }
        if (p.getLevel() == 10) {
            level10(p);
            p.setLevel(10);
        }
    }

    public static void level1(Player p) {

        p.setLevel(1);

        p.getInventory().clear();
        p.getInventory().setArmorContents(null);

        p.setGameMode(GameMode.SURVIVAL);
        p.setHealth(20);
        p.setFoodLevel(20);
        p.setFireTicks(0);
        for (PotionEffect effect : p.getActivePotionEffects()) {
            p.removePotionEffect(effect.getType());
        }

        ItemStack iSword = new ItemStack(Material.WOOD_SWORD, 1);

        p.getInventory().setItem(0, iSword);

        // SET
        ItemStack lHelmet = new ItemStack(Material.LEATHER_HELMET, 1);
        ItemStack lChestPlate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        ItemStack lLeggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        ItemStack lBoots = new ItemStack(Material.LEATHER_BOOTS, 1);

        ItemStack[] armor = new ItemStack[4];

        armor[0] = (lBoots);
        armor[1] = (lLeggings);
        armor[2] = (lChestPlate);
        armor[3] = (lHelmet);

        p.getInventory().setArmorContents(armor);
    }

    public static void level2(Player p) {

        p.setLevel(2);

        p.getInventory().clear();
        p.getInventory().setArmorContents(null);

        p.setGameMode(GameMode.SURVIVAL);
        p.setHealth(20);
        p.setFoodLevel(20);
        p.setFireTicks(0);
        for (PotionEffect effect : p.getActivePotionEffects()) {
            p.removePotionEffect(effect.getType());
        }

        ItemStack sSword = new ItemStack(Material.STONE_SWORD, 1);

        p.getInventory().setItem(0, sSword);

        // SET
        ItemStack lHelmet = new ItemStack(Material.LEATHER_HELMET, 1);
        ItemStack chChestPlate = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
        ItemStack lLeggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        ItemStack chBoots = new ItemStack(Material.CHAINMAIL_BOOTS, 1);

        ItemStack[] armor = new ItemStack[4];

        armor[0] = (chBoots);
        armor[1] = (lLeggings);
        armor[2] = (chChestPlate);
        armor[3] = (lHelmet);

        p.getInventory().setArmorContents(armor);
    }

    public static void level3(Player p) {

        p.setLevel(3);

        p.getInventory().clear();
        p.getInventory().setArmorContents(null);

        p.setGameMode(GameMode.SURVIVAL);
        p.setHealth(20);
        p.setFoodLevel(20);
        p.setFireTicks(0);
        for (PotionEffect effect : p.getActivePotionEffects()) {
            p.removePotionEffect(effect.getType());
        }

        ItemStack sSword = new ItemStack(Material.STONE_SWORD, 1);
        ItemStack snowBall = new ItemStack(Material.SNOW_BALL, 2);

        p.getInventory().setItem(0, sSword);
        p.getInventory().setItem(1, snowBall);

        // SET
        ItemStack chHelmet = new ItemStack(Material.CHAINMAIL_HELMET, 1);
        ItemStack chChestPlate = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
        ItemStack chLeggings = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
        ItemStack chBoots = new ItemStack(Material.CHAINMAIL_BOOTS, 1);

        ItemStack[] armor = new ItemStack[4];

        armor[0] = (chBoots);
        armor[1] = (chLeggings);
        armor[2] = (chChestPlate);
        armor[3] = (chHelmet);

        p.getInventory().setArmorContents(armor);
    }

    public static void level4(Player p) {

        p.setLevel(4);

        p.getInventory().clear();
        p.getInventory().setArmorContents(null);

        p.setGameMode(GameMode.SURVIVAL);
        p.setHealth(20);
        p.setFoodLevel(20);
        p.setFireTicks(0);
        for (PotionEffect effect : p.getActivePotionEffects()) {
            p.removePotionEffect(effect.getType());
        }

        ItemStack sSword = new ItemStack(Material.STONE_SWORD, 1);
        ItemStack snowBall = new ItemStack(Material.SNOW_BALL, 4);

        p.getInventory().setItem(0, sSword);
        p.getInventory().setItem(1, snowBall);

        // SET
        ItemStack chHelmet = new ItemStack(Material.CHAINMAIL_HELMET, 1);
        ItemStack iChestPlate = new ItemStack(Material.IRON_CHESTPLATE, 1);
        ItemStack chLeggings = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
        ItemStack iBoots = new ItemStack(Material.IRON_BOOTS, 1);

        ItemStack[] armor = new ItemStack[4];

        armor[0] = (iBoots);
        armor[1] = (chLeggings);
        armor[2] = (iChestPlate);
        armor[3] = (chHelmet);

        p.getInventory().setArmorContents(armor);
    }

    public static void level5(Player p) {

        p.setLevel(5);

        p.getInventory().clear();
        p.getInventory().setArmorContents(null);

        p.setGameMode(GameMode.SURVIVAL);
        p.setHealth(20);
        p.setFoodLevel(20);
        p.setFireTicks(0);
        for (PotionEffect effect : p.getActivePotionEffects()) {
            p.removePotionEffect(effect.getType());
        }

        ItemStack iSword = new ItemStack(Material.IRON_SWORD, 1);
        ItemStack snowBall = new ItemStack(Material.SNOW_BALL, 6);
        ItemStack gApple = new ItemStack(Material.GOLDEN_APPLE, 1);

        p.getInventory().setItem(0, iSword);
        p.getInventory().setItem(1, snowBall);
        p.getInventory().setItem(2, gApple);

        // SET
        ItemStack iHelmet = new ItemStack(Material.IRON_HELMET, 1);
        ItemStack iChestPlate = new ItemStack(Material.IRON_CHESTPLATE, 1);
        ItemStack iLeggings = new ItemStack(Material.IRON_LEGGINGS, 1);
        ItemStack iBoots = new ItemStack(Material.IRON_BOOTS, 1);

        ItemStack[] armor = new ItemStack[4];

        armor[0] = (iBoots);
        armor[1] = (iLeggings);
        armor[2] = (iChestPlate);
        armor[3] = (iHelmet);

        p.getInventory().setArmorContents(armor);
    }

    public static void level6(Player p) {
        p.setLevel(6);

        p.getInventory().clear();
        p.getInventory().setArmorContents(null);

        p.setGameMode(GameMode.SURVIVAL);
        p.setHealth(20);
        p.setFoodLevel(20);
        p.setFireTicks(0);
        for (PotionEffect effect : p.getActivePotionEffects()) {
            p.removePotionEffect(effect.getType());
        }

        ItemStack iSword = new ItemStack(Material.IRON_SWORD, 1);
        ItemStack snowBall = new ItemStack(Material.SNOW_BALL, 8);
        ItemStack gApple = new ItemStack(Material.GOLDEN_APPLE, 1);

        p.getInventory().setItem(0, iSword);
        p.getInventory().setItem(1, snowBall);
        p.getInventory().setItem(2, gApple);

        // SET
        ItemStack iHelmet = new ItemStack(Material.IRON_HELMET, 1);
        ItemStack iChestPlate = new ItemStack(Material.IRON_CHESTPLATE, 1);
        ItemStack iLeggings = new ItemStack(Material.IRON_LEGGINGS, 1);
        ItemStack dBoots = new ItemStack(Material.DIAMOND_BOOTS, 1);

        ItemStack[] armor = new ItemStack[4];

        armor[0] = (dBoots);
        armor[1] = (iLeggings);
        armor[2] = (iChestPlate);
        armor[3] = (iHelmet);

        p.getInventory().setArmorContents(armor);
    }

    public static void level7(Player p) {
        p.setLevel(7);

        p.getInventory().clear();
        p.getInventory().setArmorContents(null);

        p.setGameMode(GameMode.SURVIVAL);
        p.setHealth(20);
        p.setFoodLevel(20);
        p.setFireTicks(0);
        for (PotionEffect effect : p.getActivePotionEffects()) {
            p.removePotionEffect(effect.getType());
        }

        ItemStack iSword = new ItemStack(Material.IRON_SWORD, 1);
        ItemStack snowBall = new ItemStack(Material.SNOW_BALL, 10);
        ItemStack gApple = new ItemStack(Material.GOLDEN_APPLE, 2);

        p.getInventory().setItem(0, iSword);
        p.getInventory().setItem(1, snowBall);
        p.getInventory().setItem(2, gApple);

        // SET
        ItemStack iHelmet = new ItemStack(Material.IRON_HELMET, 1);
        ItemStack iChestPlate = new ItemStack(Material.IRON_CHESTPLATE, 1);
        ItemStack dLeggings = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
        ItemStack dBoots = new ItemStack(Material.DIAMOND_BOOTS, 1);

        ItemStack[] armor = new ItemStack[4];

        armor[0] = (dBoots);
        armor[1] = (dLeggings);
        armor[2] = (iChestPlate);
        armor[3] = (iHelmet);

        p.getInventory().setArmorContents(armor);
    }

    public static void level8(Player p) {
        p.setLevel(8);

        p.getInventory().clear();
        p.getInventory().setArmorContents(null);

        p.setGameMode(GameMode.SURVIVAL);
        p.setHealth(20);
        p.setFoodLevel(20);
        p.setFireTicks(0);
        for (PotionEffect effect : p.getActivePotionEffects()) {
            p.removePotionEffect(effect.getType());
        }

        ItemStack iSword = new ItemStack(Material.IRON_SWORD, 1);
        ItemStack snowBall = new ItemStack(Material.SNOW_BALL, 12);
        ItemStack gApple = new ItemStack(Material.GOLDEN_APPLE, 2);

        p.getInventory().setItem(0, iSword);
        p.getInventory().setItem(1, snowBall);
        p.getInventory().setItem(2, gApple);

        // SET
        ItemStack iHelmet = new ItemStack(Material.IRON_HELMET, 1);
        ItemStack dChestPlate = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
        ItemStack dLeggings = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
        ItemStack dBoots = new ItemStack(Material.DIAMOND_BOOTS, 1);

        ItemStack[] armor = new ItemStack[4];

        armor[0] = (dBoots);
        armor[1] = (dLeggings);
        armor[2] = (dChestPlate);
        armor[3] = (iHelmet);

        p.getInventory().setArmorContents(armor);
    }

    public static void level9(Player p) {
        p.setLevel(9);

        p.getInventory().clear();
        p.getInventory().setArmorContents(null);

        p.setGameMode(GameMode.SURVIVAL);
        p.setHealth(20);
        p.setFoodLevel(20);
        p.setFireTicks(0);
        for (PotionEffect effect : p.getActivePotionEffects()) {
            p.removePotionEffect(effect.getType());
        }

        ItemStack iSword = new ItemStack(Material.IRON_SWORD, 1);
        ItemStack snowBall = new ItemStack(Material.SNOW_BALL, 14);
        ItemStack gApple = new ItemStack(Material.GOLDEN_APPLE, 4);

        p.getInventory().setItem(0, iSword);
        p.getInventory().setItem(1, snowBall);
        p.getInventory().setItem(2, gApple);

        // SET
        ItemStack dHelmet = new ItemStack(Material.DIAMOND_HELMET, 1);
        ItemStack dChestPlate = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
        ItemStack dLeggings = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
        ItemStack dBoots = new ItemStack(Material.DIAMOND_BOOTS, 1);

        ItemStack[] armor = new ItemStack[4];

        armor[0] = (dBoots);
        armor[1] = (dLeggings);
        armor[2] = (dChestPlate);
        armor[3] = (dHelmet);

        p.getInventory().setArmorContents(armor);
    }

    public static void level10(Player p) {
        p.setLevel(10);

        p.getInventory().clear();
        p.getInventory().setArmorContents(null);

        p.setGameMode(GameMode.SURVIVAL);
        p.setHealth(20);
        p.setFoodLevel(20);
        p.setFireTicks(0);
        for (PotionEffect effect : p.getActivePotionEffects()) {
            p.removePotionEffect(effect.getType());
        }

        ItemStack iSword = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemStack snowBall = new ItemStack(Material.SNOW_BALL, 16);
        ItemStack gApple = new ItemStack(Material.GOLDEN_APPLE, 4);

        p.getInventory().setItem(0, iSword);
        p.getInventory().setItem(1, snowBall);
        p.getInventory().setItem(2, gApple);

        // SET
        ItemStack dHelmet = new ItemStack(Material.DIAMOND_HELMET, 1);
        ItemStack dChestPlate = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
        ItemStack dLeggings = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
        ItemStack dBoots = new ItemStack(Material.DIAMOND_BOOTS, 1);

        ItemStack[] armor = new ItemStack[4];

        armor[0] = (dBoots);
        armor[1] = (dLeggings);
        armor[2] = (dChestPlate);
        armor[3] = (dHelmet);

        p.getInventory().setArmorContents(armor);
    }
}
