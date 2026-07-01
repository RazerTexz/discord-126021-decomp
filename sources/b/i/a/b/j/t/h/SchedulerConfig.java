package b.i.a.b.j.t.h;

import b.i.a.b.Priority3;
import b.i.a.b.j.t.h.AutoValue_SchedulerConfig_ConfigValue;
import b.i.a.b.j.v.Clock3;
import com.google.auto.value.AutoValue;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: renamed from: b.i.a.b.j.t.h.f, reason: use source file name */
/* JADX INFO: compiled from: SchedulerConfig.java */
/* JADX INFO: loaded from: classes3.dex */
@AutoValue
public abstract class SchedulerConfig {

    /* JADX INFO: renamed from: b.i.a.b.j.t.h.f$a */
    /* JADX INFO: compiled from: SchedulerConfig.java */
    @AutoValue
    public static abstract class a {

        /* JADX INFO: renamed from: b.i.a.b.j.t.h.f$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SchedulerConfig.java */
        @AutoValue.Builder
        public static abstract class AbstractC0026a {
            public abstract a a();

            public abstract AbstractC0026a b(long j);

            public abstract AbstractC0026a c(long j);
        }

        public static AbstractC0026a a() {
            AutoValue_SchedulerConfig_ConfigValue.b bVar = new AutoValue_SchedulerConfig_ConfigValue.b();
            Set<b> setEmptySet = Collections.emptySet();
            Objects.requireNonNull(setEmptySet, "Null flags");
            bVar.c = setEmptySet;
            return bVar;
        }

        public abstract long b();

        public abstract Set<b> c();

        public abstract long d();
    }

    /* JADX INFO: renamed from: b.i.a.b.j.t.h.f$b */
    /* JADX INFO: compiled from: SchedulerConfig.java */
    public enum b {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    public abstract Clock3 a();

    public long b(Priority3 priority3, long j, int i) {
        long jA = j - a().a();
        a aVar = c().get(priority3);
        long jB = aVar.b();
        int i2 = i - 1;
        return Math.min(Math.max((long) (Math.pow(3.0d, i2) * jB * Math.max(1.0d, Math.log(10000.0d) / Math.log((jB > 1 ? jB : 2L) * ((long) i2)))), jA), aVar.d());
    }

    public abstract Map<Priority3, a> c();
}
