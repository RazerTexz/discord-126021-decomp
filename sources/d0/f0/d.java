package d0.f0;

import java.util.Iterator;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d<T> implements Sequence<T>, e<T> {
    public final Sequence<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3570b;

    /* JADX WARN: Multi-variable type inference failed */
    public d(Sequence<? extends T> sequence, int i) {
        d0.z.d.m.checkNotNullParameter(sequence, "sequence");
        this.a = sequence;
        this.f3570b = i;
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i + '.').toString());
    }

    public static final /* synthetic */ int access$getCount$p(d dVar) {
        return dVar.f3570b;
    }

    public static final /* synthetic */ Sequence access$getSequence$p(d dVar) {
        return dVar.a;
    }

    @Override // d0.f0.e
    public Sequence<T> drop(int i) {
        int i2 = this.f3570b + i;
        return i2 < 0 ? new d(this, i) : new d(this.a, i2);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new d$a(this);
    }

    @Override // d0.f0.e
    public Sequence<T> take(int i) {
        int i2 = this.f3570b;
        int i3 = i2 + i;
        return i3 < 0 ? new s(this, i) : new r(this.a, i2, i3);
    }
}
