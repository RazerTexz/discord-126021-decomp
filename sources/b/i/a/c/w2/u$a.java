package b.i.a.c.w2;

import android.os.Looper;
import androidx.annotation.Nullable;
import b.i.a.c.j1;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSession$DrmSessionException;
import com.google.android.exoplayer2.drm.UnsupportedDrmException;

/* JADX INFO: compiled from: DrmSessionManager.java */
/* JADX INFO: loaded from: classes3.dex */
public class u$a implements u {
    @Override // b.i.a.c.w2.u
    public /* synthetic */ void a() {
        t.b(this);
    }

    @Override // b.i.a.c.w2.u
    public /* synthetic */ u$b b(Looper looper, s$a s_a, j1 j1Var) {
        return t.a(this, looper, s_a, j1Var);
    }

    @Override // b.i.a.c.w2.u
    @Nullable
    public DrmSession c(Looper looper, @Nullable s$a s_a, j1 j1Var) {
        if (j1Var.f1020z == null) {
            return null;
        }
        return new z(new DrmSession$DrmSessionException(new UnsupportedDrmException(1), 6001));
    }

    @Override // b.i.a.c.w2.u
    public int d(j1 j1Var) {
        return j1Var.f1020z != null ? 1 : 0;
    }

    @Override // b.i.a.c.w2.u
    public /* synthetic */ void release() {
        t.c(this);
    }
}
