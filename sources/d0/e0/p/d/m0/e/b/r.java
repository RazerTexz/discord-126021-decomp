package d0.e0.p.d.m0.e.b;

import d0.e0.p.d.m0.c.v0;

/* JADX INFO: compiled from: KotlinJvmBinarySourceElement.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r implements d0.e0.p.d.m0.l.b.e0.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f3381b;

    public r(p pVar, d0.e0.p.d.m0.l.b.r<d0.e0.p.d.m0.f.a0.b.f> rVar, boolean z2, d0.e0.p.d.m0.l.b.e0.e eVar) {
        d0.z.d.m.checkNotNullParameter(pVar, "binaryClass");
        d0.z.d.m.checkNotNullParameter(eVar, "abiStability");
        this.f3381b = pVar;
    }

    public final p getBinaryClass() {
        return this.f3381b;
    }

    @Override // d0.e0.p.d.m0.c.u0
    public v0 getContainingFile() {
        v0 v0Var = v0.a;
        d0.z.d.m.checkNotNullExpressionValue(v0Var, "NO_SOURCE_FILE");
        return v0Var;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.f
    public String getPresentableString() {
        StringBuilder sbU = b.d.b.a.a.U("Class '");
        sbU.append(this.f3381b.getClassId().asSingleFqName().asString());
        sbU.append('\'');
        return sbU.toString();
    }

    public String toString() {
        return ((Object) r.class.getSimpleName()) + ": " + this.f3381b;
    }
}
