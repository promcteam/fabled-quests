package com.sucy.skill.quests;

import com.sucy.skill.SkillAPI;
import com.sucy.skill.api.player.PlayerData;
import com.sucy.skill.api.player.PlayerSkill;
import me.blackvein.quests.CustomRequirement;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.Map;

public class ClassSkillRequirement extends CustomRequirement {
    private static final String NAME = "Class Level Requirement";

    private static final String AUTHOR = "Eniripsa96";

    private static final String LEVEL = "Level";

    private static final String SKILL = "Skill";

    public ClassSkillRequirement() {
        setName("Class Level Requirement");
        setAuthor("Eniripsa96");
        addItem("EYE_OF_ENDER", (short) 0);
        addStringPrompt("Skill", "Enter the name of the required skill.", 0);
        addStringPrompt("Level", "Enter the minimum required level of the skill.", 0);
    }

    public boolean testRequirement(Player player, Map<String, Object> data) {
        try {
            int level = Integer.parseInt(data.get("Level").toString());
            String skill = data.get("Skill").toString();
            PlayerData playerSkills = SkillAPI.getPlayerData((OfflinePlayer)player);
            PlayerSkill skillData = playerSkills.getSkill(skill);
            return (skillData != null && skillData.getLevel() >= level);
        } catch (Exception ex) {
            return false;
        }
    }
}
