package lombok.eclipse.agent;

import java.lang.reflect.InvocationTargetException;
import lombok.Lombok;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchValEclipsePortal.SCL.lombok */
public class PatchValEclipsePortal {
    static final String LOCALDECLARATION_SIG = "org.eclipse.jdt.internal.compiler.ast.LocalDeclaration";
    static final String PARSER_SIG = "org.eclipse.jdt.internal.compiler.parser.Parser";
    static final String VARIABLEDECLARATIONSTATEMENT_SIG = "org.eclipse.jdt.core.dom.VariableDeclarationStatement";
    static final String SINGLEVARIABLEDECLARATION_SIG = "org.eclipse.jdt.core.dom.SingleVariableDeclaration";
    static final String ASTCONVERTER_SIG = "org.eclipse.jdt.core.dom.ASTConverter";

    public static void copyInitializationOfForEachIterable(Object parser) {
        try {
            PatchValEclipsePortal$Reflection.copyInitializationOfForEachIterable.invoke(null, parser);
        } catch (IllegalAccessException e) {
            throw Lombok.sneakyThrow(e);
        } catch (NoClassDefFoundError unused) {
        } catch (NullPointerException e2) {
            if (!"false".equals(System.getProperty("lombok.debug.reflection", "false"))) {
                e2.initCause(PatchValEclipsePortal$Reflection.problem);
                throw e2;
            }
        } catch (InvocationTargetException e3) {
            throw Lombok.sneakyThrow(e3.getCause());
        }
    }

    public static void copyInitializationOfLocalDeclaration(Object parser) {
        try {
            PatchValEclipsePortal$Reflection.copyInitializationOfLocalDeclaration.invoke(null, parser);
        } catch (IllegalAccessException e) {
            throw Lombok.sneakyThrow(e);
        } catch (NoClassDefFoundError unused) {
        } catch (NullPointerException e2) {
            if (!"false".equals(System.getProperty("lombok.debug.reflection", "false"))) {
                e2.initCause(PatchValEclipsePortal$Reflection.problem);
                throw e2;
            }
        } catch (InvocationTargetException e3) {
            throw Lombok.sneakyThrow(e3.getCause());
        }
    }

    public static void addFinalAndValAnnotationToVariableDeclarationStatement(Object converter, Object out, Object in) {
        try {
            PatchValEclipsePortal$Reflection.addFinalAndValAnnotationToVariableDeclarationStatement.invoke(null, converter, out, in);
        } catch (IllegalAccessException e) {
            throw Lombok.sneakyThrow(e);
        } catch (NoClassDefFoundError unused) {
        } catch (NullPointerException e2) {
            if (!"false".equals(System.getProperty("lombok.debug.reflection", "false"))) {
                e2.initCause(PatchValEclipsePortal$Reflection.problem);
                throw e2;
            }
        } catch (InvocationTargetException e3) {
            throw Lombok.sneakyThrow(e3.getCause());
        }
    }

    public static void addFinalAndValAnnotationToSingleVariableDeclaration(Object converter, Object out, Object in) {
        try {
            PatchValEclipsePortal$Reflection.addFinalAndValAnnotationToSingleVariableDeclaration.invoke(null, converter, out, in);
        } catch (IllegalAccessException e) {
            throw Lombok.sneakyThrow(e);
        } catch (NoClassDefFoundError unused) {
        } catch (NullPointerException e2) {
            if (!"false".equals(System.getProperty("lombok.debug.reflection", "false"))) {
                e2.initCause(PatchValEclipsePortal$Reflection.problem);
                throw e2;
            }
        } catch (InvocationTargetException e3) {
            throw Lombok.sneakyThrow(e3.getCause());
        }
    }
}
