package g0;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SegmentPool.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f3694b;
    public static final AtomicReference<s>[] c;
    public static final t d = new t();
    public static final s a = new s(new byte[0], 0, 0, false, false);

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f3694b = iHighestOneBit;
        AtomicReference<s>[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i = 0; i < iHighestOneBit; i++) {
            atomicReferenceArr[i] = new AtomicReference<>();
        }
        c = atomicReferenceArr;
    }

    public static final void a(s sVar) {
        d0.z.d.m.checkParameterIsNotNull(sVar, "segment");
        if (!(sVar.f == null && sVar.g == null)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (sVar.d) {
            return;
        }
        Thread threadCurrentThread = Thread.currentThread();
        d0.z.d.m.checkExpressionValueIsNotNull(threadCurrentThread, "Thread.currentThread()");
        AtomicReference<s> atomicReference = c[(int) (threadCurrentThread.getId() & (((long) f3694b) - 1))];
        s sVar2 = atomicReference.get();
        if (sVar2 == a) {
            return;
        }
        int i = sVar2 != null ? sVar2.c : 0;
        if (i >= 65536) {
            return;
        }
        sVar.f = sVar2;
        sVar.f3693b = 0;
        sVar.c = i + 8192;
        if (atomicReference.compareAndSet(sVar2, sVar)) {
            return;
        }
        sVar.f = null;
    }

    public static final s b() {
        Thread threadCurrentThread = Thread.currentThread();
        d0.z.d.m.checkExpressionValueIsNotNull(threadCurrentThread, "Thread.currentThread()");
        AtomicReference<s> atomicReference = c[(int) (threadCurrentThread.getId() & (((long) f3694b) - 1))];
        s sVar = a;
        s andSet = atomicReference.getAndSet(sVar);
        if (andSet == sVar) {
            return new s();
        }
        if (andSet == null) {
            atomicReference.set(null);
            return new s();
        }
        atomicReference.set(andSet.f);
        andSet.f = null;
        andSet.c = 0;
        return andSet;
    }
}
