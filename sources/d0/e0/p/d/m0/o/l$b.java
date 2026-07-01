package d0.e0.p.d.m0.o;

import d0.e0.p.d.m0.c.x;
import d0.z.d.m;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l$b extends l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3558b;

    public l$b(int i) {
        super(b.d.b.a.a.r("must have exactly ", i, " value parameters"), null);
        this.f3558b = i;
    }

    @Override // d0.e0.p.d.m0.o.b
    public boolean check(x xVar) {
        m.checkNotNullParameter(xVar, "functionDescriptor");
        return xVar.getValueParameters().size() == this.f3558b;
    }
}
