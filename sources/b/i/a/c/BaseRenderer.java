package b.i.a.c;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.Format2;
import b.i.a.c.a3.SampleStream;
import b.i.a.c.f3.MediaClock;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.v0, reason: use source file name */
/* JADX INFO: compiled from: BaseRenderer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseRenderer implements Renderer2, RendererCapabilities {
    public final int j;

    @Nullable
    public RendererConfiguration l;
    public int m;
    public int n;

    @Nullable
    public SampleStream o;

    @Nullable
    public Format2[] p;
    public long q;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f1140s;
    public boolean t;
    public final FormatHolder k = new FormatHolder();
    public long r = Long.MIN_VALUE;

    public BaseRenderer(int i) {
        this.j = i;
    }

    public final FormatHolder A() {
        this.k.a();
        return this.k;
    }

    public abstract void B();

    public void C(boolean z2, boolean z3) throws ExoPlaybackException {
    }

    public abstract void D(long j, boolean z2) throws ExoPlaybackException;

    public void E() {
    }

    public void F() throws ExoPlaybackException {
    }

    public void G() {
    }

    public abstract void H(Format2[] format2Arr, long j, long j2) throws ExoPlaybackException;

    public final int I(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i) {
        SampleStream sampleStream = this.o;
        Objects.requireNonNull(sampleStream);
        int iA = sampleStream.a(formatHolder, decoderInputBuffer, i);
        if (iA == -4) {
            if (decoderInputBuffer.n()) {
                this.r = Long.MIN_VALUE;
                return this.f1140s ? -4 : -3;
            }
            long j = decoderInputBuffer.n + this.q;
            decoderInputBuffer.n = j;
            this.r = Math.max(this.r, j);
        } else if (iA == -5) {
            Format2 format2 = formatHolder.f1027b;
            Objects.requireNonNull(format2);
            if (format2.A != RecyclerView.FOREVER_NS) {
                Format2.b bVarA = format2.a();
                bVarA.o = format2.A + this.q;
                formatHolder.f1027b = bVarA.a();
            }
        }
        return iA;
    }

    @Override // b.i.a.c.Renderer2
    public final void f(int i) {
        this.m = i;
    }

    @Override // b.i.a.c.Renderer2
    public final void g() {
        AnimatableValueParser.D(this.n == 1);
        this.k.a();
        this.n = 0;
        this.o = null;
        this.p = null;
        this.f1140s = false;
        B();
    }

    @Override // b.i.a.c.Renderer2
    public final int getState() {
        return this.n;
    }

    @Override // b.i.a.c.Renderer2
    @Nullable
    public final SampleStream h() {
        return this.o;
    }

    @Override // b.i.a.c.Renderer2
    public final boolean j() {
        return this.r == Long.MIN_VALUE;
    }

    @Override // b.i.a.c.Renderer2
    public final void k(Format2[] format2Arr, SampleStream sampleStream, long j, long j2) throws ExoPlaybackException {
        AnimatableValueParser.D(!this.f1140s);
        this.o = sampleStream;
        if (this.r == Long.MIN_VALUE) {
            this.r = j;
        }
        this.p = format2Arr;
        this.q = j2;
        H(format2Arr, j, j2);
    }

    @Override // b.i.a.c.Renderer2
    public final void l() {
        this.f1140s = true;
    }

    @Override // b.i.a.c.Renderer2
    public final RendererCapabilities m() {
        return this;
    }

    @Override // b.i.a.c.Renderer2
    public /* synthetic */ void n(float f, float f2) throws ExoPlaybackException {
        Renderer.a(this, f, f2);
    }

    @Override // b.i.a.c.Renderer2
    public final void o(RendererConfiguration rendererConfiguration, Format2[] format2Arr, SampleStream sampleStream, long j, boolean z2, boolean z3, long j2, long j3) throws ExoPlaybackException {
        AnimatableValueParser.D(this.n == 0);
        this.l = rendererConfiguration;
        this.n = 1;
        C(z2, z3);
        k(format2Arr, sampleStream, j2, j3);
        D(j, z2);
    }

    @Override // b.i.a.c.RendererCapabilities
    public int p() throws ExoPlaybackException {
        return 0;
    }

    @Override // b.i.a.c.PlayerMessage.b
    public void r(int i, @Nullable Object obj) throws ExoPlaybackException {
    }

    @Override // b.i.a.c.Renderer2
    public final void reset() {
        AnimatableValueParser.D(this.n == 0);
        this.k.a();
        E();
    }

    @Override // b.i.a.c.Renderer2
    public final void s() throws IOException {
        SampleStream sampleStream = this.o;
        Objects.requireNonNull(sampleStream);
        sampleStream.b();
    }

    @Override // b.i.a.c.Renderer2
    public final void start() throws ExoPlaybackException {
        AnimatableValueParser.D(this.n == 1);
        this.n = 2;
        F();
    }

    @Override // b.i.a.c.Renderer2
    public final void stop() {
        AnimatableValueParser.D(this.n == 2);
        this.n = 1;
        G();
    }

    @Override // b.i.a.c.Renderer2
    public final long t() {
        return this.r;
    }

    @Override // b.i.a.c.Renderer2
    public final void u(long j) throws ExoPlaybackException {
        this.f1140s = false;
        this.r = j;
        D(j, false);
    }

    @Override // b.i.a.c.Renderer2
    public final boolean v() {
        return this.f1140s;
    }

    @Override // b.i.a.c.Renderer2
    @Nullable
    public MediaClock w() {
        return null;
    }

    @Override // b.i.a.c.Renderer2
    public final int x() {
        return this.j;
    }

    public final ExoPlaybackException y(Throwable th, @Nullable Format2 format2, int i) {
        return z(th, format2, false, i);
    }

    public final ExoPlaybackException z(Throwable th, @Nullable Format2 format2, boolean z2, int i) {
        int iA;
        if (format2 == null || this.t) {
            iA = 4;
        } else {
            this.t = true;
            try {
                iA = a(format2) & 7;
                this.t = false;
            } catch (ExoPlaybackException unused) {
                this.t = false;
                iA = 4;
            } catch (Throwable th2) {
                this.t = false;
                throw th2;
            }
        }
        return new ExoPlaybackException(1, th, null, i, getName(), this.m, format2, format2 == null ? 4 : iA, z2);
    }
}
