
package org.jubaroo.mods.halloween;

import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.items.Item;
import com.wurmonline.server.items.ItemList;
import com.wurmonline.server.zones.NoSuchZoneException;
import com.wurmonline.server.zones.Zone;
import com.wurmonline.server.zones.Zones;
import org.gotti.wurmunlimited.modloader.classhooks.HookException;
import org.gotti.wurmunlimited.modloader.interfaces.Configurable;
import org.gotti.wurmunlimited.modloader.interfaces.Initable;
import org.gotti.wurmunlimited.modloader.interfaces.PreInitable;
import org.gotti.wurmunlimited.modloader.interfaces.WurmServerMod;
import org.gotti.wurmunlimited.modsupport.creatures.ModCreatures;
import org.jubaroo.mods.halloween.creatures.OminousTree;
import org.jubaroo.mods.halloween.creatures.ScaryPumpkin;

import java.util.Properties;
import java.util.logging.Level;

import static org.gotti.wurmunlimited.modsupport.creatures.ModCreatures.addCreature;

public class Initiator implements WurmServerMod, Configurable, PreInitable, Initable {

    @Override
    public void configure(final Properties properties) {
        Constants.partsPumpkinRollBound = Integer.valueOf(properties.getProperty("Pumpkin_Parts_Roll_Bound", String.valueOf(Constants.partsPumpkinRollBound)));
        Constants.partsTreeRollBound = Integer.valueOf(properties.getProperty("Tree_Parts_Roll_Bound", String.valueOf(Constants.partsTreeRollBound)));
        Constants.bonePumpkinRollBound = Integer.valueOf(properties.getProperty("Pumpkin_Rare_Bone_Roll_Bound", String.valueOf(Constants.bonePumpkinRollBound)));
        Constants.boneTreeRollBound = Integer.valueOf(properties.getProperty("Tree_Rare_Bone_Roll_Bound", String.valueOf(Constants.boneTreeRollBound)));
        Constants.shouldersPumpkinRollBound = Integer.valueOf(properties.getProperty("Pumpkin_Shoulders_Roll_Bound", String.valueOf(Constants.shouldersPumpkinRollBound)));
        Constants.shouldersTreeRollBound = Integer.valueOf(properties.getProperty("Tree_Shoulders_Roll_Bound", String.valueOf(Constants.shouldersTreeRollBound)));
        Constants.masksPumpkinRollBound = Integer.valueOf(properties.getProperty("Pumpkin_Masks_Roll_Bound", String.valueOf(Constants.masksPumpkinRollBound)));
        Constants.masksTreeRollBound = Integer.valueOf(properties.getProperty("Tree_Masks_Roll_Bound", String.valueOf(Constants.masksTreeRollBound)));
        Constants.partsPumpkinRollToggle = Boolean.valueOf(properties.getProperty("Pumpkin_Parts_Drop", String.valueOf(Constants.partsPumpkinRollToggle)));
        Constants.partsTreeRollToggle = Boolean.valueOf(properties.getProperty("Tree_Parts_Drop", String.valueOf(Constants.partsTreeRollToggle)));
        Constants.bonePumpkinRollToggle = Boolean.valueOf(properties.getProperty("Pumpkin_Rare_Bone_Drop", String.valueOf(Constants.bonePumpkinRollToggle)));
        Constants.boneTreeRollToggle = Boolean.valueOf(properties.getProperty("Tree_Rare_Bone_Drop", String.valueOf(Constants.boneTreeRollToggle)));
        Constants.shouldersPumpkinRollToggle = Boolean.valueOf(properties.getProperty("Pumpkin_Pumpkin_Shoulders_Drop", String.valueOf(Constants.shouldersPumpkinRollToggle)));
        Constants.shouldersTreeRollToggle = Boolean.valueOf(properties.getProperty("Tree_Pumpkin_Shoulders_Drop", String.valueOf(Constants.shouldersTreeRollToggle)));
        Constants.masksPumpkinRollToggle = Boolean.valueOf(properties.getProperty("Pumpkin_Masks_Drop", String.valueOf(Constants.masksPumpkinRollToggle)));
        Constants.masksTreeRollToggle = Boolean.valueOf(properties.getProperty("Tree_Masks_Drop", String.valueOf(Constants.masksTreeRollToggle)));
        Constants.settingsOutput = Boolean.valueOf(properties.getProperty("Output_Settings_To_Log", String.valueOf(Constants.settingsOutput)));
        if (Constants.settingsOutput) {
            if (Constants.partsPumpkinRollToggle) { Constants.logger.log(Level.INFO,"Pumpkin Part drops: Enabled"); }
            if (!Constants.partsPumpkinRollToggle) { Constants.logger.log(Level.INFO,"Pumpkin Part drops: Disabled"); }
            if (Constants.partsTreeRollToggle) { Constants.logger.log(Level.INFO,"Tree parts drop: Enabled"); }
            if (!Constants.partsTreeRollToggle) { Constants.logger.log(Level.INFO,"Tree parts drop: Disabled"); }
            if (Constants.bonePumpkinRollToggle) { Constants.logger.log(Level.INFO,"Pumpkin Rare bone drop: Enabled"); }
            if (!Constants.bonePumpkinRollToggle) { Constants.logger.log(Level.INFO,"Pumpkin Rare bone drop: Disabled"); }
            if (Constants.boneTreeRollToggle) { Constants.logger.log(Level.INFO,"Tree Rare bone drop: Enabled"); }
            if (!Constants.boneTreeRollToggle) { Constants.logger.log(Level.INFO,"Tree Rare bone drop: Disabled"); }
            if (Constants.shouldersPumpkinRollToggle) { Constants.logger.log(Level.INFO,"Pumpkin Shoulders on pumpkins drop: Enabled"); }
            if (!Constants.shouldersPumpkinRollToggle) { Constants.logger.log(Level.INFO,"Pumpkin Shoulders on pumpkins drop: Disabled"); }
            if (Constants.shouldersTreeRollToggle) { Constants.logger.log(Level.INFO,"Pumpkin Shoulders on trees drop: Enabled"); }
            if (!Constants.shouldersTreeRollToggle) { Constants.logger.log(Level.INFO,"Pumpkin Shoulders on trees drop: Disabled"); }
            if (Constants.masksPumpkinRollToggle) { Constants.logger.log(Level.INFO,"Pumpkin masks drop: Enabled"); }
            if (!Constants.masksPumpkinRollToggle) { Constants.logger.log(Level.INFO,"Pumpkin masks drop: Disabled"); }
            if (Constants.masksTreeRollToggle) { Constants.logger.log(Level.INFO,"Tree masks drop: Enabled"); }
            if (!Constants.masksTreeRollToggle) { Constants.logger.log(Level.INFO,"Tree masks drop: Disabled"); }
            if (Constants.settingsOutput) { Constants.logger.log(Level.INFO,"Output settings to log: Enabled"); }
            if (!Constants.settingsOutput) { Constants.logger.log(Level.INFO,"Output settings to log: Disabled"); }
            Constants.logger.log(Level.INFO,"Odds for pumpkins to drop pumpkin parts: 3 in " + Constants.partsPumpkinRollBound);
            Constants.logger.log(Level.INFO,"Odds for trees to drop tree parts: 3 in " + Constants.partsTreeRollBound);
            Constants.logger.log(Level.INFO,"Odds for pumpkins to drop a rare bone: 1 in " + Constants.bonePumpkinRollBound);
            Constants.logger.log(Level.INFO,"Odds for trees to drop a rare bone: 1 in " + Constants.boneTreeRollBound);
            Constants.logger.log(Level.INFO,"Odds for pumpkins to drop a set of pumpkin shoulders: 1 in " + Constants.shouldersPumpkinRollBound);
            Constants.logger.log(Level.INFO,"Odds for trees to drop a set of pumpkin shoulders: 1 in " + Constants.shouldersTreeRollBound);
            Constants.logger.log(Level.INFO,"Odds for pumpkins to drop a mask: 1 in " + Constants.masksPumpkinRollBound);
            Constants.logger.log(Level.INFO,"Odds for trees to drop a mask: 1 in " + Constants.masksTreeRollBound);
        }
    }

    @Override
    public void preInit() {
        Constants.logger.log(Level.INFO,"preInit called");
        try {
            CreatureLoot.preInit();
        } catch (IllegalArgumentException | ClassCastException e) {
            throw new HookException(e);
        }
        Constants.logger.log(Level.INFO,"all preInit completed");
    }

    @Override
    public void init() {
        Constants.logger.log(Level.INFO,"init called");
        try {
            ModCreatures.init();
            addCreature(new OminousTree());
            addCreature(new ScaryPumpkin());
            CreatureLoot.init();
        }
        catch (Throwable e) {
            Constants.logger.log(Level.SEVERE, "Error in init()", e);
        }
        Constants.logger.log(Level.INFO,"all init completed");
    }

    // Set custom corpse sizes
    public static boolean hasCustomCorpseSize(Creature creature){
        int templateId = creature.getTemplate().getTemplateId();
        return templateId == OminousTree.templateId;
    }

    // Set custom corpse sizes
    public static void setCorpseSizes(Creature creature, Item corpse){
        if(corpse.getTemplateId() != ItemList.corpse){
            return;
        }
        int templateId = creature.getTemplate().getTemplateId();
        boolean sendStatus = false;
        int size = 50000;
        if(templateId == OminousTree.templateId){
            size *= 10.0;
            corpse.setSizes(size);
            sendStatus = true;
        }else{
            corpse.setSizes((int)((float)(corpse.getSizeX() * (creature.getSizeModX() & 255)) / 64.0f), (int)((float)(corpse.getSizeY() * (creature.getSizeModY() & 255)) / 64.0f), (int)((float)(corpse.getSizeZ() * (creature.getSizeModZ() & 255)) / 64.0f));
        }
        if(sendStatus){
            try {
                Zone zone = Zones.getZone((int)corpse.getPosX() >> 2, (int)corpse.getPosY() >> 2, corpse.isOnSurface());
                zone.removeItem(corpse, true, true);
                zone.addItem(corpse, true, false, false);
            } catch (NoSuchZoneException e) {
                e.printStackTrace();
            }
        }
    }


    public String getVersion() {
        return "v1.0";
    }

}