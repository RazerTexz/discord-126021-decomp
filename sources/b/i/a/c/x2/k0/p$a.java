package b.i.a.c.x2.k0;

import java.util.Arrays;

/* JADX INFO: compiled from: H262Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class p$a {
    public static final byte[] a = {0, 0, 1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1268b;
    public int c;
    public int d;
    public byte[] e;

    public p$a(int i) {
        this.e = new byte[i];
    }

    public void a(byte[] bArr, int i, int i2) {
        if (this.f1268b) {
            int i3 = i2 - i;
            byte[] bArr2 = this.e;
            int length = bArr2.length;
            int i4 = this.c;
            if (length < i4 + i3) {
                this.e = Arrays.copyOf(bArr2, (i4 + i3) * 2);
            }
            System.arraycopy(bArr, i, this.e, this.c, i3);
            this.c += i3;
        }
    }
}
