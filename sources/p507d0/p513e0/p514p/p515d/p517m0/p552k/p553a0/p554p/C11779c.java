package p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p;

import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.p.c */
/* JADX INFO: compiled from: ImplicitClassReceiver.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C11779c implements InterfaceC11780d, InterfaceC11782f {

    /* JADX INFO: renamed from: a */
    public final InterfaceC11330e f24389a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC11330e f24390b;

    public C11779c(InterfaceC11330e interfaceC11330e, C11779c c11779c) {
        C12238m.checkNotNullParameter(interfaceC11330e, "classDescriptor");
        this.f24389a = interfaceC11330e;
        this.f24390b = interfaceC11330e;
    }

    public boolean equals(Object obj) {
        InterfaceC11330e interfaceC11330e = this.f24389a;
        C11779c c11779c = obj instanceof C11779c ? (C11779c) obj : null;
        return C12238m.areEqual(interfaceC11330e, c11779c != null ? c11779c.f24389a : null);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p.InterfaceC11782f
    public final InterfaceC11330e getClassDescriptor() {
        return this.f24389a;
    }

    public int hashCode() {
        return this.f24389a.hashCode();
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("Class{");
        sbM833U.append(getType());
        sbM833U.append('}');
        return sbM833U.toString();
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.p554p.InterfaceC11780d
    public AbstractC11934j0 getType() {
        AbstractC11934j0 defaultType = this.f24389a.getDefaultType();
        C12238m.checkNotNullExpressionValue(defaultType, "classDescriptor.defaultType");
        return defaultType;
    }
}
