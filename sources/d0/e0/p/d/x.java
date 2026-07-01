package d0.e0.p.d;

import d0.e0.p.d.m0.c.y0;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.e1;
import d0.e0.p.d.m0.n.w0;
import java.lang.reflect.Type;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: KTypeImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class x implements d0.z.d.n {
    public static final /* synthetic */ KProperty[] j = {d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(x.class), "classifier", "getClassifier()Lkotlin/reflect/KClassifier;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(x.class), "arguments", "getArguments()Ljava/util/List;"))};
    public final c0$a<Type> k;
    public final c0$a l;
    public final c0$a m;
    public final d0.e0.p.d.m0.n.c0 n;

    public x(d0.e0.p.d.m0.n.c0 c0Var, Function0<? extends Type> function0) {
        d0.z.d.m.checkNotNullParameter(c0Var, "type");
        this.n = c0Var;
        c0$a<Type> c0_aLazySoft = null;
        c0$a<Type> c0_a = (c0$a) (!(function0 instanceof c0$a) ? null : function0);
        if (c0_a != null) {
            c0_aLazySoft = c0_a;
        } else if (function0 != null) {
            c0_aLazySoft = c0.lazySoft(function0);
        }
        this.k = c0_aLazySoft;
        this.l = c0.lazySoft(new x$b(this));
        this.m = c0.lazySoft(new x$a(this, function0));
    }

    public static final /* synthetic */ d0.e0.d access$convert(x xVar, d0.e0.p.d.m0.n.c0 c0Var) {
        return xVar.a(c0Var);
    }

    public final d0.e0.d a(d0.e0.p.d.m0.n.c0 c0Var) {
        d0.e0.p.d.m0.n.c0 type;
        d0.e0.p.d.m0.c.h declarationDescriptor = c0Var.getConstructor().getDeclarationDescriptor();
        if (!(declarationDescriptor instanceof d0.e0.p.d.m0.c.e)) {
            if (declarationDescriptor instanceof z0) {
                return new y(null, (z0) declarationDescriptor);
            }
            if (declarationDescriptor instanceof y0) {
                throw new d0.j(b.d.b.a.a.w("An operation is not implemented: ", "Type alias classifiers are not yet supported"));
            }
            return null;
        }
        Class<?> javaClass = j0.toJavaClass((d0.e0.p.d.m0.c.e) declarationDescriptor);
        if (javaClass == null) {
            return null;
        }
        if (!javaClass.isArray()) {
            if (e1.isNullableType(c0Var)) {
                return new h(javaClass);
            }
            Class<?> primitiveByWrapper = d0.e0.p.d.m0.c.k1.b.b.getPrimitiveByWrapper(javaClass);
            if (primitiveByWrapper != null) {
                javaClass = primitiveByWrapper;
            }
            return new h(javaClass);
        }
        w0 w0Var = (w0) d0.t.u.singleOrNull((List) c0Var.getArguments());
        if (w0Var == null || (type = w0Var.getType()) == null) {
            return new h(javaClass);
        }
        d0.z.d.m.checkNotNullExpressionValue(type, "type.arguments.singleOrN…return KClassImpl(jClass)");
        d0.e0.d dVarA = a(type);
        if (dVarA != null) {
            return new h(d0.e0.p.d.m0.c.k1.b.b.createArrayType(d0.z.a.getJavaClass(d0.e0.p.a.getJvmErasure(dVarA))));
        }
        throw new a0("Cannot determine classifier for array element type: " + this);
    }

    public boolean equals(Object obj) {
        return (obj instanceof x) && d0.z.d.m.areEqual(this.n, ((x) obj).n);
    }

    @Override // kotlin.reflect.KType
    public List<d0.e0.i> getArguments() {
        return (List) this.m.getValue(this, j[1]);
    }

    @Override // kotlin.reflect.KType
    public d0.e0.d getClassifier() {
        return (d0.e0.d) this.l.getValue(this, j[0]);
    }

    @Override // d0.z.d.n
    public Type getJavaType() {
        c0$a<Type> c0_a = this.k;
        if (c0_a != null) {
            return c0_a.invoke();
        }
        return null;
    }

    public final d0.e0.p.d.m0.n.c0 getType() {
        return this.n;
    }

    public int hashCode() {
        return this.n.hashCode();
    }

    public String toString() {
        return e0.f3197b.renderType(this.n);
    }

    public /* synthetic */ x(d0.e0.p.d.m0.n.c0 c0Var, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(c0Var, (i & 2) != 0 ? null : function0);
    }
}
