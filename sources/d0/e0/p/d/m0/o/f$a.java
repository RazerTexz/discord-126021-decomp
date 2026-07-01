package d0.e0.p.d.m0.o;

import d0.e0.p.d.m0.c.x;
import d0.z.d.m;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f$a extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f$a f3548b = new f$a();

    public f$a() {
        super("must be a member function", null);
    }

    @Override // d0.e0.p.d.m0.o.b
    public boolean check(x xVar) {
        m.checkNotNullParameter(xVar, "functionDescriptor");
        return xVar.getDispatchReceiverParameter() != null;
    }
}
