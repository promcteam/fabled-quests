package com.sucy.skill.quests;

import com.sucy.skill.SkillAPI;
import com.sucy.skill.api.player.PlayerData;
import me.blackvein.quests.CustomReward;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.Map;

public class ClassReward extends CustomReward {
    private static final String NAME = "Class Reward";

    private static final String AUTHOR = "Eniripsa96";

    private static final String REWARD_NAME = "Class";

    private static final String CLASS = "Class";

    public ClassReward() {
        setName("Class Reward");
        setAuthor("Eniripsa96");
        setRewardName("Class");
        addItem("CHAINMAIL_HELMET", (short) 0);
        addStringPrompt("Class", "Enter what class the player will become.", 0);
    }

    public void giveReward(Player player, Map<String, Object> data) {
        String c = data.get("Class").toString();
        if (SkillAPI.getClass(c) == null)
            return;
        PlayerData playerSkills = SkillAPI.getPlayerData((OfflinePlayer)player);
        if (playerSkills.hasClass() && playerSkills.getMainClass().getData().getName().equalsIgnoreCase(c))
            return;
        playerSkills.profess(SkillAPI.getClass(c));
    }
}
