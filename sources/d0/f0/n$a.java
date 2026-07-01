package d0.f0;

import java.util.Iterator;
import kotlin.sequences.Sequence;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n$a<T> implements Sequence<T> {
    public final /* synthetic */ Iterator a;

    public n$a(Iterator it) {
        this.a = it;
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return this.a;
    }
}
