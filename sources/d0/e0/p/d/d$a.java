package d0.e0.p.d;

import java.lang.reflect.Method;
import java.util.List;

/* JADX INFO: compiled from: RuntimeTypeMapper.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d$a extends d {
    public final List<Method> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<?> f3191b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d$a(Class<?> cls) {
        super(null);
        d0.z.d.m.checkNotNullParameter(cls, "jClass");
        this.f3191b = cls;
        Method[] declaredMethods = cls.getDeclaredMethods();
        d0.z.d.m.checkNotNullExpressionValue(declaredMethods, "jClass.declaredMethods");
        this.a = d0.t.k.sortedWith(declaredMethods, new d$a$a());
    }

    @Override // d0.e0.p.d.d
    public String asString() {
        return d0.t.u.joinToString$default(this.a, "", "<init>(", ")V", 0, null, d$a$b.j, 24, null);
    }

    public final List<Method> getMethods() {
        return this.a;
    }
}
