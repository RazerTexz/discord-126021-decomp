package d0.c0.f;

import d0.c0.PlatformRandom;
import d0.z.d.Intrinsics3;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/* JADX INFO: renamed from: d0.c0.f.a, reason: use source file name */
/* JADX INFO: compiled from: PlatformThreadLocalRandom.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PlatformThreadLocalRandom extends PlatformRandom {
    @Override // d0.c0.PlatformRandom
    public Random getImpl() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        Intrinsics3.checkNotNullExpressionValue(threadLocalRandomCurrent, "ThreadLocalRandom.current()");
        return threadLocalRandomCurrent;
    }

    @Override // d0.c0.Random
    public int nextInt(int i, int i2) {
        return ThreadLocalRandom.current().nextInt(i, i2);
    }
}
