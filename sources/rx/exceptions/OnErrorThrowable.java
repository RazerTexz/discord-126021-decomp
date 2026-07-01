package rx.exceptions;

import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public final class OnErrorThrowable extends RuntimeException {
    private static final long serialVersionUID = -569558213262703934L;
    private final boolean hasValue;
    private final Object value;

    public static Throwable a(Throwable th, Object obj) {
        if (th == null) {
            th = new NullPointerException();
        }
        int i = 0;
        int i2 = 0;
        Throwable runtimeException = th;
        while (runtimeException.getCause() != null) {
            int i3 = i2 + 1;
            if (i2 >= 25) {
                runtimeException = new RuntimeException("Stack too deep to get final cause");
                break;
            }
            runtimeException = runtimeException.getCause();
            i2 = i3;
        }
        if ((runtimeException instanceof OnErrorThrowable$OnNextValue) && ((OnErrorThrowable$OnNextValue) runtimeException).a() == obj) {
            return th;
        }
        OnErrorThrowable$OnNextValue onErrorThrowable$OnNextValue = new OnErrorThrowable$OnNextValue(obj);
        HashSet hashSet = new HashSet();
        Throwable cause = th;
        try {
            while (cause.getCause() != null) {
                int i4 = i + 1;
                if (i < 25) {
                    cause = cause.getCause();
                    if (hashSet.contains(cause.getCause())) {
                        break;
                    }
                    hashSet.add(cause.getCause());
                    i = i4;
                }
                return th;
            }
            cause.initCause(onErrorThrowable$OnNextValue);
        } catch (Throwable unused) {
        }
        return th;
    }
}
