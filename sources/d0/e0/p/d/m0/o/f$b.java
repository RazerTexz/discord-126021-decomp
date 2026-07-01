package d0.e0.p.d.m0.o;

import d0.e0.p.d.m0.c.x;
import d0.z.d.m;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f$b extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f$b f3549b = new f$b();

    public f$b() {
        super("must be a member or an extension function", null);
    }

    @Override // d0.e0.p.d.m0.o.b
    public boolean check(x xVar) {
        m.checkNotNullParameter(xVar, "functionDescriptor");
        return (xVar.getDispatchReceiverParameter() == null && xVar.getExtensionReceiverParameter() == null) ? false : true;
    }
}
