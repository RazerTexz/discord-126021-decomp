package androidx.core.os;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.l;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: Trace.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TraceKt {
    public static final <T> T trace(String str, Function0<? extends T> function0) {
        m.checkNotNullParameter(str, "sectionName");
        m.checkNotNullParameter(function0, "block");
        TraceCompat.beginSection(str);
        try {
            return function0.invoke();
        } finally {
            l.finallyStart(1);
            TraceCompat.endSection();
            l.finallyEnd(1);
        }
    }
}
