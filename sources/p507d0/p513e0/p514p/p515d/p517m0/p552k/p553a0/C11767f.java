package p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0;

import java.util.ArrayList;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.AbstractC11791i;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11793k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.a0.f */
/* JADX INFO: compiled from: GivenFunctionsMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11767f extends AbstractC11791i {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ ArrayList<InterfaceC11450m> f24365a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AbstractC11766e f24366b;

    public C11767f(ArrayList<InterfaceC11450m> arrayList, AbstractC11766e abstractC11766e) {
        this.f24365a = arrayList;
        this.f24366b = abstractC11766e;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.AbstractC11792j
    public void addFakeOverride(InterfaceC11321b interfaceC11321b) {
        C12238m.checkNotNullParameter(interfaceC11321b, "fakeOverride");
        C11793k.resolveUnknownVisibilityForMember(interfaceC11321b, null);
        this.f24365a.add(interfaceC11321b);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p552k.AbstractC11791i
    public void conflict(InterfaceC11321b interfaceC11321b, InterfaceC11321b interfaceC11321b2) {
        C12238m.checkNotNullParameter(interfaceC11321b, "fromSuper");
        C12238m.checkNotNullParameter(interfaceC11321b2, "fromCurrent");
        throw new IllegalStateException(("Conflict in scope of " + this.f24366b.f24363c + ": " + interfaceC11321b + " vs " + interfaceC11321b2).toString());
    }
}
