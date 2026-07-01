package d0.e0.p.d.m0.f.z;

import d0.e0.p.d.m0.i.g$d;
import d0.e0.p.d.m0.i.g$f;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: ProtoBufUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <M extends g$d<M>, T> T getExtensionOrNull(g$d<M> g_d, g$f<M, T> g_f) {
        m.checkNotNullParameter(g_d, "<this>");
        m.checkNotNullParameter(g_f, "extension");
        if (g_d.hasExtension(g_f)) {
            return (T) g_d.getExtension(g_f);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <M extends g$d<M>, T> T getExtensionOrNull(g$d<M> g_d, g$f<M, List<T>> g_f, int i) {
        m.checkNotNullParameter(g_d, "<this>");
        m.checkNotNullParameter(g_f, "extension");
        if (i < g_d.getExtensionCount(g_f)) {
            return (T) g_d.getExtension(g_f, i);
        }
        return null;
    }
}
