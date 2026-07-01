package d0.e0.p.d.m0.e.a.i0.l;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.n0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: LazyJavaScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k$e extends d0.z.d.o implements Function1<d0.e0.p.d.m0.g.e, n0> {
    public final /* synthetic */ k this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k$e(k kVar) {
        super(1);
        this.this$0 = kVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ n0 invoke(d0.e0.p.d.m0.g.e eVar) {
        return invoke2(eVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final n0 invoke2(d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        k kVar = this.this$0;
        k kVar2 = kVar.d;
        if (kVar2 != null) {
            return (n0) k.access$getDeclaredField$p(kVar2).invoke(eVar);
        }
        d0.e0.p.d.m0.e.a.k0.n nVarFindFieldByName = kVar.f.invoke().findFieldByName(eVar);
        if (nVarFindFieldByName == null || nVarFindFieldByName.isEnumEntry()) {
            return null;
        }
        return k.access$resolveProperty(this.this$0, nVarFindFieldByName);
    }
}
