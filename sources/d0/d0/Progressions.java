package d0.d0;

import d0.x.progressionUtil;
import d0.z.d.g0.KMarkers;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.d0.c, reason: use source file name */
/* JADX INFO: compiled from: Progressions.kt */
/* JADX INFO: loaded from: classes3.dex */
public class Progressions implements Iterable<Long>, KMarkers {
    public final long j;
    public final long k;
    public final long l;

    /* JADX INFO: renamed from: d0.d0.c$a */
    /* JADX INFO: compiled from: Progressions.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    static {
        new a(null);
    }

    public Progressions(long j, long j2, long j3) {
        if (j3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j3 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.j = j;
        this.k = progressionUtil.getProgressionLastElement(j, j2, j3);
        this.l = j3;
    }

    public final long getFirst() {
        return this.j;
    }

    public final long getLast() {
        return this.k;
    }

    @Override // java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: merged with bridge method [inline-methods] */
    public Iterator<Long> iterator2() {
        return new ProgressionIterators2(this.j, this.k, this.l);
    }
}
