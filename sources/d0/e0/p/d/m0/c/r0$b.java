package d0.e0.p.d.m0.c;

import kotlin.jvm.functions.Function0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: ScopesHolderForClass.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r0$b<T> extends d0.z.d.o implements Function0<T> {
    public final /* synthetic */ d0.e0.p.d.m0.n.l1.g $kotlinTypeRefiner;
    public final /* synthetic */ r0<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r0$b(r0<T> r0Var, d0.e0.p.d.m0.n.l1.g gVar) {
        super(0);
        this.this$0 = r0Var;
        this.$kotlinTypeRefiner = gVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        return invoke();
    }

    /* JADX WARN: Incorrect return type in method signature: ()TT; */
    @Override // kotlin.jvm.functions.Function0
    public final d0.e0.p.d.m0.k.a0.i invoke() {
        return (d0.e0.p.d.m0.k.a0.i) r0.access$getScopeFactory$p(this.this$0).invoke(this.$kotlinTypeRefiner);
    }
}
