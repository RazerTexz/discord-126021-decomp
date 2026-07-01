package kotlin.reflect.full;

import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: kotlin.reflect.full.IllegalCallableAccessException, reason: use source file name */
/* JADX INFO: compiled from: exceptions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class exceptions extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public exceptions(IllegalAccessException illegalAccessException) {
        super(illegalAccessException);
        Intrinsics3.checkNotNullParameter(illegalAccessException, "cause");
    }
}
