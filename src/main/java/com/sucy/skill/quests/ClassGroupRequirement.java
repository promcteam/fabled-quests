package com.sucy.skill.quests;

import com.sucy.skill.SkillAPI;
import com.sucy.skill.api.player.PlayerClass;
import com.sucy.skill.api.player.PlayerData;
import me.blackvein.quests.CustomRequirement;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.Map;

public class ClassGroupRequirement extends CustomRequirement {
    private static final String NAME = "Class Level Requirement";

    private static final String AUTHOR = "Eniripsa96";

    private static final String GROUP = "Group";

    private static final String LEVEL = "Level";

    public ClassGroupRequirement() {
        setName("Class Level Requirement");
        setAuthor("Eniripsa96");
        addItem("CHAINMAIL_HELMET", (short) 0);
        addStringPrompt("Group", "Enter the class group to require the level for", 0);
        addStringPrompt("Level", "Enter the required level for the class group", 0);
    }

    public boolean testRequirement(Player player, Map<String, Object> data) {
        try {
            int level = Integer.parseInt(data.get("Level").toString());
            String group = data.get("Group").toString();
            PlayerData playerSkills = SkillAPI.getPlayerData((OfflinePlayer)player);
            PlayerClass c = playerSkills.getClass(group);
            return (c != null && c.getLevel() >= level);
        } catch (Exception ex) {
            return false;
        }
    }
}
