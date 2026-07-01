package b.i.c.j;

import android.os.Bundle;
import b.i.a.f.e.o.c;
import b.i.a.f.h.l.cc;
import b.i.a.f.h.l.g;
import b.i.a.f.h.l.i;
import b.i.a.f.h.l.k;
import b.i.a.f.h.l.l;
import b.i.a.f.h.l.p;
import b.i.a.f.h.l.q;
import b.i.a.f.h.l.r;
import b.i.a.f.h.l.s;
import b.i.a.f.h.l.t;
import b.i.a.f.h.l.u;
import b.i.a.f.h.l.w;
import b.i.a.f.h.l.x;
import b.i.a.f.h.l.z;
import b.i.a.f.i.b.b7;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements b7 {
    public final /* synthetic */ g a;

    public b(g gVar) {
        this.a = gVar;
    }

    @Override // b.i.a.f.i.b.b7
    public final String a() {
        g gVar = this.a;
        Objects.requireNonNull(gVar);
        cc ccVar = new cc();
        gVar.e.execute(new t(gVar, ccVar));
        return ccVar.i(500L);
    }

    @Override // b.i.a.f.i.b.b7
    public final String b() {
        g gVar = this.a;
        Objects.requireNonNull(gVar);
        cc ccVar = new cc();
        gVar.e.execute(new x(gVar, ccVar));
        return ccVar.i(500L);
    }

    @Override // b.i.a.f.i.b.b7
    public final String c() {
        g gVar = this.a;
        Objects.requireNonNull(gVar);
        cc ccVar = new cc();
        gVar.e.execute(new r(gVar, ccVar));
        return ccVar.i(50L);
    }

    @Override // b.i.a.f.i.b.b7
    public final String d() {
        g gVar = this.a;
        Objects.requireNonNull(gVar);
        cc ccVar = new cc();
        gVar.e.execute(new s(gVar, ccVar));
        return ccVar.i(500L);
    }

    @Override // b.i.a.f.i.b.b7
    public final long e() {
        g gVar = this.a;
        Objects.requireNonNull(gVar);
        cc ccVar = new cc();
        gVar.e.execute(new u(gVar, ccVar));
        Long l = (Long) cc.g(ccVar.t0(500L), Long.class);
        if (l != null) {
            return l.longValue();
        }
        long jNanoTime = System.nanoTime();
        Objects.requireNonNull((c) gVar.d);
        long jNextLong = new Random(jNanoTime ^ System.currentTimeMillis()).nextLong();
        int i = gVar.h + 1;
        gVar.h = i;
        return jNextLong + ((long) i);
    }

    @Override // b.i.a.f.i.b.b7
    public final void f(Bundle bundle) {
        g gVar = this.a;
        Objects.requireNonNull(gVar);
        gVar.e.execute(new i(gVar, bundle));
    }

    @Override // b.i.a.f.i.b.b7
    public final void g(String str) {
        g gVar = this.a;
        Objects.requireNonNull(gVar);
        gVar.e.execute(new q(gVar, str));
    }

    @Override // b.i.a.f.i.b.b7
    public final List<Bundle> h(String str, String str2) {
        g gVar = this.a;
        Objects.requireNonNull(gVar);
        cc ccVar = new cc();
        gVar.e.execute(new k(gVar, str, str2, ccVar));
        List<Bundle> list = (List) cc.g(ccVar.t0(5000L), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    @Override // b.i.a.f.i.b.b7
    public final int i(String str) {
        g gVar = this.a;
        Objects.requireNonNull(gVar);
        cc ccVar = new cc();
        gVar.e.execute(new z(gVar, str, ccVar));
        Integer num = (Integer) cc.g(ccVar.t0(10000L), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    @Override // b.i.a.f.i.b.b7
    public final void j(String str) {
        g gVar = this.a;
        Objects.requireNonNull(gVar);
        gVar.e.execute(new p(gVar, str));
    }

    @Override // b.i.a.f.i.b.b7
    public final Map<String, Object> k(String str, String str2, boolean z2) {
        g gVar = this.a;
        Objects.requireNonNull(gVar);
        cc ccVar = new cc();
        gVar.e.execute(new w(gVar, str, str2, z2, ccVar));
        Bundle bundleT0 = ccVar.t0(5000L);
        if (bundleT0 == null || bundleT0.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap map = new HashMap(bundleT0.size());
        for (String str3 : bundleT0.keySet()) {
            Object obj = bundleT0.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                map.put(str3, obj);
            }
        }
        return map;
    }

    @Override // b.i.a.f.i.b.b7
    public final void l(String str, String str2, Bundle bundle) {
        g gVar = this.a;
        Objects.requireNonNull(gVar);
        gVar.e.execute(new l(gVar, str, str2, bundle));
    }

    @Override // b.i.a.f.i.b.b7
    public final void m(String str, String str2, Bundle bundle) {
        this.a.c(str, str2, bundle, true, true, null);
    }
}
