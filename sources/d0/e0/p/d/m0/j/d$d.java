package d0.e0.p.d.m0.j;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DescriptorRendererImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$d extends d0.z.d.o implements Function1<d0.e0.p.d.m0.k.v.g<?>, CharSequence> {
    public final /* synthetic */ d this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d$d(d dVar) {
        super(1);
        this.this$0 = dVar;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final CharSequence invoke2(d0.e0.p.d.m0.k.v.g<?> gVar) {
        d0.z.d.m.checkNotNullParameter(gVar, "it");
        return d.access$renderConstant(this.this$0, gVar);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ CharSequence invoke(d0.e0.p.d.m0.k.v.g<?> gVar) {
        return invoke2(gVar);
    }
}
