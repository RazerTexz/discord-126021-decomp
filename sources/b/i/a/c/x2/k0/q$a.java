package b.i.a.c.x2.k0;

import java.util.Arrays;

/* JADX INFO: compiled from: H263Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class q$a {
    public static final byte[] a = {0, 0, 1};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1270b;
    public int c;
    public int d;
    public int e;
    public byte[] f;

    public q$a(int i) {
        this.f = new byte[i];
    }

    public void a(byte[] bArr, int i, int i2) {
        if (this.f1270b) {
            int i3 = i2 - i;
            byte[] bArr2 = this.f;
            int length = bArr2.length;
            int i4 = this.d;
            if (length < i4 + i3) {
                this.f = Arrays.copyOf(bArr2, (i4 + i3) * 2);
            }
            System.arraycopy(bArr, i, this.f, this.d, i3);
            this.d += i3;
        }
    }

    public void b() {
        this.f1270b = false;
        this.d = 0;
        this.c = 0;
    }
}
