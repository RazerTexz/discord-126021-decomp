package d0.e0.p.d.m0.l.b.e0;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.u0;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$c$a extends o implements Function1<d0.e0.p.d.m0.g.e, d0.e0.p.d.m0.c.e> {
    public final /* synthetic */ d$c this$0;
    public final /* synthetic */ d this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d$c$a(d$c d_c, d dVar) {
        super(1);
        this.this$0 = d_c;
        this.this$1 = dVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.e invoke(d0.e0.p.d.m0.g.e eVar) {
        return invoke2(eVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final d0.e0.p.d.m0.c.e invoke2(d0.e0.p.d.m0.g.e eVar) {
        d0.z.d.m.checkNotNullParameter(eVar, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.e0.p.d.m0.f.g gVar = (d0.e0.p.d.m0.f.g) d$c.access$getEnumEntryProtos$p(this.this$0).get(eVar);
        if (gVar == null) {
            return null;
        }
        d dVar = this.this$1;
        return d0.e0.p.d.m0.c.i1.o.create(dVar.getC().getStorageManager(), dVar, eVar, d$c.access$getEnumMemberNames$p(this.this$0), new a(dVar.getC().getStorageManager(), new d$c$a$a(dVar, gVar)), u0.a);
    }
}
