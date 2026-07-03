package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11353h0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11331e0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11334f0;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.m */
/* JADX INFO: compiled from: DeserializedClassDataFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11877m implements InterfaceC11871g {

    /* JADX INFO: renamed from: a */
    public final InterfaceC11334f0 f24668a;

    public C11877m(InterfaceC11334f0 interfaceC11334f0) {
        C12238m.checkNotNullParameter(interfaceC11334f0, "packageFragmentProvider");
        this.f24668a = interfaceC11334f0;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11871g
    public C11870f findClassData(C11712a c11712a) {
        C11870f c11870fFindClassData;
        C12238m.checkNotNullParameter(c11712a, "classId");
        InterfaceC11334f0 interfaceC11334f0 = this.f24668a;
        C11713b packageFqName = c11712a.getPackageFqName();
        C12238m.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
        for (InterfaceC11331e0 interfaceC11331e0 : C11353h0.packageFragments(interfaceC11334f0, packageFqName)) {
            if ((interfaceC11331e0 instanceof AbstractC11878n) && (c11870fFindClassData = ((AbstractC11878n) interfaceC11331e0).getClassDataFinder().findClassData(c11712a)) != null) {
                return c11870fFindClassData;
            }
        }
        return null;
    }
}
