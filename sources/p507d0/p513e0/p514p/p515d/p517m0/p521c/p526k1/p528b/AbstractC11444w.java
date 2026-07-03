package p507d0.p513e0.p514p.p515d.p517m0.p521c.p526k1.p528b;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11564a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11591x;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11713b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.w */
/* JADX INFO: compiled from: ReflectJavaType.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11444w implements InterfaceC11591x {

    /* JADX INFO: renamed from: a */
    public static final a f23065a = new a(null);

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.k1.b.w$a */
    /* JADX INFO: compiled from: ReflectJavaType.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final AbstractC11444w create(Type type) {
            AbstractC11444w c11430i;
            C12238m.checkNotNullParameter(type, "type");
            boolean z2 = type instanceof Class;
            if (z2) {
                Class cls = (Class) type;
                if (cls.isPrimitive()) {
                    return new C11443v(cls);
                }
            }
            if ((type instanceof GenericArrayType) || (z2 && ((Class) type).isArray())) {
                c11430i = new C11430i(type);
            } else {
                c11430i = type instanceof WildcardType ? new C11447z((WildcardType) type) : new C11433l(type);
            }
            return c11430i;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof AbstractC11444w) && C12238m.areEqual(getReflectType(), ((AbstractC11444w) obj).getReflectType());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p539k0.InterfaceC11570d
    public InterfaceC11564a findAnnotation(C11713b c11713b) {
        return InterfaceC11591x.a.findAnnotation(this, c11713b);
    }

    public abstract Type getReflectType();

    public int hashCode() {
        return getReflectType().hashCode();
    }

    public String toString() {
        return getClass().getName() + ": " + getReflectType();
    }
}
