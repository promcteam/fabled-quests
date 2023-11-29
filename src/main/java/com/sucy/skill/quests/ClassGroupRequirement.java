package com.sucy.skill.quests;

import com.sucy.skill.SkillAPI;
import com.sucy.skill.api.player.PlayerClass;
import com.sucy.skill.api.player.PlayerData;
import me.pikamug.quests.module.BukkitCustomRequirement;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

public class ClassGroupRequirement extends BukkitCustomRequirement {
    public ClassGroupRequirement() {
        setName("Class Level Requirement");
        setAuthor("Eniripsa96");
        setItem("CHAINMAIL_HELMET", (short) 0);
        addStringPrompt("Group", "Enter the class group to require the level for", 0);
        addStringPrompt("Level", "Enter the required level for the class group", 0);
    }

    @Override
    public boolean testRequirement(UUID id, Map<String, Object> data) {
        try {
            int         level        = Integer.parseInt(data.get("Level").toString());
            String      group        = data.get("Group").toString();
            Player      player       = Bukkit.getPlayer(id);
            PlayerData  playerSkills = SkillAPI.getPlayerData(player);
            PlayerClass c            = playerSkills.getClass(group);
            return (c != null && c.getLevel() >= level);
        } catch (Exception ex) {
            return false;
        }
    }
}
