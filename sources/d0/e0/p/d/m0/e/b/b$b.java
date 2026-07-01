package d0.e0.p.d.m0.e.b;

import d0.e0.p.d.m0.c.u0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
public class b$b implements p$c {
    public final s a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<A> f3365b;
    public final /* synthetic */ b c;

    public b$b(b bVar, s sVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "this$0");
        d0.z.d.m.checkNotNullParameter(sVar, "signature");
        this.c = bVar;
        this.a = sVar;
        this.f3365b = new ArrayList<>();
    }

    @Override // d0.e0.p.d.m0.e.b.p$c
    public p$a visitAnnotation(d0.e0.p.d.m0.g.a aVar, u0 u0Var) {
        d0.z.d.m.checkNotNullParameter(aVar, "classId");
        d0.z.d.m.checkNotNullParameter(u0Var, "source");
        return a.access$loadAnnotationIfNotSpecial(this.c.a, aVar, u0Var, this.f3365b);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // d0.e0.p.d.m0.e.b.p$c
    public void visitEnd() {
        if (!this.f3365b.isEmpty()) {
            this.c.f3364b.put(this.a, (List<A>) this.f3365b);
        }
    }
}
