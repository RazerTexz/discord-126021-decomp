package d0.e0.p.d.m0.e.a.i0.l;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.t0;
import d0.e0.p.d.m0.e.a.g0.g$a;
import d0.e0.p.d.m0.m.f$m;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: LazyJavaScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k$f extends d0.z.d.o implements Function1<d0.e0.p.d.m0.g.e, Collection<? extends t0>> {
    public final /* synthetic */ k this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k$f(k kVar) {
        super(1);
        this.this$0 = kVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Collection<? extends t0> invoke(d0.e0.p.d.m0.g.e eVar) {
        return invoke2(eVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Collection<t0> invoke2(d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        k kVar = this.this$0.d;
        if (kVar != null) {
            return (Collection) ((f$m) k.access$getDeclaredFunctions$p(kVar)).invoke(eVar);
        }
        ArrayList arrayList = new ArrayList();
        for (d0.e0.p.d.m0.e.a.k0.r rVar : this.this$0.f.invoke().findMethodsByName(eVar)) {
            d0.e0.p.d.m0.e.a.h0.f fVarM = this.this$0.m(rVar);
            if (this.this$0.k(fVarM)) {
                ((g$a) this.this$0.c.getComponents().getJavaResolverCache()).recordMethod(rVar, fVarM);
                arrayList.add(fVarM);
            }
        }
        this.this$0.c(arrayList, eVar);
        return arrayList;
    }
}
