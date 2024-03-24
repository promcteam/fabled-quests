package com.promcteam.fabled.quests;

import com.promcteam.fabled.Fabled;
import com.promcteam.fabled.api.player.PlayerClass;
import com.promcteam.fabled.api.player.PlayerData;
import me.pikamug.quests.module.BukkitCustomRequirement;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

public class ClassGroupRequirement extends BukkitCustomRequirement {
    public ClassGroupRequirement() {
        setName("Class Level Requirement");
        setAuthor("ProMCTeam");
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
            PlayerData  playerSkills = Fabled.getPlayerData(player);
            PlayerClass c            = playerSkills.getClass(group);
            return (c != null && c.getLevel() >= level);
        } catch (Exception ex) {
            return false;
        }
    }
}
