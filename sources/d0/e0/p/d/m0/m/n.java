package d0.e0.p.d.m0.m;

import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: storage.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n {
    public static final <T> T getValue(j<? extends T> jVar, Object obj, KProperty<?> kProperty) {
        d0.z.d.m.checkNotNullParameter(jVar, "<this>");
        d0.z.d.m.checkNotNullParameter(kProperty, "p");
        return jVar.invoke();
    }

    public static final <T> T getValue(k<? extends T> kVar, Object obj, KProperty<?> kProperty) {
        d0.z.d.m.checkNotNullParameter(kVar, "<this>");
        d0.z.d.m.checkNotNullParameter(kProperty, "p");
        return kVar.invoke();
    }
}
