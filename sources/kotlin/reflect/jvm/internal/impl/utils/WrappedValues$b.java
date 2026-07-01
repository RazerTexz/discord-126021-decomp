package kotlin.reflect.jvm.internal.impl.utils;

/* JADX INFO: loaded from: classes3.dex */
public final class WrappedValues$b {
    public final Throwable a;

    public WrappedValues$b(Throwable th, WrappedValues$a wrappedValues$a) {
        if (th != null) {
            this.a = th;
        } else {
            a(0);
            throw null;
        }
    }

    public static /* synthetic */ void a(int i) {
        String str = i != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i != 1 ? 3 : 2];
        if (i != 1) {
            objArr[0] = "throwable";
        } else {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
        }
        if (i != 1) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues$ThrowableWrapper";
        } else {
            objArr[1] = "getThrowable";
        }
        if (i != 1) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i == 1) {
            throw new IllegalStateException(str2);
        }
    }

    public Throwable getThrowable() {
        Throwable th = this.a;
        if (th != null) {
            return th;
        }
        a(1);
        throw null;
    }

    public String toString() {
        return this.a.toString();
    }
}
