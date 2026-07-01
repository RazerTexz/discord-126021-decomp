package b.g.a.c.c0;

import b.d.b.a.outline;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: b.g.a.c.c0.y, reason: use source file name */
/* JADX INFO: compiled from: MemberKey.java */
/* JADX INFO: loaded from: classes3.dex */
public final class MemberKey {
    public static final Class<?>[] a = new Class[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f696b;
    public final Class<?>[] c;

    public MemberKey(Method method) {
        String name = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        this.f696b = name;
        this.c = parameterTypes == null ? a : parameterTypes;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != MemberKey.class) {
            return false;
        }
        MemberKey memberKey = (MemberKey) obj;
        if (!this.f696b.equals(memberKey.f696b)) {
            return false;
        }
        Class<?>[] clsArr = memberKey.c;
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
        return outline.B(sb, this.c.length, "-args)");
    }

    public MemberKey(Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        this.f696b = "";
        this.c = parameterTypes == null ? a : parameterTypes;
    }
}
