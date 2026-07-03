package kotlin.reflect.full;

import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: exceptions.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class IllegalPropertyDelegateAccessException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IllegalPropertyDelegateAccessException(IllegalAccessException illegalAccessException) {
        super("Cannot obtain the delegate of a non-accessible property. Use \"isAccessible = true\" to make the property accessible", illegalAccessException);
        C12238m.checkNotNullParameter(illegalAccessException, "cause");
    }
}
