package p007b.p225i.p226a.p242c.p243a3;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.HttpDataSource$CleartextNotPermittedException;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.Loader.HandlerC10769d;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.C2811j1;
import p007b.p225i.p226a.p242c.C2812j2;
import p007b.p225i.p226a.p242c.C2815k1;
import p007b.p225i.p226a.p242c.p243a3.C2544h0;
import p007b.p225i.p226a.p242c.p243a3.C2565s;
import p007b.p225i.p226a.p242c.p243a3.InterfaceC2532b0;
import p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x;
import p007b.p225i.p226a.p242c.p255c3.InterfaceC2644j;
import p007b.p225i.p226a.p242c.p257e3.C2712n;
import p007b.p225i.p226a.p242c.p257e3.C2713o;
import p007b.p225i.p226a.p242c.p257e3.C2717s;
import p007b.p225i.p226a.p242c.p257e3.C2723y;
import p007b.p225i.p226a.p242c.p257e3.InterfaceC2706h;
import p007b.p225i.p226a.p242c.p257e3.InterfaceC2710l;
import p007b.p225i.p226a.p242c.p257e3.InterfaceC2721w;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;
import p007b.p225i.p226a.p242c.p259f3.C2743j;
import p007b.p225i.p226a.p242c.p259f3.C2753t;
import p007b.p225i.p226a.p242c.p266w2.InterfaceC2988s;
import p007b.p225i.p226a.p242c.p266w2.InterfaceC2990u;
import p007b.p225i.p226a.p242c.p267x2.C3118s;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3031h;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3041i;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3119t;
import p007b.p225i.p226a.p242c.p267x2.InterfaceC3122w;
import p007b.p225i.p226a.p242c.p267x2.p273h0.C3037f;

/* JADX INFO: renamed from: b.i.a.c.a3.e0 */
/* JADX INFO: compiled from: ProgressiveMediaPeriod.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2538e0 implements InterfaceC2570x, InterfaceC3058j, Loader.InterfaceC10767b<a>, Loader.InterfaceC10771f, C2544h0.d {

    /* JADX INFO: renamed from: j */
    public static final Map<String, String> f5498j;

    /* JADX INFO: renamed from: k */
    public static final C2811j1 f5499k;

    /* JADX INFO: renamed from: B */
    @Nullable
    public InterfaceC2570x.a f5501B;

    /* JADX INFO: renamed from: C */
    @Nullable
    public IcyHeaders f5502C;

    /* JADX INFO: renamed from: F */
    public boolean f5505F;

    /* JADX INFO: renamed from: G */
    public boolean f5506G;

    /* JADX INFO: renamed from: H */
    public boolean f5507H;

    /* JADX INFO: renamed from: I */
    public e f5508I;

    /* JADX INFO: renamed from: J */
    public InterfaceC3119t f5509J;

    /* JADX INFO: renamed from: L */
    public boolean f5511L;

    /* JADX INFO: renamed from: N */
    public boolean f5513N;

    /* JADX INFO: renamed from: O */
    public boolean f5514O;

    /* JADX INFO: renamed from: P */
    public int f5515P;

    /* JADX INFO: renamed from: R */
    public long f5517R;

    /* JADX INFO: renamed from: T */
    public boolean f5519T;

    /* JADX INFO: renamed from: U */
    public int f5520U;

    /* JADX INFO: renamed from: V */
    public boolean f5521V;

    /* JADX INFO: renamed from: W */
    public boolean f5522W;

    /* JADX INFO: renamed from: l */
    public final Uri f5523l;

    /* JADX INFO: renamed from: m */
    public final InterfaceC2710l f5524m;

    /* JADX INFO: renamed from: n */
    public final InterfaceC2990u f5525n;

    /* JADX INFO: renamed from: o */
    public final InterfaceC2721w f5526o;

    /* JADX INFO: renamed from: p */
    public final InterfaceC2532b0.a f5527p;

    /* JADX INFO: renamed from: q */
    public final InterfaceC2988s.a f5528q;

    /* JADX INFO: renamed from: r */
    public final b f5529r;

    /* JADX INFO: renamed from: s */
    public final C2713o f5530s;

    /* JADX INFO: renamed from: t */
    @Nullable
    public final String f5531t;

    /* JADX INFO: renamed from: u */
    public final long f5532u;

    /* JADX INFO: renamed from: w */
    public final InterfaceC2536d0 f5534w;

    /* JADX INFO: renamed from: v */
    public final Loader f5533v = new Loader("ProgressiveMediaPeriod");

    /* JADX INFO: renamed from: x */
    public final C2743j f5535x = new C2743j();

    /* JADX INFO: renamed from: y */
    public final Runnable f5536y = new Runnable() { // from class: b.i.a.c.a3.g
        @Override // java.lang.Runnable
        public final void run() {
            this.f5577j.m2500x();
        }
    };

    /* JADX INFO: renamed from: z */
    public final Runnable f5537z = new Runnable() { // from class: b.i.a.c.a3.i
        @Override // java.lang.Runnable
        public final void run() {
            C2538e0 c2538e0 = this.f5627j;
            if (c2538e0.f5522W) {
                return;
            }
            InterfaceC2570x.a aVar = c2538e0.f5501B;
            Objects.requireNonNull(aVar);
            aVar.mo2542a(c2538e0);
        }
    };

    /* JADX INFO: renamed from: A */
    public final Handler f5500A = C2738e0.m3002j();

    /* JADX INFO: renamed from: E */
    public d[] f5504E = new d[0];

    /* JADX INFO: renamed from: D */
    public C2544h0[] f5503D = new C2544h0[0];

    /* JADX INFO: renamed from: S */
    public long f5518S = -9223372036854775807L;

    /* JADX INFO: renamed from: Q */
    public long f5516Q = -1;

    /* JADX INFO: renamed from: K */
    public long f5510K = -9223372036854775807L;

    /* JADX INFO: renamed from: M */
    public int f5512M = 1;

    /* JADX INFO: renamed from: b.i.a.c.a3.e0$a */
    /* JADX INFO: compiled from: ProgressiveMediaPeriod.java */
    public final class a implements Loader.InterfaceC10770e, C2565s.a {

        /* JADX INFO: renamed from: b */
        public final Uri f5539b;

        /* JADX INFO: renamed from: c */
        public final C2723y f5540c;

        /* JADX INFO: renamed from: d */
        public final InterfaceC2536d0 f5541d;

        /* JADX INFO: renamed from: e */
        public final InterfaceC3058j f5542e;

        /* JADX INFO: renamed from: f */
        public final C2743j f5543f;

        /* JADX INFO: renamed from: h */
        public volatile boolean f5545h;

        /* JADX INFO: renamed from: j */
        public long f5547j;

        /* JADX INFO: renamed from: m */
        @Nullable
        public InterfaceC3122w f5550m;

        /* JADX INFO: renamed from: n */
        public boolean f5551n;

        /* JADX INFO: renamed from: g */
        public final C3118s f5544g = new C3118s();

        /* JADX INFO: renamed from: i */
        public boolean f5546i = true;

        /* JADX INFO: renamed from: l */
        public long f5549l = -1;

        /* JADX INFO: renamed from: a */
        public final long f5538a = C2566t.f5703a.getAndIncrement();

        /* JADX INFO: renamed from: k */
        public C2712n f5548k = m2503a(0);

        public a(Uri uri, InterfaceC2710l interfaceC2710l, InterfaceC2536d0 interfaceC2536d0, InterfaceC3058j interfaceC3058j, C2743j c2743j) {
            this.f5539b = uri;
            this.f5540c = new C2723y(interfaceC2710l);
            this.f5541d = interfaceC2536d0;
            this.f5542e = interfaceC3058j;
            this.f5543f = c2743j;
        }

        /* JADX INFO: renamed from: a */
        public final C2712n m2503a(long j) {
            Collections.emptyMap();
            Uri uri = this.f5539b;
            String str = C2538e0.this.f5531t;
            Map<String, String> map = C2538e0.f5498j;
            if (uri != null) {
                return new C2712n(uri, 0L, 1, null, map, j, -1L, str, 6, null);
            }
            throw new IllegalStateException("The uri must be set.");
        }

        /* JADX INFO: renamed from: b */
        public void m2504b() throws IOException {
            InterfaceC2706h c2565s;
            int i;
            int iMo3635e = 0;
            while (iMo3635e == 0 && !this.f5545h) {
                try {
                    long j = this.f5544g.f8992a;
                    C2712n c2712nM2503a = m2503a(j);
                    this.f5548k = c2712nM2503a;
                    long jMo2586a = this.f5540c.mo2586a(c2712nM2503a);
                    this.f5549l = jMo2586a;
                    if (jMo2586a != -1) {
                        this.f5549l = jMo2586a + j;
                    }
                    C2538e0.this.f5502C = IcyHeaders.m8881a(this.f5540c.mo2588j());
                    C2723y c2723y = this.f5540c;
                    IcyHeaders icyHeaders = C2538e0.this.f5502C;
                    if (icyHeaders == null || (i = icyHeaders.f19962o) == -1) {
                        c2565s = c2723y;
                    } else {
                        c2565s = new C2565s(c2723y, i, this);
                        InterfaceC3122w interfaceC3122wM2474B = C2538e0.this.m2474B(new d(0, true));
                        this.f5550m = interfaceC3122wM2474B;
                        ((C2544h0) interfaceC3122wM2474B).mo2526e(C2538e0.f5499k);
                    }
                    long jM2558a = j;
                    ((C2553m) this.f5541d).m2559b(c2565s, this.f5539b, this.f5540c.mo2588j(), j, this.f5549l, this.f5542e);
                    if (C2538e0.this.f5502C != null) {
                        InterfaceC3031h interfaceC3031h = ((C2553m) this.f5541d).f5646b;
                        if (interfaceC3031h instanceof C3037f) {
                            ((C3037f) interfaceC3031h).f8333s = true;
                        }
                    }
                    if (this.f5546i) {
                        InterfaceC2536d0 interfaceC2536d0 = this.f5541d;
                        long j2 = this.f5547j;
                        InterfaceC3031h interfaceC3031h2 = ((C2553m) interfaceC2536d0).f5646b;
                        Objects.requireNonNull(interfaceC3031h2);
                        interfaceC3031h2.mo3637g(jM2558a, j2);
                        this.f5546i = false;
                    }
                    while (true) {
                        long j3 = jM2558a;
                        while (true) {
                            if (iMo3635e != 0 || this.f5545h) {
                                break;
                            }
                            try {
                                C2743j c2743j = this.f5543f;
                                synchronized (c2743j) {
                                    while (!c2743j.f6728b) {
                                        try {
                                            c2743j.wait();
                                        } catch (Throwable th) {
                                            throw th;
                                        }
                                    }
                                }
                                InterfaceC2536d0 interfaceC2536d1 = this.f5541d;
                                C3118s c3118s = this.f5544g;
                                C2553m c2553m = (C2553m) interfaceC2536d1;
                                InterfaceC3031h interfaceC3031h3 = c2553m.f5646b;
                                Objects.requireNonNull(interfaceC3031h3);
                                InterfaceC3041i interfaceC3041i = c2553m.f5647c;
                                Objects.requireNonNull(interfaceC3041i);
                                iMo3635e = interfaceC3031h3.mo3635e(interfaceC3041i, c3118s);
                                jM2558a = ((C2553m) this.f5541d).m2558a();
                                if (jM2558a > C2538e0.this.f5532u + j3) {
                                    this.f5543f.m3025a();
                                    C2538e0 c2538e0 = C2538e0.this;
                                    c2538e0.f5500A.post(c2538e0.f5537z);
                                }
                            } catch (InterruptedException unused) {
                                throw new InterruptedIOException();
                            }
                        }
                    }
                    if (iMo3635e == 1) {
                        iMo3635e = 0;
                    } else if (((C2553m) this.f5541d).m2558a() != -1) {
                        this.f5544g.f8992a = ((C2553m) this.f5541d).m2558a();
                    }
                    C2723y c2723y2 = this.f5540c;
                    if (c2723y2 != null) {
                        try {
                            c2723y2.f6641a.close();
                        } catch (IOException unused2) {
                        }
                    }
                } catch (Throwable th2) {
                    if (iMo3635e != 1 && ((C2553m) this.f5541d).m2558a() != -1) {
                        this.f5544g.f8992a = ((C2553m) this.f5541d).m2558a();
                    }
                    C2723y c2723y3 = this.f5540c;
                    if (c2723y3 != null) {
                        try {
                            c2723y3.f6641a.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.a3.e0$b */
    /* JADX INFO: compiled from: ProgressiveMediaPeriod.java */
    public interface b {
    }

    /* JADX INFO: renamed from: b.i.a.c.a3.e0$c */
    /* JADX INFO: compiled from: ProgressiveMediaPeriod.java */
    public final class c implements InterfaceC2546i0 {

        /* JADX INFO: renamed from: a */
        public final int f5553a;

        public c(int i) {
            this.f5553a = i;
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2546i0
        /* JADX INFO: renamed from: a */
        public int mo2505a(C2815k1 c2815k1, DecoderInputBuffer decoderInputBuffer, int i) {
            int i2;
            C2538e0 c2538e0 = C2538e0.this;
            int i3 = this.f5553a;
            if (c2538e0.m2476D()) {
                return -3;
            }
            c2538e0.m2501y(i3);
            C2544h0 c2544h0 = c2538e0.f5503D[i3];
            boolean z2 = c2538e0.f5521V;
            boolean z3 = (i & 2) != 0;
            C2544h0.b bVar = c2544h0.f5597b;
            synchronized (c2544h0) {
                decoderInputBuffer.f19779m = false;
                i2 = -5;
                if (c2544h0.m2536o()) {
                    C2811j1 c2811j1 = c2544h0.f5598c.m2561b(c2544h0.m2532k()).f5625a;
                    if (z3 || c2811j1 != c2544h0.f5603h) {
                        c2544h0.m2539r(c2811j1, c2815k1);
                    } else {
                        int iM2533l = c2544h0.m2533l(c2544h0.f5615t);
                        if (c2544h0.m2538q(iM2533l)) {
                            decoderInputBuffer.f7901j = c2544h0.f5609n[iM2533l];
                            long j = c2544h0.f5610o[iM2533l];
                            decoderInputBuffer.f19780n = j;
                            if (j < c2544h0.f5616u) {
                                decoderInputBuffer.m3551j(Integer.MIN_VALUE);
                            }
                            bVar.f5622a = c2544h0.f5608m[iM2533l];
                            bVar.f5623b = c2544h0.f5607l[iM2533l];
                            bVar.f5624c = c2544h0.f5611p[iM2533l];
                            i2 = -4;
                        } else {
                            decoderInputBuffer.f19779m = true;
                            i2 = -3;
                        }
                    }
                } else if (z2 || c2544h0.f5619x) {
                    decoderInputBuffer.f7901j = 4;
                    i2 = -4;
                } else {
                    C2811j1 c2811j2 = c2544h0.f5593B;
                    if (c2811j2 == null || (!z3 && c2811j2 == c2544h0.f5603h)) {
                        i2 = -3;
                    } else {
                        c2544h0.m2539r(c2811j2, c2815k1);
                    }
                }
            }
            if (i2 == -4 && !decoderInputBuffer.m3555n()) {
                boolean z4 = (i & 1) != 0;
                if ((i & 4) == 0) {
                    if (z4) {
                        C2542g0 c2542g0 = c2544h0.f5596a;
                        C2542g0.m2517f(c2542g0.f5582e, decoderInputBuffer, c2544h0.f5597b, c2542g0.f5580c);
                    } else {
                        C2542g0 c2542g1 = c2544h0.f5596a;
                        c2542g1.f5582e = C2542g0.m2517f(c2542g1.f5582e, decoderInputBuffer, c2544h0.f5597b, c2542g1.f5580c);
                    }
                }
                if (!z4) {
                    c2544h0.f5615t++;
                }
            }
            if (i2 == -3) {
                c2538e0.m2502z(i3);
            }
            return i2;
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2546i0
        /* JADX INFO: renamed from: b */
        public void mo2506b() throws IOException {
            C2538e0 c2538e0 = C2538e0.this;
            C2544h0 c2544h0 = c2538e0.f5503D[this.f5553a];
            DrmSession drmSession = c2544h0.f5604i;
            if (drmSession == null || drmSession.getState() != 1) {
                c2538e0.m2473A();
            } else {
                DrmSession.DrmSessionException drmSessionExceptionMo3611f = c2544h0.f5604i.mo3611f();
                Objects.requireNonNull(drmSessionExceptionMo3611f);
                throw drmSessionExceptionMo3611f;
            }
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2546i0
        /* JADX INFO: renamed from: c */
        public int mo2507c(long j) {
            int iM2530i;
            C2538e0 c2538e0 = C2538e0.this;
            int i = this.f5553a;
            boolean z2 = false;
            if (c2538e0.m2476D()) {
                return 0;
            }
            c2538e0.m2501y(i);
            C2544h0 c2544h0 = c2538e0.f5503D[i];
            boolean z3 = c2538e0.f5521V;
            synchronized (c2544h0) {
                int iM2533l = c2544h0.m2533l(c2544h0.f5615t);
                if (c2544h0.m2536o() && j >= c2544h0.f5610o[iM2533l]) {
                    if (j <= c2544h0.f5618w || !z3) {
                        iM2530i = c2544h0.m2530i(iM2533l, c2544h0.f5612q - c2544h0.f5615t, j, true);
                        if (iM2530i == -1) {
                        }
                    } else {
                        iM2530i = c2544h0.f5612q - c2544h0.f5615t;
                    }
                }
                iM2530i = 0;
            }
            synchronized (c2544h0) {
                if (iM2530i >= 0) {
                    if (c2544h0.f5615t + iM2530i <= c2544h0.f5612q) {
                        z2 = true;
                    }
                }
                C1460d.m531j(z2);
                c2544h0.f5615t += iM2530i;
            }
            if (iM2530i == 0) {
                c2538e0.m2502z(i);
            }
            return iM2530i;
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2546i0
        /* JADX INFO: renamed from: d */
        public boolean mo2508d() {
            C2538e0 c2538e0 = C2538e0.this;
            return !c2538e0.m2476D() && c2538e0.f5503D[this.f5553a].m2537p(c2538e0.f5521V);
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.a3.e0$d */
    /* JADX INFO: compiled from: ProgressiveMediaPeriod.java */
    public static final class d {

        /* JADX INFO: renamed from: a */
        public final int f5555a;

        /* JADX INFO: renamed from: b */
        public final boolean f5556b;

        public d(int i, boolean z2) {
            this.f5555a = i;
            this.f5556b = z2;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.f5555a == dVar.f5555a && this.f5556b == dVar.f5556b;
        }

        public int hashCode() {
            return (this.f5555a * 31) + (this.f5556b ? 1 : 0);
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.a3.e0$e */
    /* JADX INFO: compiled from: ProgressiveMediaPeriod.java */
    public static final class e {

        /* JADX INFO: renamed from: a */
        public final C2558o0 f5557a;

        /* JADX INFO: renamed from: b */
        public final boolean[] f5558b;

        /* JADX INFO: renamed from: c */
        public final boolean[] f5559c;

        /* JADX INFO: renamed from: d */
        public final boolean[] f5560d;

        public e(C2558o0 c2558o0, boolean[] zArr) {
            this.f5557a = c2558o0;
            this.f5558b = zArr;
            int i = c2558o0.f5675k;
            this.f5559c = new boolean[i];
            this.f5560d = new boolean[i];
        }
    }

    static {
        HashMap map = new HashMap();
        map.put("Icy-MetaData", "1");
        f5498j = Collections.unmodifiableMap(map);
        C2811j1.b bVar = new C2811j1.b();
        bVar.f7163a = "icy";
        bVar.f7173k = "application/x-icy";
        f5499k = bVar.m3277a();
    }

    public C2538e0(Uri uri, InterfaceC2710l interfaceC2710l, InterfaceC2536d0 interfaceC2536d0, InterfaceC2990u interfaceC2990u, InterfaceC2988s.a aVar, InterfaceC2721w interfaceC2721w, InterfaceC2532b0.a aVar2, b bVar, C2713o c2713o, @Nullable String str, int i) {
        this.f5523l = uri;
        this.f5524m = interfaceC2710l;
        this.f5525n = interfaceC2990u;
        this.f5528q = aVar;
        this.f5526o = interfaceC2721w;
        this.f5527p = aVar2;
        this.f5529r = bVar;
        this.f5530s = c2713o;
        this.f5531t = str;
        this.f5532u = i;
        this.f5534w = interfaceC2536d0;
    }

    /* JADX INFO: renamed from: A */
    public void m2473A() throws IOException {
        Loader loader = this.f5533v;
        int iM2873a = ((C2717s) this.f5526o).m2873a(this.f5512M);
        IOException iOException = loader.f20233e;
        if (iOException != null) {
            throw iOException;
        }
        Loader.HandlerC10769d<? extends Loader.InterfaceC10770e> handlerC10769d = loader.f20232d;
        if (handlerC10769d != null) {
            if (iM2873a == Integer.MIN_VALUE) {
                iM2873a = handlerC10769d.f20236j;
            }
            IOException iOException2 = handlerC10769d.f20240n;
            if (iOException2 != null && handlerC10769d.f20241o > iM2873a) {
                throw iOException2;
            }
        }
    }

    /* JADX INFO: renamed from: B */
    public final InterfaceC3122w m2474B(d dVar) {
        int length = this.f5503D.length;
        for (int i = 0; i < length; i++) {
            if (dVar.equals(this.f5504E[i])) {
                return this.f5503D[i];
            }
        }
        C2713o c2713o = this.f5530s;
        Looper looper = this.f5500A.getLooper();
        InterfaceC2990u interfaceC2990u = this.f5525n;
        InterfaceC2988s.a aVar = this.f5528q;
        Objects.requireNonNull(looper);
        Objects.requireNonNull(interfaceC2990u);
        Objects.requireNonNull(aVar);
        C2544h0 c2544h0 = new C2544h0(c2713o, looper, interfaceC2990u, aVar);
        c2544h0.f5602g = this;
        int i2 = length + 1;
        d[] dVarArr = (d[]) Arrays.copyOf(this.f5504E, i2);
        dVarArr[length] = dVar;
        int i3 = C2738e0.f6708a;
        this.f5504E = dVarArr;
        C2544h0[] c2544h0Arr = (C2544h0[]) Arrays.copyOf(this.f5503D, i2);
        c2544h0Arr[length] = c2544h0;
        this.f5503D = c2544h0Arr;
        return c2544h0;
    }

    /* JADX INFO: renamed from: C */
    public final void m2475C() {
        a aVar = new a(this.f5523l, this.f5524m, this.f5534w, this, this.f5535x);
        if (this.f5506G) {
            C1460d.m426D(m2499w());
            long j = this.f5510K;
            if (j != -9223372036854775807L && this.f5518S > j) {
                this.f5521V = true;
                this.f5518S = -9223372036854775807L;
                return;
            }
            InterfaceC3119t interfaceC3119t = this.f5509J;
            Objects.requireNonNull(interfaceC3119t);
            long j2 = interfaceC3119t.mo3620h(this.f5518S).f8993a.f8999c;
            long j3 = this.f5518S;
            aVar.f5544g.f8992a = j2;
            aVar.f5547j = j3;
            aVar.f5546i = true;
            aVar.f5551n = false;
            for (C2544h0 c2544h0 : this.f5503D) {
                c2544h0.f5616u = this.f5518S;
            }
            this.f5518S = -9223372036854775807L;
        }
        this.f5520U = m2497u();
        Loader loader = this.f5533v;
        int iM2873a = ((C2717s) this.f5526o).m2873a(this.f5512M);
        Objects.requireNonNull(loader);
        Looper looperMyLooper = Looper.myLooper();
        C1460d.m438H(looperMyLooper);
        loader.f20233e = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        loader.new HandlerC10769d(looperMyLooper, aVar, this, iM2873a, jElapsedRealtime).m8942b(0L);
        C2712n c2712n = aVar.f5548k;
        InterfaceC2532b0.a aVar2 = this.f5527p;
        aVar2.m2471f(new C2566t(aVar.f5538a, c2712n, jElapsedRealtime), new C2569w(1, -1, null, 0, null, aVar2.m2466a(aVar.f5547j), aVar2.m2466a(this.f5510K)));
    }

    /* JADX INFO: renamed from: D */
    public final boolean m2476D() {
        return this.f5514O || m2499w();
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j
    /* JADX INFO: renamed from: a */
    public void mo2477a(final InterfaceC3119t interfaceC3119t) {
        this.f5500A.post(new Runnable() { // from class: b.i.a.c.a3.h
            @Override // java.lang.Runnable
            public final void run() {
                C2538e0 c2538e0 = this.f5590j;
                InterfaceC3119t interfaceC3119t2 = interfaceC3119t;
                c2538e0.f5509J = c2538e0.f5502C == null ? interfaceC3119t2 : new InterfaceC3119t.b(-9223372036854775807L, 0L);
                c2538e0.f5510K = interfaceC3119t2.mo3621i();
                boolean z2 = c2538e0.f5516Q == -1 && interfaceC3119t2.mo3621i() == -9223372036854775807L;
                c2538e0.f5511L = z2;
                c2538e0.f5512M = z2 ? 7 : 1;
                ((C2540f0) c2538e0.f5529r).m2512u(c2538e0.f5510K, interfaceC3119t2.mo3619c(), c2538e0.f5511L);
                if (c2538e0.f5506G) {
                    return;
                }
                c2538e0.m2500x();
            }
        });
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.InterfaceC10767b
    /* JADX INFO: renamed from: b */
    public void mo2478b(Loader.InterfaceC10770e interfaceC10770e, long j, long j2, boolean z2) {
        a aVar = (a) interfaceC10770e;
        C2723y c2723y = aVar.f5540c;
        C2566t c2566t = new C2566t(aVar.f5538a, aVar.f5548k, c2723y.f6643c, c2723y.f6644d, j, j2, c2723y.f6642b);
        Objects.requireNonNull(this.f5526o);
        InterfaceC2532b0.a aVar2 = this.f5527p;
        aVar2.m2468c(c2566t, new C2569w(1, -1, null, 0, null, aVar2.m2466a(aVar.f5547j), aVar2.m2466a(this.f5510K)));
        if (z2) {
            return;
        }
        if (this.f5516Q == -1) {
            this.f5516Q = aVar.f5549l;
        }
        for (C2544h0 c2544h0 : this.f5503D) {
            c2544h0.m2540s(false);
        }
        if (this.f5515P > 0) {
            InterfaceC2570x.a aVar3 = this.f5501B;
            Objects.requireNonNull(aVar3);
            aVar3.mo2542a(this);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x
    /* JADX INFO: renamed from: c */
    public long mo2479c() {
        if (this.f5515P == 0) {
            return Long.MIN_VALUE;
        }
        return mo2493q();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.InterfaceC10767b
    /* JADX INFO: renamed from: d */
    public void mo2480d(Loader.InterfaceC10770e interfaceC10770e, long j, long j2) {
        InterfaceC3119t interfaceC3119t;
        a aVar = (a) interfaceC10770e;
        if (this.f5510K == -9223372036854775807L && (interfaceC3119t = this.f5509J) != null) {
            boolean zMo3619c = interfaceC3119t.mo3619c();
            long jM2498v = m2498v();
            long j3 = jM2498v == Long.MIN_VALUE ? 0L : jM2498v + 10000;
            this.f5510K = j3;
            ((C2540f0) this.f5529r).m2512u(j3, zMo3619c, this.f5511L);
        }
        C2723y c2723y = aVar.f5540c;
        C2566t c2566t = new C2566t(aVar.f5538a, aVar.f5548k, c2723y.f6643c, c2723y.f6644d, j, j2, c2723y.f6642b);
        Objects.requireNonNull(this.f5526o);
        InterfaceC2532b0.a aVar2 = this.f5527p;
        aVar2.m2469d(c2566t, new C2569w(1, -1, null, 0, null, aVar2.m2466a(aVar.f5547j), aVar2.m2466a(this.f5510K)));
        if (this.f5516Q == -1) {
            this.f5516Q = aVar.f5549l;
        }
        this.f5521V = true;
        InterfaceC2570x.a aVar3 = this.f5501B;
        Objects.requireNonNull(aVar3);
        aVar3.mo2542a(this);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x
    /* JADX INFO: renamed from: e */
    public void mo2481e() throws IOException {
        m2473A();
        if (this.f5521V && !this.f5506G) {
            throw ParserException.m8755a("Loading finished before preparation is complete.", null);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x
    /* JADX INFO: renamed from: f */
    public long mo2482f(long j) {
        boolean z2;
        m2496t();
        boolean[] zArr = this.f5508I.f5558b;
        if (!this.f5509J.mo3619c()) {
            j = 0;
        }
        this.f5514O = false;
        this.f5517R = j;
        if (m2499w()) {
            this.f5518S = j;
            return j;
        }
        if (this.f5512M != 7) {
            int length = this.f5503D.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z2 = true;
                    break;
                }
                if (!this.f5503D[i].m2541t(j, false) && (zArr[i] || !this.f5507H)) {
                    z2 = false;
                    break;
                }
                i++;
            }
            if (z2) {
                return j;
            }
        }
        this.f5519T = false;
        this.f5518S = j;
        this.f5521V = false;
        if (this.f5533v.m8940b()) {
            for (C2544h0 c2544h0 : this.f5503D) {
                c2544h0.m2529h();
            }
            Loader.HandlerC10769d<? extends Loader.InterfaceC10770e> handlerC10769d = this.f5533v.f20232d;
            C1460d.m438H(handlerC10769d);
            handlerC10769d.m8941a(false);
        } else {
            this.f5533v.f20233e = null;
            for (C2544h0 c2544h1 : this.f5503D) {
                c2544h1.m2540s(false);
            }
        }
        return j;
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x
    /* JADX INFO: renamed from: g */
    public boolean mo2483g(long j) {
        if (!this.f5521V) {
            if (!(this.f5533v.f20233e != null) && !this.f5519T && (!this.f5506G || this.f5515P != 0)) {
                boolean zM3026b = this.f5535x.m3026b();
                if (this.f5533v.m8940b()) {
                    return zM3026b;
                }
                m2475C();
                return true;
            }
        }
        return false;
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x
    /* JADX INFO: renamed from: h */
    public boolean mo2484h() {
        boolean z2;
        if (this.f5533v.m8940b()) {
            C2743j c2743j = this.f5535x;
            synchronized (c2743j) {
                z2 = c2743j.f6728b;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x
    /* JADX INFO: renamed from: i */
    public long mo2485i(long j, C2812j2 c2812j2) {
        m2496t();
        if (!this.f5509J.mo3619c()) {
            return 0L;
        }
        InterfaceC3119t.a aVarMo3620h = this.f5509J.mo3620h(j);
        long j2 = aVarMo3620h.f8993a.f8998b;
        long j3 = aVarMo3620h.f8994b.f8998b;
        long j4 = c2812j2.f7191c;
        if (j4 == 0 && c2812j2.f7192d == 0) {
            return j;
        }
        int i = C2738e0.f6708a;
        long j5 = j - j4;
        long j6 = ((j4 ^ j) & (j ^ j5)) >= 0 ? j5 : Long.MIN_VALUE;
        long j7 = c2812j2.f7192d;
        long j8 = RecyclerView.FOREVER_NS;
        long j9 = j + j7;
        if (((j7 ^ j9) & (j ^ j9)) >= 0) {
            j8 = j9;
        }
        boolean z2 = false;
        boolean z3 = j6 <= j2 && j2 <= j8;
        if (j6 <= j3 && j3 <= j8) {
            z2 = true;
        }
        if (z3 && z2) {
            if (Math.abs(j2 - j) <= Math.abs(j3 - j)) {
                return j2;
            }
        } else {
            if (z3) {
                return j2;
            }
            if (!z2) {
                return j6;
            }
        }
        return j3;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j
    /* JADX INFO: renamed from: j */
    public void mo2486j() {
        this.f5505F = true;
        this.f5500A.post(this.f5536y);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x
    /* JADX INFO: renamed from: k */
    public long mo2487k() {
        if (!this.f5514O) {
            return -9223372036854775807L;
        }
        if (!this.f5521V && m2497u() <= this.f5520U) {
            return -9223372036854775807L;
        }
        this.f5514O = false;
        return this.f5517R;
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x
    /* JADX INFO: renamed from: l */
    public void mo2488l(InterfaceC2570x.a aVar, long j) {
        this.f5501B = aVar;
        this.f5535x.m3026b();
        m2475C();
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x
    /* JADX INFO: renamed from: m */
    public long mo2489m(InterfaceC2644j[] interfaceC2644jArr, boolean[] zArr, InterfaceC2546i0[] interfaceC2546i0Arr, boolean[] zArr2, long j) {
        m2496t();
        e eVar = this.f5508I;
        C2558o0 c2558o0 = eVar.f5557a;
        boolean[] zArr3 = eVar.f5559c;
        int i = this.f5515P;
        for (int i2 = 0; i2 < interfaceC2644jArr.length; i2++) {
            if (interfaceC2546i0Arr[i2] != null && (interfaceC2644jArr[i2] == null || !zArr[i2])) {
                int i3 = ((c) interfaceC2546i0Arr[i2]).f5553a;
                C1460d.m426D(zArr3[i3]);
                this.f5515P--;
                zArr3[i3] = false;
                interfaceC2546i0Arr[i2] = null;
            }
        }
        boolean z2 = !this.f5513N ? j == 0 : i != 0;
        for (int i4 = 0; i4 < interfaceC2644jArr.length; i4++) {
            if (interfaceC2546i0Arr[i4] == null && interfaceC2644jArr[i4] != null) {
                InterfaceC2644j interfaceC2644j = interfaceC2644jArr[i4];
                C1460d.m426D(interfaceC2644j.length() == 1);
                C1460d.m426D(interfaceC2644j.mo2730f(0) == 0);
                int iM2575a = c2558o0.m2575a(interfaceC2644j.mo2727a());
                C1460d.m426D(!zArr3[iM2575a]);
                this.f5515P++;
                zArr3[iM2575a] = true;
                interfaceC2546i0Arr[i4] = new c(iM2575a);
                zArr2[i4] = true;
                if (!z2) {
                    C2544h0 c2544h0 = this.f5503D[iM2575a];
                    z2 = (c2544h0.m2541t(j, true) || c2544h0.m2532k() == 0) ? false : true;
                }
            }
        }
        if (this.f5515P == 0) {
            this.f5519T = false;
            this.f5514O = false;
            if (this.f5533v.m8940b()) {
                for (C2544h0 c2544h1 : this.f5503D) {
                    c2544h1.m2529h();
                }
                Loader.HandlerC10769d<? extends Loader.InterfaceC10770e> handlerC10769d = this.f5533v.f20232d;
                C1460d.m438H(handlerC10769d);
                handlerC10769d.m8941a(false);
            } else {
                for (C2544h0 c2544h2 : this.f5503D) {
                    c2544h2.m2540s(false);
                }
            }
        } else if (z2) {
            j = mo2482f(j);
            for (int i5 = 0; i5 < interfaceC2546i0Arr.length; i5++) {
                if (interfaceC2546i0Arr[i5] != null) {
                    zArr2[i5] = true;
                }
            }
        }
        this.f5513N = true;
        return j;
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x
    /* JADX INFO: renamed from: n */
    public C2558o0 mo2490n() {
        m2496t();
        return this.f5508I.f5557a;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x007a  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:53:0x00db  */
    @Override // com.google.android.exoplayer2.upstream.Loader.InterfaceC10767b
    /* JADX INFO: renamed from: o */
    public Loader.C10768c mo2491o(Loader.InterfaceC10770e interfaceC10770e, long j, long j2, IOException iOException, int i) {
        long jMin;
        boolean z2;
        Loader.C10768c c10768cM8939a;
        InterfaceC3119t interfaceC3119t;
        boolean z3;
        a aVar = (a) interfaceC10770e;
        if (this.f5516Q == -1) {
            this.f5516Q = aVar.f5549l;
        }
        C2723y c2723y = aVar.f5540c;
        C2566t c2566t = new C2566t(aVar.f5538a, aVar.f5548k, c2723y.f6643c, c2723y.f6644d, j, j2, c2723y.f6642b);
        C2738e0.m2992M(aVar.f5547j);
        C2738e0.m2992M(this.f5510K);
        if ((iOException instanceof ParserException) || (iOException instanceof FileNotFoundException) || (iOException instanceof HttpDataSource$CleartextNotPermittedException) || (iOException instanceof Loader.UnexpectedLoaderException)) {
            jMin = -9223372036854775807L;
        } else {
            int i2 = DataSourceException.f20224j;
            Throwable cause = iOException;
            while (true) {
                if (cause == null) {
                    z3 = false;
                    break;
                }
                if ((cause instanceof DataSourceException) && ((DataSourceException) cause).reason == 2008) {
                    z3 = true;
                    break;
                }
                cause = cause.getCause();
            }
            if (z3) {
                jMin = -9223372036854775807L;
            } else {
                jMin = Math.min((i - 1) * 1000, 5000);
            }
        }
        if (jMin == -9223372036854775807L) {
            c10768cM8939a = Loader.f20230b;
        } else {
            int iM2497u = m2497u();
            boolean z4 = iM2497u > this.f5520U;
            if (this.f5516Q == -1 && ((interfaceC3119t = this.f5509J) == null || interfaceC3119t.mo3621i() == -9223372036854775807L)) {
                if (!this.f5506G || m2476D()) {
                    this.f5514O = this.f5506G;
                    this.f5517R = 0L;
                    this.f5520U = 0;
                    for (C2544h0 c2544h0 : this.f5503D) {
                        c2544h0.m2540s(false);
                    }
                    aVar.f5544g.f8992a = 0L;
                    aVar.f5547j = 0L;
                    aVar.f5546i = true;
                    aVar.f5551n = false;
                } else {
                    this.f5519T = true;
                    z2 = false;
                }
                if (z2) {
                    c10768cM8939a = Loader.m8939a(z4, jMin);
                } else {
                    c10768cM8939a = Loader.f20229a;
                }
            } else {
                this.f5520U = iM2497u;
            }
            z2 = true;
            if (z2) {
                c10768cM8939a = Loader.m8939a(z4, jMin);
            } else {
                c10768cM8939a = Loader.f20229a;
            }
        }
        int i3 = c10768cM8939a.f20234a;
        boolean z5 = !(i3 == 0 || i3 == 1);
        InterfaceC2532b0.a aVar2 = this.f5527p;
        aVar2.m2470e(c2566t, new C2569w(1, -1, null, 0, null, aVar2.m2466a(aVar.f5547j), aVar2.m2466a(this.f5510K)), iOException, z5);
        if (z5) {
            Objects.requireNonNull(this.f5526o);
        }
        return c10768cM8939a;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.InterfaceC3058j
    /* JADX INFO: renamed from: p */
    public InterfaceC3122w mo2492p(int i, int i2) {
        return m2474B(new d(i, false));
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x
    /* JADX INFO: renamed from: q */
    public long mo2493q() {
        long jM2498v;
        boolean z2;
        long j;
        m2496t();
        boolean[] zArr = this.f5508I.f5558b;
        if (this.f5521V) {
            return Long.MIN_VALUE;
        }
        if (m2499w()) {
            return this.f5518S;
        }
        if (this.f5507H) {
            int length = this.f5503D.length;
            jM2498v = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                if (zArr[i]) {
                    C2544h0 c2544h0 = this.f5503D[i];
                    synchronized (c2544h0) {
                        z2 = c2544h0.f5619x;
                    }
                    if (z2) {
                        continue;
                    } else {
                        C2544h0 c2544h1 = this.f5503D[i];
                        synchronized (c2544h1) {
                            j = c2544h1.f5618w;
                        }
                        jM2498v = Math.min(jM2498v, j);
                    }
                }
            }
        } else {
            jM2498v = Long.MAX_VALUE;
        }
        if (jM2498v == RecyclerView.FOREVER_NS) {
            jM2498v = m2498v();
        }
        return jM2498v == Long.MIN_VALUE ? this.f5517R : jM2498v;
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x
    /* JADX INFO: renamed from: r */
    public void mo2494r(long j, boolean z2) {
        long jM2528g;
        int i;
        m2496t();
        if (m2499w()) {
            return;
        }
        boolean[] zArr = this.f5508I.f5559c;
        int length = this.f5503D.length;
        for (int i2 = 0; i2 < length; i2++) {
            C2544h0 c2544h0 = this.f5503D[i2];
            boolean z3 = zArr[i2];
            C2542g0 c2542g0 = c2544h0.f5596a;
            synchronized (c2544h0) {
                int i3 = c2544h0.f5612q;
                jM2528g = -1;
                if (i3 != 0) {
                    long[] jArr = c2544h0.f5610o;
                    int i4 = c2544h0.f5614s;
                    if (j >= jArr[i4]) {
                        int iM2530i = c2544h0.m2530i(i4, (!z3 || (i = c2544h0.f5615t) == i3) ? i3 : i + 1, j, z2);
                        if (iM2530i != -1) {
                            jM2528g = c2544h0.m2528g(iM2530i);
                        }
                    }
                }
            }
            c2542g0.m2518a(jM2528g);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.InterfaceC2570x
    /* JADX INFO: renamed from: s */
    public void mo2495s(long j) {
    }

    @EnsuresNonNull({"trackState", "seekMap"})
    /* JADX INFO: renamed from: t */
    public final void m2496t() {
        C1460d.m426D(this.f5506G);
        Objects.requireNonNull(this.f5508I);
        Objects.requireNonNull(this.f5509J);
    }

    /* JADX INFO: renamed from: u */
    public final int m2497u() {
        int iM2535n = 0;
        for (C2544h0 c2544h0 : this.f5503D) {
            iM2535n += c2544h0.m2535n();
        }
        return iM2535n;
    }

    /* JADX INFO: renamed from: v */
    public final long m2498v() {
        long j;
        long jMax = Long.MIN_VALUE;
        for (C2544h0 c2544h0 : this.f5503D) {
            synchronized (c2544h0) {
                j = c2544h0.f5618w;
            }
            jMax = Math.max(jMax, j);
        }
        return jMax;
    }

    /* JADX INFO: renamed from: w */
    public final boolean m2499w() {
        return this.f5518S != -9223372036854775807L;
    }

    /* JADX INFO: renamed from: x */
    public final void m2500x() {
        if (this.f5522W || this.f5506G || !this.f5505F || this.f5509J == null) {
            return;
        }
        for (C2544h0 c2544h0 : this.f5503D) {
            if (c2544h0.m2534m() == null) {
                return;
            }
        }
        this.f5535x.m3025a();
        int length = this.f5503D.length;
        C2556n0[] c2556n0Arr = new C2556n0[length];
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            C2811j1 c2811j1M2534m = this.f5503D[i].m2534m();
            Objects.requireNonNull(c2811j1M2534m);
            String str = c2811j1M2534m.f7155w;
            boolean zM3050h = C2753t.m3050h(str);
            boolean z2 = zM3050h || C2753t.m3052j(str);
            zArr[i] = z2;
            this.f5507H = z2 | this.f5507H;
            IcyHeaders icyHeaders = this.f5502C;
            if (icyHeaders != null) {
                if (zM3050h || this.f5504E[i].f5556b) {
                    Metadata metadata = c2811j1M2534m.f7153u;
                    Metadata metadata2 = metadata == null ? new Metadata(icyHeaders) : metadata.m8877a(icyHeaders);
                    C2811j1.b bVarM3275a = c2811j1M2534m.m3275a();
                    bVarM3275a.f7171i = metadata2;
                    c2811j1M2534m = bVarM3275a.m3277a();
                }
                if (zM3050h && c2811j1M2534m.f7149q == -1 && c2811j1M2534m.f7150r == -1 && icyHeaders.f19957j != -1) {
                    C2811j1.b bVarM3275a2 = c2811j1M2534m.m3275a();
                    bVarM3275a2.f7168f = icyHeaders.f19957j;
                    c2811j1M2534m = bVarM3275a2.m3277a();
                }
            }
            int iMo3600d = this.f5525n.mo3600d(c2811j1M2534m);
            C2811j1.b bVarM3275a3 = c2811j1M2534m.m3275a();
            bVarM3275a3.f7162D = iMo3600d;
            c2556n0Arr[i] = new C2556n0(bVarM3275a3.m3277a());
        }
        this.f5508I = new e(new C2558o0(c2556n0Arr), zArr);
        this.f5506G = true;
        InterfaceC2570x.a aVar = this.f5501B;
        Objects.requireNonNull(aVar);
        aVar.mo2563b(this);
    }

    /* JADX INFO: renamed from: y */
    public final void m2501y(int i) {
        m2496t();
        e eVar = this.f5508I;
        boolean[] zArr = eVar.f5560d;
        if (zArr[i]) {
            return;
        }
        C2811j1 c2811j1 = eVar.f5557a.f5676l[i].f5662l[0];
        InterfaceC2532b0.a aVar = this.f5527p;
        aVar.m2467b(new C2569w(1, C2753t.m3049g(c2811j1.f7155w), c2811j1, 0, null, aVar.m2466a(this.f5517R), -9223372036854775807L));
        zArr[i] = true;
    }

    /* JADX INFO: renamed from: z */
    public final void m2502z(int i) {
        m2496t();
        boolean[] zArr = this.f5508I.f5558b;
        if (this.f5519T && zArr[i] && !this.f5503D[i].m2537p(false)) {
            this.f5518S = 0L;
            this.f5519T = false;
            this.f5514O = true;
            this.f5517R = 0L;
            this.f5520U = 0;
            for (C2544h0 c2544h0 : this.f5503D) {
                c2544h0.m2540s(false);
            }
            InterfaceC2570x.a aVar = this.f5501B;
            Objects.requireNonNull(aVar);
            aVar.mo2542a(this);
        }
    }
}
