package com.sucy.skill.quests;

import com.sucy.skill.SkillAPI;
import com.sucy.skill.api.player.PlayerData;
import me.blackvein.quests.CustomRequirement;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.Map;

public class ClassRequirement extends CustomRequirement {
    private static final String NAME = "Class Requirement";

    private static final String AUTHOR = "Eniripsa96";

    private static final String CLASS = "Class";

    public ClassRequirement() {
        setName("Class Requirement");
        setAuthor("Eniripsa96");
        addItem("CHAINMAIL_HELMET", (short) 0);
        addStringPrompt("Class", "The player must be the class or a profess of the class in order to take the quest.", 0);
    }

    public boolean testRequirement(Player player, Map<String, Object> data) {
        String list[], c = data.get("Class").toString();
        if (c.contains(",")) {
            list = c.split(",");
        } else {
            list = new String[] { c };
        }
        PlayerData playerSkills = SkillAPI.getPlayerData((OfflinePlayer)player);
        for (String item : list) {
            if (playerSkills.isClass(SkillAPI.getClass(item)))
                return true;
        }
        return false;
    }
}
