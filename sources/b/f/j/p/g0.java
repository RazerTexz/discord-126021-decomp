package b.f.j.p;

import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: LocalFetchProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g0 implements w0<b.f.j.j.e> {
    public final Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.f.d.g.g f612b;

    public g0(Executor executor, b.f.d.g.g gVar) {
        this.a = executor;
        this.f612b = gVar;
    }

    @Override // b.f.j.p.w0
    public void b(l<b.f.j.j.e> lVar, x0 x0Var) {
        z0 z0VarO = x0Var.o();
        ImageRequest imageRequestE = x0Var.e();
        x0Var.i("local", "fetch");
        g0$a g0_a = new g0$a(this, lVar, z0VarO, x0Var, e(), imageRequestE, z0VarO, x0Var);
        x0Var.f(new g0$b(this, g0_a));
        this.a.execute(g0_a);
    }

    public b.f.j.j.e c(InputStream inputStream, int i) throws IOException {
        CloseableReference closeableReferenceA = null;
        try {
            closeableReferenceA = i <= 0 ? CloseableReference.A(this.f612b.c(inputStream)) : CloseableReference.A(this.f612b.d(inputStream, i));
            b.f.j.j.e eVar = new b.f.j.j.e(closeableReferenceA);
            b.f.d.d.a.b(inputStream);
            if (closeableReferenceA != null) {
                closeableReferenceA.close();
            }
            return eVar;
        } catch (Throwable th) {
            b.f.d.d.a.b(inputStream);
            Class<CloseableReference> cls = CloseableReference.j;
            if (closeableReferenceA != null) {
                closeableReferenceA.close();
            }
            throw th;
        }
    }

    public abstract b.f.j.j.e d(ImageRequest imageRequest) throws IOException;

    public abstract String e();
}
