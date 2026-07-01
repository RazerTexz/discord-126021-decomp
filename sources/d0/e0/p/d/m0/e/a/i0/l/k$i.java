package d0.e0.p.d.m0.e.a.i0.l;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.t0;
import d0.e0.p.d.m0.m.f$m;
import d0.t.u;
import java.util.Collection;
import java.util.LinkedHashSet;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: LazyJavaScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k$i extends d0.z.d.o implements Function1<d0.e0.p.d.m0.g.e, Collection<? extends t0>> {
    public final /* synthetic */ k this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k$i(k kVar) {
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
        LinkedHashSet linkedHashSet = new LinkedHashSet((Collection) ((f$m) k.access$getDeclaredFunctions$p(this.this$0)).invoke(eVar));
        k.access$retainMostSpecificMethods(this.this$0, linkedHashSet);
        this.this$0.f(linkedHashSet, eVar);
        return u.toList(this.this$0.c.getComponents().getSignatureEnhancement().enhanceSignatures(this.this$0.c, linkedHashSet));
    }
}
