package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p568l1.AbstractC11947g;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.h1 */
/* JADX INFO: compiled from: ErrorType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11929h1 extends C12003s {

    /* JADX INFO: renamed from: p */
    public final String f24780p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11929h1(String str, InterfaceC12008u0 interfaceC12008u0, InterfaceC11770i interfaceC11770i, List<? extends InterfaceC12012w0> list, boolean z2) {
        super(interfaceC12008u0, interfaceC11770i, list, z2, null, 16, null);
        C12238m.checkNotNullParameter(str, "presentableName");
        C12238m.checkNotNullParameter(interfaceC12008u0, "constructor");
        C12238m.checkNotNullParameter(interfaceC11770i, "memberScope");
        C12238m.checkNotNullParameter(list, "arguments");
        this.f24780p = str;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.C12003s
    public String getPresentableName() {
        return this.f24780p;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.C12003s, p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1, p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0
    public C11929h1 refine(AbstractC11947g abstractC11947g) {
        C12238m.checkNotNullParameter(abstractC11947g, "kotlinTypeRefiner");
        return this;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.C12003s, p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11932i1
    public AbstractC11934j0 makeNullableAsSpecified(boolean z2) {
        return new C11929h1(getPresentableName(), getConstructor(), getMemberScope(), getArguments(), z2);
    }
}
