package com.sucy.skill.quests;

import com.sucy.skill.SkillAPI;
import com.sucy.skill.api.player.PlayerData;
import me.blackvein.quests.CustomRequirement;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.Map;

public class ClassAttributeRequirement extends CustomRequirement {
    private static final String NAME = "Class Attribute Requirement";

    private static final String AUTHOR = "Eniripsa96";

    private static final String ATTRIBUTE = "Attribute";

    private static final String AMOUNT = "Amount";

    public ClassAttributeRequirement() {
        setName("Class Attribute Requirement");
        setAuthor("Eniripsa96");
        addItem("FEATHER", (short) 0);
        addStringPrompt("Attribute", "Enter the name of the required attribute", 0);
        addStringPrompt("Amount", "Enter the required amount of the attribute", 0);
    }

    public boolean testRequirement(Player player, Map<String, Object> data) {
        try {
            int amount = Integer.parseInt(data.get("Amount").toString());
            String attr = data.get("Attribute").toString();
            PlayerData playerSkills = SkillAPI.getPlayerData((OfflinePlayer)player);
            return (playerSkills.getAttribute(attr) >= amount);
        } catch (Exception ex) {
            return false;
        }
    }
}
