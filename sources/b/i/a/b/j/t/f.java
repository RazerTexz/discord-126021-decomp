package b.i.a.b.j.t;

import b.i.a.b.j.t.h.c$b;
import b.i.a.b.j.t.h.f$a;
import b.i.a.b.j.t.h.f$a$a;
import b.i.a.b.j.t.h.f$b;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: SchedulingConfigModule_ConfigFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements c0.a.a {
    public final c0.a.a<b.i.a.b.j.v.a> a;

    public f(c0.a.a<b.i.a.b.j.v.a> aVar) {
        this.a = aVar;
    }

    @Override // c0.a.a
    public Object get() {
        b.i.a.b.j.v.a aVar = this.a.get();
        HashMap map = new HashMap();
        b.i.a.b.d dVar = b.i.a.b.d.DEFAULT;
        f$a$a f_a_aA = f$a.a();
        f_a_aA.b(30000L);
        f_a_aA.c(86400000L);
        map.put(dVar, f_a_aA.a());
        b.i.a.b.d dVar2 = b.i.a.b.d.HIGHEST;
        f$a$a f_a_aA2 = f$a.a();
        f_a_aA2.b(1000L);
        f_a_aA2.c(86400000L);
        map.put(dVar2, f_a_aA2.a());
        b.i.a.b.d dVar3 = b.i.a.b.d.VERY_LOW;
        f$a$a f_a_aA3 = f$a.a();
        f_a_aA3.b(86400000L);
        f_a_aA3.c(86400000L);
        Set<f$b> setUnmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(f$b.NETWORK_UNMETERED, f$b.DEVICE_IDLE)));
        c$b c_b = (c$b) f_a_aA3;
        Objects.requireNonNull(setUnmodifiableSet, "Null flags");
        c_b.c = setUnmodifiableSet;
        map.put(dVar3, c_b.a());
        Objects.requireNonNull(aVar, "missing required property: clock");
        int size = map.keySet().size();
        b.i.a.b.d.values();
        if (size < 3) {
            throw new IllegalStateException("Not all priorities have been configured");
        }
        new HashMap();
        return new b.i.a.b.j.t.h.b(aVar, map);
    }
}
