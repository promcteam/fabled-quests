package com.sucy.skill.quests;

import com.sucy.skill.SkillAPI;
import com.sucy.skill.api.player.PlayerData;
import com.sucy.skill.api.player.PlayerSkill;
import me.pikamug.quests.module.BukkitCustomRequirement;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

public class ClassSkillRequirement extends BukkitCustomRequirement {
    public ClassSkillRequirement() {
        setName("Class Level Requirement");
        setAuthor("Eniripsa96");
        setItem("EYE_OF_ENDER", (short) 0);
        addStringPrompt("Skill", "Enter the name of the required skill.", 0);
        addStringPrompt("Level", "Enter the minimum required level of the skill.", 0);
    }

    @Override
    public boolean testRequirement(UUID id, Map<String, Object> data) {
        try {
            Player      player       = Bukkit.getPlayer(id);
            int         level        = Integer.parseInt(data.get("Level").toString());
            String      skill        = data.get("Skill").toString();
            PlayerData  playerSkills = SkillAPI.getPlayerData(player);
            PlayerSkill skillData    = playerSkills.getSkill(skill);
            return (skillData != null && skillData.getLevel() >= level);
        } catch (Exception ex) {
            return false;
        }
    }
}
