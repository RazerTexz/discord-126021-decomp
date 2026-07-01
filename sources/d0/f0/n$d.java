package d0.f0;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n$d<T> extends d0.z.d.o implements Function1<T, T> {
    public final /* synthetic */ Function0 $nextFunction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n$d(Function0 function0) {
        super(1);
        this.$nextFunction = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final T invoke(T t) {
        d0.z.d.m.checkNotNullParameter(t, "it");
        return (T) this.$nextFunction.invoke();
    }
}
