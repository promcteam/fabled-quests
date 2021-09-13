package com.sucy.skill.quests;

import com.sucy.skill.SkillAPI;
import com.sucy.skill.api.enums.ExpSource;
import com.sucy.skill.api.player.PlayerData;
import me.blackvein.quests.CustomReward;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.Map;

public class ClassExperienceReward extends CustomReward {
    private static final String NAME = "Class Experience Reward";

    private static final String AUTHOR = "Eniripsa96";

    private static final String REWARD_NAME = "Experience";

    private static final String EXPERIENCE = "Experience";

    public ClassExperienceReward() {
        setName("Class Experience Reward");
        setAuthor("Eniripsa96");
        setRewardName("Experience");
        addItem("EXP_BOTTLE", (short) 0);
        addStringPrompt("Experience", "Enter how much experience to give to the player", 0);
    }

    public void giveReward(Player player, Map<String, Object> data) {
        try {
            int experience = Integer.parseInt(data.get("Experience").toString());
            PlayerData playerSkills = SkillAPI.getPlayerData((OfflinePlayer)player);
            playerSkills.giveExp(experience, ExpSource.QUEST);
        } catch (Exception ex) {}
    }
}
