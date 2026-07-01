package b.i.a.b.j.t.h;

import com.google.auto.value.AutoValue;
import java.util.Map;

/* JADX INFO: compiled from: SchedulerConfig.java */
/* JADX INFO: loaded from: classes3.dex */
@AutoValue
public abstract class f {
    public abstract b.i.a.b.j.v.a a();

    public long b(b.i.a.b.d dVar, long j, int i) {
        long jA = j - a().a();
        f$a f_a = c().get(dVar);
        long jB = f_a.b();
        int i2 = i - 1;
        return Math.min(Math.max((long) (Math.pow(3.0d, i2) * jB * Math.max(1.0d, Math.log(10000.0d) / Math.log((jB > 1 ? jB : 2L) * ((long) i2)))), jA), f_a.d());
    }

    public abstract Map<b.i.a.b.d, f$a> c();
}
