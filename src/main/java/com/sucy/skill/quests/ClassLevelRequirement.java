package com.sucy.skill.quests;

import com.sucy.skill.SkillAPI;
import com.sucy.skill.api.player.PlayerClass;
import com.sucy.skill.api.player.PlayerData;
import me.blackvein.quests.CustomRequirement;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.Map;

public class ClassLevelRequirement extends CustomRequirement {
    private static final String NAME = "Class Level Requirement";

    private static final String AUTHOR = "Eniripsa96";

    private static final String LEVEL = "Level";

    public ClassLevelRequirement() {
        setName("Class Level Requirement");
        setAuthor("Eniripsa96");
        addItem("EXP_BOTTLE", (short) 0);
        addStringPrompt("Level", "The player must be at least the specified level in order to take the quest.", 0);
    }

    public boolean testRequirement(Player player, Map<String, Object> data) {
        try {
            int level = Integer.parseInt(data.get("Level").toString());
            PlayerData playerSkills = SkillAPI.getPlayerData((OfflinePlayer)player);
            PlayerClass c = playerSkills.getMainClass();
            return (c != null && c.getLevel() >= level);
        } catch (Exception ex) {
            return false;
        }
    }
}
