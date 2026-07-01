package d0.e0.p.d.m0.n;

import java.util.Map;

/* JADX INFO: compiled from: TypeSubstitution.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class v0$a$a extends v0 {
    public final /* synthetic */ Map<u0, w0> c;
    public final /* synthetic */ boolean d;

    /* JADX WARN: Multi-variable type inference failed */
    public v0$a$a(Map<u0, ? extends w0> map, boolean z2) {
        this.c = map;
        this.d = z2;
    }

    @Override // d0.e0.p.d.m0.n.z0
    public boolean approximateCapturedTypes() {
        return this.d;
    }

    @Override // d0.e0.p.d.m0.n.v0
    public w0 get(u0 u0Var) {
        d0.z.d.m.checkNotNullParameter(u0Var, "key");
        return this.c.get(u0Var);
    }

    @Override // d0.e0.p.d.m0.n.z0
    public boolean isEmpty() {
        return this.c.isEmpty();
    }
}
