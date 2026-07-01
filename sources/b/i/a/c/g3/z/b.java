package b.i.a.c.g3.z;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import java.util.Iterator;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ k j;
    public final /* synthetic */ SurfaceTexture k;

    public /* synthetic */ b(k kVar, SurfaceTexture surfaceTexture) {
        this.j = kVar;
        this.k = surfaceTexture;
    }

    @Override // java.lang.Runnable
    public final void run() {
        k kVar = this.j;
        SurfaceTexture surfaceTexture = this.k;
        SurfaceTexture surfaceTexture2 = kVar.q;
        Surface surface = kVar.r;
        Surface surface2 = new Surface(surfaceTexture);
        kVar.q = surfaceTexture;
        kVar.r = surface2;
        Iterator<k$b> it = kVar.j.iterator();
        while (it.hasNext()) {
            it.next().u(surface2);
        }
        if (surfaceTexture2 != null) {
            surfaceTexture2.release();
        }
        if (surface != null) {
            surface.release();
        }
    }
}
