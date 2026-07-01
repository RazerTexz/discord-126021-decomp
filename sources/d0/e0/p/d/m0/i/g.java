package d0.e0.p.d.m0.i;

import java.io.Serializable;
import java.util.Collections;

/* JADX INFO: compiled from: GeneratedMessageLite.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g extends a implements Serializable {
    public g() {
    }

    public static <ContainingType extends n, Type> g$f<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingtype, n nVar, h$b<?> h_b, int i, w$b w_b, boolean z2, Class cls) {
        return new g$f<>(containingtype, Collections.emptyList(), nVar, new g$e(h_b, i, w_b, true, z2), cls);
    }

    public static <ContainingType extends n, Type> g$f<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingtype, Type type, n nVar, h$b<?> h_b, int i, w$b w_b, Class cls) {
        return new g$f<>(containingtype, type, nVar, new g$e(h_b, i, w_b, false, false), cls);
    }

    public g(g$b g_b) {
    }
}
