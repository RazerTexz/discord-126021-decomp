package p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v;

import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11291k;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11470w;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12005t;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.y */
/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11833y extends AbstractC11810b0<Integer> {
    public C11833y(int i) {
        super(Integer.valueOf(i));
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g
    public AbstractC11913c0 getType(InterfaceC11325c0 interfaceC11325c0) {
        C12238m.checkNotNullParameter(interfaceC11325c0, "module");
        InterfaceC11330e interfaceC11330eFindClassAcrossModuleDependencies = C11470w.findClassAcrossModuleDependencies(interfaceC11325c0, C11291k.a.f22543g0);
        AbstractC11934j0 defaultType = interfaceC11330eFindClassAcrossModuleDependencies == null ? null : interfaceC11330eFindClassAcrossModuleDependencies.getDefaultType();
        if (defaultType != null) {
            return defaultType;
        }
        AbstractC11934j0 abstractC11934j0CreateErrorType = C12005t.createErrorType("Unsigned type UInt not found");
        C12238m.checkNotNullExpressionValue(abstractC11934j0CreateErrorType, "createErrorType(\"Unsigned type UInt not found\")");
        return abstractC11934j0CreateErrorType;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g
    public String toString() {
        return getValue().intValue() + ".toUInt()";
    }
}
