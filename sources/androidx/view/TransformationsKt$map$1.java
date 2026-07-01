package androidx.view;

import androidx.arch.core.util.Function;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [X, Y] */
/* JADX INFO: compiled from: Transformations.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TransformationsKt$map$1<I, O, X, Y> implements Function<X, Y> {
    public final /* synthetic */ Function1 $transform;

    public TransformationsKt$map$1(Function1 function1) {
        this.$transform = function1;
    }

    @Override // androidx.arch.core.util.Function
    public final Y apply(X x2) {
        return (Y) this.$transform.invoke(x2);
    }
}
