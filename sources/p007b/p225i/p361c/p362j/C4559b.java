package p007b.p225i.p361c.p362j;

import android.os.Bundle;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;
import p007b.p225i.p226a.p288f.p313h.p325l.BinderC3618cc;
import p007b.p225i.p226a.p288f.p313h.p325l.C3661g;
import p007b.p225i.p226a.p288f.p313h.p325l.C3689i;
import p007b.p225i.p226a.p288f.p313h.p325l.C3716k;
import p007b.p225i.p226a.p288f.p313h.p325l.C3729l;
import p007b.p225i.p226a.p288f.p313h.p325l.C3781p;
import p007b.p225i.p226a.p288f.p313h.p325l.C3794q;
import p007b.p225i.p226a.p288f.p313h.p325l.C3807r;
import p007b.p225i.p226a.p288f.p313h.p325l.C3820s;
import p007b.p225i.p226a.p288f.p313h.p325l.C3833t;
import p007b.p225i.p226a.p288f.p313h.p325l.C3846u;
import p007b.p225i.p226a.p288f.p313h.p325l.C3872w;
import p007b.p225i.p226a.p288f.p313h.p325l.C3885x;
import p007b.p225i.p226a.p288f.p313h.p325l.C3911z;
import p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC3988b7;

/* JADX INFO: renamed from: b.i.c.j.b */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4559b implements InterfaceC3988b7 {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C3661g f12162a;

    public C4559b(C3661g c3661g) {
        this.f12162a = c3661g;
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC3988b7
    /* JADX INFO: renamed from: a */
    public final String mo5502a() {
        C3661g c3661g = this.f12162a;
        Objects.requireNonNull(c3661g);
        BinderC3618cc binderC3618cc = new BinderC3618cc();
        c3661g.f9950e.execute(new C3833t(c3661g, binderC3618cc));
        return binderC3618cc.m4620i(500L);
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC3988b7
    /* JADX INFO: renamed from: b */
    public final String mo5503b() {
        C3661g c3661g = this.f12162a;
        Objects.requireNonNull(c3661g);
        BinderC3618cc binderC3618cc = new BinderC3618cc();
        c3661g.f9950e.execute(new C3885x(c3661g, binderC3618cc));
        return binderC3618cc.m4620i(500L);
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC3988b7
    /* JADX INFO: renamed from: c */
    public final String mo5504c() {
        C3661g c3661g = this.f12162a;
        Objects.requireNonNull(c3661g);
        BinderC3618cc binderC3618cc = new BinderC3618cc();
        c3661g.f9950e.execute(new C3807r(c3661g, binderC3618cc));
        return binderC3618cc.m4620i(50L);
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC3988b7
    /* JADX INFO: renamed from: d */
    public final String mo5505d() {
        C3661g c3661g = this.f12162a;
        Objects.requireNonNull(c3661g);
        BinderC3618cc binderC3618cc = new BinderC3618cc();
        c3661g.f9950e.execute(new C3820s(c3661g, binderC3618cc));
        return binderC3618cc.m4620i(500L);
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC3988b7
    /* JADX INFO: renamed from: e */
    public final long mo5506e() {
        C3661g c3661g = this.f12162a;
        Objects.requireNonNull(c3661g);
        BinderC3618cc binderC3618cc = new BinderC3618cc();
        c3661g.f9950e.execute(new C3846u(c3661g, binderC3618cc));
        Long l = (Long) BinderC3618cc.m4618g(binderC3618cc.m4621t0(500L), Long.class);
        if (l != null) {
            return l.longValue();
        }
        long jNanoTime = System.nanoTime();
        Objects.requireNonNull((C3401c) c3661g.f9949d);
        long jNextLong = new Random(jNanoTime ^ System.currentTimeMillis()).nextLong();
        int i = c3661g.f9953h + 1;
        c3661g.f9953h = i;
        return jNextLong + ((long) i);
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC3988b7
    /* JADX INFO: renamed from: f */
    public final void mo5507f(Bundle bundle) {
        C3661g c3661g = this.f12162a;
        Objects.requireNonNull(c3661g);
        c3661g.f9950e.execute(new C3689i(c3661g, bundle));
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC3988b7
    /* JADX INFO: renamed from: g */
    public final void mo5508g(String str) {
        C3661g c3661g = this.f12162a;
        Objects.requireNonNull(c3661g);
        c3661g.f9950e.execute(new C3794q(c3661g, str));
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC3988b7
    /* JADX INFO: renamed from: h */
    public final List<Bundle> mo5509h(String str, String str2) {
        C3661g c3661g = this.f12162a;
        Objects.requireNonNull(c3661g);
        BinderC3618cc binderC3618cc = new BinderC3618cc();
        c3661g.f9950e.execute(new C3716k(c3661g, str, str2, binderC3618cc));
        List<Bundle> list = (List) BinderC3618cc.m4618g(binderC3618cc.m4621t0(5000L), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC3988b7
    /* JADX INFO: renamed from: i */
    public final int mo5510i(String str) {
        C3661g c3661g = this.f12162a;
        Objects.requireNonNull(c3661g);
        BinderC3618cc binderC3618cc = new BinderC3618cc();
        c3661g.f9950e.execute(new C3911z(c3661g, str, binderC3618cc));
        Integer num = (Integer) BinderC3618cc.m4618g(binderC3618cc.m4621t0(10000L), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC3988b7
    /* JADX INFO: renamed from: j */
    public final void mo5511j(String str) {
        C3661g c3661g = this.f12162a;
        Objects.requireNonNull(c3661g);
        c3661g.f9950e.execute(new C3781p(c3661g, str));
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC3988b7
    /* JADX INFO: renamed from: k */
    public final Map<String, Object> mo5512k(String str, String str2, boolean z2) {
        C3661g c3661g = this.f12162a;
        Objects.requireNonNull(c3661g);
        BinderC3618cc binderC3618cc = new BinderC3618cc();
        c3661g.f9950e.execute(new C3872w(c3661g, str, str2, z2, binderC3618cc));
        Bundle bundleM4621t0 = binderC3618cc.m4621t0(5000L);
        if (bundleM4621t0 == null || bundleM4621t0.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap map = new HashMap(bundleM4621t0.size());
        for (String str3 : bundleM4621t0.keySet()) {
            Object obj = bundleM4621t0.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                map.put(str3, obj);
            }
        }
        return map;
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC3988b7
    /* JADX INFO: renamed from: l */
    public final void mo5513l(String str, String str2, Bundle bundle) {
        C3661g c3661g = this.f12162a;
        Objects.requireNonNull(c3661g);
        c3661g.f9950e.execute(new C3729l(c3661g, str, str2, bundle));
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC3988b7
    /* JADX INFO: renamed from: m */
    public final void mo5514m(String str, String str2, Bundle bundle) {
        this.f12162a.m4886c(str, str2, bundle, true, true, null);
    }
}
