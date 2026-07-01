package d0.e0.p.d.m0.m;

import d0.z.d.Intrinsics3;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: d0.e0.p.d.m0.m.n, reason: use source file name */
/* JADX INFO: compiled from: storage.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class storage7 {
    public static final <T> T getValue(storage5<? extends T> storage5Var, Object obj, KProperty<?> kProperty) {
        Intrinsics3.checkNotNullParameter(storage5Var, "<this>");
        Intrinsics3.checkNotNullParameter(kProperty, "p");
        return storage5Var.invoke();
    }

    public static final <T> T getValue(storage6<? extends T> storage6Var, Object obj, KProperty<?> kProperty) {
        Intrinsics3.checkNotNullParameter(storage6Var, "<this>");
        Intrinsics3.checkNotNullParameter(kProperty, "p");
        return storage6Var.invoke();
    }
}
