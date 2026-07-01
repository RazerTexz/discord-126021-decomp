package b.i.c.m.d.l;

import b.d.b.a.outline;
import com.discord.api.permission.Permission;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: renamed from: b.i.c.m.d.l.c, reason: use source file name */
/* JADX INFO: compiled from: QueueFile.java */
/* JADX INFO: loaded from: classes3.dex */
public class QueueFile implements Closeable {
    public static final Logger j = Logger.getLogger(QueueFile.class.getName());
    public final RandomAccessFile k;
    public int l;
    public int m;
    public b n;
    public b o;
    public final byte[] p = new byte[16];

    /* JADX INFO: renamed from: b.i.c.m.d.l.c$a */
    /* JADX INFO: compiled from: QueueFile.java */
    public class a implements d {
        public boolean a = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ StringBuilder f1708b;

        public a(QueueFile queueFile, StringBuilder sb) {
            this.f1708b = sb;
        }

        @Override // b.i.c.m.d.l.QueueFile.d
        public void a(InputStream inputStream, int i) throws IOException {
            if (this.a) {
                this.a = false;
            } else {
                this.f1708b.append(", ");
            }
            this.f1708b.append(i);
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.l.c$b */
    /* JADX INFO: compiled from: QueueFile.java */
    public static class b {
        public static final b a = new b(0, 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1709b;
        public final int c;

        public b(int i, int i2) {
            this.f1709b = i;
            this.c = i2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(b.class.getSimpleName());
            sb.append("[position = ");
            sb.append(this.f1709b);
            sb.append(", length = ");
            return outline.B(sb, this.c, "]");
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.l.c$d */
    /* JADX INFO: compiled from: QueueFile.java */
    public interface d {
        void a(InputStream inputStream, int i) throws IOException;
    }

    public QueueFile(File file) throws IOException {
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
            StringBuilder sbU = outline.U("File is truncated. Expected length: ");
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

    public static int a(QueueFile queueFile, int i) {
        int i2 = queueFile.l;
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
                        b bVar = this.o;
                        iY = y(bVar.f1709b + 4 + bVar.c);
                    }
                    b bVar2 = new b(iY, length);
                    C(this.p, 0, length);
                    u(iY, this.p, 0, 4);
                    u(iY + 4, bArr, 0, length);
                    A(this.l, this.m + 1, zF ? iY : this.n.f1709b, iY);
                    this.o = bVar2;
                    this.m++;
                    if (zF) {
                        this.n = bVar2;
                    }
                }
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public synchronized void c() throws IOException {
        A(4096, 0, 0, 0);
        this.m = 0;
        b bVar = b.a;
        this.n = bVar;
        this.o = bVar;
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
        b bVar = this.o;
        int iY = y(bVar.f1709b + 4 + bVar.c);
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
            this.o = new b(i6, this.o.c);
        } else {
            A(i3, this.m, i5, i4);
        }
        this.l = i3;
    }

    public synchronized void e(d dVar) throws IOException {
        int iY = this.n.f1709b;
        for (int i = 0; i < this.m; i++) {
            b bVarN = n(iY);
            dVar.a(new c(bVarN, null), bVarN.c);
            iY = y(bVarN.f1709b + 4 + bVarN.c);
        }
    }

    public synchronized boolean f() {
        return this.m == 0;
    }

    public final b n(int i) throws IOException {
        if (i == 0) {
            return b.a;
        }
        this.k.seek(i);
        return new b(i, this.k.readInt());
    }

    public synchronized void s() throws IOException {
        if (f()) {
            throw new NoSuchElementException();
        }
        if (this.m == 1) {
            c();
        } else {
            b bVar = this.n;
            int iY = y(bVar.f1709b + 4 + bVar.c);
            t(iY, this.p, 0, 4);
            int iQ = q(this.p, 0);
            A(this.l, this.m - 1, iY, this.o.f1709b);
            this.m--;
            this.n = new b(iY, iQ);
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
        sb.append(QueueFile.class.getSimpleName());
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
            e(new a(this, sb));
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
        b bVar = this.o;
        int i = bVar.f1709b;
        int i2 = this.n.f1709b;
        return i >= i2 ? (i - i2) + 4 + bVar.c + 16 : (((i + 4) + bVar.c) + this.l) - i2;
    }

    public final int y(int i) {
        int i2 = this.l;
        return i < i2 ? i : (i + 16) - i2;
    }

    /* JADX INFO: renamed from: b.i.c.m.d.l.c$c */
    /* JADX INFO: compiled from: QueueFile.java */
    public final class c extends InputStream {
        public int j;
        public int k;

        public c(b bVar, a aVar) {
            int i = bVar.f1709b + 4;
            int i2 = QueueFile.this.l;
            this.j = i >= i2 ? (i + 16) - i2 : i;
            this.k = bVar.c;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            Objects.requireNonNull(bArr, "buffer");
            if ((i | i2) < 0 || i2 > bArr.length - i) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i3 = this.k;
            if (i3 <= 0) {
                return -1;
            }
            if (i2 > i3) {
                i2 = i3;
            }
            QueueFile.this.t(this.j, bArr, i, i2);
            this.j = QueueFile.a(QueueFile.this, this.j + i2);
            this.k -= i2;
            return i2;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.k == 0) {
                return -1;
            }
            QueueFile.this.k.seek(this.j);
            int i = QueueFile.this.k.read();
            this.j = QueueFile.a(QueueFile.this, this.j + 1);
            this.k--;
            return i;
        }
    }
}
