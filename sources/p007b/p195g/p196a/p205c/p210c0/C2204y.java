package p007b.p195g.p196a.p205c.p210c0;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.g.a.c.c0.y */
/* JADX INFO: compiled from: MemberKey.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2204y {

    /* JADX INFO: renamed from: a */
    public static final Class<?>[] f4761a = new Class[0];

    /* JADX INFO: renamed from: b */
    public final String f4762b;

    /* JADX INFO: renamed from: c */
    public final Class<?>[] f4763c;

    public C2204y(Method method) {
        String name = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        this.f4762b = name;
        this.f4763c = parameterTypes == null ? f4761a : parameterTypes;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != C2204y.class) {
            return false;
        }
        C2204y c2204y = (C2204y) obj;
        if (!this.f4762b.equals(c2204y.f4762b)) {
            return false;
        }
        Class<?>[] clsArr = c2204y.f4763c;
        int length = this.f4763c.length;
        if (clsArr.length != length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (clsArr[i] != this.f4763c[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        return this.f4762b.hashCode() + this.f4763c.length;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f4762b);
        sb.append("(");
        return C1643a.m814B(sb, this.f4763c.length, "-args)");
    }

    public C2204y(Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        this.f4762b = "";
        this.f4763c = parameterTypes == null ? f4761a : parameterTypes;
    }
}
