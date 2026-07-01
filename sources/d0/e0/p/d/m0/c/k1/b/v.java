package d0.e0.p.d.m0.c.k1.b;

import java.lang.reflect.Type;
import java.util.Collection;

/* JADX INFO: compiled from: ReflectJavaPrimitiveType.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class v extends w implements d0.e0.p.d.m0.e.a.k0.v {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<?> f3295b;
    public final Collection<d0.e0.p.d.m0.e.a.k0.a> c;

    public v(Class<?> cls) {
        d0.z.d.m.checkNotNullParameter(cls, "reflectType");
        this.f3295b = cls;
        this.c = d0.t.n.emptyList();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public Collection<d0.e0.p.d.m0.e.a.k0.a> getAnnotations() {
        return this.c;
    }

    @Override // d0.e0.p.d.m0.c.k1.b.w
    public Type getReflectType() {
        return this.f3295b;
    }

    @Override // d0.e0.p.d.m0.e.a.k0.v
    public d0.e0.p.d.m0.b.i getType() {
        if (d0.z.d.m.areEqual(this.f3295b, Void.TYPE)) {
            return null;
        }
        return d0.e0.p.d.m0.k.y.d.get(this.f3295b.getName()).getPrimitiveType();
    }

    @Override // d0.e0.p.d.m0.e.a.k0.d
    public boolean isDeprecatedInJavaDoc() {
        return false;
    }
}
