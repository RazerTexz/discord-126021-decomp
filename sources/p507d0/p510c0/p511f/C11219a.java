package p507d0.p510c0.p511f;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import p507d0.p510c0.AbstractC11214a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.c0.f.a */
/* JADX INFO: compiled from: PlatformThreadLocalRandom.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11219a extends AbstractC11214a {
    @Override // p507d0.p510c0.AbstractC11214a
    public Random getImpl() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        C12238m.checkNotNullExpressionValue(threadLocalRandomCurrent, "ThreadLocalRandom.current()");
        return threadLocalRandomCurrent;
    }

    @Override // p507d0.p510c0.AbstractC11216c
    public int nextInt(int i, int i2) {
        return ThreadLocalRandom.current().nextInt(i, i2);
    }
}
