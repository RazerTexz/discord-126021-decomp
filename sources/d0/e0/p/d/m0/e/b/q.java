package d0.e0.p.d.m0.e.b;

import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.c.v0;

/* JADX INFO: compiled from: KotlinJvmBinaryPackageSourceElement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q implements u0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0.e0.p.d.m0.e.a.i0.l.i f3380b;

    public q(d0.e0.p.d.m0.e.a.i0.l.i iVar) {
        d0.z.d.m.checkNotNullParameter(iVar, "packageFragment");
        this.f3380b = iVar;
    }

    @Override // d0.e0.p.d.m0.c.u0
    public v0 getContainingFile() {
        v0 v0Var = v0.a;
        d0.z.d.m.checkNotNullExpressionValue(v0Var, "NO_SOURCE_FILE");
        return v0Var;
    }

    public String toString() {
        return this.f3380b + ": " + this.f3380b.getBinaryClasses$descriptors_jvm().keySet();
    }
}
