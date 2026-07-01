package d0.e0.p.d.m0.k.a0.p;

import d0.e0.p.d.m0.n.c0;

/* JADX INFO: compiled from: AbstractReceiverValue.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements d {
    public final c0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f3465b;

    public a(c0 c0Var, d dVar) {
        if (c0Var == null) {
            a(0);
            throw null;
        }
        this.a = c0Var;
        this.f3465b = dVar == null ? this : dVar;
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 1 || i == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 2) ? 2 : 3];
        if (i == 1 || i == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
        } else {
            objArr[0] = "receiverType";
        }
        if (i == 1) {
            objArr[1] = "getType";
        } else if (i != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/scopes/receivers/AbstractReceiverValue";
        } else {
            objArr[1] = "getOriginal";
        }
        if (i != 1 && i != 2) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // d0.e0.p.d.m0.k.a0.p.d
    public c0 getType() {
        c0 c0Var = this.a;
        if (c0Var != null) {
            return c0Var;
        }
        a(1);
        throw null;
    }
}
