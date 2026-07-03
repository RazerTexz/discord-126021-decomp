package p507d0.p513e0.p514p.p515d.p517m0.p552k;

import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.l */
/* JADX INFO: compiled from: OverridingUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11794l implements Function1<InterfaceC11321b, Boolean> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ InterfaceC11450m f24423j;

    public C11794l(InterfaceC11450m interfaceC11450m) {
        this.f24423j = interfaceC11450m;
    }

    @Override // kotlin.jvm.functions.Function1
    public Boolean invoke(InterfaceC11321b interfaceC11321b) {
        return Boolean.valueOf(interfaceC11321b.getContainingDeclaration() == this.f24423j);
    }
}
