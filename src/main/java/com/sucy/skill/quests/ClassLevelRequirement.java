package com.sucy.skill.quests;

import com.sucy.skill.SkillAPI;
import com.sucy.skill.api.player.PlayerClass;
import com.sucy.skill.api.player.PlayerData;
import me.pikamug.quests.module.BukkitCustomRequirement;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

public class ClassLevelRequirement extends BukkitCustomRequirement {
    public ClassLevelRequirement() {
        setName("Class Level Requirement");
        setAuthor("Eniripsa96");
        setItem("EXP_BOTTLE", (short) 0);
        addStringPrompt("Level", "The player must be at least the specified level in order to take the quest.", 0);
    }

    @Override
    public boolean testRequirement(UUID id, Map<String, Object> data) {
        try {
            int         level        = Integer.parseInt(data.get("Level").toString());
            Player      player       = Bukkit.getPlayer(id);
            PlayerData  playerSkills = SkillAPI.getPlayerData(player);
            PlayerClass c            = playerSkills.getMainClass();
            return (c != null && c.getLevel() >= level);
        } catch (Exception ex) {
            return false;
        }
    }
}
