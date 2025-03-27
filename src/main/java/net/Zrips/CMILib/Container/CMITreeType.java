package net.Zrips.CMILib.Container;

import java.util.HashMap;
import java.util.Map.Entry;

import org.bukkit.TreeType;

public enum CMITreeType {

    ACACIA(),
    AZALEA(),
    BIG_TREE("Large oak", "bigoak", "big"),
    BIRCH("white", "whitebark"),
    BROWN_MUSHROOM("browngiantmushroom"),
    CHERRY(),
    CHORUS_PLANT("chorus"),
    COCOA_TREE("Cocoa"),
    CRIMSON_FUNGUS(),
    DARK_OAK(),
    JUNGLE(),
    JUNGLE_BUSH("jungleshrub"),
    MANGROVE(),
    MEGA_REDWOOD("Large spruce"),
    PALE_OAK,
    PALE_OAK_CREAKING,
    RED_MUSHROOM("redgiantmushroom"),
    REDWOOD("Spruce", "sequoia", "sequoioideae"),
    SMALL_JUNGLE(),
    SWAMP("swamptree"),
    TALL_BIRCH(),
    TALL_MANGROVE(),
    TALL_REDWOOD("Tall spruce", "bigspruce", "tallsequoia", "tallsequoioideae"),
    TREE("Oak", "regular"),
    WARPED_FUNGUS();

    private String name;
    private String[] identifiers;
    private TreeType type = null;

    CMITreeType(String... identifiers) {

        name = CMIText.firstToUpperCase(this.toString());

        this.identifiers = identifiers;

        for (TreeType one : TreeType.values()) {
            if (one.name().equalsIgnoreCase(this.toString())) {
                type = one;
                break;
            }
        }
    }

    static HashMap<String, CMITreeType> map = new HashMap<String, CMITreeType>();

    static {
        for (CMITreeType one : CMITreeType.values()) {
            map.put(one.getName().replace(" ", "").toLowerCase(), one);
            if (one.getIdentifiers() == null)
                continue;
            for (String oneE : one.getIdentifiers()) {
                map.put(oneE.replace(" ", "").toLowerCase(), one);
            }
        }
    }

    public static CMITreeType getType(String name) {
        name = name.replace(" ", "").replace("_", "").toLowerCase();
        CMITreeType got = map.get(name);
        if (got != null)
            return got;

        for (Entry<String, CMITreeType> one : map.entrySet()) {
            if (one.getKey().startsWith(name) || one.getKey().contains(name))
                return one.getValue();
        }

        return null;
    }

    public String getName() {
        return name;
    }

    public String[] getIdentifiers() {
        return identifiers;
    }

    public TreeType getType() {
        return type;
    }
}
