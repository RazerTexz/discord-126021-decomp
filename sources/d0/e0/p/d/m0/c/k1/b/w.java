package d0.e0.p.d.m0.c.k1.b;

import d0.e0.p.d.m0.e.a.k0.x$a;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: ReflectJavaType.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class w implements d0.e0.p.d.m0.e.a.k0.x {
    public static final w$a a = new w$a(null);

    public boolean equals(Object obj) {
        return (obj instanceof w) && d0.z.d.m.areEqual(getReflectType(), ((w) obj).getReflectType());
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public d0.e0.p.d.m0.e.a.k0.a findAnnotation(d0.e0.p.d.m0.g.b bVar) {
        return x$a.findAnnotation(this, bVar);
    }

    public abstract Type getReflectType();

    public int hashCode() {
        return getReflectType().hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + getReflectType();
    }
}
