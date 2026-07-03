package p007b.p225i.p226a.p242c;

import android.util.Log;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p243a3.C2558o0;
import p007b.p225i.p226a.p242c.p255c3.InterfaceC2644j;
import p007b.p225i.p226a.p242c.p257e3.C2713o;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: renamed from: b.i.a.c.z0 */
/* JADX INFO: compiled from: DefaultLoadControl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C3153z0 implements InterfaceC2827n1 {

    /* JADX INFO: renamed from: a */
    public final C2713o f9125a;

    /* JADX INFO: renamed from: b */
    public final long f9126b;

    /* JADX INFO: renamed from: c */
    public final long f9127c;

    /* JADX INFO: renamed from: d */
    public final long f9128d;

    /* JADX INFO: renamed from: e */
    public final long f9129e;

    /* JADX INFO: renamed from: f */
    public final int f9130f;

    /* JADX INFO: renamed from: g */
    public final boolean f9131g;

    /* JADX INFO: renamed from: h */
    public final long f9132h;

    /* JADX INFO: renamed from: i */
    public final boolean f9133i;

    /* JADX INFO: renamed from: j */
    public int f9134j;

    /* JADX INFO: renamed from: k */
    public boolean f9135k;

    public C3153z0(C2713o c2713o, int i, int i2, int i3, int i4, int i5, boolean z2, int i6, boolean z3) {
        m3871j(i3, 0, "bufferForPlaybackMs", "0");
        m3871j(i4, 0, "bufferForPlaybackAfterRebufferMs", "0");
        m3871j(i, i3, "minBufferMs", "bufferForPlaybackMs");
        m3871j(i, i4, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        m3871j(i2, i, "maxBufferMs", "minBufferMs");
        m3871j(i6, 0, "backBufferDurationMs", "0");
        this.f9125a = c2713o;
        this.f9126b = C2738e0.m2981B(i);
        this.f9127c = C2738e0.m2981B(i2);
        this.f9128d = C2738e0.m2981B(i3);
        this.f9129e = C2738e0.m2981B(i4);
        this.f9130f = i5;
        this.f9134j = i5 == -1 ? 13107200 : i5;
        this.f9131g = z2;
        this.f9132h = C2738e0.m2981B(i6);
        this.f9133i = z3;
    }

    /* JADX INFO: renamed from: j */
    public static void m3871j(int i, int i2, String str, String str2) {
        boolean z2 = i >= i2;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + String.valueOf(str).length() + 21);
        sb.append(str);
        sb.append(" cannot be less than ");
        sb.append(str2);
        C1460d.m543m(z2, sb.toString());
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2827n1
    /* JADX INFO: renamed from: a */
    public boolean mo3309a() {
        return this.f9133i;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2827n1
    /* JADX INFO: renamed from: b */
    public long mo3310b() {
        return this.f9132h;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2827n1
    /* JADX INFO: renamed from: c */
    public void mo3311c() {
        m3872k(false);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // p007b.p225i.p226a.p242c.InterfaceC2827n1
    /* JADX INFO: renamed from: d */
    public void mo3312d(InterfaceC2728f2[] interfaceC2728f2Arr, C2558o0 c2558o0, InterfaceC2644j[] interfaceC2644jArr) {
        int iMax = this.f9130f;
        if (iMax == -1) {
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = 13107200;
                if (i < interfaceC2728f2Arr.length) {
                    if (interfaceC2644jArr[i] != null) {
                        switch (interfaceC2728f2Arr[i].mo2946x()) {
                            case -2:
                                i3 = 0;
                                i2 += i3;
                                break;
                            case -1:
                            default:
                                throw new IllegalArgumentException();
                            case 0:
                                i3 = 144310272;
                                i2 += i3;
                                break;
                            case 1:
                                i2 += i3;
                                break;
                            case 2:
                                i3 = 131072000;
                                i2 += i3;
                                break;
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                                i3 = 131072;
                                i2 += i3;
                                break;
                        }
                    }
                    i++;
                } else {
                    iMax = Math.max(13107200, i2);
                }
            }
        }
        this.f9134j = iMax;
        this.f9125a.m2859b(iMax);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2827n1
    /* JADX INFO: renamed from: e */
    public void mo3313e() {
        m3872k(true);
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2827n1
    /* JADX INFO: renamed from: f */
    public boolean mo3314f(long j, float f, boolean z2, long j2) {
        int i;
        int i2 = C2738e0.f6708a;
        if (f != 1.0f) {
            j = Math.round(j / ((double) f));
        }
        long jMin = z2 ? this.f9129e : this.f9128d;
        if (j2 != -9223372036854775807L) {
            jMin = Math.min(j2 / 2, jMin);
        }
        if (jMin > 0 && j < jMin) {
            if (!this.f9131g) {
                C2713o c2713o = this.f9125a;
                synchronized (c2713o) {
                    i = c2713o.f6566e * c2713o.f6563b;
                }
                if (i >= this.f9134j) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2827n1
    /* JADX INFO: renamed from: g */
    public boolean mo3315g(long j, long j2, float f) {
        int i;
        C2713o c2713o = this.f9125a;
        synchronized (c2713o) {
            i = c2713o.f6566e * c2713o.f6563b;
        }
        boolean z2 = true;
        boolean z3 = i >= this.f9134j;
        long jMin = this.f9126b;
        if (f > 1.0f) {
            jMin = Math.min(C2738e0.m3009q(jMin, f), this.f9127c);
        }
        if (j2 < Math.max(jMin, 500000L)) {
            if (!this.f9131g && z3) {
                z2 = false;
            }
            this.f9135k = z2;
            if (!z2 && j2 < 500000) {
                Log.w("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j2 >= this.f9127c || z3) {
            this.f9135k = false;
        }
        return this.f9135k;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2827n1
    /* JADX INFO: renamed from: h */
    public C2713o mo3316h() {
        return this.f9125a;
    }

    @Override // p007b.p225i.p226a.p242c.InterfaceC2827n1
    /* JADX INFO: renamed from: i */
    public void mo3317i() {
        m3872k(true);
    }

    /* JADX INFO: renamed from: k */
    public final void m3872k(boolean z2) {
        int i = this.f9130f;
        if (i == -1) {
            i = 13107200;
        }
        this.f9134j = i;
        this.f9135k = false;
        if (z2) {
            C2713o c2713o = this.f9125a;
            synchronized (c2713o) {
                if (c2713o.f6562a) {
                    c2713o.m2859b(0);
                }
            }
        }
    }
}
