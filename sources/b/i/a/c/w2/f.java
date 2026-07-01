package b.i.a.c.w2;

import com.google.android.exoplayer2.drm.DefaultDrmSession;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ DefaultDrmSession j;

    public /* synthetic */ f(DefaultDrmSession defaultDrmSession) {
        this.j = defaultDrmSession;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.j.b(null);
    }
}
