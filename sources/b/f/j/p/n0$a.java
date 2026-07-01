package b.f.j.p;

import com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream;
import java.io.InputStream;
import java.util.Objects;

/* JADX INFO: compiled from: NetworkFetchProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class n0$a implements o0$a {
    public final /* synthetic */ x a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n0 f630b;

    public n0$a(n0 n0Var, x xVar) {
        this.f630b = n0Var;
        this.a = xVar;
    }

    public void a(Throwable th) {
        n0 n0Var = this.f630b;
        x xVar = this.a;
        Objects.requireNonNull(n0Var);
        xVar.a().k(xVar.f642b, "NetworkFetchProducer", th, null);
        xVar.a().c(xVar.f642b, "NetworkFetchProducer", false);
        xVar.f642b.n("network");
        xVar.a.c(th);
    }

    public void b(InputStream inputStream, int i) throws Throwable {
        b.f.j.r.b.b();
        n0 n0Var = this.f630b;
        x xVar = this.a;
        b.f.d.g.i iVarE = i > 0 ? n0Var.a.e(i) : n0Var.a.a();
        byte[] bArr = n0Var.f629b.get(16384);
        while (true) {
            try {
                int i2 = inputStream.read(bArr);
                if (i2 < 0) {
                    o0 o0Var = n0Var.c;
                    int i3 = ((MemoryPooledByteBufferOutputStream) iVarE).l;
                    a0 a0Var = (a0) o0Var;
                    Objects.requireNonNull(a0Var);
                    ((a0$a) xVar).f = a0Var.c.now();
                    n0Var.c(iVarE, xVar);
                    n0Var.f629b.release(bArr);
                    iVarE.close();
                    b.f.j.r.b.b();
                    return;
                }
                if (i2 > 0) {
                    iVarE.write(bArr, 0, i2);
                    n0Var.d(iVarE, xVar);
                    int i4 = ((MemoryPooledByteBufferOutputStream) iVarE).l;
                    xVar.a.a(i > 0 ? i4 / i : 1.0f - ((float) Math.exp(((double) (-i4)) / 50000.0d)));
                }
            } catch (Throwable th) {
                n0Var.f629b.release(bArr);
                iVarE.close();
                throw th;
            }
        }
    }
}
