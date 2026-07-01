package d0.e0.p.d.m0.k.a0.p;

import d0.e0.p.d.m0.n.c0;

/* JADX INFO: compiled from: TransientReceiver.java */
/* JADX INFO: loaded from: classes3.dex */
public class g extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(c0 c0Var) {
        super(c0Var, null);
        if (c0Var == null) {
            a(0);
            throw null;
        }
        if (c0Var != null) {
        } else {
            a(1);
            throw null;
        }
    }

    public static /* synthetic */ void a(int i) {
        Object[] objArr = new Object[3];
        if (i != 2) {
            objArr[0] = "type";
        } else {
            objArr[0] = "newType";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/TransientReceiver";
        if (i != 2) {
            objArr[2] = "<init>";
        } else {
            objArr[2] = "replaceType";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("{Transient} : ");
        sbU.append(getType());
        return sbU.toString();
    }
}
