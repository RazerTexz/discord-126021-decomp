package p507d0;

import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.g */
/* JADX INFO: compiled from: LazyJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12083g {
    public static final <T> Lazy<T> lazy(Function0<? extends T> function0) {
        C12238m.checkNotNullParameter(function0, "initializer");
        DefaultConstructorMarker defaultConstructorMarker = null;
        return new C12115n(function0, defaultConstructorMarker, 2, defaultConstructorMarker);
    }

    public static final <T> Lazy<T> lazy(EnumC12110i enumC12110i, Function0<? extends T> function0) {
        C12238m.checkNotNullParameter(enumC12110i, "mode");
        C12238m.checkNotNullParameter(function0, "initializer");
        int iOrdinal = enumC12110i.ordinal();
        int i = 2;
        if (iOrdinal == 0) {
            DefaultConstructorMarker defaultConstructorMarker = null;
            return new C12115n(function0, defaultConstructorMarker, i, defaultConstructorMarker);
        }
        if (iOrdinal == 1) {
            return new C12114m(function0);
        }
        if (iOrdinal == 2) {
            return new C12120s(function0);
        }
        throw new NoWhenBranchMatchedException();
    }
}
