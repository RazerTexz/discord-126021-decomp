package b.i.a.c.w2;

import android.os.Looper;
import androidx.annotation.Nullable;
import b.i.a.c.j1;
import com.google.android.exoplayer2.drm.DrmSession;

/* JADX INFO: compiled from: DrmSessionManager.java */
/* JADX INFO: loaded from: classes3.dex */
public interface u {
    public static final u a = new u$a();

    void a();

    u$b b(Looper looper, @Nullable s$a s_a, j1 j1Var);

    @Nullable
    DrmSession c(Looper looper, @Nullable s$a s_a, j1 j1Var);

    int d(j1 j1Var);

    void release();
}
