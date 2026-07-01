package g0;

import java.io.IOException;
import java.util.zip.Deflater;
import okio.BufferedSink;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: compiled from: DeflaterSink.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements v {
    public boolean j;
    public final BufferedSink k;
    public final Deflater l;

    public h(v vVar, Deflater deflater) {
        d0.z.d.m.checkParameterIsNotNull(vVar, "sink");
        d0.z.d.m.checkParameterIsNotNull(deflater, "deflater");
        d0.z.d.m.checkParameterIsNotNull(vVar, "$this$buffer");
        q qVar = new q(vVar);
        d0.z.d.m.checkParameterIsNotNull(qVar, "sink");
        d0.z.d.m.checkParameterIsNotNull(deflater, "deflater");
        this.k = qVar;
        this.l = deflater;
    }

    @IgnoreJRERequirement
    public final void a(boolean z2) throws IOException {
        s sVarN;
        int iDeflate;
        e eVarG = this.k.g();
        while (true) {
            sVarN = eVarG.N(1);
            if (z2) {
                Deflater deflater = this.l;
                byte[] bArr = sVarN.a;
                int i = sVarN.c;
                iDeflate = deflater.deflate(bArr, i, 8192 - i, 2);
            } else {
                Deflater deflater2 = this.l;
                byte[] bArr2 = sVarN.a;
                int i2 = sVarN.c;
                iDeflate = deflater2.deflate(bArr2, i2, 8192 - i2);
            }
            if (iDeflate > 0) {
                sVarN.c += iDeflate;
                eVarG.k += (long) iDeflate;
                this.k.F();
            } else if (this.l.needsInput()) {
                break;
            }
        }
        if (sVarN.f3693b == sVarN.c) {
            eVarG.j = sVarN.a();
            t.a(sVarN);
        }
    }

    @Override // g0.v, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.j) {
            return;
        }
        Throwable th = null;
        try {
            this.l.finish();
            a(false);
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.l.end();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        try {
            this.k.close();
        } catch (Throwable th4) {
            if (th == null) {
                th = th4;
            }
        }
        this.j = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // g0.v, java.io.Flushable
    public void flush() throws IOException {
        a(true);
        this.k.flush();
    }

    @Override // g0.v
    public y timeout() {
        return this.k.timeout();
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("DeflaterSink(");
        sbU.append(this.k);
        sbU.append(')');
        return sbU.toString();
    }

    @Override // g0.v
    public void write(e eVar, long j) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(eVar, "source");
        b.i.a.f.e.o.f.B(eVar.k, 0L, j);
        while (j > 0) {
            s sVar = eVar.j;
            if (sVar == null) {
                d0.z.d.m.throwNpe();
            }
            int iMin = (int) Math.min(j, sVar.c - sVar.f3693b);
            this.l.setInput(sVar.a, sVar.f3693b, iMin);
            a(false);
            long j2 = iMin;
            eVar.k -= j2;
            int i = sVar.f3693b + iMin;
            sVar.f3693b = i;
            if (i == sVar.c) {
                eVar.j = sVar.a();
                t.a(sVar);
            }
            j -= j2;
        }
    }
}
