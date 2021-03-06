
package org.jubaroo.mods.halloween.creatures;

import com.wurmonline.mesh.Tiles;
import com.wurmonline.server.bodys.BodyTemplate;
import com.wurmonline.server.bodys.Wound;
import com.wurmonline.server.combat.ArmourTemplate;
import com.wurmonline.shared.constants.CreatureTypes;
import com.wurmonline.shared.constants.ItemMaterials;
import org.gotti.wurmunlimited.modsupport.CreatureTemplateBuilder;
import org.gotti.wurmunlimited.modsupport.creatures.EncounterBuilder;
import org.gotti.wurmunlimited.modsupport.creatures.ModCreature;

import static com.wurmonline.server.skills.SkillList.*;

public class ScaryPumpkin implements ModCreature, CreatureTypes {

    private static final String SCARY_PUMPKIN = "mod.creature.pumpkin";
    public static int templateId;

    public CreatureTemplateBuilder createCreateTemplateBuilder() {

        final int[] types = { C_TYPE_MOVE_LOCAL, C_TYPE_MONSTER, C_TYPE_AGG_HUMAN, C_TYPE_HUNTING, C_TYPE_CARNIVORE, C_TYPE_DOMINATABLE, C_TYPE_NON_NEWBIE, C_TYPE_MISSION_OK, C_TYPE_MISSION_TRAITOR_OK };
        final int[] itemsButchered = new int[0];

        final CreatureTemplateBuilder builder = new CreatureTemplateBuilder(SCARY_PUMPKIN, "Scary Pumpkin", "An enchanted tree that have gone berserk from a stray spell. It has come alive and turned hostile.", "model.creature.pumpkin", types, BodyTemplate.TYPE_BEAR, (short) 5, (byte) 0,
                (short) 160, (short) 50, (short) 50, "sound.forest.leafrustle", "sound.forest.leafrustle", "sound.forest.leafrustle", "sound.forest.leafrustle", 0.17f, 6.0f, 1.5f, 11.0f, 0.0f, 0.0f, 1.8f, 750, itemsButchered, 30, 100);

        templateId = builder.getTemplateId();

        builder.skill(BODY_STRENGTH, 26.0f);
        builder.skill(BODY_CONTROL, 26.0f);
        builder.skill(BODY_STAMINA, 26.0f);
        builder.skill(MIND_LOGICAL, 4.0f);
        builder.skill(MIND_SPEED, 4.0f);
        builder.skill(SOUL_STRENGTH, 30.0f);
        builder.skill(SOUL_DEPTH, 4.0f);
        builder.skill(WEAPONLESS_FIGHTING, 30.0f);

        builder.handDamString("vine whip");
        builder.kickDamString("vine whip");
        builder.maxAge(100);
        builder.armourType(ArmourTemplate.ARMOUR_TYPE_STUDDED);
        builder.baseCombatRating(11.0f);
        builder.combatDamageType(Wound.TYPE_PIERCE);
        builder.maxGroupAttackSize(10);
        builder.maxPercentOfCreatures(0.001f);
        builder.meatMaterial(ItemMaterials.MATERIAL_MEAT);

        return builder;
    }

    @Override
    public void addEncounters() {
        if (templateId == 0) {
            return;
        }
        new EncounterBuilder(Tiles.Tile.TILE_GRASS.id).addCreatures(templateId, 1).build(1);
        new EncounterBuilder(Tiles.Tile.TILE_DIRT.id).addCreatures(templateId, 1).build(1);

    }
}