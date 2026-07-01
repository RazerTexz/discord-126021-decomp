package lombok.eclipse.agent;

import java.lang.reflect.Field;
import lombok.permit.Permit;
import org.eclipse.jdt.internal.compiler.ast.LocalDeclaration;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchVal$Reflection.SCL.lombok */
public final class PatchVal$Reflection {
    private static final Field initCopyField;
    private static final Field iterableCopyField;

    static /* synthetic */ Field access$0() {
        return initCopyField;
    }

    static /* synthetic */ Field access$1() {
        return iterableCopyField;
    }

    static {
        Field a = null;
        Field b2 = null;
        try {
            a = Permit.getField(LocalDeclaration.class, "$initCopy");
            b2 = Permit.getField(LocalDeclaration.class, "$iterableCopy");
        } catch (Throwable unused) {
        }
        initCopyField = a;
        iterableCopyField = b2;
    }
}
