package b.o.a.v;

import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import androidx.annotation.NonNull;
import java.util.Objects;

/* JADX INFO: compiled from: SnapshotGlPictureRecorder.java */
/* JADX INFO: loaded from: classes3.dex */
public class g$a implements b.o.a.w.f {
    public final /* synthetic */ g a;

    public g$a(g gVar) {
        this.a = gVar;
    }

    @Override // b.o.a.w.f
    public void a(@NonNull SurfaceTexture surfaceTexture, int i, float f, float f2) {
        this.a.n.d(this);
        g gVar = this.a;
        Objects.requireNonNull(gVar);
        b.o.a.r.g.a(new h(gVar, surfaceTexture, i, f, f2, EGL14.eglGetCurrentContext()));
    }

    @Override // b.o.a.w.f
    public void b(int i) {
        g gVar = this.a;
        Objects.requireNonNull(gVar);
        gVar.f1956s = new b.o.a.r.c(new b.o.b.f.b(33984, 36197, Integer.valueOf(i)));
        Rect rectL = b.i.a.f.e.o.f.L(gVar.j.d, gVar.o);
        gVar.j.d = new b.o.a.x.b(rectL.width(), rectL.height());
        if (gVar.q) {
            gVar.r = new b.o.a.u.b(gVar.p, gVar.j.d);
        }
    }

    @Override // b.o.a.w.f
    public void c(@NonNull b.o.a.o.b bVar) {
        this.a.f1956s.d = bVar.a();
    }
}
