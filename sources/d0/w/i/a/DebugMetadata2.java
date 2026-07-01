package d0.w.i.a;

import com.discord.widgets.chat.input.MentionUtils;
import d0.z.d.Intrinsics3;
import java.lang.reflect.Field;

/* JADX INFO: renamed from: d0.w.i.a.f, reason: use source file name */
/* JADX INFO: compiled from: DebugMetadata.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class DebugMetadata2 {
    public static final StackTraceElement getStackTraceElement(ContinuationImpl continuationImpl) {
        int iIntValue;
        String strC;
        Intrinsics3.checkNotNullParameter(continuationImpl, "$this$getStackTraceElementImpl");
        DebugMetadata debugMetadata = (DebugMetadata) continuationImpl.getClass().getAnnotation(DebugMetadata.class);
        Object obj = null;
        if (debugMetadata == null) {
            return null;
        }
        int iV = debugMetadata.v();
        if (iV > 1) {
            throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + iV + ". Please update the Kotlin standard library.").toString());
        }
        try {
            Field declaredField = continuationImpl.getClass().getDeclaredField("label");
            Intrinsics3.checkNotNullExpressionValue(declaredField, "field");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(continuationImpl);
            if (obj2 instanceof Integer) {
                obj = obj2;
            }
            Integer num = (Integer) obj;
            iIntValue = (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            iIntValue = -1;
        }
        int i = iIntValue >= 0 ? debugMetadata.l()[iIntValue] : -1;
        String moduleName = DebugMetadata3.c.getModuleName(continuationImpl);
        if (moduleName == null) {
            strC = debugMetadata.c();
        } else {
            strC = moduleName + MentionUtils.SLASH_CHAR + debugMetadata.c();
        }
        return new StackTraceElement(strC, debugMetadata.m(), debugMetadata.f(), i);
    }
}
