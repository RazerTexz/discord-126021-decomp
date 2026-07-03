package androidx.core.os;

import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.C12237l;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Trace.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TraceKt {
    public static final <T> T trace(String str, Function0<? extends T> function0) {
        C12238m.checkNotNullParameter(str, "sectionName");
        C12238m.checkNotNullParameter(function0, "block");
        TraceCompat.beginSection(str);
        try {
            return function0.invoke();
        } finally {
            C12237l.finallyStart(1);
            TraceCompat.endSection();
            C12237l.finallyEnd(1);
        }
    }
}
