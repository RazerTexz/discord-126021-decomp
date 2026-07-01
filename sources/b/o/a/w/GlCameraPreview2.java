package b.o.a.w;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import b.o.a.o.Filter2;
import b.o.a.o.NoFilter;
import b.o.a.r.GlTextureDrawer;
import b.o.a.w.CameraPreview;
import b.o.a.x.AspectRatio2;
import b.o.b.f.GlTexture2;
import com.otaliastudios.cameraview.R;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: renamed from: b.o.a.w.d, reason: use source file name */
/* JADX INFO: compiled from: GlCameraPreview.java */
/* JADX INFO: loaded from: classes3.dex */
public class GlCameraPreview2 extends CameraPreview<GLSurfaceView, SurfaceTexture> implements FilterCameraPreview, RendererCameraPreview {
    public boolean j;
    public SurfaceTexture k;
    public GlTextureDrawer l;
    public final Set<RendererFrameCallback> m;

    @VisibleForTesting
    public float n;

    @VisibleForTesting
    public float o;
    public View p;
    public Filter2 q;

    /* JADX INFO: renamed from: b.o.a.w.d$a */
    /* JADX INFO: compiled from: GlCameraPreview.java */
    public class a implements Runnable {
        public final /* synthetic */ RendererFrameCallback j;

        public a(RendererFrameCallback rendererFrameCallback) {
            this.j = rendererFrameCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            GlCameraPreview2.this.m.add(this.j);
            GlTextureDrawer glTextureDrawer = GlCameraPreview2.this.l;
            if (glTextureDrawer != null) {
                this.j.b(glTextureDrawer.a.g);
            }
            this.j.c(GlCameraPreview2.this.q);
        }
    }

    /* JADX INFO: renamed from: b.o.a.w.d$b */
    /* JADX INFO: compiled from: GlCameraPreview.java */
    public class b implements Runnable {
        public final /* synthetic */ Filter2 j;

        public b(Filter2 filter2) {
            this.j = filter2;
        }

        @Override // java.lang.Runnable
        public void run() {
            GlCameraPreview2 glCameraPreview2 = GlCameraPreview2.this;
            GlTextureDrawer glTextureDrawer = glCameraPreview2.l;
            if (glTextureDrawer != null) {
                glTextureDrawer.d = this.j;
            }
            Iterator<RendererFrameCallback> it = glCameraPreview2.m.iterator();
            while (it.hasNext()) {
                it.next().c(this.j);
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.w.d$c */
    /* JADX INFO: compiled from: GlCameraPreview.java */
    public class c implements GLSurfaceView.Renderer {

        /* JADX INFO: renamed from: b.o.a.w.d$c$a */
        /* JADX INFO: compiled from: GlCameraPreview.java */
        public class a implements Runnable {
            public final /* synthetic */ int j;

            public a(int i) {
                this.j = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator<RendererFrameCallback> it = GlCameraPreview2.this.m.iterator();
                while (it.hasNext()) {
                    it.next().b(this.j);
                }
            }
        }

        /* JADX INFO: renamed from: b.o.a.w.d$c$b */
        /* JADX INFO: compiled from: GlCameraPreview.java */
        public class b implements SurfaceTexture.OnFrameAvailableListener {
            public b() {
            }

            @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                ((GLSurfaceView) GlCameraPreview2.this.c).requestRender();
            }
        }

        public c() {
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            GlCameraPreview2 glCameraPreview2 = GlCameraPreview2.this;
            SurfaceTexture surfaceTexture = glCameraPreview2.k;
            if (surfaceTexture != null && glCameraPreview2.g > 0 && glCameraPreview2.h > 0) {
                float[] fArr = glCameraPreview2.l.f1950b;
                surfaceTexture.updateTexImage();
                GlCameraPreview2.this.k.getTransformMatrix(fArr);
                if (GlCameraPreview2.this.i != 0) {
                    Matrix.translateM(fArr, 0, 0.5f, 0.5f, 0.0f);
                    Matrix.rotateM(fArr, 0, GlCameraPreview2.this.i, 0.0f, 0.0f, 1.0f);
                    Matrix.translateM(fArr, 0, -0.5f, -0.5f, 0.0f);
                }
                GlCameraPreview2 glCameraPreview3 = GlCameraPreview2.this;
                if (glCameraPreview3.d) {
                    Matrix.translateM(fArr, 0, (1.0f - glCameraPreview3.n) / 2.0f, (1.0f - glCameraPreview3.o) / 2.0f, 0.0f);
                    GlCameraPreview2 glCameraPreview4 = GlCameraPreview2.this;
                    Matrix.scaleM(fArr, 0, glCameraPreview4.n, glCameraPreview4.o, 1.0f);
                }
                GlCameraPreview2 glCameraPreview5 = GlCameraPreview2.this;
                glCameraPreview5.l.a(glCameraPreview5.k.getTimestamp() / 1000);
                for (RendererFrameCallback rendererFrameCallback : GlCameraPreview2.this.m) {
                    GlCameraPreview2 glCameraPreview6 = GlCameraPreview2.this;
                    rendererFrameCallback.a(glCameraPreview6.k, glCameraPreview6.i, glCameraPreview6.n, glCameraPreview6.o);
                }
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            gl10.glViewport(0, 0, i, i2);
            GlCameraPreview2.this.q.k(i, i2);
            GlCameraPreview2 glCameraPreview2 = GlCameraPreview2.this;
            if (!glCameraPreview2.j) {
                glCameraPreview2.f(i, i2);
                GlCameraPreview2.this.j = true;
            } else {
                if (i == glCameraPreview2.e && i2 == glCameraPreview2.f) {
                    return;
                }
                glCameraPreview2.h(i, i2);
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            GlCameraPreview2 glCameraPreview2 = GlCameraPreview2.this;
            if (glCameraPreview2.q == null) {
                glCameraPreview2.q = new NoFilter();
            }
            GlCameraPreview2.this.l = new GlTextureDrawer(new GlTexture2(33984, 36197, null, 4));
            GlCameraPreview2 glCameraPreview3 = GlCameraPreview2.this;
            GlTextureDrawer glTextureDrawer = glCameraPreview3.l;
            glTextureDrawer.d = glCameraPreview3.q;
            int i = glTextureDrawer.a.g;
            glCameraPreview3.k = new SurfaceTexture(i);
            ((GLSurfaceView) GlCameraPreview2.this.c).queueEvent(new a(i));
            GlCameraPreview2.this.k.setOnFrameAvailableListener(new b());
        }
    }

    public GlCameraPreview2(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        super(context, viewGroup);
        this.m = new CopyOnWriteArraySet();
        this.n = 1.0f;
        this.o = 1.0f;
    }

    @Override // b.o.a.w.FilterCameraPreview
    public void a(@NonNull Filter2 filter2) {
        this.q = filter2;
        if (m()) {
            filter2.k(this.e, this.f);
        }
        ((GLSurfaceView) this.c).queueEvent(new b(filter2));
    }

    @Override // b.o.a.w.RendererCameraPreview
    public void b(@NonNull RendererFrameCallback rendererFrameCallback) {
        ((GLSurfaceView) this.c).queueEvent(new a(rendererFrameCallback));
    }

    @Override // b.o.a.w.FilterCameraPreview
    @NonNull
    public Filter2 c() {
        return this.q;
    }

    @Override // b.o.a.w.RendererCameraPreview
    public void d(@NonNull RendererFrameCallback rendererFrameCallback) {
        this.m.remove(rendererFrameCallback);
    }

    @Override // b.o.a.w.CameraPreview
    public void e(@Nullable CameraPreview.b bVar) {
        int i;
        int i2;
        float fI;
        float fI2;
        if (this.g <= 0 || this.h <= 0 || (i = this.e) <= 0 || (i2 = this.f) <= 0) {
            return;
        }
        AspectRatio2 aspectRatio2F = AspectRatio2.f(i, i2);
        AspectRatio2 aspectRatio2F2 = AspectRatio2.f(this.g, this.h);
        if (aspectRatio2F.i() >= aspectRatio2F2.i()) {
            fI2 = aspectRatio2F.i() / aspectRatio2F2.i();
            fI = 1.0f;
        } else {
            fI = aspectRatio2F2.i() / aspectRatio2F.i();
            fI2 = 1.0f;
        }
        this.d = fI > 1.02f || fI2 > 1.02f;
        this.n = 1.0f / fI;
        this.o = 1.0f / fI2;
        ((GLSurfaceView) this.c).requestRender();
    }

    @Override // b.o.a.w.CameraPreview
    @NonNull
    public SurfaceTexture i() {
        return this.k;
    }

    @Override // b.o.a.w.CameraPreview
    @NonNull
    public Class<SurfaceTexture> j() {
        return SurfaceTexture.class;
    }

    @Override // b.o.a.w.CameraPreview
    @NonNull
    public View k() {
        return this.p;
    }

    @Override // b.o.a.w.CameraPreview
    @NonNull
    public View n(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(context).inflate(R.b.cameraview_gl_view, viewGroup, false);
        GLSurfaceView gLSurfaceView = (GLSurfaceView) viewGroup2.findViewById(R.a.gl_surface_view);
        c cVar = new c();
        gLSurfaceView.setEGLContextClientVersion(2);
        gLSurfaceView.setRenderer(cVar);
        gLSurfaceView.setRenderMode(0);
        gLSurfaceView.getHolder().addCallback(new GlCameraPreview(this, gLSurfaceView, cVar));
        viewGroup.addView(viewGroup2, 0);
        this.p = viewGroup2;
        return gLSurfaceView;
    }

    @Override // b.o.a.w.CameraPreview
    public void o() {
        super.o();
        this.m.clear();
    }

    @Override // b.o.a.w.CameraPreview
    public void p() {
        ((GLSurfaceView) this.c).onPause();
    }

    @Override // b.o.a.w.CameraPreview
    public void q() {
        ((GLSurfaceView) this.c).onResume();
    }
}
