package d0.t;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: _Arrays.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k$c<T> extends d0.z.d.o implements Function0<Iterator<? extends T>> {
    public final /* synthetic */ Object[] $this_withIndex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k$c(Object[] objArr) {
        super(0);
        this.$this_withIndex = objArr;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        return invoke();
    }

    @Override // kotlin.jvm.functions.Function0
    public final Iterator<T> invoke() {
        return d0.z.d.c.iterator(this.$this_withIndex);
    }
}
