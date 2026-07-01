package d0.e0.p.d;

import kotlin.jvm.functions.Function0;

/* JADX INFO: Add missing generic type declarations: [T, V] */
/* JADX INFO: compiled from: KProperty1Impl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q$b<T, V> extends d0.z.d.o implements Function0<q$a<T, ? extends V>> {
    public final /* synthetic */ q this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q$b(q qVar) {
        super(0);
        this.this$0 = qVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        return invoke();
    }

    @Override // kotlin.jvm.functions.Function0
    public final q$a<T, V> invoke() {
        return new q$a<>(this.this$0);
    }
}
