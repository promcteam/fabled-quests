package com.promcteam.fabled.quests;

import com.promcteam.fabled.Fabled;
import com.promcteam.fabled.api.enums.ExpSource;
import com.promcteam.fabled.api.player.PlayerData;
import me.pikamug.quests.module.BukkitCustomReward;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

public class ClassExperienceReward extends BukkitCustomReward {
    private static final String NAME = "Class Experience Reward";

    private static final String AUTHOR = "ProMCTeam";

    private static final String REWARD_NAME = "Experience";

    private static final String EXPERIENCE = "Experience";

    public ClassExperienceReward() {
        setName("Class Experience Reward");
        setAuthor("ProMCTeam");
        setDisplay("Experience");
        setItem("EXP_BOTTLE", (short) 0);
        addStringPrompt("Experience", "Enter how much experience to give to the player", 0);
    }

    @Override
    public void giveReward(UUID id, Map<String, Object> data) {
        try {
            int        experience   = Integer.parseInt(data.get("Experience").toString());
            Player     player       = Bukkit.getPlayer(id);
            PlayerData playerSkills = Fabled.getPlayerData(player);
            playerSkills.giveExp(experience, ExpSource.QUEST);
        } catch (Exception ex) {
        }
    }
}
