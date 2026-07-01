package b.i.a.c.w2;

import com.google.android.exoplayer2.drm.DefaultDrmSessionManager$d;
import com.google.android.exoplayer2.drm.DrmSession;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ DefaultDrmSessionManager$d j;

    public /* synthetic */ d(DefaultDrmSessionManager$d defaultDrmSessionManager$d) {
        this.j = defaultDrmSessionManager$d;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DefaultDrmSessionManager$d defaultDrmSessionManager$d = this.j;
        if (defaultDrmSessionManager$d.d) {
            return;
        }
        DrmSession drmSession = defaultDrmSessionManager$d.c;
        if (drmSession != null) {
            drmSession.b(defaultDrmSessionManager$d.f2932b);
        }
        defaultDrmSessionManager$d.e.n.remove(defaultDrmSessionManager$d);
        defaultDrmSessionManager$d.d = true;
    }
}
