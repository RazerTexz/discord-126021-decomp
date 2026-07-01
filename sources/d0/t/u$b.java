package d0.t;

import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: _Collections.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class u$b<T> extends d0.z.d.o implements Function1<Integer, T> {
    public final /* synthetic */ int $index;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u$b(int i) {
        super(1);
        this.$index = i;
    }

    public final T invoke(int i) {
        throw new IndexOutOfBoundsException(b.d.b.a.a.A(b.d.b.a.a.U("Collection doesn't contain element at index "), this.$index, '.'));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
        return invoke(num.intValue());
    }
}
