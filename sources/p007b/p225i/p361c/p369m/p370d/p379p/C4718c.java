package p007b.p225i.p361c.p369m.p370d.p379p;

import java.io.ByteArrayInputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.OutputStream;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: b.i.c.m.d.p.c */
/* JADX INFO: compiled from: CodedOutputStream.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4718c implements Flushable {

    /* JADX INFO: renamed from: j */
    public final byte[] f12690j;

    /* JADX INFO: renamed from: k */
    public final int f12691k;

    /* JADX INFO: renamed from: l */
    public int f12692l = 0;

    /* JADX INFO: renamed from: m */
    public final OutputStream f12693m;

    /* JADX INFO: renamed from: b.i.c.m.d.p.c$a */
    /* JADX INFO: compiled from: CodedOutputStream.java */
    public static class a extends IOException {
        private static final long serialVersionUID = -6947486886997889499L;

        public a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    public C4718c(OutputStream outputStream, byte[] bArr) {
        this.f12693m = outputStream;
        this.f12690j = bArr;
        this.f12691k = bArr.length;
    }

    /* JADX INFO: renamed from: a */
    public static int m6639a(int i, boolean z2) {
        return m6643e(i) + 1;
    }

    /* JADX INFO: renamed from: b */
    public static int m6640b(int i, C4716a c4716a) {
        return m6643e(i) + m6642d(c4716a.f12684a.length) + c4716a.f12684a.length;
    }

    /* JADX INFO: renamed from: c */
    public static int m6641c(int i, int i2) {
        return m6643e(i) + (i2 >= 0 ? m6642d(i2) : 10);
    }

    /* JADX INFO: renamed from: d */
    public static int m6642d(int i) {
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

    /* JADX INFO: renamed from: e */
    public static int m6643e(int i) {
        return m6642d((i << 3) | 0);
    }

    /* JADX INFO: renamed from: f */
    public static int m6644f(int i, int i2) {
        return m6643e(i) + m6642d(i2);
    }

    /* JADX INFO: renamed from: h */
    public static int m6645h(int i, long j) {
        int i2;
        int iM6643e = m6643e(i);
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
        return iM6643e + i2;
    }

    /* JADX INFO: renamed from: i */
    public static C4718c m6646i(OutputStream outputStream) {
        return new C4718c(outputStream, new byte[4096]);
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.f12693m != null) {
            m6647j();
        }
    }

    /* JADX INFO: renamed from: j */
    public final void m6647j() throws IOException {
        OutputStream outputStream = this.f12693m;
        if (outputStream == null) {
            throw new a();
        }
        outputStream.write(this.f12690j, 0, this.f12692l);
        this.f12692l = 0;
    }

    /* JADX INFO: renamed from: k */
    public void m6648k(int i, boolean z2) throws IOException {
        m6652o((i << 3) | 0);
        m6651n(z2 ? 1 : 0);
    }

    /* JADX INFO: renamed from: l */
    public void m6649l(int i, C4716a c4716a) throws IOException {
        m6652o((i << 3) | 2);
        m6652o(c4716a.f12684a.length);
        byte[] bArr = c4716a.f12684a;
        int length = bArr.length;
        int i2 = this.f12691k;
        int i3 = this.f12692l;
        int i4 = i2 - i3;
        if (i4 >= length) {
            System.arraycopy(bArr, 0, this.f12690j, i3, length);
            this.f12692l += length;
            return;
        }
        System.arraycopy(bArr, 0, this.f12690j, i3, i4);
        int i5 = i4 + 0;
        int i6 = length - i4;
        this.f12692l = this.f12691k;
        m6647j();
        if (i6 <= this.f12691k) {
            System.arraycopy(c4716a.f12684a, i5, this.f12690j, 0, i6);
            this.f12692l = i6;
            return;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(c4716a.f12684a);
        long j = i5;
        if (j != byteArrayInputStream.skip(j)) {
            throw new IllegalStateException("Skip failed.");
        }
        while (i6 > 0) {
            int iMin = Math.min(i6, this.f12691k);
            int i7 = byteArrayInputStream.read(this.f12690j, 0, iMin);
            if (i7 != iMin) {
                throw new IllegalStateException("Read failed.");
            }
            this.f12693m.write(this.f12690j, 0, i7);
            i6 -= i7;
        }
    }

    /* JADX INFO: renamed from: m */
    public void m6650m(int i, int i2) throws IOException {
        m6652o((i << 3) | 0);
        if (i2 >= 0) {
            m6652o(i2);
        } else {
            m6653q(i2);
        }
    }

    /* JADX INFO: renamed from: n */
    public void m6651n(int i) throws IOException {
        byte b2 = (byte) i;
        if (this.f12692l == this.f12691k) {
            m6647j();
        }
        byte[] bArr = this.f12690j;
        int i2 = this.f12692l;
        this.f12692l = i2 + 1;
        bArr[i2] = b2;
    }

    /* JADX INFO: renamed from: o */
    public void m6652o(int i) throws IOException {
        while ((i & (-128)) != 0) {
            m6651n((i & Opcodes.LAND) | 128);
            i >>>= 7;
        }
        m6651n(i);
    }

    /* JADX INFO: renamed from: q */
    public void m6653q(long j) throws IOException {
        while (((-128) & j) != 0) {
            m6651n((((int) j) & Opcodes.LAND) | 128);
            j >>>= 7;
        }
        m6651n((int) j);
    }

    /* JADX INFO: renamed from: r */
    public void m6654r(int i, int i2) throws IOException {
        m6652o((i << 3) | i2);
    }

    /* JADX INFO: renamed from: s */
    public void m6655s(int i, int i2) throws IOException {
        m6652o((i << 3) | 0);
        m6652o(i2);
    }

    /* JADX INFO: renamed from: t */
    public void m6656t(int i, long j) throws IOException {
        m6652o((i << 3) | 0);
        m6653q(j);
    }
}
