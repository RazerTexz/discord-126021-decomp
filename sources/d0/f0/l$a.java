package d0.f0;

import java.util.Iterator;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.Sequence;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l$a<T> implements Sequence<T> {
    public final /* synthetic */ Function2 a;

    public l$a(Function2 function2) {
        this.a = function2;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return l.iterator(this.a);
    }
}
