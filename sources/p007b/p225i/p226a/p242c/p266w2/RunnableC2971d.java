package p007b.p225i.p226a.p242c.p266w2;

import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSession;

/* JADX INFO: renamed from: b.i.a.c.w2.d */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2971d implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ DefaultDrmSessionManager.C10707d f7981j;

    @Override // java.lang.Runnable
    public final void run() {
        DefaultDrmSessionManager.C10707d c10707d = this.f7981j;
        if (c10707d.f19842d) {
            return;
        }
        DrmSession drmSession = c10707d.f19841c;
        if (drmSession != null) {
            drmSession.mo3607b(c10707d.f19840b);
        }
        c10707d.f19843e.f19827n.remove(c10707d);
        c10707d.f19842d = true;
    }
}
