package lombok.launch;

import java.lang.reflect.Method;
import org.eclipse.jdt.internal.compiler.ast.Expression;
import org.eclipse.jdt.internal.compiler.ast.ForeachStatement;
import org.eclipse.jdt.internal.compiler.ast.LocalDeclaration;
import org.eclipse.jdt.internal.compiler.lookup.BlockScope;
import org.eclipse.jdt.internal.compiler.lookup.TypeBinding;

/* JADX INFO: loaded from: app.apk:Class50/lombok/launch/PatchFixesHider$Val.SCL.lombok */
public final class PatchFixesHider$Val {
    private static final Method SKIP_RESOLVE_INITIALIZER_IF_ALREADY_CALLED;
    private static final Method SKIP_RESOLVE_INITIALIZER_IF_ALREADY_CALLED2;
    private static final Method HANDLE_VAL_FOR_LOCAL_DECLARATION;
    private static final Method HANDLE_VAL_FOR_FOR_EACH;

    static {
        Class<?> shadowed = PatchFixesHider$Util.shadowLoadClass("lombok.eclipse.agent.PatchVal");
        SKIP_RESOLVE_INITIALIZER_IF_ALREADY_CALLED = PatchFixesHider$Util.findMethod(shadowed, "skipResolveInitializerIfAlreadyCalled", Expression.class, BlockScope.class);
        SKIP_RESOLVE_INITIALIZER_IF_ALREADY_CALLED2 = PatchFixesHider$Util.findMethod(shadowed, "skipResolveInitializerIfAlreadyCalled2", Expression.class, BlockScope.class, LocalDeclaration.class);
        HANDLE_VAL_FOR_LOCAL_DECLARATION = PatchFixesHider$Util.findMethod(shadowed, "handleValForLocalDeclaration", LocalDeclaration.class, BlockScope.class);
        HANDLE_VAL_FOR_FOR_EACH = PatchFixesHider$Util.findMethod(shadowed, "handleValForForEach", ForeachStatement.class, BlockScope.class);
    }

    public static TypeBinding skipResolveInitializerIfAlreadyCalled(Expression expr, BlockScope scope) {
        return (TypeBinding) PatchFixesHider$Util.invokeMethod(SKIP_RESOLVE_INITIALIZER_IF_ALREADY_CALLED, expr, scope);
    }

    public static TypeBinding skipResolveInitializerIfAlreadyCalled2(Expression expr, BlockScope scope, LocalDeclaration decl) {
        return (TypeBinding) PatchFixesHider$Util.invokeMethod(SKIP_RESOLVE_INITIALIZER_IF_ALREADY_CALLED2, expr, scope, decl);
    }

    public static boolean handleValForLocalDeclaration(LocalDeclaration local, BlockScope scope) {
        return ((Boolean) PatchFixesHider$Util.invokeMethod(HANDLE_VAL_FOR_LOCAL_DECLARATION, local, scope)).booleanValue();
    }

    public static boolean handleValForForEach(ForeachStatement forEach, BlockScope scope) {
        return ((Boolean) PatchFixesHider$Util.invokeMethod(HANDLE_VAL_FOR_FOR_EACH, forEach, scope)).booleanValue();
    }
}
