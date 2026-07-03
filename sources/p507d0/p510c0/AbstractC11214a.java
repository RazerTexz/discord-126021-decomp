package p507d0.p510c0;

import java.util.Random;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.c0.a */
/* JADX INFO: compiled from: PlatformRandom.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11214a extends AbstractC11216c {
    public abstract Random getImpl();

    @Override // p507d0.p510c0.AbstractC11216c
    public int nextBits(int i) {
        return C11217d.takeUpperBits(getImpl().nextInt(), i);
    }

    @Override // p507d0.p510c0.AbstractC11216c
    public byte[] nextBytes(byte[] bArr) {
        C12238m.checkNotNullParameter(bArr, "array");
        getImpl().nextBytes(bArr);
        return bArr;
    }

    @Override // p507d0.p510c0.AbstractC11216c
    public int nextInt() {
        return getImpl().nextInt();
    }

    @Override // p507d0.p510c0.AbstractC11216c
    public long nextLong() {
        return getImpl().nextLong();
    }

    @Override // p507d0.p510c0.AbstractC11216c
    public int nextInt(int i) {
        return getImpl().nextInt(i);
    }
}
