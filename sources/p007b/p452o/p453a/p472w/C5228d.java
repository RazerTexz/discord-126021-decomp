package p007b.p452o.p453a.p472w;

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
import com.otaliastudios.cameraview.C11196R;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import p007b.p452o.p453a.p464o.C5185c;
import p007b.p452o.p453a.p464o.InterfaceC5184b;
import p007b.p452o.p453a.p467r.C5202c;
import p007b.p452o.p453a.p472w.AbstractC5225a;
import p007b.p452o.p453a.p473x.C5235a;
import p007b.p452o.p475b.p481f.C5269b;

/* JADX INFO: renamed from: b.o.a.w.d */
/* JADX INFO: compiled from: GlCameraPreview.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5228d extends AbstractC5225a<GLSurfaceView, SurfaceTexture> implements InterfaceC5226b, InterfaceC5229e {

    /* JADX INFO: renamed from: j */
    public boolean f14221j;

    /* JADX INFO: renamed from: k */
    public SurfaceTexture f14222k;

    /* JADX INFO: renamed from: l */
    public C5202c f14223l;

    /* JADX INFO: renamed from: m */
    public final Set<InterfaceC5230f> f14224m;

    /* JADX INFO: renamed from: n */
    @VisibleForTesting
    public float f14225n;

    /* JADX INFO: renamed from: o */
    @VisibleForTesting
    public float f14226o;

    /* JADX INFO: renamed from: p */
    public View f14227p;

    /* JADX INFO: renamed from: q */
    public InterfaceC5184b f14228q;

    /* JADX INFO: renamed from: b.o.a.w.d$a */
    /* JADX INFO: compiled from: GlCameraPreview.java */
    public class a implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ InterfaceC5230f f14229j;

        public a(InterfaceC5230f interfaceC5230f) {
            this.f14229j = interfaceC5230f;
        }

        @Override // java.lang.Runnable
        public void run() {
            C5228d.this.f14224m.add(this.f14229j);
            C5202c c5202c = C5228d.this.f14223l;
            if (c5202c != null) {
                this.f14229j.mo7423b(c5202c.f14105a.f14337g);
            }
            this.f14229j.mo7424c(C5228d.this.f14228q);
        }
    }

    /* JADX INFO: renamed from: b.o.a.w.d$b */
    /* JADX INFO: compiled from: GlCameraPreview.java */
    public class b implements Runnable {

        /* JADX INFO: renamed from: j */
        public final /* synthetic */ InterfaceC5184b f14231j;

        public b(InterfaceC5184b interfaceC5184b) {
            this.f14231j = interfaceC5184b;
        }

        @Override // java.lang.Runnable
        public void run() {
            C5228d c5228d = C5228d.this;
            C5202c c5202c = c5228d.f14223l;
            if (c5202c != null) {
                c5202c.f14108d = this.f14231j;
            }
            Iterator<InterfaceC5230f> it = c5228d.f14224m.iterator();
            while (it.hasNext()) {
                it.next().mo7424c(this.f14231j);
            }
        }
    }

    /* JADX INFO: renamed from: b.o.a.w.d$c */
    /* JADX INFO: compiled from: GlCameraPreview.java */
    public class c implements GLSurfaceView.Renderer {

        /* JADX INFO: renamed from: b.o.a.w.d$c$a */
        /* JADX INFO: compiled from: GlCameraPreview.java */
        public class a implements Runnable {

            /* JADX INFO: renamed from: j */
            public final /* synthetic */ int f14234j;

            public a(int i) {
                this.f14234j = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator<InterfaceC5230f> it = C5228d.this.f14224m.iterator();
                while (it.hasNext()) {
                    it.next().mo7423b(this.f14234j);
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
                ((GLSurfaceView) C5228d.this.f14208c).requestRender();
            }
        }

        public c() {
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            C5228d c5228d = C5228d.this;
            SurfaceTexture surfaceTexture = c5228d.f14222k;
            if (surfaceTexture != null && c5228d.f14212g > 0 && c5228d.f14213h > 0) {
                float[] fArr = c5228d.f14223l.f14106b;
                surfaceTexture.updateTexImage();
                C5228d.this.f14222k.getTransformMatrix(fArr);
                if (C5228d.this.f14214i != 0) {
                    Matrix.translateM(fArr, 0, 0.5f, 0.5f, 0.0f);
                    Matrix.rotateM(fArr, 0, C5228d.this.f14214i, 0.0f, 0.0f, 1.0f);
                    Matrix.translateM(fArr, 0, -0.5f, -0.5f, 0.0f);
                }
                C5228d c5228d2 = C5228d.this;
                if (c5228d2.f14209d) {
                    Matrix.translateM(fArr, 0, (1.0f - c5228d2.f14225n) / 2.0f, (1.0f - c5228d2.f14226o) / 2.0f, 0.0f);
                    C5228d c5228d3 = C5228d.this;
                    Matrix.scaleM(fArr, 0, c5228d3.f14225n, c5228d3.f14226o, 1.0f);
                }
                C5228d c5228d4 = C5228d.this;
                c5228d4.f14223l.m7399a(c5228d4.f14222k.getTimestamp() / 1000);
                for (InterfaceC5230f interfaceC5230f : C5228d.this.f14224m) {
                    C5228d c5228d5 = C5228d.this;
                    interfaceC5230f.mo7422a(c5228d5.f14222k, c5228d5.f14214i, c5228d5.f14225n, c5228d5.f14226o);
                }
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            gl10.glViewport(0, 0, i, i2);
            C5228d.this.f14228q.mo7374k(i, i2);
            C5228d c5228d = C5228d.this;
            if (!c5228d.f14221j) {
                c5228d.m7426f(i, i2);
                C5228d.this.f14221j = true;
            } else {
                if (i == c5228d.f14210e && i2 == c5228d.f14211f) {
                    return;
                }
                c5228d.m7428h(i, i2);
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            C5228d c5228d = C5228d.this;
            if (c5228d.f14228q == null) {
                c5228d.f14228q = new C5185c();
            }
            C5228d.this.f14223l = new C5202c(new C5269b(33984, 36197, null, 4));
            C5228d c5228d2 = C5228d.this;
            C5202c c5202c = c5228d2.f14223l;
            c5202c.f14108d = c5228d2.f14228q;
            int i = c5202c.f14105a.f14337g;
            c5228d2.f14222k = new SurfaceTexture(i);
            ((GLSurfaceView) C5228d.this.f14208c).queueEvent(new a(i));
            C5228d.this.f14222k.setOnFrameAvailableListener(new b());
        }
    }

    public C5228d(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        super(context, viewGroup);
        this.f14224m = new CopyOnWriteArraySet();
        this.f14225n = 1.0f;
        this.f14226o = 1.0f;
    }

    @Override // p007b.p452o.p453a.p472w.InterfaceC5226b
    /* JADX INFO: renamed from: a */
    public void mo7443a(@NonNull InterfaceC5184b interfaceC5184b) {
        this.f14228q = interfaceC5184b;
        if (m7433m()) {
            interfaceC5184b.mo7374k(this.f14210e, this.f14211f);
        }
        ((GLSurfaceView) this.f14208c).queueEvent(new b(interfaceC5184b));
    }

    @Override // p007b.p452o.p453a.p472w.InterfaceC5229e
    /* JADX INFO: renamed from: b */
    public void mo7445b(@NonNull InterfaceC5230f interfaceC5230f) {
        ((GLSurfaceView) this.f14208c).queueEvent(new a(interfaceC5230f));
    }

    @Override // p007b.p452o.p453a.p472w.InterfaceC5226b
    @NonNull
    /* JADX INFO: renamed from: c */
    public InterfaceC5184b mo7444c() {
        return this.f14228q;
    }

    @Override // p007b.p452o.p453a.p472w.InterfaceC5229e
    /* JADX INFO: renamed from: d */
    public void mo7446d(@NonNull InterfaceC5230f interfaceC5230f) {
        this.f14224m.remove(interfaceC5230f);
    }

    @Override // p007b.p452o.p453a.p472w.AbstractC5225a
    /* JADX INFO: renamed from: e */
    public void mo7425e(@Nullable AbstractC5225a.b bVar) {
        int i;
        int i2;
        float fM7450i;
        float fM7450i2;
        if (this.f14212g <= 0 || this.f14213h <= 0 || (i = this.f14210e) <= 0 || (i2 = this.f14211f) <= 0) {
            return;
        }
        C5235a c5235aM7447f = C5235a.m7447f(i, i2);
        C5235a c5235aM7447f2 = C5235a.m7447f(this.f14212g, this.f14213h);
        if (c5235aM7447f.m7450i() >= c5235aM7447f2.m7450i()) {
            fM7450i2 = c5235aM7447f.m7450i() / c5235aM7447f2.m7450i();
            fM7450i = 1.0f;
        } else {
            fM7450i = c5235aM7447f2.m7450i() / c5235aM7447f.m7450i();
            fM7450i2 = 1.0f;
        }
        this.f14209d = fM7450i > 1.02f || fM7450i2 > 1.02f;
        this.f14225n = 1.0f / fM7450i;
        this.f14226o = 1.0f / fM7450i2;
        ((GLSurfaceView) this.f14208c).requestRender();
    }

    @Override // p007b.p452o.p453a.p472w.AbstractC5225a
    @NonNull
    /* JADX INFO: renamed from: i */
    public SurfaceTexture mo7429i() {
        return this.f14222k;
    }

    @Override // p007b.p452o.p453a.p472w.AbstractC5225a
    @NonNull
    /* JADX INFO: renamed from: j */
    public Class<SurfaceTexture> mo7430j() {
        return SurfaceTexture.class;
    }

    @Override // p007b.p452o.p453a.p472w.AbstractC5225a
    @NonNull
    /* JADX INFO: renamed from: k */
    public View mo7431k() {
        return this.f14227p;
    }

    @Override // p007b.p452o.p453a.p472w.AbstractC5225a
    @NonNull
    /* JADX INFO: renamed from: n */
    public View mo7434n(@NonNull Context context, @NonNull ViewGroup viewGroup) {
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(context).inflate(C11196R.b.cameraview_gl_view, viewGroup, false);
        GLSurfaceView gLSurfaceView = (GLSurfaceView) viewGroup2.findViewById(C11196R.a.gl_surface_view);
        c cVar = new c();
        gLSurfaceView.setEGLContextClientVersion(2);
        gLSurfaceView.setRenderer(cVar);
        gLSurfaceView.setRenderMode(0);
        gLSurfaceView.getHolder().addCallback(new SurfaceHolderCallbackC5227c(this, gLSurfaceView, cVar));
        viewGroup.addView(viewGroup2, 0);
        this.f14227p = viewGroup2;
        return gLSurfaceView;
    }

    @Override // p007b.p452o.p453a.p472w.AbstractC5225a
    /* JADX INFO: renamed from: o */
    public void mo7435o() {
        super.mo7435o();
        this.f14224m.clear();
    }

    @Override // p007b.p452o.p453a.p472w.AbstractC5225a
    /* JADX INFO: renamed from: p */
    public void mo7436p() {
        ((GLSurfaceView) this.f14208c).onPause();
    }

    @Override // p007b.p452o.p453a.p472w.AbstractC5225a
    /* JADX INFO: renamed from: q */
    public void mo7437q() {
        ((GLSurfaceView) this.f14208c).onResume();
    }
}
