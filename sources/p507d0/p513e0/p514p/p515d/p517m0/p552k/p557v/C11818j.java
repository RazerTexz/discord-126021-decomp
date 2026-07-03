package p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v;

import kotlin.Pair;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11470w;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11787e;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12005t;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.v.j */
/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11818j extends AbstractC11815g<Pair<? extends C11712a, ? extends C11716e>> {

    /* JADX INFO: renamed from: b */
    public final C11712a f24440b;

    /* JADX INFO: renamed from: c */
    public final C11716e f24441c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11818j(C11712a c11712a, C11716e c11716e) {
        super(C12116o.m10073to(c11712a, c11716e));
        C12238m.checkNotNullParameter(c11712a, "enumClassId");
        C12238m.checkNotNullParameter(c11716e, "enumEntryName");
        this.f24440b = c11712a;
        this.f24441c = c11716e;
    }

    public final C11716e getEnumEntryName() {
        return this.f24441c;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g
    public AbstractC11913c0 getType(InterfaceC11325c0 interfaceC11325c0) {
        C12238m.checkNotNullParameter(interfaceC11325c0, "module");
        InterfaceC11330e interfaceC11330eFindClassAcrossModuleDependencies = C11470w.findClassAcrossModuleDependencies(interfaceC11325c0, this.f24440b);
        AbstractC11934j0 defaultType = null;
        if (interfaceC11330eFindClassAcrossModuleDependencies != null) {
            if (!C11787e.isEnumClass(interfaceC11330eFindClassAcrossModuleDependencies)) {
                interfaceC11330eFindClassAcrossModuleDependencies = null;
            }
            if (interfaceC11330eFindClassAcrossModuleDependencies != null) {
                defaultType = interfaceC11330eFindClassAcrossModuleDependencies.getDefaultType();
            }
        }
        if (defaultType != null) {
            return defaultType;
        }
        StringBuilder sbM833U = C1643a.m833U("Containing class for error-class based enum entry ");
        sbM833U.append(this.f24440b);
        sbM833U.append('.');
        sbM833U.append(this.f24441c);
        AbstractC11934j0 abstractC11934j0CreateErrorType = C12005t.createErrorType(sbM833U.toString());
        C12238m.checkNotNullExpressionValue(abstractC11934j0CreateErrorType, "createErrorType(\"Containing class for error-class based enum entry $enumClassId.$enumEntryName\")");
        return abstractC11934j0CreateErrorType;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f24440b.getShortClassName());
        sb.append('.');
        sb.append(this.f24441c);
        return sb.toString();
    }
}
