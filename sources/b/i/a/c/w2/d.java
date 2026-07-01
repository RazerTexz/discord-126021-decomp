package b.i.a.c.w2;

import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSession;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ DefaultDrmSessionManager.d j;

    @Override // java.lang.Runnable
    public final void run() {
        DefaultDrmSessionManager.d dVar = this.j;
        if (dVar.d) {
            return;
        }
        DrmSession drmSession = dVar.c;
        if (drmSession != null) {
            drmSession.b(dVar.f2932b);
        }
        dVar.e.n.remove(dVar);
        dVar.d = true;
    }
}
