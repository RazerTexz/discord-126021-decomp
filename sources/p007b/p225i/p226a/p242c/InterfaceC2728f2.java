package p007b.p225i.p226a.p242c;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import java.io.IOException;
import p007b.p225i.p226a.p242c.p243a3.InterfaceC2546i0;
import p007b.p225i.p226a.p242c.p259f3.InterfaceC2752s;

/* JADX INFO: renamed from: b.i.a.c.f2 */
/* JADX INFO: compiled from: Renderer.java */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC2728f2 extends C2576b2.b {

    /* JADX INFO: renamed from: b.i.a.c.f2$a */
    /* JADX INFO: compiled from: Renderer.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo2947a();

        /* JADX INFO: renamed from: b */
        void mo2948b(long j);
    }

    /* JADX INFO: renamed from: b */
    boolean mo2631b();

    /* JADX INFO: renamed from: d */
    boolean mo2632d();

    /* JADX INFO: renamed from: f */
    void mo2932f(int i);

    /* JADX INFO: renamed from: g */
    void mo2933g();

    String getName();

    int getState();

    @Nullable
    /* JADX INFO: renamed from: h */
    InterfaceC2546i0 mo2934h();

    /* JADX INFO: renamed from: j */
    boolean mo2935j();

    /* JADX INFO: renamed from: k */
    void mo2936k(C2811j1[] c2811j1Arr, InterfaceC2546i0 interfaceC2546i0, long j, long j2) throws ExoPlaybackException;

    /* JADX INFO: renamed from: l */
    void mo2937l();

    /* JADX INFO: renamed from: m */
    InterfaceC2763g2 mo2938m();

    /* JADX INFO: renamed from: n */
    void mo2939n(float f, float f2) throws ExoPlaybackException;

    /* JADX INFO: renamed from: o */
    void mo2940o(C2804h2 c2804h2, C2811j1[] c2811j1Arr, InterfaceC2546i0 interfaceC2546i0, long j, boolean z2, boolean z3, long j2, long j3) throws ExoPlaybackException;

    /* JADX INFO: renamed from: q */
    void mo2633q(long j, long j2) throws ExoPlaybackException;

    void reset();

    /* JADX INFO: renamed from: s */
    void mo2941s() throws IOException;

    void start() throws ExoPlaybackException;

    void stop();

    /* JADX INFO: renamed from: t */
    long mo2942t();

    /* JADX INFO: renamed from: u */
    void mo2943u(long j) throws ExoPlaybackException;

    /* JADX INFO: renamed from: v */
    boolean mo2944v();

    @Nullable
    /* JADX INFO: renamed from: w */
    InterfaceC2752s mo2945w();

    /* JADX INFO: renamed from: x */
    int mo2946x();
}
