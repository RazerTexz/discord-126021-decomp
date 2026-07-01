package d0.e0.p.d.m0.l.b.e0;

import d0.e0.p.d.m0.c.y0;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DeserializedMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$c$e extends o implements Function1<d0.e0.p.d.m0.g.e, y0> {
    public final /* synthetic */ h$c this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h$c$e(h$c h_c) {
        super(1);
        this.this$0 = h_c;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ y0 invoke(d0.e0.p.d.m0.g.e eVar) {
        return invoke2(eVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final y0 invoke2(d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, "it");
        return h$c.access$createTypeAlias(this.this$0, eVar);
    }
}
