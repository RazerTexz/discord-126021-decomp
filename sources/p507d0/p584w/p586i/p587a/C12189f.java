package p507d0.p584w.p586i.p587a;

import com.discord.widgets.chat.input.MentionUtilsKt;
import java.lang.reflect.Field;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.w.i.a.f */
/* JADX INFO: compiled from: DebugMetadata.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12189f {
    public static final StackTraceElement getStackTraceElement(AbstractC12184a abstractC12184a) {
        int iIntValue;
        String strM10084c;
        C12238m.checkNotNullParameter(abstractC12184a, "$this$getStackTraceElementImpl");
        InterfaceC12188e interfaceC12188e = (InterfaceC12188e) abstractC12184a.getClass().getAnnotation(InterfaceC12188e.class);
        Object obj = null;
        if (interfaceC12188e == null) {
            return null;
        }
        int iM10088v = interfaceC12188e.m10088v();
        if (iM10088v > 1) {
            throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + iM10088v + ". Please update the Kotlin standard library.").toString());
        }
        try {
            Field declaredField = abstractC12184a.getClass().getDeclaredField("label");
            C12238m.checkNotNullExpressionValue(declaredField, "field");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(abstractC12184a);
            if (obj2 instanceof Integer) {
                obj = obj2;
            }
            Integer num = (Integer) obj;
            iIntValue = (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            iIntValue = -1;
        }
        int i = iIntValue >= 0 ? interfaceC12188e.m10086l()[iIntValue] : -1;
        String moduleName = C12191h.f25247c.getModuleName(abstractC12184a);
        if (moduleName == null) {
            strM10084c = interfaceC12188e.m10084c();
        } else {
            strM10084c = moduleName + MentionUtilsKt.SLASH_CHAR + interfaceC12188e.m10084c();
        }
        return new StackTraceElement(strM10084c, interfaceC12188e.m10087m(), interfaceC12188e.m10085f(), i);
    }
}
