package d0.e0.p.d.m0.n;

import java.util.List;

/* JADX INFO: compiled from: KotlinType.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k1 extends c0 {
    public k1() {
        super(null);
    }

    public abstract c0 a();

    @Override // d0.e0.p.d.m0.c.g1.a
    public d0.e0.p.d.m0.c.g1.g getAnnotations() {
        return a().getAnnotations();
    }

    @Override // d0.e0.p.d.m0.n.c0
    public List<w0> getArguments() {
        return a().getArguments();
    }

    @Override // d0.e0.p.d.m0.n.c0
    public u0 getConstructor() {
        return a().getConstructor();
    }

    @Override // d0.e0.p.d.m0.n.c0
    public d0.e0.p.d.m0.k.a0.i getMemberScope() {
        return a().getMemberScope();
    }

    public boolean isComputed() {
        return true;
    }

    @Override // d0.e0.p.d.m0.n.c0
    public boolean isMarkedNullable() {
        return a().isMarkedNullable();
    }

    public String toString() {
        return isComputed() ? a().toString() : "<Not computed yet>";
    }

    @Override // d0.e0.p.d.m0.n.c0
    public final i1 unwrap() {
        c0 c0VarA = a();
        while (c0VarA instanceof k1) {
            c0VarA = ((k1) c0VarA).a();
        }
        return (i1) c0VarA;
    }
}
