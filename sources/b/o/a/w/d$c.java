package b.o.a.w;

import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView$Renderer;
import android.opengl.Matrix;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: compiled from: GlCameraPreview.java */
/* JADX INFO: loaded from: classes3.dex */
public class d$c implements GLSurfaceView$Renderer {
    public final /* synthetic */ d j;

    public d$c(d dVar) {
        this.j = dVar;
    }

    @Override // android.opengl.GLSurfaceView$Renderer
    public void onDrawFrame(GL10 gl10) {
        d dVar = this.j;
        SurfaceTexture surfaceTexture = dVar.k;
        if (surfaceTexture != null && dVar.g > 0 && dVar.h > 0) {
            float[] fArr = dVar.l.f1950b;
            surfaceTexture.updateTexImage();
            this.j.k.getTransformMatrix(fArr);
            if (this.j.i != 0) {
                Matrix.translateM(fArr, 0, 0.5f, 0.5f, 0.0f);
                Matrix.rotateM(fArr, 0, this.j.i, 0.0f, 0.0f, 1.0f);
                Matrix.translateM(fArr, 0, -0.5f, -0.5f, 0.0f);
            }
            d dVar2 = this.j;
            if (dVar2.d) {
                Matrix.translateM(fArr, 0, (1.0f - dVar2.n) / 2.0f, (1.0f - dVar2.o) / 2.0f, 0.0f);
                d dVar3 = this.j;
                Matrix.scaleM(fArr, 0, dVar3.n, dVar3.o, 1.0f);
            }
            d dVar4 = this.j;
            dVar4.l.a(dVar4.k.getTimestamp() / 1000);
            for (f fVar : this.j.m) {
                d dVar5 = this.j;
                fVar.a(dVar5.k, dVar5.i, dVar5.n, dVar5.o);
            }
        }
    }

    @Override // android.opengl.GLSurfaceView$Renderer
    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        gl10.glViewport(0, 0, i, i2);
        this.j.q.k(i, i2);
        d dVar = this.j;
        if (!dVar.j) {
            dVar.f(i, i2);
            this.j.j = true;
        } else {
            if (i == dVar.e && i2 == dVar.f) {
                return;
            }
            dVar.h(i, i2);
        }
    }

    @Override // android.opengl.GLSurfaceView$Renderer
    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        d dVar = this.j;
        if (dVar.q == null) {
            dVar.q = new b.o.a.o.c();
        }
        this.j.l = new b.o.a.r.c(new b.o.b.f.b(33984, 36197, null, 4));
        d dVar2 = this.j;
        b.o.a.r.c cVar = dVar2.l;
        cVar.d = dVar2.q;
        int i = cVar.a.g;
        dVar2.k = new SurfaceTexture(i);
        ((GLSurfaceView) this.j.c).queueEvent(new d$c$a(this, i));
        this.j.k.setOnFrameAvailableListener(new d$c$b(this));
    }
}
