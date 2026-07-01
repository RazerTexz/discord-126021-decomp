package lombok.eclipse.agent;

import java.lang.reflect.Method;
import lombok.permit.Permit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IMember;
import org.eclipse.jdt.internal.ui.text.javadoc.JavadocContentAccess2;

/* JADX INFO: loaded from: app.apk:lombok/eclipse/agent/PatchJavadoc$Reflection.SCL.lombok */
class PatchJavadoc$Reflection {
    private static final Method javadoc2HTML;
    private static final Method oldJavadoc2HTML;

    private PatchJavadoc$Reflection() {
    }

    static {
        Method a = null;
        Method b2 = null;
        try {
            a = Permit.getMethod(JavadocContentAccess2.class, "javadoc2HTML", IMember.class, IJavaElement.class, String.class);
        } catch (Throwable unused) {
        }
        try {
            b2 = Permit.getMethod(JavadocContentAccess2.class, "javadoc2HTML", IMember.class, String.class);
        } catch (Throwable unused2) {
        }
        javadoc2HTML = a;
        oldJavadoc2HTML = b2;
    }

    static /* synthetic */ String access$0(IMember iMember, IJavaElement iJavaElement, String str) {
        return javadoc2HTML(iMember, iJavaElement, str);
    }

    private static String javadoc2HTML(IMember member, IJavaElement element, String rawJavadoc) {
        if (javadoc2HTML != null) {
            try {
                return (String) javadoc2HTML.invoke(null, member, element, rawJavadoc);
            } catch (Throwable unused) {
                return null;
            }
        }
        if (oldJavadoc2HTML != null) {
            try {
                return (String) oldJavadoc2HTML.invoke(null, member, rawJavadoc);
            } catch (Throwable unused2) {
                return null;
            }
        }
        return null;
    }
}
