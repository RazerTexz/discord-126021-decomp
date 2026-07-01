package d0.e0.p.d.m0.c.g1;

import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.n.c0;
import java.util.Map;

/* JADX INFO: compiled from: AnnotationDescriptorImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class d implements c {
    public final c0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<d0.e0.p.d.m0.g.e, d0.e0.p.d.m0.k.v.g<?>> f3248b;
    public final u0 c;

    public d(c0 c0Var, Map<d0.e0.p.d.m0.g.e, d0.e0.p.d.m0.k.v.g<?>> map, u0 u0Var) {
        if (c0Var == null) {
            a(0);
            throw null;
        }
        if (map == null) {
            a(1);
            throw null;
        }
        if (u0Var == null) {
            a(2);
            throw null;
        }
        this.a = c0Var;
        this.f3248b = map;
        this.c = u0Var;
    }

    public static /* synthetic */ void a(int i) {
        String str = (i == 3 || i == 4 || i == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 3 || i == 4 || i == 5) ? 2 : 3];
        if (i == 1) {
            objArr[0] = "valueArguments";
        } else if (i == 2) {
            objArr[0] = "source";
        } else if (i == 3 || i == 4 || i == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[0] = "annotationType";
        }
        if (i == 3) {
            objArr[1] = "getType";
        } else if (i == 4) {
            objArr[1] = "getAllValueArguments";
        } else if (i != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (i != 3 && i != 4 && i != 5) {
            objArr[2] = "<init>";
        }
        String str2 = String.format(str, objArr);
        if (i != 3 && i != 4 && i != 5) {
            throw new IllegalArgumentException(str2);
        }
        throw new IllegalStateException(str2);
    }

    @Override // d0.e0.p.d.m0.c.g1.c
    public Map<d0.e0.p.d.m0.g.e, d0.e0.p.d.m0.k.v.g<?>> getAllValueArguments() {
        Map<d0.e0.p.d.m0.g.e, d0.e0.p.d.m0.k.v.g<?>> map = this.f3248b;
        if (map != null) {
            return map;
        }
        a(4);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.g1.c
    public d0.e0.p.d.m0.g.b getFqName() {
        return c$a.getFqName(this);
    }

    @Override // d0.e0.p.d.m0.c.g1.c
    public u0 getSource() {
        u0 u0Var = this.c;
        if (u0Var != null) {
            return u0Var;
        }
        a(5);
        throw null;
    }

    @Override // d0.e0.p.d.m0.c.g1.c
    public c0 getType() {
        c0 c0Var = this.a;
        if (c0Var != null) {
            return c0Var;
        }
        a(3);
        throw null;
    }

    public String toString() {
        return d0.e0.p.d.m0.j.c.f3439b.renderAnnotation(this, null);
    }
}
