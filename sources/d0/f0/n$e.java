package d0.f0;

import kotlin.jvm.functions.Function0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n$e<T> extends d0.z.d.o implements Function0<T> {
    public final /* synthetic */ Object $seed;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n$e(Object obj) {
        super(0);
        this.$seed = obj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final T invoke() {
        return (T) this.$seed;
    }
}
