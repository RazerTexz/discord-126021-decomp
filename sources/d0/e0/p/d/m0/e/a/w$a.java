package d0.e0.p.d.m0.e.a;

import d0.e0.p.d.m0.c.f1;

/* JADX INFO: compiled from: JavaDescriptorVisibilities.java */
/* JADX INFO: loaded from: classes3.dex */
public class w$a extends d0.e0.p.d.m0.c.r {
    public w$a(f1 f1Var) {
        super(f1Var);
    }

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        if (i != 1) {
            objArr[0] = "what";
        } else {
            objArr[0] = "from";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$1";
        objArr[2] = "isVisible";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // d0.e0.p.d.m0.c.u
    public boolean isVisible(d0.e0.p.d.m0.k.a0.p.d dVar, d0.e0.p.d.m0.c.q qVar, d0.e0.p.d.m0.c.m mVar) {
        if (qVar == null) {
            a(0);
            throw null;
        }
        if (mVar != null) {
            return w.c(qVar, mVar);
        }
        a(1);
        throw null;
    }
}
