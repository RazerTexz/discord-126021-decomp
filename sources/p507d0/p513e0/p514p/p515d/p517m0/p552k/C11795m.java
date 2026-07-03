package p507d0.p513e0.p514p.p515d.p517m0.p552k;

import kotlin.jvm.functions.Function1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11464t;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.m */
/* JADX INFO: compiled from: OverridingUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C11795m implements Function1<InterfaceC11321b, Boolean> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ InterfaceC11330e f24424j;

    public C11795m(InterfaceC11330e interfaceC11330e) {
        this.f24424j = interfaceC11330e;
    }

    @Override // kotlin.jvm.functions.Function1
    public Boolean invoke(InterfaceC11321b interfaceC11321b) {
        return Boolean.valueOf(!C11464t.isPrivate(interfaceC11321b.getVisibility()) && C11464t.isVisibleIgnoringReceiver(interfaceC11321b, this.f24424j));
    }
}
