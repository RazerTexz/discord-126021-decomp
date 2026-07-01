package kotlin.reflect.full;

import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: kotlin.reflect.full.IllegalPropertyDelegateAccessException, reason: use source file name */
/* JADX INFO: compiled from: exceptions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class exceptions2 extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public exceptions2(IllegalAccessException illegalAccessException) {
        super("Cannot obtain the delegate of a non-accessible property. Use \"isAccessible = true\" to make the property accessible", illegalAccessException);
        Intrinsics3.checkNotNullParameter(illegalAccessException, "cause");
    }
}
