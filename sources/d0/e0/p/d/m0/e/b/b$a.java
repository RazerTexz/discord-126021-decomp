package d0.e0.p.d.m0.e.b;

import d0.e0.p.d.m0.c.u0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b$a extends b$b implements p$e {
    public final /* synthetic */ b d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b$a(b bVar, s sVar) {
        super(bVar, sVar);
        d0.z.d.m.checkNotNullParameter(bVar, "this$0");
        d0.z.d.m.checkNotNullParameter(sVar, "signature");
        this.d = bVar;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // d0.e0.p.d.m0.e.b.p$e
    public p$a visitParameterAnnotation(int i, d0.e0.p.d.m0.g.a aVar, u0 u0Var) {
        d0.z.d.m.checkNotNullParameter(aVar, "classId");
        d0.z.d.m.checkNotNullParameter(u0Var, "source");
        s sVarFromMethodSignatureAndParameterIndex = s.a.fromMethodSignatureAndParameterIndex(this.a, i);
        List arrayList = (List) this.d.f3364b.get(sVarFromMethodSignatureAndParameterIndex);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.d.f3364b.put(sVarFromMethodSignatureAndParameterIndex, (List<A>) arrayList);
        }
        return a.access$loadAnnotationIfNotSpecial(this.d.a, aVar, u0Var, arrayList);
    }
}
