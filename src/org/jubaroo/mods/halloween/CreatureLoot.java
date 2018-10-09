
package org.jubaroo.mods.halloween;

import com.wurmonline.server.Server;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.items.Item;
import com.wurmonline.server.items.ItemFactory;
import com.wurmonline.server.items.ItemList;
import com.wurmonline.server.items.Materials;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import javassist.bytecode.Descriptor;
import org.gotti.wurmunlimited.modloader.classhooks.HookException;
import org.gotti.wurmunlimited.modloader.classhooks.HookManager;
import org.jubaroo.mods.halloween.creatures.OminousTree;
import org.jubaroo.mods.halloween.creatures.ScaryPumpkin;

public class CreatureLoot {

    public static void modifyNewCreature(Creature creature){
        try{
            Item inv = creature.getInventory();
            int templateId = creature.getTemplate().getTemplateId();
            Item rareBone = ItemFactory.createItem(ItemList.boneCollar, 50.0f + (Server.rand.nextFloat() * 49.9f), Materials.MATERIAL_BONE, (byte) (Server.rand.nextInt(3)+ 1), null);
            Item shouldersPumpkin = ItemFactory.createItem(ItemList.shoulderPumpkinHalloween, 50.0f + (Server.rand.nextFloat() * 49.9f), Materials.MATERIAL_LEATHER, (byte) (Server.rand.nextInt(3)), null);
            Item maskTrollHalloween = ItemFactory.createItem(ItemList.maskTrollHalloween, 50.0f + (Server.rand.nextFloat() * 49.9f), Materials.MATERIAL_LEATHER, (byte) (Server.rand.nextInt(3)), null);
            Item candy = ItemFactory.createItem(ItemList.sweet, 10.0f + (Server.rand.nextFloat() * 89.9f), Materials.MATERIAL_VEGETARIAN, (byte) 0, null);
            if (templateId == ScaryPumpkin.templateId) {
                if (Constants.partsPumpkinRollToggle) {
                    int partsPumpkinRoll = Server.rand.nextInt(Constants.partsPumpkinRollBound);
                    switch (partsPumpkinRoll) {
                        case 0:
                            Item pumpkin = ItemFactory.createItem(ItemList.pumpkin, 1.0f + ((99.9f) * Server.rand.nextFloat()), Materials.MATERIAL_VEGETARIAN, (byte) 0, null);
                            inv.insertItem(pumpkin, true);
                            inv.insertItem(candy, true);
                            break;
                        case 1:
                            Item seedPumpkin = ItemFactory.createItem(ItemList.pumpkinSeed, 1.0f + ((99.9f) * Server.rand.nextFloat()), Materials.MATERIAL_VEGETARIAN, (byte) 0, null);
                            inv.insertItem(seedPumpkin, true);
                            inv.insertItem(seedPumpkin, true);
                            inv.insertItem(seedPumpkin, true);
                            inv.insertItem(seedPumpkin, true);
                            inv.insertItem(seedPumpkin, true);
                            inv.insertItem(candy, true);
                            break;
                        case 2:
                            Item carvedPumpkin = ItemFactory.createItem(ItemList.pumpkinHalloween, 20.0f + ((79.9f) * Server.rand.nextFloat()), Materials.MATERIAL_VEGETARIAN, (byte) 0, null);
                            inv.insertItem(carvedPumpkin, true);
                            inv.insertItem(candy, true);
                            break;
                    }
                }
                if (Constants.bonePumpkinRollToggle) {
                    int bonePumpkinRoll = Server.rand.nextInt(Constants.bonePumpkinRollBound);
                    switch (bonePumpkinRoll) {
                        case 0:
                            inv.insertItem(rareBone, true);
                            break;
                    }
                }
                if (Constants.shouldersPumpkinRollToggle) {
                    int shouldersPumpkinRoll = Server.rand.nextInt(Constants.shouldersPumpkinRollBound);
                    switch (shouldersPumpkinRoll) {
                        case 0:
                            inv.insertItem(shouldersPumpkin, true);
                            break;
                    }
                }
                if (Constants.masksPumpkinRollToggle) {
                    int masksPumpkinRoll = Server.rand.nextInt(Constants.masksPumpkinRollBound);
                    switch (masksPumpkinRoll) {
                        case 0:
                            inv.insertItem(maskTrollHalloween, true);
                            break;
                    }
                }

            }
            else if (templateId == OminousTree.templateId) {
                if (Constants.partsTreeRollToggle) {
                    int partsTreeRoll = Server.rand.nextInt(Constants.partsTreeRollBound);
                    switch (partsTreeRoll) {
                        case 0:
                            Item branch = ItemFactory.createItem(ItemList.branch, 1.0f + ((99.9f) * Server.rand.nextFloat()), Materials.MATERIAL_WOOD_BIRCH, (byte) 0, null);
                            inv.insertItem(branch, true);
                            inv.insertItem(branch, true);
                            inv.insertItem(branch, true);
                            inv.insertItem(candy, true);
                            break;
                        case 1:
                            Item log = ItemFactory.createItem(ItemList.log, 1.0f + ((99.9f) * Server.rand.nextFloat()), Materials.MATERIAL_WOOD_OAK, (byte) 0, null);
                            inv.insertItem(log, true);
                            inv.insertItem(log, true);
                            inv.insertItem(log, true);
                            inv.insertItem(log, true);
                            inv.insertItem(log, true);
                            inv.insertItem(candy, true);
                            break;
                        case 2:
                            Item acorn = ItemFactory.createItem(ItemList.acorn, 1.0f + ((99.9f) * Server.rand.nextFloat()), Materials.MATERIAL_VEGETARIAN, (byte) 0, null);
                            inv.insertItem(acorn, true);
                            inv.insertItem(candy, true);
                            break;
                    }
                }
                if (Constants.boneTreeRollToggle) {
                    int boneTreeRoll = Server.rand.nextInt(Constants.boneTreeRollBound);
                    switch (boneTreeRoll) {
                        case 0:
                            inv.insertItem(rareBone, true);
                            break;
                    }
                }
                if (Constants.shouldersTreeRollToggle) {
                    int shouldersTreeRoll = Server.rand.nextInt(Constants.shouldersTreeRollBound);
                    switch (shouldersTreeRoll) {
                        case 0:
                            inv.insertItem(shouldersPumpkin, true);
                            break;
                    }
                }
                if (Constants.masksTreeRollToggle) {
                    int masksTreeRoll = Server.rand.nextInt(Constants.masksTreeRollBound);
                    switch (masksTreeRoll) {
                        case 0:
                            inv.insertItem(maskTrollHalloween, true);
                            break;
                    }
                }

            }
            else if (Constants.candyOnMonsters) {
                if (creature.isMonster()) {
                    inv.insertItem(candy, true);
                }
            }
            else if (Constants.candyOnUndead) {
                if (creature.isUndead()) {
                    inv.insertItem(candy, true);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    static void preInit(){
        try{
            ClassPool classPool = HookManager.getInstance().getClassPool();
            final Class<CreatureLoot> thisClass = CreatureLoot.class;
            String replace;

            CtClass ctCreature = classPool.get("com.wurmonline.server.creatures.Creature");
            Utility.setReason("Set custom corpse sizes.");
            replace = "$_ = $proceed($$);"
                    + "if("+Initiator.class.getName()+".hasCustomCorpseSize(this)){"
                    + "  "+Initiator.class.getName()+".setCorpseSizes(this, corpse);"
                    + "}";
            Utility.instrumentDeclared(thisClass, ctCreature, "die", "addItem", replace);
        } catch ( NotFoundException | IllegalArgumentException | ClassCastException e) {
            throw new HookException(e);
        }
    }

    static void init() throws CannotCompileException {
        try {
            ClassPool classPool = HookManager.getInstance().getClassPool();
            final Class<CreatureLoot> thisClass = CreatureLoot.class;
            CtClass ctCreature = classPool.get("com.wurmonline.server.creatures.Creature");
            String replace;
            CtClass[] params = {
                    CtClass.intType,
                    CtClass.booleanType,
                    CtClass.floatType,
                    CtClass.floatType,
                    CtClass.floatType,
                    CtClass.intType,
                    classPool.get("java.lang.String"),
                    CtClass.byteType,
                    CtClass.byteType,
                    CtClass.byteType,
                    CtClass.booleanType,
                    CtClass.byteType,
                    CtClass.intType
            };
            String desc = Descriptor.ofMethod(ctCreature, params);
            replace = "$_ = $proceed($$);"
                    + CreatureLoot.class.getName()+".modifyNewCreature($1);";
            Utility.instrumentDescribed(thisClass, ctCreature, "doNew", desc, "sendToWorld", replace);
        }
        catch (NotFoundException e) {
            throw new HookException(e);
        }
    }

}