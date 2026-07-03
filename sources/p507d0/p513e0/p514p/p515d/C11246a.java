package p507d0.p513e0.p514p.p515d;

import kotlin.Unit;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11385m;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.a */
/* JADX INFO: compiled from: util.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C11246a extends C11385m<AbstractC11256f<?>, Unit> {

    /* JADX INFO: renamed from: a */
    public final AbstractC11262i f22319a;

    public C11246a(AbstractC11262i abstractC11262i) {
        C12238m.checkNotNullParameter(abstractC11262i, "container");
        this.f22319a = abstractC11262i;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11385m, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o
    public AbstractC11256f<?> visitFunctionDescriptor(InterfaceC11472x interfaceC11472x, Unit unit) {
        C12238m.checkNotNullParameter(interfaceC11472x, "descriptor");
        C12238m.checkNotNullParameter(unit, "data");
        return new C11264j(this.f22319a, interfaceC11472x);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11454o
    public AbstractC11256f<?> visitPropertyDescriptor(InterfaceC11453n0 interfaceC11453n0, Unit unit) {
        C12238m.checkNotNullParameter(interfaceC11453n0, "descriptor");
        C12238m.checkNotNullParameter(unit, "data");
        int i = (interfaceC11453n0.getDispatchReceiverParameter() != null ? 1 : 0) + (interfaceC11453n0.getExtensionReceiverParameter() != null ? 1 : 0);
        if (interfaceC11453n0.isVar()) {
            if (i == 0) {
                return new C11266k(this.f22319a, interfaceC11453n0);
            }
            if (i == 1) {
                return new C11268l(this.f22319a, interfaceC11453n0);
            }
            if (i == 2) {
                return new C11279m(this.f22319a, interfaceC11453n0);
            }
        } else {
            if (i == 0) {
                return new C12050p(this.f22319a, interfaceC11453n0);
            }
            if (i == 1) {
                return new C12051q(this.f22319a, interfaceC11453n0);
            }
            if (i == 2) {
                return new C12052r(this.f22319a, interfaceC11453n0);
            }
        }
        throw new C11247a0("Unsupported property: " + interfaceC11453n0);
    }
}
