package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.c.e0;
import d0.e0.p.d.m0.c.f0;
import d0.e0.p.d.m0.c.h0;

/* JADX INFO: compiled from: DeserializedClassDataFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m implements g {
    public final f0 a;

    public m(f0 f0Var) {
        d0.z.d.m.checkNotNullParameter(f0Var, "packageFragmentProvider");
        this.a = f0Var;
    }

    @Override // d0.e0.p.d.m0.l.b.g
    public f findClassData(d0.e0.p.d.m0.g.a aVar) {
        f fVarFindClassData;
        d0.z.d.m.checkNotNullParameter(aVar, "classId");
        f0 f0Var = this.a;
        d0.e0.p.d.m0.g.b packageFqName = aVar.getPackageFqName();
        d0.z.d.m.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
        for (e0 e0Var : h0.packageFragments(f0Var, packageFqName)) {
            if ((e0Var instanceof n) && (fVarFindClassData = ((n) e0Var).getClassDataFinder().findClassData(aVar)) != null) {
                return fVarFindClassData;
            }
        }
        return null;
    }
}
