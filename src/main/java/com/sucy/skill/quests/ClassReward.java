package com.sucy.skill.quests;

import com.sucy.skill.SkillAPI;
import com.sucy.skill.api.player.PlayerData;
import me.pikamug.quests.module.BukkitCustomReward;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.UUID;

public class ClassReward extends BukkitCustomReward {
    public ClassReward() {
        setName("Class Reward");
        setAuthor("Eniripsa96");
        setDisplay("Class");
        setItem("CHAINMAIL_HELMET", (short) 0);
        addStringPrompt("Class", "Enter what class the player will become.", 0);
    }

    @Override
    public void giveReward(UUID id, Map<String, Object> data) {
        String c = data.get("Class").toString();
        if (SkillAPI.getClass(c) == null)
            return;
        Player     player       = Bukkit.getPlayer(id);
        PlayerData playerSkills = SkillAPI.getPlayerData(player);
        if (playerSkills.hasClass() && playerSkills.getMainClass().getData().getName().equalsIgnoreCase(c))
            return;
        playerSkills.profess(SkillAPI.getClass(c));
    }
}
