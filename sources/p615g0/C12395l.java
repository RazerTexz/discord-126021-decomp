package p615g0;

import androidx.recyclerview.widget.RecyclerView;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: g0.l */
/* JADX INFO: compiled from: GzipSource.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12395l implements InterfaceC12407x {

    /* JADX INFO: renamed from: j */
    public byte f26095j;

    /* JADX INFO: renamed from: k */
    public final C12401r f26096k;

    /* JADX INFO: renamed from: l */
    public final Inflater f26097l;

    /* JADX INFO: renamed from: m */
    public final C12396m f26098m;

    /* JADX INFO: renamed from: n */
    public final CRC32 f26099n;

    public C12395l(InterfaceC12407x interfaceC12407x) {
        C12238m.checkParameterIsNotNull(interfaceC12407x, "source");
        C12401r c12401r = new C12401r(interfaceC12407x);
        this.f26096k = c12401r;
        Inflater inflater = new Inflater(true);
        this.f26097l = inflater;
        this.f26098m = new C12396m((InterfaceC12390g) c12401r, inflater);
        this.f26099n = new CRC32();
    }

    /* JADX INFO: renamed from: a */
    public final void m10486a(String str, int i, int i2) throws IOException {
        if (i2 == i) {
            return;
        }
        String str2 = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}, 3));
        C12238m.checkExpressionValueIsNotNull(str2, "java.lang.String.format(this, *args)");
        throw new IOException(str2);
    }

    /* JADX INFO: renamed from: b */
    public final void m10487b(C12388e c12388e, long j, long j2) {
        C12402s c12402s = c12388e.f26079j;
        if (c12402s == null) {
            C12238m.throwNpe();
        }
        while (true) {
            int i = c12402s.f26120c;
            int i2 = c12402s.f26119b;
            if (j < i - i2) {
                break;
            }
            j -= (long) (i - i2);
            c12402s = c12402s.f26123f;
            if (c12402s == null) {
                C12238m.throwNpe();
            }
        }
        while (j2 > 0) {
            int i3 = (int) (((long) c12402s.f26119b) + j);
            int iMin = (int) Math.min(c12402s.f26120c - i3, j2);
            this.f26099n.update(c12402s.f26118a, i3, iMin);
            j2 -= (long) iMin;
            c12402s = c12402s.f26123f;
            if (c12402s == null) {
                C12238m.throwNpe();
            }
            j = 0;
        }
    }

    @Override // p615g0.InterfaceC12407x, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f26098m.close();
    }

    @Override // p615g0.InterfaceC12407x
    /* JADX INFO: renamed from: i0 */
    public long mo10176i0(C12388e c12388e, long j) throws IOException {
        C12238m.checkParameterIsNotNull(c12388e, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(C1643a.m877t("byteCount < 0: ", j).toString());
        }
        if (j == 0) {
            return 0L;
        }
        if (this.f26095j == 0) {
            this.f26096k.mo10463p0(10L);
            byte bM10464q = this.f26096k.f26114j.m10464q(3L);
            boolean z2 = ((bM10464q >> 1) & 1) == 1;
            if (z2) {
                m10487b(this.f26096k.f26114j, 0L, 10L);
            }
            m10486a("ID1ID2", 8075, this.f26096k.readShort());
            this.f26096k.skip(8L);
            if (((bM10464q >> 2) & 1) == 1) {
                this.f26096k.mo10463p0(2L);
                if (z2) {
                    m10487b(this.f26096k.f26114j, 0L, 2L);
                }
                long jM10474y = this.f26096k.f26114j.m10474y();
                this.f26096k.mo10463p0(jM10474y);
                if (z2) {
                    m10487b(this.f26096k.f26114j, 0L, jM10474y);
                }
                this.f26096k.skip(jM10474y);
            }
            if (((bM10464q >> 3) & 1) == 1) {
                long jM10492a = this.f26096k.m10492a((byte) 0, 0L, RecyclerView.FOREVER_NS);
                if (jM10492a == -1) {
                    throw new EOFException();
                }
                if (z2) {
                    m10487b(this.f26096k.f26114j, 0L, jM10492a + 1);
                }
                this.f26096k.skip(jM10492a + 1);
            }
            if (((bM10464q >> 4) & 1) == 1) {
                long jM10492a2 = this.f26096k.m10492a((byte) 0, 0L, RecyclerView.FOREVER_NS);
                if (jM10492a2 == -1) {
                    throw new EOFException();
                }
                if (z2) {
                    m10487b(this.f26096k.f26114j, 0L, jM10492a2 + 1);
                }
                this.f26096k.skip(jM10492a2 + 1);
            }
            if (z2) {
                C12401r c12401r = this.f26096k;
                c12401r.mo10463p0(2L);
                m10486a("FHCRC", c12401r.f26114j.m10474y(), (short) this.f26099n.getValue());
                this.f26099n.reset();
            }
            this.f26095j = (byte) 1;
        }
        if (this.f26095j == 1) {
            long j2 = c12388e.f26080k;
            long jMo10176i0 = this.f26098m.mo10176i0(c12388e, j);
            if (jMo10176i0 != -1) {
                m10487b(c12388e, j2, jMo10176i0);
                return jMo10176i0;
            }
            this.f26095j = (byte) 2;
        }
        if (this.f26095j == 2) {
            m10486a("CRC", this.f26096k.m10493b(), (int) this.f26099n.getValue());
            m10486a("ISIZE", this.f26096k.m10493b(), (int) this.f26097l.getBytesWritten());
            this.f26095j = (byte) 3;
            if (!this.f26096k.mo10472w()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // p615g0.InterfaceC12407x
    public C12408y timeout() {
        return this.f26096k.timeout();
    }
}
