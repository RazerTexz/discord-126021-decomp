package b.i.a.c.w2;

import android.os.Looper;
import b.i.a.c.j1;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager$d;
import java.util.Objects;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ DefaultDrmSessionManager$d j;
    public final /* synthetic */ j1 k;

    public /* synthetic */ e(DefaultDrmSessionManager$d defaultDrmSessionManager$d, j1 j1Var) {
        this.j = defaultDrmSessionManager$d;
        this.k = j1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DefaultDrmSessionManager$d defaultDrmSessionManager$d = this.j;
        j1 j1Var = this.k;
        DefaultDrmSessionManager defaultDrmSessionManager = defaultDrmSessionManager$d.e;
        if (defaultDrmSessionManager.p == 0 || defaultDrmSessionManager$d.d) {
            return;
        }
        Looper looper = defaultDrmSessionManager.t;
        Objects.requireNonNull(looper);
        defaultDrmSessionManager$d.c = defaultDrmSessionManager.e(looper, defaultDrmSessionManager$d.f2932b, j1Var, false);
        defaultDrmSessionManager$d.e.n.add(defaultDrmSessionManager$d);
    }
}
