package d0.e0.p.d.m0.b;

import d0.g0.t;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: ReflectionTypes.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j$a {
    public final int a;

    public j$a(int i) {
        this.a = i;
    }

    public final d0.e0.p.d.m0.c.e getValue(j jVar, KProperty<?> kProperty) {
        d0.z.d.m.checkNotNullParameter(jVar, "types");
        d0.z.d.m.checkNotNullParameter(kProperty, "property");
        return j.access$find(jVar, t.capitalize(kProperty.getName()), this.a);
    }
}
