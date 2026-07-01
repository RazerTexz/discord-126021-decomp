package d0.e0.p.d;

import kotlin.jvm.functions.Function0;

/* JADX INFO: Add missing generic type declarations: [D, E, V] */
/* JADX INFO: compiled from: KProperty2Impl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r$b<D, E, V> extends d0.z.d.o implements Function0<r$a<D, E, ? extends V>> {
    public final /* synthetic */ r this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r$b(r rVar) {
        super(0);
        this.this$0 = rVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        return invoke();
    }

    @Override // kotlin.jvm.functions.Function0
    public final r$a<D, E, V> invoke() {
        return new r$a<>(this.this$0);
    }
}
