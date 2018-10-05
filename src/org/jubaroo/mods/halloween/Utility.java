
package org.jubaroo.mods.halloween;

import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.NotFoundException;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;

import java.util.logging.Logger;

public class Utility {

    public Utility() {
    }

    public static void setReason(String reason) {
        reason = " [Reason: " + reason + "]";
    }

    private static void checkSuccess(int type, Class<?> instrumentingClass, CtClass editClass, String declaredMethod, String methodCall) {
        String editType = "Instrument";
        if (type == 1) {
            editType = "Insert";
        } else if (type == 2) {
            editType = "Set Body";
        }

        String errorType = editType.toUpperCase();
        Logger classLogger = Logger.getLogger(instrumentingClass.getName());
        if (Constants.success) {
            classLogger.info(editType + ": " + editClass.getSimpleName() + " - " + declaredMethod + " " + (methodCall.length() > 0 ? "call to " + methodCall + " " : "") + "successful." + Constants.reason);
        } else {
            classLogger.severe("[" + errorType + " ERROR] from " + instrumentingClass.getSimpleName() + "! Could not " + editType + " " + editClass.getName() + " - " + declaredMethod + (methodCall.length() > 0 ? " call to " + methodCall + " " : "") + "!" + Constants.reason);
        }

        Constants.success = false;
        Constants.reason = "";
    }

    public static void instrumentDeclaredCount(Class<?> instrumentingClass, CtClass ctToInstrument, String declaredMethod, final String methodCall, final int count, final String replace) {
        try {
            ctToInstrument.getDeclaredMethod(declaredMethod).instrument(new ExprEditor() {
                private int n = 1;

                public void edit(MethodCall m) throws CannotCompileException {
                    if (m.getMethodName().equals(methodCall)) {
                        if (this.n == count) {
                            m.replace(replace);
                            Constants.success = true;
                        }

                        ++this.n;
                    }

                }
            });
            checkSuccess(0, instrumentingClass, ctToInstrument, declaredMethod, methodCall);
        } catch (NotFoundException | CannotCompileException var7) {
            checkSuccess(0, instrumentingClass, ctToInstrument, declaredMethod, methodCall);
            Constants.logger.severe(var7.getMessage());
        }

    }

    public static void instrumentDeclared(Class<?> instrumentingClass, CtClass ctToInstrument, String declaredMethod, final String methodCall, final String replace) {
        try {
            ctToInstrument.getDeclaredMethod(declaredMethod).instrument(new ExprEditor() {
                public void edit(MethodCall m) throws CannotCompileException {
                    if (m.getMethodName().equals(methodCall)) {
                        m.replace(replace);
                        Constants.success = true;
                    }

                }
            });
            checkSuccess(0, instrumentingClass, ctToInstrument, declaredMethod, methodCall);
        } catch (NotFoundException | CannotCompileException var6) {
            checkSuccess(0, instrumentingClass, ctToInstrument, declaredMethod, methodCall);
            Constants.logger.severe(var6.getMessage());
        }

    }

    public static void instrumentDescribedCount(Class<?> instrumentingClass, CtClass ctToInstrument, String declaredMethod, String descriptor, final String methodCall, final int count, final String replace) {
        try {
            ctToInstrument.getMethod(declaredMethod, descriptor).instrument(new ExprEditor() {
                private int n = 1;

                public void edit(MethodCall m) throws CannotCompileException {
                    if (m.getMethodName().equals(methodCall)) {
                        if (this.n == count) {
                            m.replace(replace);
                            Constants.success = true;
                        }

                        ++this.n;
                    }

                }
            });
            checkSuccess(0, instrumentingClass, ctToInstrument, declaredMethod, methodCall);
        } catch (NotFoundException | CannotCompileException var8) {
            checkSuccess(0, instrumentingClass, ctToInstrument, declaredMethod, methodCall);
            Constants.logger.severe(var8.getMessage());
        }

    }

    public static void instrumentDescribed(Class<?> instrumentingClass, CtClass ctToInstrument, String declaredMethod, String descriptor, final String methodCall, final String replace) {
        try {
            ctToInstrument.getMethod(declaredMethod, descriptor).instrument(new ExprEditor() {
                public void edit(MethodCall m) throws CannotCompileException {
                    if (m.getMethodName().equals(methodCall)) {
                        m.replace(replace);
                        Constants.success = true;
                    }

                }
            });
            checkSuccess(0, instrumentingClass, ctToInstrument, declaredMethod, methodCall);
        } catch (NotFoundException | CannotCompileException var7) {
            checkSuccess(0, instrumentingClass, ctToInstrument, declaredMethod, methodCall);
            Constants.logger.severe(var7.getMessage());
        }

    }

    public static void insertAfterDeclared(Class<?> instrumentingClass, CtClass ctToInstrument, String declaredMethod, String insert) {
        try {
            ctToInstrument.getDeclaredMethod(declaredMethod).insertAfter(insert);
            Constants.success = true;
            checkSuccess(1, instrumentingClass, ctToInstrument, declaredMethod, "");
        } catch (NotFoundException | CannotCompileException var5) {
            checkSuccess(1, instrumentingClass, ctToInstrument, declaredMethod, "");
            Constants.logger.severe(var5.getMessage());
        }

    }

    public static void insertAfterDescribed(Class<?> instrumentingClass, CtClass ctToInstrument, String declaredMethod, String descriptor, String insert) {
        try {
            ctToInstrument.getMethod(declaredMethod, descriptor).insertAfter(insert);
            Constants.success = true;
            checkSuccess(1, instrumentingClass, ctToInstrument, declaredMethod, "");
        } catch (NotFoundException | CannotCompileException var6) {
            checkSuccess(1, instrumentingClass, ctToInstrument, declaredMethod, "");
            Constants.logger.severe(var6.getMessage());
        }

    }

    public static void insertBeforeDeclared(Class<?> instrumentingClass, CtClass ctToInstrument, String declaredMethod, String insert) {
        try {
            ctToInstrument.getDeclaredMethod(declaredMethod).insertBefore(insert);
            Constants.success = true;
            checkSuccess(1, instrumentingClass, ctToInstrument, declaredMethod, "");
        } catch (NotFoundException | CannotCompileException var5) {
            checkSuccess(1, instrumentingClass, ctToInstrument, declaredMethod, "");
            Constants.logger.severe(var5.getMessage());
        }

    }

    public static void insertBeforeDescribed(Class<?> instrumentingClass, CtClass ctToInstrument, String declaredMethod, String descriptor, String insert) {
        try {
            ctToInstrument.getMethod(declaredMethod, descriptor).insertBefore(insert);
            Constants.success = true;
            checkSuccess(1, instrumentingClass, ctToInstrument, declaredMethod, "");
        } catch (NotFoundException | CannotCompileException var6) {
            checkSuccess(1, instrumentingClass, ctToInstrument, declaredMethod, "");
            Constants.logger.severe(var6.getMessage());
        }

    }

    public static void setBodyDeclared(Class<?> instrumentingClass, CtClass ctToInstrument, String declaredMethod, String body) {
        try {
            ctToInstrument.getDeclaredMethod(declaredMethod).setBody(body);
            Constants.success = true;
            checkSuccess(2, instrumentingClass, ctToInstrument, declaredMethod, "");
        } catch (NotFoundException | CannotCompileException var5) {
            checkSuccess(2, instrumentingClass, ctToInstrument, declaredMethod, "");
            Constants.logger.severe(var5.getMessage());
        }

    }

    public static void setBodyDescribed(Class<?> instrumentingClass, CtClass ctToInstrument, String declaredMethod, String descriptor, String body) {
        try {
            ctToInstrument.getMethod(declaredMethod, descriptor).setBody(body);
            Constants.success = true;
            checkSuccess(2, instrumentingClass, ctToInstrument, declaredMethod, "");
        } catch (NotFoundException | CannotCompileException var6) {
            checkSuccess(2, instrumentingClass, ctToInstrument, declaredMethod, "");
            Constants.logger.severe(var6.getMessage());
        }

    }
}
