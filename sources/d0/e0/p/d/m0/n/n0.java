package d0.e0.p.d.m0.n;

/* JADX INFO: compiled from: StarProjectionImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n0 extends x0 {
    public final c0 a;

    public n0(d0.e0.p.d.m0.b.h hVar) {
        d0.z.d.m.checkNotNullParameter(hVar, "kotlinBuiltIns");
        j0 nullableAnyType = hVar.getNullableAnyType();
        d0.z.d.m.checkNotNullExpressionValue(nullableAnyType, "kotlinBuiltIns.nullableAnyType");
        this.a = nullableAnyType;
    }

    @Override // d0.e0.p.d.m0.n.w0
    public j1 getProjectionKind() {
        return j1.OUT_VARIANCE;
    }

    @Override // d0.e0.p.d.m0.n.w0
    public c0 getType() {
        return this.a;
    }

    @Override // d0.e0.p.d.m0.n.w0
    public boolean isStarProjection() {
        return true;
    }

    @Override // d0.e0.p.d.m0.n.w0
    public w0 refine(d0.e0.p.d.m0.n.l1.g gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "kotlinTypeRefiner");
        return this;
    }
}
