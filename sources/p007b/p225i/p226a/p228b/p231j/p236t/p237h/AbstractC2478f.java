package p007b.p225i.p226a.p228b.p231j.p236t.p237h;

import com.google.auto.value.AutoValue;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import p007b.p225i.p226a.p228b.EnumC2409d;
import p007b.p225i.p226a.p228b.p231j.p240v.InterfaceC2519a;

/* JADX INFO: renamed from: b.i.a.b.j.t.h.f */
/* JADX INFO: compiled from: SchedulerConfig.java */
/* JADX INFO: loaded from: classes3.dex */
@AutoValue
public abstract class AbstractC2478f {

    /* JADX INFO: renamed from: b.i.a.b.j.t.h.f$a */
    /* JADX INFO: compiled from: SchedulerConfig.java */
    @AutoValue
    public static abstract class a {

        /* JADX INFO: renamed from: b.i.a.b.j.t.h.f$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SchedulerConfig.java */
        @AutoValue.Builder
        public static abstract class AbstractC13221a {
            /* JADX INFO: renamed from: a */
            public abstract a mo2379a();

            /* JADX INFO: renamed from: b */
            public abstract AbstractC13221a mo2380b(long j);

            /* JADX INFO: renamed from: c */
            public abstract AbstractC13221a mo2381c(long j);
        }

        /* JADX INFO: renamed from: a */
        public static AbstractC13221a m2384a() {
            C2475c.b bVar = new C2475c.b();
            Set<b> setEmptySet = Collections.emptySet();
            Objects.requireNonNull(setEmptySet, "Null flags");
            bVar.f5360c = setEmptySet;
            return bVar;
        }

        /* JADX INFO: renamed from: b */
        public abstract long mo2376b();

        /* JADX INFO: renamed from: c */
        public abstract Set<b> mo2377c();

        /* JADX INFO: renamed from: d */
        public abstract long mo2378d();
    }

    /* JADX INFO: renamed from: b.i.a.b.j.t.h.f$b */
    /* JADX INFO: compiled from: SchedulerConfig.java */
    public enum b {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    /* JADX INFO: renamed from: a */
    public abstract InterfaceC2519a mo2374a();

    /* JADX INFO: renamed from: b */
    public long m2383b(EnumC2409d enumC2409d, long j, int i) {
        long jMo2413a = j - mo2374a().mo2413a();
        a aVar = mo2375c().get(enumC2409d);
        long jMo2376b = aVar.mo2376b();
        int i2 = i - 1;
        return Math.min(Math.max((long) (Math.pow(3.0d, i2) * jMo2376b * Math.max(1.0d, Math.log(10000.0d) / Math.log((jMo2376b > 1 ? jMo2376b : 2L) * ((long) i2)))), jMo2413a), aVar.mo2378d());
    }

    /* JADX INFO: renamed from: c */
    public abstract Map<EnumC2409d, a> mo2375c();
}
