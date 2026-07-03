package p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.m */
/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11821m extends AbstractC11824p<Integer> {
    public C11821m(int i) {
        super(Integer.valueOf(i));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g
    public AbstractC11934j0 getType(InterfaceC11325c0 interfaceC11325c0) {
        C12238m.checkNotNullParameter(interfaceC11325c0, "module");
        AbstractC11934j0 intType = interfaceC11325c0.getBuiltIns().getIntType();
        C12238m.checkNotNullExpressionValue(intType, "module.builtIns.intType");
        return intType;
    }
}
