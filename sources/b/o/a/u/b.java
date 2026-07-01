package b.o.a.u;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import b.o.a.r.e;

/* JADX INFO: compiled from: OverlayDrawer.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public static final b.o.a.b a = new b.o.a.b(b.class.getSimpleName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f1953b;
    public SurfaceTexture c;
    public Surface d;
    public e f;
    public final Object g = new Object();

    @VisibleForTesting
    public b.o.a.r.c e = new b.o.a.r.c(new b.o.b.f.b(33984, 36197, null, 4));

    public b(@NonNull a aVar, @NonNull b.o.a.x.b bVar) {
        this.f1953b = aVar;
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.e.a.g);
        this.c = surfaceTexture;
        surfaceTexture.setDefaultBufferSize(bVar.j, bVar.k);
        this.d = new Surface(this.c);
        this.f = new e(this.e.a.g);
    }
}
