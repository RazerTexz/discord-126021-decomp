package d0.e0.p.d.m0.l.b.e0;

import d0.t.u;
import d0.z.d.o;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: DeserializedClassDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$c$a$a extends o implements Function0<List<? extends d0.e0.p.d.m0.c.g1.c>> {
    public final /* synthetic */ d0.e0.p.d.m0.f.g $proto;
    public final /* synthetic */ d this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d$c$a$a(d dVar, d0.e0.p.d.m0.f.g gVar) {
        super(0);
        this.this$0 = dVar;
        this.$proto = gVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends d0.e0.p.d.m0.c.g1.c> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends d0.e0.p.d.m0.c.g1.c> invoke2() {
        return u.toList(this.this$0.getC().getComponents().getAnnotationAndConstantLoader().loadEnumEntryAnnotations(this.this$0.getThisAsProtoContainer$deserialization(), this.$proto));
    }
}
