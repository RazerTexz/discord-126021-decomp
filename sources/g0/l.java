package g0;

import androidx.recyclerview.widget.RecyclerView;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: GzipSource.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l implements x {
    public byte j;
    public final r k;
    public final Inflater l;
    public final m m;
    public final CRC32 n;

    public l(x xVar) {
        d0.z.d.m.checkParameterIsNotNull(xVar, "source");
        r rVar = new r(xVar);
        this.k = rVar;
        Inflater inflater = new Inflater(true);
        this.l = inflater;
        this.m = new m((g) rVar, inflater);
        this.n = new CRC32();
    }

    public final void a(String str, int i, int i2) throws IOException {
        if (i2 == i) {
            return;
        }
        String str2 = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}, 3));
        d0.z.d.m.checkExpressionValueIsNotNull(str2, "java.lang.String.format(this, *args)");
        throw new IOException(str2);
    }

    public final void b(e eVar, long j, long j2) {
        s sVar = eVar.j;
        if (sVar == null) {
            d0.z.d.m.throwNpe();
        }
        while (true) {
            int i = sVar.c;
            int i2 = sVar.f3693b;
            if (j < i - i2) {
                break;
            }
            j -= (long) (i - i2);
            sVar = sVar.f;
            if (sVar == null) {
                d0.z.d.m.throwNpe();
            }
        }
        while (j2 > 0) {
            int i3 = (int) (((long) sVar.f3693b) + j);
            int iMin = (int) Math.min(sVar.c - i3, j2);
            this.n.update(sVar.a, i3, iMin);
            j2 -= (long) iMin;
            sVar = sVar.f;
            if (sVar == null) {
                d0.z.d.m.throwNpe();
            }
            j = 0;
        }
    }

    @Override // g0.x, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.m.close();
    }

    @Override // g0.x
    public long i0(e eVar, long j) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(eVar, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(b.d.b.a.a.t("byteCount < 0: ", j).toString());
        }
        if (j == 0) {
            return 0L;
        }
        if (this.j == 0) {
            this.k.p0(10L);
            byte bQ = this.k.j.q(3L);
            boolean z2 = ((bQ >> 1) & 1) == 1;
            if (z2) {
                b(this.k.j, 0L, 10L);
            }
            a("ID1ID2", 8075, this.k.readShort());
            this.k.skip(8L);
            if (((bQ >> 2) & 1) == 1) {
                this.k.p0(2L);
                if (z2) {
                    b(this.k.j, 0L, 2L);
                }
                long jY = this.k.j.y();
                this.k.p0(jY);
                if (z2) {
                    b(this.k.j, 0L, jY);
                }
                this.k.skip(jY);
            }
            if (((bQ >> 3) & 1) == 1) {
                long jA = this.k.a((byte) 0, 0L, RecyclerView.FOREVER_NS);
                if (jA == -1) {
                    throw new EOFException();
                }
                if (z2) {
                    b(this.k.j, 0L, jA + 1);
                }
                this.k.skip(jA + 1);
            }
            if (((bQ >> 4) & 1) == 1) {
                long jA2 = this.k.a((byte) 0, 0L, RecyclerView.FOREVER_NS);
                if (jA2 == -1) {
                    throw new EOFException();
                }
                if (z2) {
                    b(this.k.j, 0L, jA2 + 1);
                }
                this.k.skip(jA2 + 1);
            }
            if (z2) {
                r rVar = this.k;
                rVar.p0(2L);
                a("FHCRC", rVar.j.y(), (short) this.n.getValue());
                this.n.reset();
            }
            this.j = (byte) 1;
        }
        if (this.j == 1) {
            long j2 = eVar.k;
            long jI0 = this.m.i0(eVar, j);
            if (jI0 != -1) {
                b(eVar, j2, jI0);
                return jI0;
            }
            this.j = (byte) 2;
        }
        if (this.j == 2) {
            a("CRC", this.k.b(), (int) this.n.getValue());
            a("ISIZE", this.k.b(), (int) this.l.getBytesWritten());
            this.j = (byte) 3;
            if (!this.k.w()) {
                throw new IOException("gzip finished without exhausting source");
            }
        }
        return -1L;
    }

    @Override // g0.x
    public y timeout() {
        return this.k.timeout();
    }
}
