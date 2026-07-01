package d0.e0.p.d.m0.l.b;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ClassDeserializer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$c extends d0.z.d.o implements Function1<h$a, d0.e0.p.d.m0.c.e> {
    public final /* synthetic */ h this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h$c(h hVar) {
        super(1);
        this.this$0 = hVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.e invoke(h$a h_a) {
        return invoke2(h_a);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final d0.e0.p.d.m0.c.e invoke2(h$a h_a) {
        d0.z.d.m.checkNotNullParameter(h_a, "key");
        return h.access$createClass(this.this$0, h_a);
    }
}
