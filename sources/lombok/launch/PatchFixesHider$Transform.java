package lombok.launch;

import java.io.IOException;
import java.lang.reflect.Method;
import org.eclipse.jdt.internal.compiler.ast.CompilationUnitDeclaration;
import org.eclipse.jdt.internal.compiler.parser.Parser;

/* JADX INFO: loaded from: app.apk:Class50/lombok/launch/PatchFixesHider$Transform.SCL.lombok */
public final class PatchFixesHider$Transform {
    private static final Method TRANSFORM;
    private static final Method TRANSFORM_SWAPPED;

    static {
        Class<?> shadowed = PatchFixesHider$Util.shadowLoadClass("lombok.eclipse.TransformEclipseAST");
        TRANSFORM = PatchFixesHider$Util.findMethod(shadowed, "transform", Parser.class, CompilationUnitDeclaration.class);
        TRANSFORM_SWAPPED = PatchFixesHider$Util.findMethod(shadowed, "transform_swapped", CompilationUnitDeclaration.class, Parser.class);
    }

    public static void transform(Parser parser, CompilationUnitDeclaration ast) throws IOException {
        PatchFixesHider$Util.invokeMethod(TRANSFORM, parser, ast);
    }

    public static void transform_swapped(CompilationUnitDeclaration ast, Parser parser) throws IOException {
        PatchFixesHider$Util.invokeMethod(TRANSFORM_SWAPPED, ast, parser);
    }
}
