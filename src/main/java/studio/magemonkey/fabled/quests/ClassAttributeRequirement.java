package studio.magemonkey.fabled.quests;

import studio.magemonkey.fabled.Fabled;
import studio.magemonkey.fabled.api.player.PlayerData;
import me.pikamug.quests.module.BukkitCustomRequirement;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

public class ClassAttributeRequirement extends BukkitCustomRequirement {
    public ClassAttributeRequirement() {
        setName("Class Attribute Requirement");
        setAuthor("MageMonkeyStudio");
        setItem("FEATHER", (short) 0);
        addStringPrompt("Attribute", "Enter the name of the required attribute", 0);
        addStringPrompt("Amount", "Enter the required amount of the attribute", 0);
    }

    @Override
    public boolean testRequirement(UUID id, Map<String, Object> data) {
        try {
            int        amount       = Integer.parseInt(data.get("Amount").toString());
            String     attr         = data.get("Attribute").toString();
            Player     player       = Bukkit.getPlayer(id);
            PlayerData playerSkills = Fabled.getData(player);
            return (playerSkills.getAttribute(attr) >= amount);
        } catch (Exception ex) {
            return false;
        }
    }
}
