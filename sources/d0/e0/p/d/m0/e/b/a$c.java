package d0.e0.p.d.m0.e.b;

import d0.e0.p.d.m0.c.u0;
import java.util.ArrayList;

/* JADX INFO: compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$c implements p$c {
    public final /* synthetic */ a<A, C> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList<A> f3363b;

    public a$c(a<A, C> aVar, ArrayList<A> arrayList) {
        this.a = aVar;
        this.f3363b = arrayList;
    }

    @Override // d0.e0.p.d.m0.e.b.p$c
    public p$a visitAnnotation(d0.e0.p.d.m0.g.a aVar, u0 u0Var) {
        d0.z.d.m.checkNotNullParameter(aVar, "classId");
        d0.z.d.m.checkNotNullParameter(u0Var, "source");
        return a.access$loadAnnotationIfNotSpecial(this.a, aVar, u0Var, this.f3363b);
    }

    @Override // d0.e0.p.d.m0.e.b.p$c
    public void visitEnd() {
    }
}
