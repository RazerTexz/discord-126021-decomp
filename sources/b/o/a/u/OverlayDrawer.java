package b.o.a.u;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import b.o.a.CameraLogger;
import b.o.a.r.GlTextureDrawer;
import b.o.a.r.Issue514Workaround;
import b.o.a.x.Size3;
import b.o.b.f.GlTexture2;

/* JADX INFO: renamed from: b.o.a.u.b, reason: use source file name */
/* JADX INFO: compiled from: OverlayDrawer.java */
/* JADX INFO: loaded from: classes3.dex */
public class OverlayDrawer {
    public static final CameraLogger a = new CameraLogger(OverlayDrawer.class.getSimpleName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Overlay f1953b;
    public SurfaceTexture c;
    public Surface d;
    public Issue514Workaround f;
    public final Object g = new Object();

    @VisibleForTesting
    public GlTextureDrawer e = new GlTextureDrawer(new GlTexture2(33984, 36197, null, 4));

    public OverlayDrawer(@NonNull Overlay overlay, @NonNull Size3 size3) {
        this.f1953b = overlay;
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.e.a.g);
        this.c = surfaceTexture;
        surfaceTexture.setDefaultBufferSize(size3.j, size3.k);
        this.d = new Surface(this.c);
        this.f = new Issue514Workaround(this.e.a.g);
    }
}
