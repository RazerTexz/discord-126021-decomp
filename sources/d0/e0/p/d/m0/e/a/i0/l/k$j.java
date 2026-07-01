package d0.e0.p.d.m0.e.a.i0.l;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.n0;
import d0.t.u;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: LazyJavaScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k$j extends d0.z.d.o implements Function1<d0.e0.p.d.m0.g.e, List<? extends n0>> {
    public final /* synthetic */ k this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k$j(k kVar) {
        super(1);
        this.this$0 = kVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ List<? extends n0> invoke(d0.e0.p.d.m0.g.e eVar) {
        return invoke2(eVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<n0> invoke2(d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        ArrayList arrayList = new ArrayList();
        d0.e0.p.d.m0.p.a.addIfNotNull(arrayList, k.access$getDeclaredField$p(this.this$0).invoke(eVar));
        this.this$0.g(eVar, arrayList);
        return d0.e0.p.d.m0.k.e.isAnnotationClass(this.this$0.j()) ? u.toList(arrayList) : u.toList(this.this$0.c.getComponents().getSignatureEnhancement().enhanceSignatures(this.this$0.c, arrayList));
    }
}
