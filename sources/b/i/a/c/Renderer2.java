package b.i.a.c;

import androidx.annotation.Nullable;
import b.i.a.c.PlayerMessage;
import b.i.a.c.a3.SampleStream;
import b.i.a.c.f3.MediaClock;
import com.google.android.exoplayer2.ExoPlaybackException;
import java.io.IOException;

/* JADX INFO: renamed from: b.i.a.c.f2, reason: use source file name */
/* JADX INFO: compiled from: Renderer.java */
/* JADX INFO: loaded from: classes3.dex */
public interface Renderer2 extends PlayerMessage.b {

    /* JADX INFO: renamed from: b.i.a.c.f2$a */
    /* JADX INFO: compiled from: Renderer.java */
    public interface a {
        void a();

        void b(long j);
    }

    boolean b();

    boolean d();

    void f(int i);

    void g();

    String getName();

    int getState();

    @Nullable
    SampleStream h();

    boolean j();

    void k(Format2[] format2Arr, SampleStream sampleStream, long j, long j2) throws ExoPlaybackException;

    void l();

    RendererCapabilities m();

    void n(float f, float f2) throws ExoPlaybackException;

    void o(RendererConfiguration rendererConfiguration, Format2[] format2Arr, SampleStream sampleStream, long j, boolean z2, boolean z3, long j2, long j3) throws ExoPlaybackException;

    void q(long j, long j2) throws ExoPlaybackException;

    void reset();

    void s() throws IOException;

    void start() throws ExoPlaybackException;

    void stop();

    long t();

    void u(long j) throws ExoPlaybackException;

    boolean v();

    @Nullable
    MediaClock w();

    int x();
}
