package p507d0.p513e0.p514p.p515d.p517m0.p552k;

import java.util.Collection;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11464t;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.t */
/* JADX INFO: compiled from: VisibilityUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11802t {
    public static final InterfaceC11321b findMemberWithMaxVisibility(Collection<? extends InterfaceC11321b> collection) {
        Integer numCompare;
        C12238m.checkNotNullParameter(collection, "descriptors");
        collection.isEmpty();
        InterfaceC11321b interfaceC11321b = null;
        for (InterfaceC11321b interfaceC11321b2 : collection) {
            if (interfaceC11321b == null || ((numCompare = C11464t.compare(interfaceC11321b.getVisibility(), interfaceC11321b2.getVisibility())) != null && numCompare.intValue() < 0)) {
                interfaceC11321b = interfaceC11321b2;
            }
        }
        C12238m.checkNotNull(interfaceC11321b);
        return interfaceC11321b;
    }
}
