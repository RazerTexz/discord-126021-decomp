package d0.c0;

import d0.z.d.m;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: Random.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class c$a extends c implements Serializable {
    public c$a() {
    }

    private final Object writeReplace() {
        return c$a$a.j;
    }

    @Override // d0.c0.c
    public int nextBits(int i) {
        return c.access$getDefaultRandom$cp().nextBits(i);
    }

    @Override // d0.c0.c
    public byte[] nextBytes(byte[] bArr) {
        m.checkNotNullParameter(bArr, "array");
        return c.access$getDefaultRandom$cp().nextBytes(bArr);
    }

    @Override // d0.c0.c
    public int nextInt() {
        return c.access$getDefaultRandom$cp().nextInt();
    }

    @Override // d0.c0.c
    public long nextLong() {
        return c.access$getDefaultRandom$cp().nextLong();
    }

    public c$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    @Override // d0.c0.c
    public byte[] nextBytes(int i) {
        return c.access$getDefaultRandom$cp().nextBytes(i);
    }

    @Override // d0.c0.c
    public int nextInt(int i) {
        return c.access$getDefaultRandom$cp().nextInt(i);
    }

    @Override // d0.c0.c
    public byte[] nextBytes(byte[] bArr, int i, int i2) {
        m.checkNotNullParameter(bArr, "array");
        return c.access$getDefaultRandom$cp().nextBytes(bArr, i, i2);
    }

    @Override // d0.c0.c
    public int nextInt(int i, int i2) {
        return c.access$getDefaultRandom$cp().nextInt(i, i2);
    }
}
