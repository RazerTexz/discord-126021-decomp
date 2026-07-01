package b.i.a.b.j.t.h;

import com.google.auto.value.AutoValue;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: SchedulerConfig.java */
/* JADX INFO: loaded from: classes3.dex */
@AutoValue
public abstract class f$a {
    public static f$a$a a() {
        c$b c_b = new c$b();
        Set<f$b> setEmptySet = Collections.emptySet();
        Objects.requireNonNull(setEmptySet, "Null flags");
        c_b.c = setEmptySet;
        return c_b;
    }

    public abstract long b();

    public abstract Set<f$b> c();

    public abstract long d();
}
