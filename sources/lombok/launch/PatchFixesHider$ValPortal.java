package lombok.launch;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: app.apk:Class50/lombok/launch/PatchFixesHider$ValPortal.SCL.lombok */
public final class PatchFixesHider$ValPortal {
    private static final Method COPY_INITIALIZATION_OF_FOR_EACH_ITERABLE;
    private static final Method COPY_INITIALIZATION_OF_LOCAL_DECLARATION;
    private static final Method ADD_FINAL_AND_VAL_ANNOTATION_TO_VARIABLE_DECLARATION_STATEMENT;
    private static final Method ADD_FINAL_AND_VAL_ANNOTATION_TO_SINGLE_VARIABLE_DECLARATION;

    static {
        Class<?> shadowed = PatchFixesHider$Util.shadowLoadClass("lombok.eclipse.agent.PatchValEclipsePortal");
        COPY_INITIALIZATION_OF_FOR_EACH_ITERABLE = PatchFixesHider$Util.findMethod(shadowed, "copyInitializationOfForEachIterable", Object.class);
        COPY_INITIALIZATION_OF_LOCAL_DECLARATION = PatchFixesHider$Util.findMethod(shadowed, "copyInitializationOfLocalDeclaration", Object.class);
        ADD_FINAL_AND_VAL_ANNOTATION_TO_VARIABLE_DECLARATION_STATEMENT = PatchFixesHider$Util.findMethod(shadowed, "addFinalAndValAnnotationToVariableDeclarationStatement", Object.class, Object.class, Object.class);
        ADD_FINAL_AND_VAL_ANNOTATION_TO_SINGLE_VARIABLE_DECLARATION = PatchFixesHider$Util.findMethod(shadowed, "addFinalAndValAnnotationToSingleVariableDeclaration", Object.class, Object.class, Object.class);
    }

    public static void copyInitializationOfForEachIterable(Object parser) {
        PatchFixesHider$Util.invokeMethod(COPY_INITIALIZATION_OF_FOR_EACH_ITERABLE, parser);
    }

    public static void copyInitializationOfLocalDeclaration(Object parser) {
        PatchFixesHider$Util.invokeMethod(COPY_INITIALIZATION_OF_LOCAL_DECLARATION, parser);
    }

    public static void addFinalAndValAnnotationToVariableDeclarationStatement(Object converter, Object out, Object in) {
        PatchFixesHider$Util.invokeMethod(ADD_FINAL_AND_VAL_ANNOTATION_TO_VARIABLE_DECLARATION_STATEMENT, converter, out, in);
    }

    public static void addFinalAndValAnnotationToSingleVariableDeclaration(Object converter, Object out, Object in) {
        PatchFixesHider$Util.invokeMethod(ADD_FINAL_AND_VAL_ANNOTATION_TO_SINGLE_VARIABLE_DECLARATION, converter, out, in);
    }
}
