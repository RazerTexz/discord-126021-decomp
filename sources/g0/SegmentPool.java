package g0;

import d0.z.d.Intrinsics3;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: g0.t, reason: use source file name */
/* JADX INFO: compiled from: SegmentPool.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SegmentPool {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f3694b;
    public static final AtomicReference<Segment2>[] c;
    public static final SegmentPool d = new SegmentPool();
    public static final Segment2 a = new Segment2(new byte[0], 0, 0, false, false);

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f3694b = iHighestOneBit;
        AtomicReference<Segment2>[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i = 0; i < iHighestOneBit; i++) {
            atomicReferenceArr[i] = new AtomicReference<>();
        }
        c = atomicReferenceArr;
    }

    public static final void a(Segment2 segment2) {
        Intrinsics3.checkParameterIsNotNull(segment2, "segment");
        if (!(segment2.f == null && segment2.g == null)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (segment2.d) {
            return;
        }
        Thread threadCurrentThread = Thread.currentThread();
        Intrinsics3.checkExpressionValueIsNotNull(threadCurrentThread, "Thread.currentThread()");
        AtomicReference<Segment2> atomicReference = c[(int) (threadCurrentThread.getId() & (((long) f3694b) - 1))];
        Segment2 segment3 = atomicReference.get();
        if (segment3 == a) {
            return;
        }
        int i = segment3 != null ? segment3.c : 0;
        if (i >= 65536) {
            return;
        }
        segment2.f = segment3;
        segment2.f3693b = 0;
        segment2.c = i + 8192;
        if (atomicReference.compareAndSet(segment3, segment2)) {
            return;
        }
        segment2.f = null;
    }

    public static final Segment2 b() {
        Thread threadCurrentThread = Thread.currentThread();
        Intrinsics3.checkExpressionValueIsNotNull(threadCurrentThread, "Thread.currentThread()");
        AtomicReference<Segment2> atomicReference = c[(int) (threadCurrentThread.getId() & (((long) f3694b) - 1))];
        Segment2 segment2 = a;
        Segment2 andSet = atomicReference.getAndSet(segment2);
        if (andSet == segment2) {
            return new Segment2();
        }
        if (andSet == null) {
            atomicReference.set(null);
            return new Segment2();
        }
        atomicReference.set(andSet.f);
        andSet.f = null;
        andSet.c = 0;
        return andSet;
    }
}
