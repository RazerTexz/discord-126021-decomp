package p615g0;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: g0.m */
/* JADX INFO: compiled from: InflaterSource.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12396m implements InterfaceC12407x {

    /* JADX INFO: renamed from: j */
    public int f26100j;

    /* JADX INFO: renamed from: k */
    public boolean f26101k;

    /* JADX INFO: renamed from: l */
    public final InterfaceC12390g f26102l;

    /* JADX INFO: renamed from: m */
    public final Inflater f26103m;

    public C12396m(InterfaceC12407x interfaceC12407x, Inflater inflater) {
        C12238m.checkParameterIsNotNull(interfaceC12407x, "source");
        C12238m.checkParameterIsNotNull(inflater, "inflater");
        C12238m.checkParameterIsNotNull(interfaceC12407x, "$this$buffer");
        C12401r c12401r = new C12401r(interfaceC12407x);
        C12238m.checkParameterIsNotNull(c12401r, "source");
        C12238m.checkParameterIsNotNull(inflater, "inflater");
        this.f26102l = c12401r;
        this.f26103m = inflater;
    }

    /* JADX INFO: renamed from: a */
    public final long m10488a(C12388e c12388e, long j) throws IOException {
        C12238m.checkParameterIsNotNull(c12388e, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(C1643a.m877t("byteCount < 0: ", j).toString());
        }
        if (!(!this.f26101k)) {
            throw new IllegalStateException("closed".toString());
        }
        if (j == 0) {
            return 0L;
        }
        try {
            C12402s c12402sM10438N = c12388e.m10438N(1);
            int iMin = (int) Math.min(j, 8192 - c12402sM10438N.f26120c);
            if (this.f26103m.needsInput() && !this.f26102l.mo10472w()) {
                C12402s c12402s = this.f26102l.mo10457g().f26079j;
                if (c12402s == null) {
                    C12238m.throwNpe();
                }
                int i = c12402s.f26120c;
                int i2 = c12402s.f26119b;
                int i3 = i - i2;
                this.f26100j = i3;
                this.f26103m.setInput(c12402s.f26118a, i2, i3);
            }
            int iInflate = this.f26103m.inflate(c12402sM10438N.f26118a, c12402sM10438N.f26120c, iMin);
            int i4 = this.f26100j;
            if (i4 != 0) {
                int remaining = i4 - this.f26103m.getRemaining();
                this.f26100j -= remaining;
                this.f26102l.skip(remaining);
            }
            if (iInflate > 0) {
                c12402sM10438N.f26120c += iInflate;
                long j2 = iInflate;
                c12388e.f26080k += j2;
                return j2;
            }
            if (c12402sM10438N.f26119b == c12402sM10438N.f26120c) {
                c12388e.f26079j = c12402sM10438N.m10494a();
                C12403t.m10498a(c12402sM10438N);
            }
            return 0L;
        } catch (DataFormatException e) {
            throw new IOException(e);
        }
    }

    @Override // p615g0.InterfaceC12407x, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f26101k) {
            return;
        }
        this.f26103m.end();
        this.f26101k = true;
        this.f26102l.close();
    }

    @Override // p615g0.InterfaceC12407x
    /* JADX INFO: renamed from: i0 */
    public long mo10176i0(C12388e c12388e, long j) throws IOException {
        C12238m.checkParameterIsNotNull(c12388e, "sink");
        do {
            long jM10488a = m10488a(c12388e, j);
            if (jM10488a > 0) {
                return jM10488a;
            }
            if (this.f26103m.finished() || this.f26103m.needsDictionary()) {
                return -1L;
            }
        } while (!this.f26102l.mo10472w());
        throw new EOFException("source exhausted prematurely");
    }

    @Override // p615g0.InterfaceC12407x
    public C12408y timeout() {
        return this.f26102l.timeout();
    }

    public C12396m(InterfaceC12390g interfaceC12390g, Inflater inflater) {
        C12238m.checkParameterIsNotNull(interfaceC12390g, "source");
        C12238m.checkParameterIsNotNull(inflater, "inflater");
        this.f26102l = interfaceC12390g;
        this.f26103m = inflater;
    }
}
