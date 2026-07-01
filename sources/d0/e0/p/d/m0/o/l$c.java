package d0.e0.p.d.m0.o;

import d0.e0.p.d.m0.c.x;
import d0.z.d.m;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l$c extends l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l$c f3559b = new l$c();

    public l$c() {
        super("must have no value parameters", null);
    }

    @Override // d0.e0.p.d.m0.o.b
    public boolean check(x xVar) {
        m.checkNotNullParameter(xVar, "functionDescriptor");
        return xVar.getValueParameters().isEmpty();
    }
}
