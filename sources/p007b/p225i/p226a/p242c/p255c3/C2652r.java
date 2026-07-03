package p007b.p225i.p226a.p242c.p255c3;

import androidx.annotation.Nullable;
import p007b.p225i.p226a.p242c.C2804h2;
import p007b.p225i.p226a.p242c.C2836p2;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: renamed from: b.i.a.c.c3.r */
/* JADX INFO: compiled from: TrackSelectorResult.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2652r {

    /* JADX INFO: renamed from: a */
    public final int f6326a;

    /* JADX INFO: renamed from: b */
    public final C2804h2[] f6327b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC2644j[] f6328c;

    /* JADX INFO: renamed from: d */
    public final C2836p2 f6329d;

    /* JADX INFO: renamed from: e */
    @Nullable
    public final Object f6330e;

    public C2652r(C2804h2[] c2804h2Arr, InterfaceC2644j[] interfaceC2644jArr, C2836p2 c2836p2, @Nullable Object obj) {
        this.f6327b = c2804h2Arr;
        this.f6328c = (InterfaceC2644j[]) interfaceC2644jArr.clone();
        this.f6329d = c2836p2;
        this.f6330e = obj;
        this.f6326a = c2804h2Arr.length;
    }

    /* JADX INFO: renamed from: a */
    public boolean m2755a(@Nullable C2652r c2652r, int i) {
        return c2652r != null && C2738e0.m2993a(this.f6327b[i], c2652r.f6327b[i]) && C2738e0.m2993a(this.f6328c[i], c2652r.f6328c[i]);
    }

    /* JADX INFO: renamed from: b */
    public boolean m2756b(int i) {
        return this.f6327b[i] != null;
    }
}
