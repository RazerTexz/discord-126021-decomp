package d0.e0.p.d.m0.e.a;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ClassicBuiltinSpecialProperties.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k$a extends d0.z.d.o implements Function1<d0.e0.p.d.m0.c.b, Boolean> {
    public final /* synthetic */ k this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k$a(k kVar) {
        super(1);
        this.this$0 = kVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(d0.e0.p.d.m0.c.b bVar) {
        return Boolean.valueOf(invoke2(bVar));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(d0.e0.p.d.m0.c.b bVar) {
        d0.z.d.m.checkNotNullParameter(bVar, "it");
        return this.this$0.hasBuiltinSpecialPropertyFqName(bVar);
    }
}
