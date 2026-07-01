package d0.w.i.a;

import com.discord.widgets.chat.input.MentionUtilsKt;
import d0.z.d.m;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: DebugMetadata.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {
    public static final StackTraceElement getStackTraceElement(a aVar) {
        int iIntValue;
        String strC;
        m.checkNotNullParameter(aVar, "$this$getStackTraceElementImpl");
        e eVar = (e) aVar.getClass().getAnnotation(e.class);
        Object obj = null;
        if (eVar == null) {
            return null;
        }
        int iV = eVar.v();
        if (iV > 1) {
            throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + iV + ". Please update the Kotlin standard library.").toString());
        }
        try {
            Field declaredField = aVar.getClass().getDeclaredField("label");
            m.checkNotNullExpressionValue(declaredField, "field");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(aVar);
            if (obj2 instanceof Integer) {
                obj = obj2;
            }
            Integer num = (Integer) obj;
            iIntValue = (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            iIntValue = -1;
        }
        int i = iIntValue >= 0 ? eVar.l()[iIntValue] : -1;
        String moduleName = h.c.getModuleName(aVar);
        if (moduleName == null) {
            strC = eVar.c();
        } else {
            strC = moduleName + MentionUtilsKt.SLASH_CHAR + eVar.c();
        }
        return new StackTraceElement(strC, eVar.m(), eVar.f(), i);
    }
}
