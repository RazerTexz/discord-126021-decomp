package d0.e0.p.d.m0.o;

import d0.e0.p.d.m0.c.x;
import d0.e0.p.d.m0.n.c0;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: modifierChecks.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k implements b {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<d0.e0.p.d.m0.b.h, c0> f3556b;
    public final String c;

    public k(String str, Function1 function1, DefaultConstructorMarker defaultConstructorMarker) {
        this.a = str;
        this.f3556b = function1;
        this.c = m.stringPlus("must return ", str);
    }

    @Override // d0.e0.p.d.m0.o.b
    public boolean check(x xVar) {
        m.checkNotNullParameter(xVar, "functionDescriptor");
        return m.areEqual(xVar.getReturnType(), this.f3556b.invoke(d0.e0.p.d.m0.k.x.a.getBuiltIns(xVar)));
    }

    @Override // d0.e0.p.d.m0.o.b
    public String getDescription() {
        return this.c;
    }

    @Override // d0.e0.p.d.m0.o.b
    public String invoke(x xVar) {
        return b$a.invoke(this, xVar);
    }
}
