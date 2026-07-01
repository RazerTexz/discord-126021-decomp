package d0.f0;

import java.util.Iterator;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class s<T> implements Sequence<T>, e<T> {
    public final Sequence<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3576b;

    /* JADX WARN: Multi-variable type inference failed */
    public s(Sequence<? extends T> sequence, int i) {
        d0.z.d.m.checkNotNullParameter(sequence, "sequence");
        this.a = sequence;
        this.f3576b = i;
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i + '.').toString());
    }

    public static final /* synthetic */ int access$getCount$p(s sVar) {
        return sVar.f3576b;
    }

    public static final /* synthetic */ Sequence access$getSequence$p(s sVar) {
        return sVar.a;
    }

    @Override // d0.f0.e
    public Sequence<T> drop(int i) {
        int i2 = this.f3576b;
        return i >= i2 ? n.emptySequence() : new r(this.a, i, i2);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new s$a(this);
    }

    @Override // d0.f0.e
    public Sequence<T> take(int i) {
        return i >= this.f3576b ? this : new s(this.a, i);
    }
}
