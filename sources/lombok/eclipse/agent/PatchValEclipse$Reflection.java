package lombok.eclipse.agent;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import lombok.permit.Permit;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.MarkerAnnotation;
import org.eclipse.jdt.core.dom.Modifier;
import org.eclipse.jdt.internal.compiler.ast.LocalDeclaration;
import org.eclipse.jdt.internal.compiler.parser.Parser;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchValEclipse$Reflection.SCL.lombok */
public final class PatchValEclipse$Reflection {
    private static final Field initCopyField;
    private static final Field iterableCopyField;
    private static final Field astStackField;
    private static final Field astPtrField;
    private static final Constructor<Modifier> modifierConstructor;
    private static final Constructor<MarkerAnnotation> markerAnnotationConstructor;
    private static final Method astConverterRecordNodes;

    static /* synthetic */ Field access$2() {
        return iterableCopyField;
    }

    static /* synthetic */ Field access$3() {
        return initCopyField;
    }

    static /* synthetic */ Field access$0() {
        return astStackField;
    }

    static /* synthetic */ Field access$1() {
        return astPtrField;
    }

    static /* synthetic */ Constructor access$5() {
        return modifierConstructor;
    }

    static /* synthetic */ Constructor access$6() {
        return markerAnnotationConstructor;
    }

    static /* synthetic */ Method access$4() {
        return astConverterRecordNodes;
    }

    static {
        Field a = null;
        Field b2 = null;
        Field c = null;
        Field d = null;
        Constructor<Modifier> f = null;
        Constructor<MarkerAnnotation> g = null;
        Method h = null;
        try {
            a = Permit.getField(LocalDeclaration.class, "$initCopy");
            b2 = Permit.getField(LocalDeclaration.class, "$iterableCopy");
        } catch (Throwable unused) {
        }
        try {
            c = Permit.getField(Parser.class, "astStack");
            d = Permit.getField(Parser.class, "astPtr");
            f = Permit.getConstructor(Modifier.class, AST.class);
            g = Permit.getConstructor(MarkerAnnotation.class, AST.class);
            Class<?> z2 = Class.forName("org.eclipse.jdt.core.dom.ASTConverter");
            h = Permit.getMethod(z2, "recordNodes", ASTNode.class, org.eclipse.jdt.internal.compiler.ast.ASTNode.class);
        } catch (Throwable unused2) {
        }
        initCopyField = a;
        iterableCopyField = b2;
        astStackField = c;
        astPtrField = d;
        modifierConstructor = f;
        markerAnnotationConstructor = g;
        astConverterRecordNodes = h;
    }
}
