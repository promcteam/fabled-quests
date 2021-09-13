package com.sucy.skill.quests;

import com.sucy.skill.SkillAPI;
import com.sucy.skill.api.player.PlayerData;
import me.blackvein.quests.CustomReward;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.Map;

public class ClassAttributeReward extends CustomReward {
    private static final String NAME = "Class Attribute Points Reward";

    private static final String AUTHOR = "Eniripsa96";

    private static final String REWARD_NAME = "Attribute Points";

    private static final String POINTS = "Points";

    public ClassAttributeReward() {
        setName("Class Attribute Points Reward");
        setAuthor("Eniripsa96");
        setRewardName("Attribute Points");
        addItem("FEATHER", (short) 0);
        addStringPrompt("Points", "Enter how many attribute points to give to the player", 0);
    }

    public void giveReward(Player player, Map<String, Object> data) {
        try {
            int points = Integer.parseInt(data.get("Points").toString());
            PlayerData playerSkills = SkillAPI.getPlayerData((OfflinePlayer)player);
            playerSkills.giveAttribPoints(points);
        } catch (Exception ex) {}
    }
}
