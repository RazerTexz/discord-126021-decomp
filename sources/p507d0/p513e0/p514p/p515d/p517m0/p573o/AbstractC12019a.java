package p507d0.p513e0.p514p.p515d.p517m0.p573o;

import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x;
import p507d0.p513e0.p514p.p515d.p517m0.p573o.AbstractC12021c;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.o.a */
/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC12019a {
    public final AbstractC12021c check(InterfaceC11472x interfaceC11472x) {
        C12238m.checkNotNullParameter(interfaceC11472x, "functionDescriptor");
        for (C12022d c12022d : getChecks$descriptors()) {
            if (c12022d.isApplicable(interfaceC11472x)) {
                return c12022d.checkAll(interfaceC11472x);
            }
        }
        return AbstractC12021c.a.f24901b;
    }

    public abstract List<C12022d> getChecks$descriptors();
}
