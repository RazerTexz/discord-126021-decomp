package b.i.a.b.j.t;

import b.i.a.b.Priority3;
import b.i.a.b.j.t.h.AutoValue_SchedulerConfig;
import b.i.a.b.j.t.h.AutoValue_SchedulerConfig_ConfigValue;
import b.i.a.b.j.t.h.SchedulerConfig;
import b.i.a.b.j.v.Clock3;
import c0.a.Provider3;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: renamed from: b.i.a.b.j.t.f, reason: use source file name */
/* JADX INFO: compiled from: SchedulingConfigModule_ConfigFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SchedulingConfigModule_ConfigFactory implements Provider3 {
    public final Provider3<Clock3> a;

    public SchedulingConfigModule_ConfigFactory(Provider3<Clock3> provider3) {
        this.a = provider3;
    }

    @Override // c0.a.Provider3
    public Object get() {
        Clock3 clock3 = this.a.get();
        HashMap map = new HashMap();
        Priority3 priority3 = Priority3.DEFAULT;
        SchedulerConfig.a.AbstractC0026a abstractC0026aA = SchedulerConfig.a.a();
        abstractC0026aA.b(30000L);
        abstractC0026aA.c(86400000L);
        map.put(priority3, abstractC0026aA.a());
        Priority3 priority4 = Priority3.HIGHEST;
        SchedulerConfig.a.AbstractC0026a abstractC0026aA2 = SchedulerConfig.a.a();
        abstractC0026aA2.b(1000L);
        abstractC0026aA2.c(86400000L);
        map.put(priority4, abstractC0026aA2.a());
        Priority3 priority5 = Priority3.VERY_LOW;
        SchedulerConfig.a.AbstractC0026a abstractC0026aA3 = SchedulerConfig.a.a();
        abstractC0026aA3.b(86400000L);
        abstractC0026aA3.c(86400000L);
        Set<SchedulerConfig.b> setUnmodifiableSet = Collections.unmodifiableSet(new HashSet(Arrays.asList(SchedulerConfig.b.NETWORK_UNMETERED, SchedulerConfig.b.DEVICE_IDLE)));
        AutoValue_SchedulerConfig_ConfigValue.b bVar = (AutoValue_SchedulerConfig_ConfigValue.b) abstractC0026aA3;
        Objects.requireNonNull(setUnmodifiableSet, "Null flags");
        bVar.c = setUnmodifiableSet;
        map.put(priority5, bVar.a());
        Objects.requireNonNull(clock3, "missing required property: clock");
        int size = map.keySet().size();
        Priority3.values();
        if (size < 3) {
            throw new IllegalStateException("Not all priorities have been configured");
        }
        new HashMap();
        return new AutoValue_SchedulerConfig(clock3, map);
    }
}
