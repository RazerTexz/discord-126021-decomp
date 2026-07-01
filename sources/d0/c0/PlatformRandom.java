package d0.c0;

import d0.z.d.Intrinsics3;
import java.util.Random;

/* JADX INFO: renamed from: d0.c0.a, reason: use source file name */
/* JADX INFO: compiled from: PlatformRandom.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class PlatformRandom extends Random {
    public abstract Random getImpl();

    @Override // d0.c0.Random
    public int nextBits(int i) {
        return Random2.takeUpperBits(getImpl().nextInt(), i);
    }

    @Override // d0.c0.Random
    public byte[] nextBytes(byte[] bArr) {
        Intrinsics3.checkNotNullParameter(bArr, "array");
        getImpl().nextBytes(bArr);
        return bArr;
    }

    @Override // d0.c0.Random
    public int nextInt() {
        return getImpl().nextInt();
    }

    @Override // d0.c0.Random
    public long nextLong() {
        return getImpl().nextLong();
    }

    @Override // d0.c0.Random
    public int nextInt(int i) {
        return getImpl().nextInt(i);
    }
}
