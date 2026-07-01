package d0;

import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: LazyJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public class g {
    public static final <T> Lazy<T> lazy(Function0<? extends T> function0) {
        d0.z.d.m.checkNotNullParameter(function0, "initializer");
        return new n(function0, null, 2, null);
    }

    public static final <T> Lazy<T> lazy(i iVar, Function0<? extends T> function0) {
        d0.z.d.m.checkNotNullParameter(iVar, "mode");
        d0.z.d.m.checkNotNullParameter(function0, "initializer");
        int iOrdinal = iVar.ordinal();
        if (iOrdinal == 0) {
            return new n(function0, null, 2, null);
        }
        if (iOrdinal == 1) {
            return new m(function0);
        }
        if (iOrdinal == 2) {
            return new s(function0);
        }
        throw new NoWhenBranchMatchedException();
    }
}
