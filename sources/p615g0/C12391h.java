package p615g0;

import java.io.IOException;
import java.util.zip.Deflater;
import okio.BufferedSink;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: g0.h */
/* JADX INFO: compiled from: DeflaterSink.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12391h implements InterfaceC12405v {

    /* JADX INFO: renamed from: j */
    public boolean f26090j;

    /* JADX INFO: renamed from: k */
    public final BufferedSink f26091k;

    /* JADX INFO: renamed from: l */
    public final Deflater f26092l;

    public C12391h(InterfaceC12405v interfaceC12405v, Deflater deflater) {
        C12238m.checkParameterIsNotNull(interfaceC12405v, "sink");
        C12238m.checkParameterIsNotNull(deflater, "deflater");
        C12238m.checkParameterIsNotNull(interfaceC12405v, "$this$buffer");
        C12400q c12400q = new C12400q(interfaceC12405v);
        C12238m.checkParameterIsNotNull(c12400q, "sink");
        C12238m.checkParameterIsNotNull(deflater, "deflater");
        this.f26091k = c12400q;
        this.f26092l = deflater;
    }

    @IgnoreJRERequirement
    /* JADX INFO: renamed from: a */
    public final void m10477a(boolean z2) throws IOException {
        C12402s c12402sM10438N;
        int iDeflate;
        C12388e c12388eMo10457g = this.f26091k.mo10457g();
        while (true) {
            c12402sM10438N = c12388eMo10457g.m10438N(1);
            if (z2) {
                Deflater deflater = this.f26092l;
                byte[] bArr = c12402sM10438N.f26118a;
                int i = c12402sM10438N.f26120c;
                iDeflate = deflater.deflate(bArr, i, 8192 - i, 2);
            } else {
                Deflater deflater2 = this.f26092l;
                byte[] bArr2 = c12402sM10438N.f26118a;
                int i2 = c12402sM10438N.f26120c;
                iDeflate = deflater2.deflate(bArr2, i2, 8192 - i2);
            }
            if (iDeflate > 0) {
                c12402sM10438N.f26120c += iDeflate;
                c12388eMo10457g.f26080k += (long) iDeflate;
                this.f26091k.mo10431F();
            } else if (this.f26092l.needsInput()) {
                break;
            }
        }
        if (c12402sM10438N.f26119b == c12402sM10438N.f26120c) {
            c12388eMo10457g.f26079j = c12402sM10438N.m10494a();
            C12403t.m10498a(c12402sM10438N);
        }
    }

    @Override // p615g0.InterfaceC12405v, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f26090j) {
            return;
        }
        Throwable th = null;
        try {
            this.f26092l.finish();
            m10477a(false);
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f26092l.end();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        try {
            this.f26091k.close();
        } catch (Throwable th4) {
            if (th == null) {
                th = th4;
            }
        }
        this.f26090j = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // p615g0.InterfaceC12405v, java.io.Flushable
    public void flush() throws IOException {
        m10477a(true);
        this.f26091k.flush();
    }

    @Override // p615g0.InterfaceC12405v
    public C12408y timeout() {
        return this.f26091k.timeout();
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("DeflaterSink(");
        sbM833U.append(this.f26091k);
        sbM833U.append(')');
        return sbM833U.toString();
    }

    @Override // p615g0.InterfaceC12405v
    public void write(C12388e c12388e, long j) throws IOException {
        C12238m.checkParameterIsNotNull(c12388e, "source");
        C3404f.m4192B(c12388e.f26080k, 0L, j);
        while (j > 0) {
            C12402s c12402s = c12388e.f26079j;
            if (c12402s == null) {
                C12238m.throwNpe();
            }
            int iMin = (int) Math.min(j, c12402s.f26120c - c12402s.f26119b);
            this.f26092l.setInput(c12402s.f26118a, c12402s.f26119b, iMin);
            m10477a(false);
            long j2 = iMin;
            c12388e.f26080k -= j2;
            int i = c12402s.f26119b + iMin;
            c12402s.f26119b = i;
            if (i == c12402s.f26120c) {
                c12388e.f26079j = c12402s.m10494a();
                C12403t.m10498a(c12402s);
            }
            j -= j2;
        }
    }
}
