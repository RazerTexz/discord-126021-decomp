package androidx.view;

import androidx.arch.core.util.Function;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [X, Y] */
/* JADX INFO: compiled from: Transformations.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TransformationsKt$switchMap$1<I, O, X, Y> implements Function<X, LiveData<Y>> {
    public final /* synthetic */ Function1 $transform;

    public TransformationsKt$switchMap$1(Function1 function1) {
        this.$transform = function1;
    }

    @Override // androidx.arch.core.util.Function
    public final LiveData<Y> apply(X x2) {
        return (LiveData) this.$transform.invoke(x2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.arch.core.util.Function
    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return apply(obj);
    }
}
