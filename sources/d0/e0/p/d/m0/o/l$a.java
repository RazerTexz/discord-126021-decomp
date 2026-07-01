package d0.e0.p.d.m0.o;

import d0.e0.p.d.m0.c.x;
import d0.z.d.m;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l$a extends l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3557b;

    /* JADX WARN: Illegal instructions before constructor call */
    public l$a(int i) {
        StringBuilder sbV = b.d.b.a.a.V("must have at least ", i, " value parameter");
        sbV.append(i > 1 ? "s" : "");
        super(sbV.toString(), null);
        this.f3557b = i;
    }

    @Override // d0.e0.p.d.m0.o.b
    public boolean check(x xVar) {
        m.checkNotNullParameter(xVar, "functionDescriptor");
        return xVar.getValueParameters().size() >= this.f3557b;
    }
}
