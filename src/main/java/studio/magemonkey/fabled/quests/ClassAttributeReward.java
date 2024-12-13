package studio.magemonkey.fabled.quests;

import me.pikamug.quests.module.BukkitCustomReward;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import studio.magemonkey.fabled.Fabled;
import studio.magemonkey.fabled.api.player.PlayerData;

import java.util.Map;
import java.util.UUID;

public class ClassAttributeReward extends BukkitCustomReward {
    private static final String NAME = "Class Attribute Points Reward";

    private static final String AUTHOR = "MageMonkeyStudio";

    private static final String REWARD_NAME = "Attribute Points";

    private static final String POINTS = "Points";

    public ClassAttributeReward() {
        setName("Class Attribute Points Reward");
        setAuthor("MageMonkeyStudio");
        setDisplay("Attribute Points");
        setItem("FEATHER", (short) 0);
        addStringPrompt("Points", "Enter how many attribute points to give to the player", 0);
    }

    @Override
    public void giveReward(UUID id, Map<String, Object> data) {
        try {
            int        points       = Integer.parseInt(data.get("Points").toString());
            Player     player       = Bukkit.getPlayer(id);
            PlayerData playerSkills = Fabled.getData(player);
            playerSkills.giveAttribPoints(points);
        } catch (Exception ex) {
        }
    }
}
