package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.c.u0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ProtoContainer.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class y {
    public final d0.e0.p.d.m0.f.z.c a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0.e0.p.d.m0.f.z.g f3510b;
    public final u0 c;

    public y(d0.e0.p.d.m0.f.z.c cVar, d0.e0.p.d.m0.f.z.g gVar, u0 u0Var, DefaultConstructorMarker defaultConstructorMarker) {
        this.a = cVar;
        this.f3510b = gVar;
        this.c = u0Var;
    }

    public abstract d0.e0.p.d.m0.g.b debugFqName();

    public final d0.e0.p.d.m0.f.z.c getNameResolver() {
        return this.a;
    }

    public final u0 getSource() {
        return this.c;
    }

    public final d0.e0.p.d.m0.f.z.g getTypeTable() {
        return this.f3510b;
    }

    public String toString() {
        return ((Object) getClass().getSimpleName()) + ": " + debugFqName();
    }
}
