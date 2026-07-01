package d0.e0.p.d.m0.e.b;

/* JADX INFO: compiled from: JavaClassDataFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements d0.e0.p.d.m0.l.b.g {
    public final n a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f3377b;

    public g(n nVar, f fVar) {
        d0.z.d.m.checkNotNullParameter(nVar, "kotlinClassFinder");
        d0.z.d.m.checkNotNullParameter(fVar, "deserializedDescriptorResolver");
        this.a = nVar;
        this.f3377b = fVar;
    }

    @Override // d0.e0.p.d.m0.l.b.g
    public d0.e0.p.d.m0.l.b.f findClassData(d0.e0.p.d.m0.g.a aVar) {
        d0.z.d.m.checkNotNullParameter(aVar, "classId");
        p pVarFindKotlinClass = o.findKotlinClass(this.a, aVar);
        if (pVarFindKotlinClass == null) {
            return null;
        }
        d0.z.d.m.areEqual(pVarFindKotlinClass.getClassId(), aVar);
        return this.f3377b.readClassData$descriptors_jvm(pVarFindKotlinClass);
    }
}
