package d0.c0;

import d0.z.d.m;
import java.util.Random;

/* JADX INFO: compiled from: PlatformRandom.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends c {
    public abstract Random getImpl();

    @Override // d0.c0.c
    public int nextBits(int i) {
        return d.takeUpperBits(getImpl().nextInt(), i);
    }

    @Override // d0.c0.c
    public byte[] nextBytes(byte[] bArr) {
        m.checkNotNullParameter(bArr, "array");
        getImpl().nextBytes(bArr);
        return bArr;
    }

    @Override // d0.c0.c
    public int nextInt() {
        return getImpl().nextInt();
    }

    @Override // d0.c0.c
    public long nextLong() {
        return getImpl().nextLong();
    }

    @Override // d0.c0.c
    public int nextInt(int i) {
        return getImpl().nextInt(i);
    }
}
