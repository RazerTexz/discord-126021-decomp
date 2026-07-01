package b.g.a.c.i0;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;

/* JADX INFO: compiled from: ClassUtil.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d$a {
    public final Constructor<?> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient Annotation[] f727b;
    public transient Annotation[][] c;
    public int d = -1;

    public d$a(Constructor<?> constructor) {
        this.a = constructor;
    }

    public int a() {
        int i = this.d;
        if (i >= 0) {
            return i;
        }
        int length = this.a.getParameterTypes().length;
        this.d = length;
        return length;
    }
}
