package kotlin.reflect.jvm.internal.impl.utils;

import p507d0.p513e0.p514p.p515d.p517m0.p576p.C12035c;

/* JADX INFO: loaded from: classes3.dex */
public class WrappedValues {

    /* JADX INFO: renamed from: a */
    public static final Object f27450a = new C12795a();

    public static class WrappedProcessCanceledException extends RuntimeException {
    }

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.utils.WrappedValues$a */
    public static class C12795a {
        public String toString() {
            return "NULL_VALUE";
        }
    }

    /* JADX INFO: renamed from: kotlin.reflect.jvm.internal.impl.utils.WrappedValues$b */
    public static final class C12796b {

        /* JADX INFO: renamed from: a */
        public final Throwable f27451a;

        public C12796b(Throwable th, C12795a c12795a) {
            if (th != null) {
                this.f27451a = th;
            } else {
                m10899a(0);
                throw null;
            }
        }

        /* JADX INFO: renamed from: a */
        public static /* synthetic */ void m10899a(int i) {
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
            Throwable th = this.f27451a;
            if (th != null) {
                return th;
            }
            m10899a(1);
            throw null;
        }

        public String toString() {
            return this.f27451a.toString();
        }
    }

    /* JADX INFO: renamed from: a */
    public static /* synthetic */ void m10898a(int i) {
        String str = (i == 1 || i == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 2) ? 2 : 3];
        if (i == 1 || i == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
        } else if (i != 3) {
            objArr[0] = "value";
        } else {
            objArr[0] = "throwable";
        }
        if (i == 1 || i == 2) {
            objArr[1] = "escapeNull";
        } else {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/utils/WrappedValues";
        }
        if (i != 1 && i != 2) {
            if (i == 3) {
                objArr[2] = "escapeThrowable";
            } else if (i != 4) {
                objArr[2] = "unescapeNull";
            } else {
                objArr[2] = "unescapeExceptionOrNull";
            }
        }
        String str2 = String.format(str, objArr);
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    public static <V> Object escapeNull(V v) {
        return v == null ? f27450a : v;
    }

    public static Object escapeThrowable(Throwable th) {
        if (th != null) {
            return new C12796b(th, null);
        }
        m10898a(3);
        throw null;
    }

    public static <V> V unescapeExceptionOrNull(Object obj) {
        if (obj != null) {
            return (V) unescapeNull(unescapeThrowable(obj));
        }
        m10898a(4);
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <V> V unescapeNull(Object obj) {
        if (obj == 0) {
            m10898a(0);
            throw null;
        }
        if (obj == f27450a) {
            return null;
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <V> V unescapeThrowable(Object obj) {
        if (obj instanceof C12796b) {
            throw C12035c.rethrow(((C12796b) obj).getThrowable());
        }
        return obj;
    }
}
