package d0.e0.p.d.m0.p;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: functions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public static final Function1<Object, Boolean> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Function3<Object, Object, Object, Unit> f3562b;

    static {
        d$f d_f = d$f.j;
        a = d$b.j;
        d$a d_a = d$a.j;
        d$c d_c = d$c.j;
        d$d d_d = d$d.j;
        f3562b = d$e.j;
    }

    public static final <T> Function1<T, Boolean> alwaysTrue() {
        return (Function1<T, Boolean>) a;
    }

    public static final Function3<Object, Object, Object, Unit> getDO_NOTHING_3() {
        return f3562b;
    }
}
