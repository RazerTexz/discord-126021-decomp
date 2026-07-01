package d0.e0.p.d.m0.e.b;

import d0.e0.p.d.m0.n.c0;
import java.util.Collection;

/* JADX INFO: compiled from: descriptorBasedTypeSignatureMapping.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface x<T> {
    c0 commonSupertype(Collection<c0> collection);

    String getPredefinedFullInternalNameForClass(d0.e0.p.d.m0.c.e eVar);

    String getPredefinedInternalNameForClass(d0.e0.p.d.m0.c.e eVar);

    T getPredefinedTypeForClass(d0.e0.p.d.m0.c.e eVar);

    c0 preprocessType(c0 c0Var);

    void processErrorType(c0 c0Var, d0.e0.p.d.m0.c.e eVar);

    boolean releaseCoroutines();
}
