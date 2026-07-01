package b.i.c.m.d.p;

import java.io.ByteArrayInputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.OutputStream;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: CodedOutputStream.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c implements Flushable {
    public final byte[] j;
    public final int k;
    public int l = 0;
    public final OutputStream m;

    public c(OutputStream outputStream, byte[] bArr) {
        this.m = outputStream;
        this.j = bArr;
        this.k = bArr.length;
    }

    public static int a(int i, boolean z2) {
        return e(i) + 1;
    }

    public static int b(int i, a aVar) {
        return e(i) + d(aVar.a.length) + aVar.a.length;
    }

    public static int c(int i, int i2) {
        return e(i) + (i2 >= 0 ? d(i2) : 10);
    }

    public static int d(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int e(int i) {
        return d((i << 3) | 0);
    }

    public static int f(int i, int i2) {
        return e(i) + d(i2);
    }

    public static int h(int i, long j) {
        int i2;
        int iE = e(i);
        if (((-128) & j) == 0) {
            i2 = 1;
        } else if (((-16384) & j) == 0) {
            i2 = 2;
        } else if (((-2097152) & j) == 0) {
            i2 = 3;
        } else if (((-268435456) & j) == 0) {
            i2 = 4;
        } else if (((-34359738368L) & j) == 0) {
            i2 = 5;
        } else if (((-4398046511104L) & j) == 0) {
            i2 = 6;
        } else if (((-562949953421312L) & j) == 0) {
            i2 = 7;
        } else if (((-72057594037927936L) & j) == 0) {
            i2 = 8;
        } else {
            i2 = (j & Long.MIN_VALUE) == 0 ? 9 : 10;
        }
        return iE + i2;
    }

    public static c i(OutputStream outputStream) {
        return new c(outputStream, new byte[4096]);
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.m != null) {
            j();
        }
    }

    public final void j() throws IOException {
        OutputStream outputStream = this.m;
        if (outputStream == null) {
            throw new c$a();
        }
        outputStream.write(this.j, 0, this.l);
        this.l = 0;
    }

    public void k(int i, boolean z2) throws IOException {
        o((i << 3) | 0);
        n(z2 ? 1 : 0);
    }

    public void l(int i, a aVar) throws IOException {
        o((i << 3) | 2);
        o(aVar.a.length);
        byte[] bArr = aVar.a;
        int length = bArr.length;
        int i2 = this.k;
        int i3 = this.l;
        int i4 = i2 - i3;
        if (i4 >= length) {
            System.arraycopy(bArr, 0, this.j, i3, length);
            this.l += length;
            return;
        }
        System.arraycopy(bArr, 0, this.j, i3, i4);
        int i5 = i4 + 0;
        int i6 = length - i4;
        this.l = this.k;
        j();
        if (i6 <= this.k) {
            System.arraycopy(aVar.a, i5, this.j, 0, i6);
            this.l = i6;
            return;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(aVar.a);
        long j = i5;
        if (j != byteArrayInputStream.skip(j)) {
            throw new IllegalStateException("Skip failed.");
        }
        while (i6 > 0) {
            int iMin = Math.min(i6, this.k);
            int i7 = byteArrayInputStream.read(this.j, 0, iMin);
            if (i7 != iMin) {
                throw new IllegalStateException("Read failed.");
            }
            this.m.write(this.j, 0, i7);
            i6 -= i7;
        }
    }

    public void m(int i, int i2) throws IOException {
        o((i << 3) | 0);
        if (i2 >= 0) {
            o(i2);
        } else {
            q(i2);
        }
    }

    public void n(int i) throws IOException {
        byte b2 = (byte) i;
        if (this.l == this.k) {
            j();
        }
        byte[] bArr = this.j;
        int i2 = this.l;
        this.l = i2 + 1;
        bArr[i2] = b2;
    }

    public void o(int i) throws IOException {
        while ((i & (-128)) != 0) {
            n((i & Opcodes.LAND) | 128);
            i >>>= 7;
        }
        n(i);
    }

    public void q(long j) throws IOException {
        while (((-128) & j) != 0) {
            n((((int) j) & Opcodes.LAND) | 128);
            j >>>= 7;
        }
        n((int) j);
    }

    public void r(int i, int i2) throws IOException {
        o((i << 3) | i2);
    }

    public void s(int i, int i2) throws IOException {
        o((i << 3) | 0);
        o(i2);
    }

    public void t(int i, long j) throws IOException {
        o((i << 3) | 0);
        q(j);
    }
}
