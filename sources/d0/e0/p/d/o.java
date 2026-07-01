package d0.e0.p.d;

import d0.e0.p.d.m0.c.c1;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: KParameterImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class o implements d0.e0.f {
    public static final /* synthetic */ KProperty[] j = {d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(o.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ParameterDescriptor;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(o.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    public final c0$a k;
    public final f<?> l;
    public final int m;
    public final d0.e0.f$a n;

    public o(f<?> fVar, int i, d0.e0.f$a f_a, Function0<? extends d0.e0.p.d.m0.c.k0> function0) {
        d0.z.d.m.checkNotNullParameter(fVar, "callable");
        d0.z.d.m.checkNotNullParameter(f_a, "kind");
        d0.z.d.m.checkNotNullParameter(function0, "computeDescriptor");
        this.l = fVar;
        this.m = i;
        this.n = f_a;
        this.k = c0.lazySoft(function0);
        c0.lazySoft(new o$a(this));
    }

    public static final /* synthetic */ d0.e0.p.d.m0.c.k0 access$getDescriptor$p(o oVar) {
        return oVar.a();
    }

    public final d0.e0.p.d.m0.c.k0 a() {
        return (d0.e0.p.d.m0.c.k0) this.k.getValue(this, j[0]);
    }

    public boolean equals(Object obj) {
        if (obj instanceof o) {
            o oVar = (o) obj;
            if (d0.z.d.m.areEqual(this.l, oVar.l) && getIndex() == oVar.getIndex()) {
                return true;
            }
        }
        return false;
    }

    public final f<?> getCallable() {
        return this.l;
    }

    public int getIndex() {
        return this.m;
    }

    @Override // d0.e0.f
    public d0.e0.f$a getKind() {
        return this.n;
    }

    @Override // d0.e0.f
    public String getName() {
        d0.e0.p.d.m0.c.k0 k0VarA = a();
        if (!(k0VarA instanceof c1)) {
            k0VarA = null;
        }
        c1 c1Var = (c1) k0VarA;
        if (c1Var == null || c1Var.getContainingDeclaration().hasSynthesizedParameterNames()) {
            return null;
        }
        d0.e0.p.d.m0.g.e name = c1Var.getName();
        d0.z.d.m.checkNotNullExpressionValue(name, "valueParameter.name");
        if (name.isSpecial()) {
            return null;
        }
        return name.asString();
    }

    @Override // d0.e0.f
    public KType getType() {
        d0.e0.p.d.m0.n.c0 type = a().getType();
        d0.z.d.m.checkNotNullExpressionValue(type, "descriptor.type");
        return new x(type, new o$b(this));
    }

    public int hashCode() {
        return Integer.valueOf(getIndex()).hashCode() + (this.l.hashCode() * 31);
    }

    @Override // d0.e0.f
    public boolean isOptional() {
        d0.e0.p.d.m0.c.k0 k0VarA = a();
        if (!(k0VarA instanceof c1)) {
            k0VarA = null;
        }
        c1 c1Var = (c1) k0VarA;
        if (c1Var != null) {
            return d0.e0.p.d.m0.k.x.a.declaresOrInheritsDefaultValue(c1Var);
        }
        return false;
    }

    @Override // d0.e0.f
    public boolean isVararg() {
        d0.e0.p.d.m0.c.k0 k0VarA = a();
        return (k0VarA instanceof c1) && ((c1) k0VarA).getVarargElementType() != null;
    }

    public String toString() {
        return e0.f3197b.renderParameter(this);
    }
}
