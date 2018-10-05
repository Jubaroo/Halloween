
package org.jubaroo.mods.halloween;

import java.util.logging.Logger;

class Constants {
    static Logger logger;
    static boolean success;
    static String reason;
    static boolean settingsOutput;
    static int partsPumpkinRollBound;
    static int partsTreeRollBound;
    static int bonePumpkinRollBound;
    static int boneTreeRollBound;
    static int shouldersPumpkinRollBound;
    static int shouldersTreeRollBound;
    static int masksPumpkinRollBound;
    static int masksTreeRollBound;
    static boolean partsPumpkinRollToggle;
    static boolean partsTreeRollToggle;
    static boolean bonePumpkinRollToggle;
    static boolean boneTreeRollToggle;
    static boolean shouldersPumpkinRollToggle;
    static boolean shouldersTreeRollToggle;
    static boolean masksPumpkinRollToggle;
    static boolean masksTreeRollToggle;

    static {
        logger = Logger.getLogger(Constants.class.getName());
        success = false;
        reason = "";
        settingsOutput = false;
        partsPumpkinRollBound = 10;
        partsTreeRollBound = 10;
        bonePumpkinRollBound = 100;
        boneTreeRollBound = 100;
        shouldersPumpkinRollBound = 100;
        shouldersTreeRollBound = 100;
        masksPumpkinRollBound = 100;
        masksTreeRollBound = 100;
        partsTreeRollToggle = false;
        bonePumpkinRollToggle = false;
        boneTreeRollToggle = false;
        shouldersPumpkinRollToggle = false;
        shouldersTreeRollToggle = false;
        masksPumpkinRollToggle = false;
        masksTreeRollToggle = false;
    }

}
