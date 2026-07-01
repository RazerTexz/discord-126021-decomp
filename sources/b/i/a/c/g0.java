package b.i.a.c;

import com.google.android.exoplayer2.ExoPlaybackException;
import java.util.Objects;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class g0 implements Runnable {
    public final /* synthetic */ h1 j;
    public final /* synthetic */ b2 k;

    public /* synthetic */ g0(h1 h1Var, b2 b2Var) {
        this.j = h1Var;
        this.k = b2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h1 h1Var = this.j;
        b2 b2Var = this.k;
        Objects.requireNonNull(h1Var);
        try {
            h1Var.d(b2Var);
        } catch (ExoPlaybackException e) {
            b.i.a.c.f3.q.b("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e);
            throw new RuntimeException(e);
        }
    }
}
