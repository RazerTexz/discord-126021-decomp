package b.g.a.c.c0;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: MemberKey.java */
/* JADX INFO: loaded from: classes3.dex */
public final class y {
    public static final Class<?>[] a = new Class[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f696b;
    public final Class<?>[] c;

    public y(Method method) {
        String name = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        this.f696b = name;
        this.c = parameterTypes == null ? a : parameterTypes;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != y.class) {
            return false;
        }
        y yVar = (y) obj;
        if (!this.f696b.equals(yVar.f696b)) {
            return false;
        }
        Class<?>[] clsArr = yVar.c;
        int length = this.c.length;
        if (clsArr.length != length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (clsArr[i] != this.c[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return this.f696b.hashCode() + this.c.length;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f696b);
        sb.append("(");
        return b.d.b.a.a.B(sb, this.c.length, "-args)");
    }

    public y(Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        this.f696b = "";
        this.c = parameterTypes == null ? a : parameterTypes;
    }
}
