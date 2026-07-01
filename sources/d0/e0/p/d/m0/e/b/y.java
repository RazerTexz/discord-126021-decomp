package d0.e0.p.d.m0.e.b;

import d0.e0.p.d.m0.n.c0;
import java.util.Collection;

/* JADX INFO: compiled from: methodSignatureMapping.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class y implements x<k> {
    public static final y a = new y();

    @Override // d0.e0.p.d.m0.e.b.x
    public c0 commonSupertype(Collection<? extends c0> collection) {
        d0.z.d.m.checkNotNullParameter(collection, "types");
        throw new AssertionError(d0.z.d.m.stringPlus("There should be no intersection type in existing descriptors, but found: ", d0.t.u.joinToString$default(collection, null, null, null, 0, null, null, 63, null)));
    }

    @Override // d0.e0.p.d.m0.e.b.x
    public String getPredefinedFullInternalNameForClass(d0.e0.p.d.m0.c.e eVar) {
        return x$a.getPredefinedFullInternalNameForClass(this, eVar);
    }

    @Override // d0.e0.p.d.m0.e.b.x
    public String getPredefinedInternalNameForClass(d0.e0.p.d.m0.c.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, "classDescriptor");
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // d0.e0.p.d.m0.e.b.x
    public k getPredefinedTypeForClass(d0.e0.p.d.m0.c.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, "classDescriptor");
        return null;
    }

    @Override // d0.e0.p.d.m0.e.b.x
    public /* bridge */ /* synthetic */ k getPredefinedTypeForClass(d0.e0.p.d.m0.c.e eVar) {
        return getPredefinedTypeForClass(eVar);
    }

    @Override // d0.e0.p.d.m0.e.b.x
    public c0 preprocessType(c0 c0Var) {
        return x$a.preprocessType(this, c0Var);
    }

    @Override // d0.e0.p.d.m0.e.b.x
    public void processErrorType(c0 c0Var, d0.e0.p.d.m0.c.e eVar) {
        d0.z.d.m.checkNotNullParameter(c0Var, "kotlinType");
        d0.z.d.m.checkNotNullParameter(eVar, "descriptor");
    }

    @Override // d0.e0.p.d.m0.e.b.x
    public boolean releaseCoroutines() {
        return x$a.releaseCoroutines(this);
    }
}
