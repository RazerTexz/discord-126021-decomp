package p007b.p225i.p226a.p242c;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.List;
import p007b.p225i.p226a.p242c.p243a3.C2558o0;
import p007b.p225i.p226a.p242c.p243a3.InterfaceC2530a0;
import p007b.p225i.p226a.p242c.p255c3.C2652r;
import p007b.p225i.p355b.p357b.AbstractC4493a;
import p007b.p225i.p355b.p357b.AbstractC4523p;
import p007b.p225i.p355b.p357b.C4508h0;

/* JADX INFO: renamed from: b.i.a.c.w1 */
/* JADX INFO: compiled from: PlaybackInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2964w1 {

    /* JADX INFO: renamed from: a */
    public static final InterfaceC2530a0.a f7946a = new InterfaceC2530a0.a(new Object());

    /* JADX INFO: renamed from: b */
    public final AbstractC2832o2 f7947b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC2530a0.a f7948c;

    /* JADX INFO: renamed from: d */
    public final long f7949d;

    /* JADX INFO: renamed from: e */
    public final long f7950e;

    /* JADX INFO: renamed from: f */
    public final int f7951f;

    /* JADX INFO: renamed from: g */
    @Nullable
    public final ExoPlaybackException f7952g;

    /* JADX INFO: renamed from: h */
    public final boolean f7953h;

    /* JADX INFO: renamed from: i */
    public final C2558o0 f7954i;

    /* JADX INFO: renamed from: j */
    public final C2652r f7955j;

    /* JADX INFO: renamed from: k */
    public final List<Metadata> f7956k;

    /* JADX INFO: renamed from: l */
    public final InterfaceC2530a0.a f7957l;

    /* JADX INFO: renamed from: m */
    public final boolean f7958m;

    /* JADX INFO: renamed from: n */
    public final int f7959n;

    /* JADX INFO: renamed from: o */
    public final C2998x1 f7960o;

    /* JADX INFO: renamed from: p */
    public final boolean f7961p;

    /* JADX INFO: renamed from: q */
    public final boolean f7962q;

    /* JADX INFO: renamed from: r */
    public volatile long f7963r;

    /* JADX INFO: renamed from: s */
    public volatile long f7964s;

    /* JADX INFO: renamed from: t */
    public volatile long f7965t;

    public C2964w1(AbstractC2832o2 abstractC2832o2, InterfaceC2530a0.a aVar, long j, long j2, int i, @Nullable ExoPlaybackException exoPlaybackException, boolean z2, C2558o0 c2558o0, C2652r c2652r, List<Metadata> list, InterfaceC2530a0.a aVar2, boolean z3, int i2, C2998x1 c2998x1, long j3, long j4, long j5, boolean z4, boolean z5) {
        this.f7947b = abstractC2832o2;
        this.f7948c = aVar;
        this.f7949d = j;
        this.f7950e = j2;
        this.f7951f = i;
        this.f7952g = exoPlaybackException;
        this.f7953h = z2;
        this.f7954i = c2558o0;
        this.f7955j = c2652r;
        this.f7956k = list;
        this.f7957l = aVar2;
        this.f7958m = z3;
        this.f7959n = i2;
        this.f7960o = c2998x1;
        this.f7963r = j3;
        this.f7964s = j4;
        this.f7965t = j5;
        this.f7961p = z4;
        this.f7962q = z5;
    }

    /* JADX INFO: renamed from: h */
    public static C2964w1 m3561h(C2652r c2652r) {
        AbstractC2832o2 abstractC2832o2 = AbstractC2832o2.f7337j;
        InterfaceC2530a0.a aVar = f7946a;
        C2558o0 c2558o0 = C2558o0.f5674j;
        AbstractC4493a<Object> abstractC4493a = AbstractC4523p.f12045k;
        return new C2964w1(abstractC2832o2, aVar, -9223372036854775807L, 0L, 1, null, false, c2558o0, c2652r, C4508h0.f12012l, aVar, false, 0, C2998x1.f8026j, 0L, 0L, 0L, false, false);
    }

    @CheckResult
    /* JADX INFO: renamed from: a */
    public C2964w1 m3562a(InterfaceC2530a0.a aVar) {
        return new C2964w1(this.f7947b, this.f7948c, this.f7949d, this.f7950e, this.f7951f, this.f7952g, this.f7953h, this.f7954i, this.f7955j, this.f7956k, aVar, this.f7958m, this.f7959n, this.f7960o, this.f7963r, this.f7964s, this.f7965t, this.f7961p, this.f7962q);
    }

    @CheckResult
    /* JADX INFO: renamed from: b */
    public C2964w1 m3563b(InterfaceC2530a0.a aVar, long j, long j2, long j3, long j4, C2558o0 c2558o0, C2652r c2652r, List<Metadata> list) {
        return new C2964w1(this.f7947b, aVar, j2, j3, this.f7951f, this.f7952g, this.f7953h, c2558o0, c2652r, list, this.f7957l, this.f7958m, this.f7959n, this.f7960o, this.f7963r, j4, j, this.f7961p, this.f7962q);
    }

    @CheckResult
    /* JADX INFO: renamed from: c */
    public C2964w1 m3564c(boolean z2) {
        return new C2964w1(this.f7947b, this.f7948c, this.f7949d, this.f7950e, this.f7951f, this.f7952g, this.f7953h, this.f7954i, this.f7955j, this.f7956k, this.f7957l, this.f7958m, this.f7959n, this.f7960o, this.f7963r, this.f7964s, this.f7965t, z2, this.f7962q);
    }

    @CheckResult
    /* JADX INFO: renamed from: d */
    public C2964w1 m3565d(boolean z2, int i) {
        return new C2964w1(this.f7947b, this.f7948c, this.f7949d, this.f7950e, this.f7951f, this.f7952g, this.f7953h, this.f7954i, this.f7955j, this.f7956k, this.f7957l, z2, i, this.f7960o, this.f7963r, this.f7964s, this.f7965t, this.f7961p, this.f7962q);
    }

    @CheckResult
    /* JADX INFO: renamed from: e */
    public C2964w1 m3566e(@Nullable ExoPlaybackException exoPlaybackException) {
        return new C2964w1(this.f7947b, this.f7948c, this.f7949d, this.f7950e, this.f7951f, exoPlaybackException, this.f7953h, this.f7954i, this.f7955j, this.f7956k, this.f7957l, this.f7958m, this.f7959n, this.f7960o, this.f7963r, this.f7964s, this.f7965t, this.f7961p, this.f7962q);
    }

    @CheckResult
    /* JADX INFO: renamed from: f */
    public C2964w1 m3567f(int i) {
        return new C2964w1(this.f7947b, this.f7948c, this.f7949d, this.f7950e, i, this.f7952g, this.f7953h, this.f7954i, this.f7955j, this.f7956k, this.f7957l, this.f7958m, this.f7959n, this.f7960o, this.f7963r, this.f7964s, this.f7965t, this.f7961p, this.f7962q);
    }

    @CheckResult
    /* JADX INFO: renamed from: g */
    public C2964w1 m3568g(AbstractC2832o2 abstractC2832o2) {
        return new C2964w1(abstractC2832o2, this.f7948c, this.f7949d, this.f7950e, this.f7951f, this.f7952g, this.f7953h, this.f7954i, this.f7955j, this.f7956k, this.f7957l, this.f7958m, this.f7959n, this.f7960o, this.f7963r, this.f7964s, this.f7965t, this.f7961p, this.f7962q);
    }
}
