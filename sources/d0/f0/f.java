package d0.f0;

import d0.t.v;
import java.util.Iterator;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements Sequence, e {
    public static final f a = new f();

    @Override // d0.f0.e
    public /* bridge */ /* synthetic */ Sequence drop(int i) {
        return drop(i);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator iterator() {
        return v.j;
    }

    @Override // d0.f0.e
    public /* bridge */ /* synthetic */ Sequence take(int i) {
        return take(i);
    }

    @Override // d0.f0.e
    public f drop(int i) {
        return a;
    }

    @Override // d0.f0.e
    public f take(int i) {
        return a;
    }
}
