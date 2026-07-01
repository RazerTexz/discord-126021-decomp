package b.i.a.c.g3.z;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture$OnFrameAvailableListener;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class a implements SurfaceTexture$OnFrameAvailableListener {
    public final /* synthetic */ j j;

    public /* synthetic */ a(j jVar) {
        this.j = jVar;
    }

    @Override // android.graphics.SurfaceTexture$OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.j.j.set(true);
    }
}
