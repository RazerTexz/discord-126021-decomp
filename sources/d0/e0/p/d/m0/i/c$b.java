package d0.e0.p.d.m0.i;

import java.io.OutputStream;
import java.util.ArrayList;

/* JADX INFO: compiled from: ByteString.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c$b extends OutputStream {
    public static final byte[] j = new byte[0];
    public final int k;
    public final ArrayList<c> l;
    public int m;
    public byte[] n;
    public int o;

    public c$b(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Buffer size < 0");
        }
        this.k = i;
        this.l = new ArrayList<>();
        this.n = new byte[i];
    }

    public final void a(int i) {
        this.l.add(new m(this.n));
        int length = this.m + this.n.length;
        this.m = length;
        this.n = new byte[Math.max(this.k, Math.max(i, length >>> 1))];
        this.o = 0;
    }

    public final void b() {
        int i = this.o;
        byte[] bArr = this.n;
        if (i >= bArr.length) {
            this.l.add(new m(this.n));
            this.n = j;
        } else if (i > 0) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i));
            this.l.add(new m(bArr2));
        }
        this.m += this.o;
        this.o = 0;
    }

    public synchronized int size() {
        return this.m + this.o;
    }

    public synchronized c toByteString() {
        b();
        return c.copyFrom(this.l);
    }

    public String toString() {
        return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) {
        if (this.o == this.n.length) {
            a(1);
        }
        byte[] bArr = this.n;
        int i2 = this.o;
        this.o = i2 + 1;
        bArr[i2] = (byte) i;
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        byte[] bArr2 = this.n;
        int length = bArr2.length;
        int i3 = this.o;
        if (i2 <= length - i3) {
            System.arraycopy(bArr, i, bArr2, i3, i2);
            this.o += i2;
        } else {
            int length2 = bArr2.length - i3;
            System.arraycopy(bArr, i, bArr2, i3, length2);
            int i4 = i2 - length2;
            a(i4);
            System.arraycopy(bArr, i + length2, this.n, 0, i4);
            this.o = i4;
        }
    }
}
