package d0.e0.p.d.m0.e.a.i0.l;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DeclaredMemberIndex.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$a extends d0.z.d.o implements Function1<d0.e0.p.d.m0.e.a.k0.r, Boolean> {
    public final /* synthetic */ a this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a$a(a aVar) {
        super(1);
        this.this$0 = aVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(d0.e0.p.d.m0.e.a.k0.r rVar) {
        return Boolean.valueOf(invoke2(rVar));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(d0.e0.p.d.m0.e.a.k0.r rVar) {
        d0.z.d.m.checkNotNullParameter(rVar, "m");
        return ((Boolean) a.access$getMemberFilter$p(this.this$0).invoke(rVar)).booleanValue() && !d0.e0.p.d.m0.e.a.k0.p.isObjectMethodInInterface(rVar);
    }
}
