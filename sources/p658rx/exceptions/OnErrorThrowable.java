package p658rx.exceptions;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import p007b.p100d.p104b.p105a.C1643a;
import p637j0.p652o.C12777o;

/* JADX INFO: loaded from: classes3.dex */
public final class OnErrorThrowable extends RuntimeException {
    private static final long serialVersionUID = -569558213262703934L;
    private final boolean hasValue;
    private final Object value;

    public static class OnNextValue extends RuntimeException {
        private static final long serialVersionUID = -3454462756050397899L;
        private final Object value;

        /* JADX INFO: renamed from: rx.exceptions.OnErrorThrowable$OnNextValue$a */
        public static final class C13013a {

            /* JADX INFO: renamed from: a */
            public static final Set<Class<?>> f27643a;

            static {
                HashSet hashSet = new HashSet();
                hashSet.add(Boolean.class);
                hashSet.add(Character.class);
                hashSet.add(Byte.class);
                hashSet.add(Short.class);
                hashSet.add(Integer.class);
                hashSet.add(Long.class);
                hashSet.add(Float.class);
                hashSet.add(Double.class);
                f27643a = hashSet;
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public OnNextValue(Object obj) {
            String strName;
            StringBuilder sbM833U = C1643a.m833U("OnError while emitting onNext value: ");
            if (obj == null) {
                strName = "null";
            } else if (C13013a.f27643a.contains(obj.getClass())) {
                strName = obj.toString();
            } else if (obj instanceof String) {
                strName = (String) obj;
            } else if (obj instanceof Enum) {
                strName = ((Enum) obj).name();
            } else {
                Objects.requireNonNull(C12777o.f27384a.m10869b());
                strName = obj.getClass().getName() + ".class";
            }
            sbM833U.append(strName);
            super(sbM833U.toString());
            if (!(obj instanceof Serializable)) {
                try {
                    obj = String.valueOf(obj);
                } catch (Throwable th) {
                    obj = th.getMessage();
                }
            }
            this.value = obj;
        }

        /* JADX INFO: renamed from: a */
        public Object m11127a() {
            return this.value;
        }
    }

    /* JADX INFO: renamed from: a */
    public static Throwable m11126a(Throwable th, Object obj) {
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
        if ((runtimeException instanceof OnNextValue) && ((OnNextValue) runtimeException).m11127a() == obj) {
            return th;
        }
        OnNextValue onNextValue = new OnNextValue(obj);
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
            cause.initCause(onNextValue);
        } catch (Throwable unused) {
        }
        return th;
    }
}
