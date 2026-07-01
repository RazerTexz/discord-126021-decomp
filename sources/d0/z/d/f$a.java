package d0.z.d;

import com.discord.models.domain.ModelAuditLogEntry;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ClassReference.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f$a {
    public f$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final String getClassQualifiedName(Class<?> cls) {
        String str;
        m.checkNotNullParameter(cls, "jClass");
        String strW = null;
        if (cls.isAnonymousClass() || cls.isLocalClass()) {
            return null;
        }
        if (!cls.isArray()) {
            String str2 = (String) f.access$getClassFqNames$cp().get(cls.getName());
            return str2 != null ? str2 : cls.getCanonicalName();
        }
        Class<?> componentType = cls.getComponentType();
        m.checkNotNullExpressionValue(componentType, "componentType");
        if (componentType.isPrimitive() && (str = (String) f.access$getClassFqNames$cp().get(componentType.getName())) != null) {
            strW = b.d.b.a.a.w(str, "Array");
        }
        return strW != null ? strW : "kotlin.Array";
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0043  */
    /* JADX WARN: Code duplicated, block: B:14:0x0049  */
    /* JADX WARN: Code duplicated, block: B:15:0x0065  */
    /* JADX WARN: Instruction removed from duplicated block: B:14:0x0049, please report this as an issue */
    public final String getClassSimpleName(Class<?> cls) {
        String str;
        Constructor<?> enclosingConstructor;
        String strSubstringAfter$default;
        m.checkNotNullParameter(cls, "jClass");
        String strW = null;
        if (!cls.isAnonymousClass()) {
            if (cls.isLocalClass()) {
                String simpleName = cls.getSimpleName();
                Method enclosingMethod = cls.getEnclosingMethod();
                if (enclosingMethod != null) {
                    m.checkNotNullExpressionValue(simpleName, ModelAuditLogEntry.CHANGE_KEY_NAME);
                    strSubstringAfter$default = d0.g0.w.substringAfter$default(simpleName, enclosingMethod.getName() + "$", (String) null, 2, (Object) null);
                    if (strSubstringAfter$default == null) {
                        enclosingConstructor = cls.getEnclosingConstructor();
                        if (enclosingConstructor != null) {
                            m.checkNotNullExpressionValue(simpleName, ModelAuditLogEntry.CHANGE_KEY_NAME);
                            strSubstringAfter$default = d0.g0.w.substringAfter$default(simpleName, enclosingConstructor.getName() + "$", (String) null, 2, (Object) null);
                        } else {
                            strSubstringAfter$default = null;
                        }
                    }
                } else {
                    enclosingConstructor = cls.getEnclosingConstructor();
                    if (enclosingConstructor != null) {
                        m.checkNotNullExpressionValue(simpleName, ModelAuditLogEntry.CHANGE_KEY_NAME);
                        strSubstringAfter$default = d0.g0.w.substringAfter$default(simpleName, enclosingConstructor.getName() + "$", (String) null, 2, (Object) null);
                    } else {
                        strSubstringAfter$default = null;
                    }
                }
                if (strSubstringAfter$default != null) {
                    return strSubstringAfter$default;
                }
                m.checkNotNullExpressionValue(simpleName, ModelAuditLogEntry.CHANGE_KEY_NAME);
                return d0.g0.w.substringAfter$default(simpleName, '$', (String) null, 2, (Object) null);
            }
            if (!cls.isArray()) {
                String str2 = (String) f.access$getSimpleNames$cp().get(cls.getName());
                return str2 != null ? str2 : cls.getSimpleName();
            }
            Class<?> componentType = cls.getComponentType();
            m.checkNotNullExpressionValue(componentType, "componentType");
            if (componentType.isPrimitive() && (str = (String) f.access$getSimpleNames$cp().get(componentType.getName())) != null) {
                strW = b.d.b.a.a.w(str, "Array");
            }
            if (strW == null) {
                return "Array";
            }
        }
        return strW;
    }
}
