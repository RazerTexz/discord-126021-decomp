package p007b.p225i.p226a.p288f.p313h.p325l;

import com.google.android.gms.internal.measurement.zzhi;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.f.h.l.f7 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C3655f7 extends AbstractC3627d7<C3613c7, C3613c7> {
    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3627d7
    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C3613c7 mo4634a() {
        return C3613c7.m4610c();
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3627d7
    /* JADX INFO: renamed from: b */
    public final /* synthetic */ void mo4635b(C3613c7 c3613c7, int i, long j) {
        c3613c7.m4611a(i << 3, Long.valueOf(j));
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3627d7
    /* JADX INFO: renamed from: c */
    public final /* synthetic */ void mo4636c(C3613c7 c3613c7, InterfaceC3867v7 interfaceC3867v7) throws IOException {
        c3613c7.m4612d(interfaceC3867v7);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3627d7
    /* JADX INFO: renamed from: d */
    public final void mo4637d(Object obj, C3613c7 c3613c7) {
        ((AbstractC3851u4) obj).zzb = c3613c7;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3627d7
    /* JADX INFO: renamed from: e */
    public final /* synthetic */ C3613c7 mo4638e(Object obj) {
        return ((AbstractC3851u4) obj).zzb;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3627d7
    /* JADX INFO: renamed from: f */
    public final void mo4639f(C3613c7 c3613c7, InterfaceC3867v7 interfaceC3867v7) throws IOException {
        C3613c7 c3613c8 = c3613c7;
        Objects.requireNonNull(c3613c8);
        Objects.requireNonNull(interfaceC3867v7);
        for (int i = 0; i < c3613c8.f9878b; i++) {
            ((C3666g4) interfaceC3867v7).m4911c(c3613c8.f9879c[i] >>> 3, c3613c8.f9880d[i]);
        }
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3627d7
    /* JADX INFO: renamed from: g */
    public final C3613c7 mo4640g(C3613c7 c3613c7, C3613c7 c3613c8) {
        C3613c7 c3613c9 = c3613c7;
        C3613c7 c3613c10 = c3613c8;
        if (c3613c10.equals(C3613c7.f9877a)) {
            return c3613c9;
        }
        int i = c3613c9.f9878b + c3613c10.f9878b;
        int[] iArrCopyOf = Arrays.copyOf(c3613c9.f9879c, i);
        System.arraycopy(c3613c10.f9879c, 0, iArrCopyOf, c3613c9.f9878b, c3613c10.f9878b);
        Object[] objArrCopyOf = Arrays.copyOf(c3613c9.f9880d, i);
        System.arraycopy(c3613c10.f9880d, 0, objArrCopyOf, c3613c9.f9878b, c3613c10.f9878b);
        return new C3613c7(i, iArrCopyOf, objArrCopyOf, true);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3627d7
    /* JADX INFO: renamed from: h */
    public final void mo4641h(Object obj) {
        ((AbstractC3851u4) obj).zzb.f9882f = false;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3627d7
    /* JADX INFO: renamed from: i */
    public final int mo4642i(C3613c7 c3613c7) {
        C3613c7 c3613c8 = c3613c7;
        int i = c3613c8.f9881e;
        if (i != -1) {
            return i;
        }
        int iM9078w = 0;
        for (int i2 = 0; i2 < c3613c8.f9878b; i2++) {
            int i3 = c3613c8.f9879c[i2] >>> 3;
            AbstractC3837t3 abstractC3837t3 = (AbstractC3837t3) c3613c8.f9880d[i2];
            iM9078w += zzhi.m9078w(3, abstractC3837t3) + zzhi.m9060M(2, i3) + (zzhi.m9059L(8) << 1);
        }
        c3613c8.f9881e = iM9078w;
        return iM9078w;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3627d7
    /* JADX INFO: renamed from: j */
    public final /* synthetic */ int mo4643j(C3613c7 c3613c7) {
        return c3613c7.m4613e();
    }
}
