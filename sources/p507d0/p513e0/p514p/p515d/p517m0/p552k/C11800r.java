package p507d0.p513e0.p514p.p515d.p517m0.p552k;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11322b0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.r */
/* JADX INFO: compiled from: ResolutionAnchorProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11800r {

    /* JADX INFO: renamed from: a */
    public static final C11322b0<InterfaceC11799q> f24427a = new C11322b0<>("ResolutionAnchorProvider");

    public static final InterfaceC11325c0 getResolutionAnchorIfAny(InterfaceC11325c0 interfaceC11325c0) {
        C12238m.checkNotNullParameter(interfaceC11325c0, "<this>");
        InterfaceC11799q interfaceC11799q = (InterfaceC11799q) interfaceC11325c0.getCapability(f24427a);
        if (interfaceC11799q == null) {
            return null;
        }
        return interfaceC11799q.getResolutionAnchor(interfaceC11325c0);
    }
}
