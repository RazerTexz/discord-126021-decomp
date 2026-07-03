package p007b.p225i.p226a.p242c.p255c3;

import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import java.util.List;
import p007b.p225i.p226a.p242c.p243a3.C2556n0;
import p007b.p225i.p226a.p242c.p255c3.InterfaceC2644j;
import p007b.p225i.p226a.p242c.p257e3.InterfaceC2704f;
import p007b.p225i.p226a.p242c.p259f3.InterfaceC2740g;
import p007b.p225i.p355b.p357b.AbstractC4523p;

/* JADX INFO: renamed from: b.i.a.c.c3.f */
/* JADX INFO: compiled from: AdaptiveTrackSelection.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2640f extends AbstractC2641g {

    /* JADX INFO: renamed from: f */
    public final InterfaceC2704f f6182f;

    /* JADX INFO: renamed from: g */
    public final InterfaceC2740g f6183g;

    /* JADX INFO: renamed from: b.i.a.c.c3.f$a */
    /* JADX INFO: compiled from: AdaptiveTrackSelection.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final long f6184a;

        /* JADX INFO: renamed from: b */
        public final long f6185b;

        public a(long j, long j2) {
            this.f6184a = j;
            this.f6185b = j2;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f6184a == aVar.f6184a && this.f6185b == aVar.f6185b;
        }

        public int hashCode() {
            return (((int) this.f6184a) * 31) + ((int) this.f6185b);
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.c3.f$b */
    /* JADX INFO: compiled from: AdaptiveTrackSelection.java */
    public static class b implements InterfaceC2644j.b {

        /* JADX INFO: renamed from: a */
        public final InterfaceC2740g f6186a = InterfaceC2740g.f6720a;
    }

    public C2640f(C2556n0 c2556n0, int[] iArr, int i, InterfaceC2704f interfaceC2704f, long j, long j2, long j3, int i2, int i3, float f, float f2, List<a> list, InterfaceC2740g interfaceC2740g) {
        super(c2556n0, iArr, i);
        if (j3 < j) {
            Log.w("AdaptiveTrackSelection", "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
        }
        this.f6182f = interfaceC2704f;
        AbstractC4523p.m6264n(list);
        this.f6183g = interfaceC2740g;
    }

    /* JADX INFO: renamed from: m */
    public static void m2722m(List<AbstractC4523p.a<a>> list, long[] jArr) {
        long j = 0;
        for (long j2 : jArr) {
            j += j2;
        }
        for (int i = 0; i < list.size(); i++) {
            AbstractC4523p.a<a> aVar = list.get(i);
            if (aVar != null) {
                aVar.m6271b(new a(j, jArr[i]));
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p255c3.InterfaceC2644j
    /* JADX INFO: renamed from: b */
    public int mo2723b() {
        return 0;
    }

    @Override // p007b.p225i.p226a.p242c.p255c3.AbstractC2641g, p007b.p225i.p226a.p242c.p255c3.InterfaceC2644j
    @CallSuper
    /* JADX INFO: renamed from: e */
    public void mo2724e() {
    }

    @Override // p007b.p225i.p226a.p242c.p255c3.AbstractC2641g, p007b.p225i.p226a.p242c.p255c3.InterfaceC2644j
    @CallSuper
    /* JADX INFO: renamed from: g */
    public void mo2725g() {
    }

    @Override // p007b.p225i.p226a.p242c.p255c3.AbstractC2641g, p007b.p225i.p226a.p242c.p255c3.InterfaceC2644j
    /* JADX INFO: renamed from: i */
    public void mo2726i(float f) {
    }
}
