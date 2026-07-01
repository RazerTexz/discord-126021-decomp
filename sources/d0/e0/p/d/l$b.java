package d0.e0.p.d;

import kotlin.jvm.functions.Function0;

/* JADX INFO: Add missing generic type declarations: [T, V] */
/* JADX INFO: compiled from: KProperty1Impl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l$b<T, V> extends d0.z.d.o implements Function0<l$a<T, V>> {
    public final /* synthetic */ l this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l$b(l lVar) {
        super(0);
        this.this$0 = lVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        return invoke();
    }

    @Override // kotlin.jvm.functions.Function0
    public final l$a<T, V> invoke() {
        return new l$a<>(this.this$0);
    }
}
