package b.o.a.w;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.otaliastudios.cameraview.R$a;
import com.otaliastudios.cameraview.R$b;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: GlCameraPreview.java */
/* JADX INFO: loaded from: classes3.dex */
public class d extends a<GLSurfaceView, SurfaceTexture> implements b, e {
    public boolean j;
    public SurfaceTexture k;
    public b.o.a.r.c l;
    public final Set<f> m;

    @VisibleForTesting
    public float n;

    @VisibleForTesting
    public float o;
    public View p;
    public b.o.a.o.b q;

    public d(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        super(context, viewGroup);
        this.m = new CopyOnWriteArraySet();
        this.n = 1.0f;
        this.o = 1.0f;
    }

    @Override // b.o.a.w.b
    public void a(@NonNull b.o.a.o.b bVar) {
        this.q = bVar;
        if (m()) {
            bVar.k(this.e, this.f);
        }
        ((GLSurfaceView) this.c).queueEvent(new d$b(this, bVar));
    }

    @Override // b.o.a.w.e
    public void b(@NonNull f fVar) {
        ((GLSurfaceView) this.c).queueEvent(new d$a(this, fVar));
    }

    @Override // b.o.a.w.b
    @NonNull
    public b.o.a.o.b c() {
        return this.q;
    }

    @Override // b.o.a.w.e
    public void d(@NonNull f fVar) {
        this.m.remove(fVar);
    }

    @Override // b.o.a.w.a
    public void e(@Nullable a$b a_b) {
        int i;
        int i2;
        float fI;
        float fI2;
        if (this.g <= 0 || this.h <= 0 || (i = this.e) <= 0 || (i2 = this.f) <= 0) {
            return;
        }
        b.o.a.x.a aVarF = b.o.a.x.a.f(i, i2);
        b.o.a.x.a aVarF2 = b.o.a.x.a.f(this.g, this.h);
        if (aVarF.i() >= aVarF2.i()) {
            fI2 = aVarF.i() / aVarF2.i();
            fI = 1.0f;
        } else {
            fI = aVarF2.i() / aVarF.i();
            fI2 = 1.0f;
        }
        this.d = fI > 1.02f || fI2 > 1.02f;
        this.n = 1.0f / fI;
        this.o = 1.0f / fI2;
        ((GLSurfaceView) this.c).requestRender();
    }

    @Override // b.o.a.w.a
    @NonNull
    public SurfaceTexture i() {
        return this.k;
    }

    @Override // b.o.a.w.a
    @NonNull
    public Class<SurfaceTexture> j() {
        return SurfaceTexture.class;
    }

    @Override // b.o.a.w.a
    @NonNull
    public View k() {
        return this.p;
    }

    @Override // b.o.a.w.a
    @NonNull
    public View n(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(context).inflate(R$b.cameraview_gl_view, viewGroup, false);
        GLSurfaceView gLSurfaceView = (GLSurfaceView) viewGroup2.findViewById(R$a.gl_surface_view);
        d$c d_c = new d$c(this);
        gLSurfaceView.setEGLContextClientVersion(2);
        gLSurfaceView.setRenderer(d_c);
        gLSurfaceView.setRenderMode(0);
        gLSurfaceView.getHolder().addCallback(new c(this, gLSurfaceView, d_c));
        viewGroup.addView(viewGroup2, 0);
        this.p = viewGroup2;
        return gLSurfaceView;
    }

    @Override // b.o.a.w.a
    public void o() {
        super.o();
        this.m.clear();
    }

    @Override // b.o.a.w.a
    public void p() {
        ((GLSurfaceView) this.c).onPause();
    }

    @Override // b.o.a.w.a
    public void q() {
        ((GLSurfaceView) this.c).onResume();
    }
}
