package p007b.p225i.p361c.p369m.p370d.p374l;

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
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.i.c.m.d.l.c */
/* JADX INFO: compiled from: QueueFile.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4671c implements Closeable {

    /* JADX INFO: renamed from: j */
    public static final Logger f12474j = Logger.getLogger(C4671c.class.getName());

    /* JADX INFO: renamed from: k */
    public final RandomAccessFile f12475k;

    /* JADX INFO: renamed from: l */
    public int f12476l;

    /* JADX INFO: renamed from: m */
    public int f12477m;

    /* JADX INFO: renamed from: n */
    public b f12478n;

    /* JADX INFO: renamed from: o */
    public b f12479o;

    /* JADX INFO: renamed from: p */
    public final byte[] f12480p = new byte[16];

    /* JADX INFO: renamed from: b.i.c.m.d.l.c$a */
    /* JADX INFO: compiled from: QueueFile.java */
    public class a implements d {

        /* JADX INFO: renamed from: a */
        public boolean f12481a = true;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ StringBuilder f12482b;

        public a(C4671c c4671c, StringBuilder sb) {
            this.f12482b = sb;
        }

        @Override // p007b.p225i.p361c.p369m.p370d.p374l.C4671c.d
        /* JADX INFO: renamed from: a */
        public void mo6512a(InputStream inputStream, int i) throws IOException {
            if (this.f12481a) {
                this.f12481a = false;
            } else {
                this.f12482b.append(", ");
            }
            this.f12482b.append(i);
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.l.c$b */
    /* JADX INFO: compiled from: QueueFile.java */
    public static class b {

        /* JADX INFO: renamed from: a */
        public static final b f12483a = new b(0, 0);

        /* JADX INFO: renamed from: b */
        public final int f12484b;

        /* JADX INFO: renamed from: c */
        public final int f12485c;

        public b(int i, int i2) {
            this.f12484b = i;
            this.f12485c = i2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(b.class.getSimpleName());
            sb.append("[position = ");
            sb.append(this.f12484b);
            sb.append(", length = ");
            return C1643a.m814B(sb, this.f12485c, "]");
        }
    }

    /* JADX INFO: renamed from: b.i.c.m.d.l.c$d */
    /* JADX INFO: compiled from: QueueFile.java */
    public interface d {
        /* JADX INFO: renamed from: a */
        void mo6512a(InputStream inputStream, int i) throws IOException;
    }

    public C4671c(File file) throws IOException {
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
                    m6497C(bArr, i, iArr[i2]);
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
        this.f12475k = randomAccessFile2;
        randomAccessFile2.seek(0L);
        randomAccessFile2.readFully(this.f12480p);
        int iM6499q = m6499q(this.f12480p, 0);
        this.f12476l = iM6499q;
        if (iM6499q > randomAccessFile2.length()) {
            StringBuilder sbM833U = C1643a.m833U("File is truncated. Expected length: ");
            sbM833U.append(this.f12476l);
            sbM833U.append(", Actual length: ");
            sbM833U.append(randomAccessFile2.length());
            throw new IOException(sbM833U.toString());
        }
        this.f12477m = m6499q(this.f12480p, 4);
        int iM6499q2 = m6499q(this.f12480p, 8);
        int iM6499q3 = m6499q(this.f12480p, 12);
        this.f12478n = m6506n(iM6499q2);
        this.f12479o = m6506n(iM6499q3);
    }

    /* JADX INFO: renamed from: C */
    public static void m6497C(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    /* JADX INFO: renamed from: a */
    public static int m6498a(C4671c c4671c, int i) {
        int i2 = c4671c.f12476l;
        return i < i2 ? i : (i + 16) - i2;
    }

    /* JADX INFO: renamed from: q */
    public static int m6499q(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 24) + ((bArr[i + 1] & 255) << 16) + ((bArr[i + 2] & 255) << 8) + (bArr[i + 3] & 255);
    }

    /* JADX INFO: renamed from: A */
    public final void m6500A(int i, int i2, int i3, int i4) throws IOException {
        byte[] bArr = this.f12480p;
        int[] iArr = {i, i2, i3, i4};
        int i5 = 0;
        for (int i6 = 0; i6 < 4; i6++) {
            m6497C(bArr, i5, iArr[i6]);
            i5 += 4;
        }
        this.f12475k.seek(0L);
        this.f12475k.write(this.f12480p);
    }

    /* JADX INFO: renamed from: b */
    public void m6501b(byte[] bArr) throws IOException {
        int iM6511y;
        int length = bArr.length;
        synchronized (this) {
            if ((0 | length) >= 0) {
                if (length <= bArr.length - 0) {
                    m6503d(length);
                    boolean zM6505f = m6505f();
                    if (zM6505f) {
                        iM6511y = 16;
                    } else {
                        b bVar = this.f12479o;
                        iM6511y = m6511y(bVar.f12484b + 4 + bVar.f12485c);
                    }
                    b bVar2 = new b(iM6511y, length);
                    m6497C(this.f12480p, 0, length);
                    m6509u(iM6511y, this.f12480p, 0, 4);
                    m6509u(iM6511y + 4, bArr, 0, length);
                    m6500A(this.f12476l, this.f12477m + 1, zM6505f ? iM6511y : this.f12478n.f12484b, iM6511y);
                    this.f12479o = bVar2;
                    this.f12477m++;
                    if (zM6505f) {
                        this.f12478n = bVar2;
                    }
                }
            }
            throw new IndexOutOfBoundsException();
        }
    }

    /* JADX INFO: renamed from: c */
    public synchronized void m6502c() throws IOException {
        m6500A(4096, 0, 0, 0);
        this.f12477m = 0;
        b bVar = b.f12483a;
        this.f12478n = bVar;
        this.f12479o = bVar;
        if (this.f12476l > 4096) {
            this.f12475k.setLength(4096);
            this.f12475k.getChannel().force(true);
        }
        this.f12476l = 4096;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.f12475k.close();
    }

    /* JADX INFO: renamed from: d */
    public final void m6503d(int i) throws IOException {
        int i2 = i + 4;
        int iM6510x = this.f12476l - m6510x();
        if (iM6510x >= i2) {
            return;
        }
        int i3 = this.f12476l;
        do {
            iM6510x += i3;
            i3 <<= 1;
        } while (iM6510x < i2);
        this.f12475k.setLength(i3);
        this.f12475k.getChannel().force(true);
        b bVar = this.f12479o;
        int iM6511y = m6511y(bVar.f12484b + 4 + bVar.f12485c);
        if (iM6511y < this.f12478n.f12484b) {
            FileChannel channel = this.f12475k.getChannel();
            channel.position(this.f12476l);
            long j = iM6511y - 4;
            if (channel.transferTo(16L, j, channel) != j) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        int i4 = this.f12479o.f12484b;
        int i5 = this.f12478n.f12484b;
        if (i4 < i5) {
            int i6 = (this.f12476l + i4) - 16;
            m6500A(i3, this.f12477m, i5, i6);
            this.f12479o = new b(i6, this.f12479o.f12485c);
        } else {
            m6500A(i3, this.f12477m, i5, i4);
        }
        this.f12476l = i3;
    }

    /* JADX INFO: renamed from: e */
    public synchronized void m6504e(d dVar) throws IOException {
        int iM6511y = this.f12478n.f12484b;
        for (int i = 0; i < this.f12477m; i++) {
            b bVarM6506n = m6506n(iM6511y);
            dVar.mo6512a(new c(bVarM6506n, null), bVarM6506n.f12485c);
            iM6511y = m6511y(bVarM6506n.f12484b + 4 + bVarM6506n.f12485c);
        }
    }

    /* JADX INFO: renamed from: f */
    public synchronized boolean m6505f() {
        return this.f12477m == 0;
    }

    /* JADX INFO: renamed from: n */
    public final b m6506n(int i) throws IOException {
        if (i == 0) {
            return b.f12483a;
        }
        this.f12475k.seek(i);
        return new b(i, this.f12475k.readInt());
    }

    /* JADX INFO: renamed from: s */
    public synchronized void m6507s() throws IOException {
        if (m6505f()) {
            throw new NoSuchElementException();
        }
        if (this.f12477m == 1) {
            m6502c();
        } else {
            b bVar = this.f12478n;
            int iM6511y = m6511y(bVar.f12484b + 4 + bVar.f12485c);
            m6508t(iM6511y, this.f12480p, 0, 4);
            int iM6499q = m6499q(this.f12480p, 0);
            m6500A(this.f12476l, this.f12477m - 1, iM6511y, this.f12479o.f12484b);
            this.f12477m--;
            this.f12478n = new b(iM6511y, iM6499q);
        }
    }

    /* JADX INFO: renamed from: t */
    public final void m6508t(int i, byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.f12476l;
        if (i >= i4) {
            i = (i + 16) - i4;
        }
        if (i + i3 <= i4) {
            this.f12475k.seek(i);
            this.f12475k.readFully(bArr, i2, i3);
            return;
        }
        int i5 = i4 - i;
        this.f12475k.seek(i);
        this.f12475k.readFully(bArr, i2, i5);
        this.f12475k.seek(16L);
        this.f12475k.readFully(bArr, i2 + i5, i3 - i5);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(C4671c.class.getSimpleName());
        sb.append('[');
        sb.append("fileLength=");
        sb.append(this.f12476l);
        sb.append(", size=");
        sb.append(this.f12477m);
        sb.append(", first=");
        sb.append(this.f12478n);
        sb.append(", last=");
        sb.append(this.f12479o);
        sb.append(", element lengths=[");
        try {
            m6504e(new a(this, sb));
        } catch (IOException e) {
            f12474j.log(Level.WARNING, "read error", (Throwable) e);
        }
        sb.append("]]");
        return sb.toString();
    }

    /* JADX INFO: renamed from: u */
    public final void m6509u(int i, byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.f12476l;
        if (i >= i4) {
            i = (i + 16) - i4;
        }
        if (i + i3 <= i4) {
            this.f12475k.seek(i);
            this.f12475k.write(bArr, i2, i3);
            return;
        }
        int i5 = i4 - i;
        this.f12475k.seek(i);
        this.f12475k.write(bArr, i2, i5);
        this.f12475k.seek(16L);
        this.f12475k.write(bArr, i2 + i5, i3 - i5);
    }

    /* JADX INFO: renamed from: x */
    public int m6510x() {
        if (this.f12477m == 0) {
            return 16;
        }
        b bVar = this.f12479o;
        int i = bVar.f12484b;
        int i2 = this.f12478n.f12484b;
        return i >= i2 ? (i - i2) + 4 + bVar.f12485c + 16 : (((i + 4) + bVar.f12485c) + this.f12476l) - i2;
    }

    /* JADX INFO: renamed from: y */
    public final int m6511y(int i) {
        int i2 = this.f12476l;
        return i < i2 ? i : (i + 16) - i2;
    }

    /* JADX INFO: renamed from: b.i.c.m.d.l.c$c */
    /* JADX INFO: compiled from: QueueFile.java */
    public final class c extends InputStream {

        /* JADX INFO: renamed from: j */
        public int f12486j;

        /* JADX INFO: renamed from: k */
        public int f12487k;

        public c(b bVar, a aVar) {
            int i = bVar.f12484b + 4;
            int i2 = C4671c.this.f12476l;
            this.f12486j = i >= i2 ? (i + 16) - i2 : i;
            this.f12487k = bVar.f12485c;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            Objects.requireNonNull(bArr, "buffer");
            if ((i | i2) < 0 || i2 > bArr.length - i) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i3 = this.f12487k;
            if (i3 <= 0) {
                return -1;
            }
            if (i2 > i3) {
                i2 = i3;
            }
            C4671c.this.m6508t(this.f12486j, bArr, i, i2);
            this.f12486j = C4671c.m6498a(C4671c.this, this.f12486j + i2);
            this.f12487k -= i2;
            return i2;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.f12487k == 0) {
                return -1;
            }
            C4671c.this.f12475k.seek(this.f12486j);
            int i = C4671c.this.f12475k.read();
            this.f12486j = C4671c.m6498a(C4671c.this, this.f12486j + 1);
            this.f12487k--;
            return i;
        }
    }
}
