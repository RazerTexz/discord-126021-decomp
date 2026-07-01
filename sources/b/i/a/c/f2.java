package b.i.a.c;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import java.io.IOException;

/* JADX INFO: compiled from: Renderer.java */
/* JADX INFO: loaded from: classes3.dex */
public interface f2 extends b2$b {
    boolean b();

    boolean d();

    void f(int i);

    void g();

    String getName();

    int getState();

    @Nullable
    b.i.a.c.a3.i0 h();

    boolean j();

    void k(j1[] j1VarArr, b.i.a.c.a3.i0 i0Var, long j, long j2) throws ExoPlaybackException;

    void l();

    g2 m();

    void n(float f, float f2) throws ExoPlaybackException;

    void o(h2 h2Var, j1[] j1VarArr, b.i.a.c.a3.i0 i0Var, long j, boolean z2, boolean z3, long j2, long j3) throws ExoPlaybackException;

    void q(long j, long j2) throws ExoPlaybackException;

    void reset();

    void s() throws IOException;

    void start() throws ExoPlaybackException;

    void stop();

    long t();

    void u(long j) throws ExoPlaybackException;

    boolean v();

    @Nullable
    b.i.a.c.f3.s w();

    int x();
}
