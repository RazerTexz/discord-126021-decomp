package b.i.c.m.d.l;

import com.discord.api.permission.Permission;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: QueueFile.java */
/* JADX INFO: loaded from: classes3.dex */
public class c implements Closeable {
    public static final Logger j = Logger.getLogger(c.class.getName());
    public final RandomAccessFile k;
    public int l;
    public int m;
    public c$b n;
    public c$b o;
    public final byte[] p = new byte[16];

    public c(File file) throws IOException {
        if (!file.exists()) {
            File file2 = new File(file.getPath() + ".tmp");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rwd");
            try {
                randomAccessFile.setLength(Permission.SEND_TTS_MESSAGES);
                randomAccessFile.seek(0L);
                byte[] bArr = new byte[16];
                int[] iArr = {4096, 0, 0, 0};
                int i = 0;
                for (int i2 = 0; i2 < 4; i2++) {
                    C(bArr, i, iArr[i2]);
                    i += 4;
                }
                randomAccessFile.write(bArr);
                randomAccessFile.close();
                if (!file2.renameTo(file)) {
                    throw new IOException("Rename failed!");
                }
            } catch (Throwable th) {
                randomAccessFile.close();
                throw th;
            }
        }
        RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rwd");
        this.k = randomAccessFile2;
        randomAccessFile2.seek(0L);
        randomAccessFile2.readFully(this.p);
        int iQ = q(this.p, 0);
        this.l = iQ;
        if (iQ > randomAccessFile2.length()) {
            StringBuilder sbU = b.d.b.a.a.U("File is truncated. Expected length: ");
            sbU.append(this.l);
            sbU.append(", Actual length: ");
            sbU.append(randomAccessFile2.length());
            throw new IOException(sbU.toString());
        }
        this.m = q(this.p, 4);
        int iQ2 = q(this.p, 8);
        int iQ3 = q(this.p, 12);
        this.n = n(iQ2);
        this.o = n(iQ3);
    }

    public static void C(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    public static int a(c cVar, int i) {
        int i2 = cVar.l;
        return i < i2 ? i : (i + 16) - i2;
    }

    public static int q(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 24) + ((bArr[i + 1] & 255) << 16) + ((bArr[i + 2] & 255) << 8) + (bArr[i + 3] & 255);
    }

    public final void A(int i, int i2, int i3, int i4) throws IOException {
        byte[] bArr = this.p;
        int[] iArr = {i, i2, i3, i4};
        int i5 = 0;
        for (int i6 = 0; i6 < 4; i6++) {
            C(bArr, i5, iArr[i6]);
            i5 += 4;
        }
        this.k.seek(0L);
        this.k.write(this.p);
    }

    public void b(byte[] bArr) throws IOException {
        int iY;
        int length = bArr.length;
        synchronized (this) {
            if ((0 | length) >= 0) {
                if (length <= bArr.length - 0) {
                    d(length);
                    boolean zF = f();
                    if (zF) {
                        iY = 16;
                    } else {
                        c$b c_b = this.o;
                        iY = y(c_b.f1709b + 4 + c_b.c);
                    }
                    c$b c_b2 = new c$b(iY, length);
                    C(this.p, 0, length);
                    u(iY, this.p, 0, 4);
                    u(iY + 4, bArr, 0, length);
                    A(this.l, this.m + 1, zF ? iY : this.n.f1709b, iY);
                    this.o = c_b2;
                    this.m++;
                    if (zF) {
                        this.n = c_b2;
                    }
                }
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public synchronized void c() throws IOException {
        A(4096, 0, 0, 0);
        this.m = 0;
        c$b c_b = c$b.a;
        this.n = c_b;
        this.o = c_b;
        if (this.l > 4096) {
            this.k.setLength(4096);
            this.k.getChannel().force(true);
        }
        this.l = 4096;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.k.close();
    }

    public final void d(int i) throws IOException {
        int i2 = i + 4;
        int iX = this.l - x();
        if (iX >= i2) {
            return;
        }
        int i3 = this.l;
        do {
            iX += i3;
            i3 <<= 1;
        } while (iX < i2);
        this.k.setLength(i3);
        this.k.getChannel().force(true);
        c$b c_b = this.o;
        int iY = y(c_b.f1709b + 4 + c_b.c);
        if (iY < this.n.f1709b) {
            FileChannel channel = this.k.getChannel();
            channel.position(this.l);
            long j2 = iY - 4;
            if (channel.transferTo(16L, j2, channel) != j2) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        int i4 = this.o.f1709b;
        int i5 = this.n.f1709b;
        if (i4 < i5) {
            int i6 = (this.l + i4) - 16;
            A(i3, this.m, i5, i6);
            this.o = new c$b(i6, this.o.c);
        } else {
            A(i3, this.m, i5, i4);
        }
        this.l = i3;
    }

    public synchronized void e(c$d c_d) throws IOException {
        int iY = this.n.f1709b;
        for (int i = 0; i < this.m; i++) {
            c$b c_bN = n(iY);
            c_d.a(new c$c(this, c_bN, null), c_bN.c);
            iY = y(c_bN.f1709b + 4 + c_bN.c);
        }
    }

    public synchronized boolean f() {
        return this.m == 0;
    }

    public final c$b n(int i) throws IOException {
        if (i == 0) {
            return c$b.a;
        }
        this.k.seek(i);
        return new c$b(i, this.k.readInt());
    }

    public synchronized void s() throws IOException {
        if (f()) {
            throw new NoSuchElementException();
        }
        if (this.m == 1) {
            c();
        } else {
            c$b c_b = this.n;
            int iY = y(c_b.f1709b + 4 + c_b.c);
            t(iY, this.p, 0, 4);
            int iQ = q(this.p, 0);
            A(this.l, this.m - 1, iY, this.o.f1709b);
            this.m--;
            this.n = new c$b(iY, iQ);
        }
    }

    public final void t(int i, byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.l;
        if (i >= i4) {
            i = (i + 16) - i4;
        }
        if (i + i3 <= i4) {
            this.k.seek(i);
            this.k.readFully(bArr, i2, i3);
            return;
        }
        int i5 = i4 - i;
        this.k.seek(i);
        this.k.readFully(bArr, i2, i5);
        this.k.seek(16L);
        this.k.readFully(bArr, i2 + i5, i3 - i5);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(c.class.getSimpleName());
        sb.append('[');
        sb.append("fileLength=");
        sb.append(this.l);
        sb.append(", size=");
        sb.append(this.m);
        sb.append(", first=");
        sb.append(this.n);
        sb.append(", last=");
        sb.append(this.o);
        sb.append(", element lengths=[");
        try {
            e(new c$a(this, sb));
        } catch (IOException e) {
            j.log(Level.WARNING, "read error", (Throwable) e);
        }
        sb.append("]]");
        return sb.toString();
    }

    public final void u(int i, byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.l;
        if (i >= i4) {
            i = (i + 16) - i4;
        }
        if (i + i3 <= i4) {
            this.k.seek(i);
            this.k.write(bArr, i2, i3);
            return;
        }
        int i5 = i4 - i;
        this.k.seek(i);
        this.k.write(bArr, i2, i5);
        this.k.seek(16L);
        this.k.write(bArr, i2 + i5, i3 - i5);
    }

    public int x() {
        if (this.m == 0) {
            return 16;
        }
        c$b c_b = this.o;
        int i = c_b.f1709b;
        int i2 = this.n.f1709b;
        return i >= i2 ? (i - i2) + 4 + c_b.c + 16 : (((i + 4) + c_b.c) + this.l) - i2;
    }

    public final int y(int i) {
        int i2 = this.l;
        return i < i2 ? i : (i + 16) - i2;
    }
}
