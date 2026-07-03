package p507d0.p513e0.p514p.p515d.p517m0.p567n.p572p1;

import p507d0.p513e0.p514p.p515d.p517m0.p552k.p555u.p556a.InterfaceC11804b;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12010v0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C12016y0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.EnumC11935j1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12008u0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.InterfaceC12012w0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.p1.c */
/* JADX INFO: compiled from: CapturedTypeApproximation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11997c extends AbstractC12010v0 {
    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12010v0
    public InterfaceC12012w0 get(InterfaceC12008u0 interfaceC12008u0) {
        C12238m.checkNotNullParameter(interfaceC12008u0, "key");
        InterfaceC11804b interfaceC11804b = interfaceC12008u0 instanceof InterfaceC11804b ? (InterfaceC11804b) interfaceC12008u0 : null;
        if (interfaceC11804b == null) {
            return null;
        }
        return interfaceC11804b.getProjection().isStarProjection() ? new C12016y0(EnumC11935j1.OUT_VARIANCE, interfaceC11804b.getProjection().getType()) : interfaceC11804b.getProjection();
    }
}
