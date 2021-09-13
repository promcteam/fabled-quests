package com.sucy.skill.quests;

import com.sucy.skill.SkillAPI;
import com.sucy.skill.api.enums.ExpSource;
import com.sucy.skill.api.player.PlayerData;
import me.blackvein.quests.CustomReward;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.Map;

public class ClassSkillPointsReward extends CustomReward {
    private static final String NAME = "Class Skill Points Reward";

    private static final String AUTHOR = "Eniripsa96";

    private static final String REWARD_NAME = "Skill Points";

    private static final String POINTS = "Points";

    public ClassSkillPointsReward() {
        setName("Class Skill Points Reward");
        setAuthor("Eniripsa96");
        setRewardName("Skill Points");
        addItem("ENDER_PEARL", (short) 0);
        addStringPrompt("Points", "Enter how many skill points to give to the player.", 0);
    }

    public void giveReward(Player player, Map<String, Object> data) {
        try {
            int points = Integer.parseInt(data.get("Points").toString());
            PlayerData playerSkills = SkillAPI.getPlayerData((OfflinePlayer)player);
            playerSkills.givePoints(points, ExpSource.QUEST);
        } catch (Exception ex) {}
    }
}
