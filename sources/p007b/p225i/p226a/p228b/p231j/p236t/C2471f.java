package p007b.p225i.p226a.p228b.p231j.p236t;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import p007b.p225i.p226a.p228b.EnumC2409d;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.AbstractC2478f;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.C2474b;
import p007b.p225i.p226a.p228b.p231j.p236t.p237h.C2475c;
import p007b.p225i.p226a.p228b.p231j.p240v.InterfaceC2519a;
import p496c0.p497a.InterfaceC5318a;

/* JADX INFO: renamed from: b.i.a.b.j.t.f */
/* JADX INFO: compiled from: SchedulingConfigModule_ConfigFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2471f implements InterfaceC5318a {

    /* JADX INFO: renamed from: a */
    public final InterfaceC5318a<InterfaceC2519a> f5347a;

    public C2471f(InterfaceC5318a<InterfaceC2519a> interfaceC5318a) {
        this.f5347a = interfaceC5318a;
    }

    @Override // p496c0.p497a.InterfaceC5318a
    public Object get() {
        InterfaceC2519a interfaceC2519a = this.f5347a.get();
        HashMap map = new HashMap();
        EnumC2409d enumC2409d = EnumC2409d.DEFAULT;
        AbstractC2478f.a.AbstractC13221a abstractC13221aM2384a = AbstractC2478f.a.m2384a();
        abstractC13221aM2384a.mo2380b(30000L);
        abstractC13221aM2384a.mo2381c(86400000L);
        map.put(enumC2409d, abstractC13221aM2384a.mo2379a());
        EnumC2409d enumC2409d2 = EnumC2409d.HIGHEST;
        AbstractC2478f.a.AbstractC13221a abstractC13221aM2384a2 = AbstractC2478f.a.m2384a();
        abstractC13221aM2384a2.mo2380b(1000L);
        abstractC13221aM2384a2.mo2381c(86400000L);
        map.put(enumC2409d2, abstractC13221aM2384a2.mo2379a());
        EnumC2409d enumC2409d3 = EnumC2409d.VERY_LOW;
        AbstractC2478f.a.AbstractC13221a abstractC13221aM2384a3 = AbstractC2478f.a.m2384a();
        abstractC13221aM2384a3.mo2380b(86400000L);
        abstractC13221aM2384a3.mo2381c(86400000L);
        Set<AbstractC2478f.b> setUnmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(AbstractC2478f.b.NETWORK_UNMETERED, AbstractC2478f.b.DEVICE_IDLE)));
        C2475c.b bVar = (C2475c.b) abstractC13221aM2384a3;
        Objects.requireNonNull(setUnmodifiableSet, "Null flags");
        bVar.f5360c = setUnmodifiableSet;
        map.put(enumC2409d3, bVar.mo2379a());
        Objects.requireNonNull(interfaceC2519a, "missing required property: clock");
        int size = map.keySet().size();
        EnumC2409d.values();
        if (size < 3) {
            throw new IllegalStateException("Not all priorities have been configured");
        }
        new HashMap();
        return new C2474b(interfaceC2519a, map);
    }
}
