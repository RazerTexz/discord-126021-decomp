package p615g0;

import java.util.concurrent.atomic.AtomicReference;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: g0.t */
/* JADX INFO: compiled from: SegmentPool.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12403t {

    /* JADX INFO: renamed from: b */
    public static final int f26126b;

    /* JADX INFO: renamed from: c */
    public static final AtomicReference<C12402s>[] f26127c;

    /* JADX INFO: renamed from: d */
    public static final C12403t f26128d = new C12403t();

    /* JADX INFO: renamed from: a */
    public static final C12402s f26125a = new C12402s(new byte[0], 0, 0, false, false);

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f26126b = iHighestOneBit;
        AtomicReference<C12402s>[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i = 0; i < iHighestOneBit; i++) {
            atomicReferenceArr[i] = new AtomicReference<>();
        }
        f26127c = atomicReferenceArr;
    }

    /* JADX INFO: renamed from: a */
    public static final void m10498a(C12402s c12402s) {
        C12238m.checkParameterIsNotNull(c12402s, "segment");
        if (!(c12402s.f26123f == null && c12402s.f26124g == null)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (c12402s.f26121d) {
            return;
        }
        Thread threadCurrentThread = Thread.currentThread();
        C12238m.checkExpressionValueIsNotNull(threadCurrentThread, "Thread.currentThread()");
        AtomicReference<C12402s> atomicReference = f26127c[(int) (threadCurrentThread.getId() & (((long) f26126b) - 1))];
        C12402s c12402s2 = atomicReference.get();
        if (c12402s2 == f26125a) {
            return;
        }
        int i = c12402s2 != null ? c12402s2.f26120c : 0;
        if (i >= 65536) {
            return;
        }
        c12402s.f26123f = c12402s2;
        c12402s.f26119b = 0;
        c12402s.f26120c = i + 8192;
        if (atomicReference.compareAndSet(c12402s2, c12402s)) {
            return;
        }
        c12402s.f26123f = null;
    }

    /* JADX INFO: renamed from: b */
    public static final C12402s m10499b() {
        Thread threadCurrentThread = Thread.currentThread();
        C12238m.checkExpressionValueIsNotNull(threadCurrentThread, "Thread.currentThread()");
        AtomicReference<C12402s> atomicReference = f26127c[(int) (threadCurrentThread.getId() & (((long) f26126b) - 1))];
        C12402s c12402s = f26125a;
        C12402s andSet = atomicReference.getAndSet(c12402s);
        if (andSet == c12402s) {
            return new C12402s();
        }
        if (andSet == null) {
            atomicReference.set(null);
            return new C12402s();
        }
        atomicReference.set(andSet.f26123f);
        andSet.f26123f = null;
        andSet.f26120c = 0;
        return andSet;
    }
}
