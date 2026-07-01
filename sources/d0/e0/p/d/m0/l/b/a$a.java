package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.c.e0;
import java.io.InputStream;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: AbstractDeserializedPackageFragmentProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$a extends d0.z.d.o implements Function1<d0.e0.p.d.m0.g.b, e0> {
    public final /* synthetic */ a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a$a(a aVar) {
        super(1);
        this.this$0 = aVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ e0 invoke(d0.e0.p.d.m0.g.b bVar) {
        return invoke2(bVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final e0 invoke2(d0.e0.p.d.m0.g.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        d0.e0.p.d.m0.b.q.o oVar = (d0.e0.p.d.m0.b.q.o) this.this$0;
        Objects.requireNonNull(oVar);
        d0.z.d.m.checkNotNullParameter(bVar, "fqName");
        InputStream inputStreamFindBuiltInsData = oVar.f3481b.findBuiltInsData(bVar);
        d0.e0.p.d.m0.l.b.d0.c cVarCreate = inputStreamFindBuiltInsData == null ? null : d0.e0.p.d.m0.l.b.d0.c.v.create(bVar, oVar.a, oVar.c, inputStreamFindBuiltInsData, false);
        if (cVarCreate == null) {
            return null;
        }
        j jVar = this.this$0.d;
        if (jVar != null) {
            cVarCreate.initialize(jVar);
            return cVarCreate;
        }
        d0.z.d.m.throwUninitializedPropertyAccessException("components");
        throw null;
    }
}
