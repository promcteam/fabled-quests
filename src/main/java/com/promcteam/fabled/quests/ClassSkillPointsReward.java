package com.promcteam.fabled.quests;

import com.promcteam.fabled.Fabled;
import com.promcteam.fabled.api.enums.ExpSource;
import com.promcteam.fabled.api.player.PlayerData;
import me.pikamug.quests.module.BukkitCustomReward;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

public class ClassSkillPointsReward extends BukkitCustomReward {
    public ClassSkillPointsReward() {
        setName("Class Skill Points Reward");
        setAuthor("ProMCTeam");
        setDisplay("Skill Points");
        setItem("ENDER_PEARL", (short) 0);
        addStringPrompt("Points", "Enter how many skill points to give to the player.", 0);
    }

    @Override
    public void giveReward(UUID id, Map<String, Object> data) {
        try {
            int        points       = Integer.parseInt(data.get("Points").toString());
            Player     player       = Bukkit.getPlayer(id);
            PlayerData playerSkills = Fabled.getPlayerData(player);
            playerSkills.givePoints(points, ExpSource.QUEST);
        } catch (Exception ex) {
        }
    }
}
