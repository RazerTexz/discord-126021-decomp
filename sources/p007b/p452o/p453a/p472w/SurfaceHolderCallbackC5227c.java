package p007b.p452o.p453a.p472w;

import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.view.SurfaceHolder;
import p007b.p452o.p453a.p467r.C5202c;
import p007b.p452o.p453a.p472w.C5228d;

/* JADX INFO: renamed from: b.o.a.w.c */
/* JADX INFO: compiled from: GlCameraPreview.java */
/* JADX INFO: loaded from: classes3.dex */
public class SurfaceHolderCallbackC5227c implements SurfaceHolder.Callback {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ GLSurfaceView f14217j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C5228d.c f14218k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ C5228d f14219l;

    /* JADX INFO: renamed from: b.o.a.w.c$a */
    /* JADX INFO: compiled from: GlCameraPreview.java */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C5228d.c cVar = SurfaceHolderCallbackC5227c.this.f14218k;
            SurfaceTexture surfaceTexture = C5228d.this.f14222k;
            if (surfaceTexture != null) {
                surfaceTexture.setOnFrameAvailableListener(null);
                C5228d.this.f14222k.release();
                C5228d.this.f14222k = null;
            }
            C5202c c5202c = C5228d.this.f14223l;
            if (c5202c != null) {
                c5202c.m7400b();
                C5228d.this.f14223l = null;
            }
        }
    }

    public SurfaceHolderCallbackC5227c(C5228d c5228d, GLSurfaceView gLSurfaceView, C5228d.c cVar) {
        this.f14219l = c5228d;
        this.f14217j = gLSurfaceView;
        this.f14218k = cVar;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f14219l.m7427g();
        this.f14217j.queueEvent(new a());
        this.f14219l.f14221j = false;
    }
}
