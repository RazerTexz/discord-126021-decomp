package d0.e0.p.d.m0.n;

/* JADX INFO: compiled from: AbstractTypeChecker.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f$b$d extends f$b {
    public static final f$b$d a = new f$b$d();

    public f$b$d() {
        super(null);
    }

    @Override // d0.e0.p.d.m0.n.f$b
    public d0.e0.p.d.m0.n.n1.i transformType(f fVar, d0.e0.p.d.m0.n.n1.h hVar) {
        d0.z.d.m.checkNotNullParameter(fVar, "context");
        d0.z.d.m.checkNotNullParameter(hVar, "type");
        return fVar.upperBoundIfFlexible(hVar);
    }
}
