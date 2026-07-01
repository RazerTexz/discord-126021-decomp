package d0.f0;

import java.util.Iterator;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r<T> implements Sequence<T>, e<T> {
    public final Sequence<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f3575b;
    public final int c;

    /* JADX WARN: Multi-variable type inference failed */
    public r(Sequence<? extends T> sequence, int i, int i2) {
        d0.z.d.m.checkNotNullParameter(sequence, "sequence");
        this.a = sequence;
        this.f3575b = i;
        this.c = i2;
        if (!(i >= 0)) {
            throw new IllegalArgumentException(b.d.b.a.a.q("startIndex should be non-negative, but is ", i).toString());
        }
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(b.d.b.a.a.q("endIndex should be non-negative, but is ", i2).toString());
        }
        if (!(i2 >= i)) {
            throw new IllegalArgumentException(b.d.b.a.a.s("endIndex should be not less than startIndex, but was ", i2, " < ", i).toString());
        }
    }

    public static final /* synthetic */ int access$getEndIndex$p(r rVar) {
        return rVar.c;
    }

    public static final /* synthetic */ Sequence access$getSequence$p(r rVar) {
        return rVar.a;
    }

    public static final /* synthetic */ int access$getStartIndex$p(r rVar) {
        return rVar.f3575b;
    }

    @Override // d0.f0.e
    public Sequence<T> drop(int i) {
        int i2 = this.c;
        int i3 = this.f3575b;
        return i >= i2 - i3 ? n.emptySequence() : new r(this.a, i3 + i, i2);
    }

    @Override // kotlin.sequences.Sequence
    public Iterator<T> iterator() {
        return new r$a(this);
    }

    @Override // d0.f0.e
    public Sequence<T> take(int i) {
        int i2 = this.c;
        int i3 = this.f3575b;
        return i >= i2 - i3 ? this : new r(this.a, i3, i + i3);
    }
}
