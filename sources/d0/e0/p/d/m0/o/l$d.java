package d0.e0.p.d.m0.o;

import d0.e0.p.d.m0.c.x;
import d0.z.d.m;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l$d extends l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l$d f3560b = new l$d();

    public l$d() {
        super("must have a single value parameter", null);
    }

    @Override // d0.e0.p.d.m0.o.b
    public boolean check(x xVar) {
        m.checkNotNullParameter(xVar, "functionDescriptor");
        return xVar.getValueParameters().size() == 1;
    }
}
