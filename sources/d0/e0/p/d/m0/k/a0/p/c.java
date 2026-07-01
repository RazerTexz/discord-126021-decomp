package d0.e0.p.d.m0.k.a0.p;

import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.j0;
import d0.z.d.m;

/* JADX INFO: compiled from: ImplicitClassReceiver.kt */
/* JADX INFO: loaded from: classes3.dex */
public class c implements d, f {
    public final d0.e0.p.d.m0.c.e a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0.e0.p.d.m0.c.e f3466b;

    public c(d0.e0.p.d.m0.c.e eVar, c cVar) {
        m.checkNotNullParameter(eVar, "classDescriptor");
        this.a = eVar;
        this.f3466b = eVar;
    }

    public boolean equals(Object obj) {
        d0.e0.p.d.m0.c.e eVar = this.a;
        c cVar = obj instanceof c ? (c) obj : null;
        return m.areEqual(eVar, cVar != null ? cVar.a : null);
    }

    @Override // d0.e0.p.d.m0.k.a0.p.f
    public final d0.e0.p.d.m0.c.e getClassDescriptor() {
        return this.a;
    }

    @Override // d0.e0.p.d.m0.k.a0.p.d
    public /* bridge */ /* synthetic */ c0 getType() {
        return getType();
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("Class{");
        sbU.append(getType());
        sbU.append('}');
        return sbU.toString();
    }

    @Override // d0.e0.p.d.m0.k.a0.p.d
    public j0 getType() {
        j0 defaultType = this.a.getDefaultType();
        m.checkNotNullExpressionValue(defaultType, "classDescriptor.defaultType");
        return defaultType;
    }
}
