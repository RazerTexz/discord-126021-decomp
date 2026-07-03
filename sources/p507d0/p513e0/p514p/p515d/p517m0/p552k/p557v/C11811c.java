package p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.c */
/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11811c extends AbstractC11815g<Boolean> {
    public C11811c(boolean z2) {
        super(Boolean.valueOf(z2));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g
    public AbstractC11934j0 getType(InterfaceC11325c0 interfaceC11325c0) {
        C12238m.checkNotNullParameter(interfaceC11325c0, "module");
        AbstractC11934j0 booleanType = interfaceC11325c0.getBuiltIns().getBooleanType();
        C12238m.checkNotNullExpressionValue(booleanType, "module.builtIns.booleanType");
        return booleanType;
    }
}
