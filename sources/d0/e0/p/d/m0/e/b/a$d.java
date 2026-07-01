package d0.e0.p.d.m0.e.b;

import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [A, C] */
/* JADX INFO: compiled from: AbstractBinaryClassAnnotationAndConstantLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a$d<A, C> extends d0.z.d.o implements Function1<p, a$b<? extends A, ? extends C>> {
    public final /* synthetic */ a<A, C> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a$d(a<A, C> aVar) {
        super(1);
        this.this$0 = aVar;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(p pVar) {
        return invoke2(pVar);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final a$b<A, C> invoke2(p pVar) {
        d0.z.d.m.checkNotNullParameter(pVar, "kotlinClass");
        return a.access$loadAnnotationsAndInitializers(this.this$0, pVar);
    }
}
