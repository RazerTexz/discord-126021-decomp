package b.f.j.p;

import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PostprocessorProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class t0 implements w0<CloseableReference<b.f.j.j.c>> {
    public final w0<CloseableReference<b.f.j.j.c>> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PlatformBitmapFactory f639b;
    public final Executor c;

    public t0(w0<CloseableReference<b.f.j.j.c>> w0Var, PlatformBitmapFactory platformBitmapFactory, Executor executor) {
        Objects.requireNonNull(w0Var);
        this.a = w0Var;
        this.f639b = platformBitmapFactory;
        Objects.requireNonNull(executor);
        this.c = executor;
    }

    @Override // b.f.j.p.w0
    public void b(l<CloseableReference<b.f.j.j.c>> lVar, x0 x0Var) {
        z0 z0VarO = x0Var.o();
        b.f.j.q.b bVar = x0Var.e().f2903s;
        Objects.requireNonNull(bVar);
        t0$b t0_b = new t0$b(this, lVar, z0VarO, bVar, x0Var);
        this.a.b(bVar instanceof b.f.j.q.c ? new t0$c(this, t0_b, (b.f.j.q.c) bVar, x0Var, null) : new t0$d(this, t0_b, null), x0Var);
    }
}
