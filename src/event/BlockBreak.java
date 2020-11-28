package event;

import main.Main;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class BlockBreak implements Listener {
    @EventHandler
    public void BlockBreak (BlockBreakEvent e) {
        if (e.getPlayer().getGameMode() != GameMode.SURVIVAL) return;
        List<Material> materials = Arrays.asList(new Material[] {Material.IRON_ORE, Material.GOLD_ORE, Material.LAPIS_ORE, Material.REDSTONE_ORE, Material.DIAMOND_ORE, Material.ANDESITE, Material.GRANITE, Material.DIORITE});

        ItemStack itemInMainHand = e.getPlayer().getInventory().getItemInMainHand();
        if (itemInMainHand.getEnchantmentLevel(Enchantment.SILK_TOUCH) >= 1) {
            return;
        }

        for (Material material : materials) {
            if (e.getBlock().getType() == material) {
                Material stone = Material.STONE;
                e.getBlock().setType(stone);
            }
        }

        if (e.getBlock().getType() == Material.STONE) {
            if (Math.random() < (Main.getBlock().getDouble("Probability.diamond") / 100)) {
                e.getBlock().setType(Material.DIAMOND_ORE);
            } else if (Math.random() < (Main.getBlock().getDouble("Probability.gold") / 100)) {
                e.getBlock().setType(Material.GOLD_ORE);
            } else if (Math.random() < (Main.getBlock().getDouble("Probability.iron") / 100)) {
                e.getBlock().setType(Material.IRON_ORE);
            } else if (Math.random() < (Main.getBlock().getDouble("Probability.redstone") / 100)) {
                e.getBlock().setType(Material.REDSTONE_ORE);
            } else if (Math.random() < (Main.getBlock().getDouble("Probability.lapis") / 100)) {
                e.getBlock().setType(Material.LAPIS_ORE);
            } else if (Math.random() < (Main.getBlock().getDouble("Probability.stone") / 100)) {
                e.getBlock().setType(Material.STONE);
            } else {
                e.getBlock().setType(Material.STONE);
            }
        }
    }
}
