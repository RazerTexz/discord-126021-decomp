package d0.e0.p.d;

import com.discord.models.domain.ModelAuditLogEntry;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: KClassImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$a extends i$b {
    public static final /* synthetic */ KProperty[] d = {d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(h$a.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/ClassDescriptor;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(h$a.class), "annotations", "getAnnotations()Ljava/util/List;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(h$a.class), "simpleName", "getSimpleName()Ljava/lang/String;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(h$a.class), "qualifiedName", "getQualifiedName()Ljava/lang/String;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(h$a.class), "constructors", "getConstructors()Ljava/util/Collection;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(h$a.class), "nestedClasses", "getNestedClasses()Ljava/util/Collection;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(h$a.class), "objectInstance", "getObjectInstance()Ljava/lang/Object;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(h$a.class), "typeParameters", "getTypeParameters()Ljava/util/List;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(h$a.class), "supertypes", "getSupertypes()Ljava/util/List;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(h$a.class), "sealedSubclasses", "getSealedSubclasses()Ljava/util/List;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(h$a.class), "declaredNonStaticMembers", "getDeclaredNonStaticMembers()Ljava/util/Collection;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(h$a.class), "declaredStaticMembers", "getDeclaredStaticMembers()Ljava/util/Collection;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(h$a.class), "inheritedNonStaticMembers", "getInheritedNonStaticMembers()Ljava/util/Collection;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(h$a.class), "inheritedStaticMembers", "getInheritedStaticMembers()Ljava/util/Collection;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(h$a.class), "allNonStaticMembers", "getAllNonStaticMembers()Ljava/util/Collection;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(h$a.class), "allStaticMembers", "getAllStaticMembers()Ljava/util/Collection;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(h$a.class), "declaredMembers", "getDeclaredMembers()Ljava/util/Collection;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(h$a.class), "allMembers", "getAllMembers()Ljava/util/Collection;"))};
    public final c0$a e;
    public final c0$a f;
    public final c0$a g;
    public final c0$b h;
    public final c0$a i;
    public final c0$a j;
    public final c0$a k;
    public final c0$a l;
    public final c0$a m;
    public final c0$a n;
    public final c0$a o;
    public final /* synthetic */ h p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h$a(h hVar) {
        super(hVar);
        this.p = hVar;
        this.e = c0.lazySoft(new h$a$i(this));
        c0.lazySoft(new h$a$d(this));
        this.f = c0.lazySoft(new h$a$p(this));
        this.g = c0.lazySoft(new h$a$n(this));
        c0.lazySoft(new h$a$e(this));
        c0.lazySoft(new h$a$l(this));
        this.h = c0.lazy(new h$a$m(this));
        c0.lazySoft(new h$a$r(this));
        c0.lazySoft(new h$a$q(this));
        this.i = c0.lazySoft(new h$a$o(this));
        this.j = c0.lazySoft(new h$a$g(this));
        this.k = c0.lazySoft(new h$a$h(this));
        this.l = c0.lazySoft(new h$a$j(this));
        this.m = c0.lazySoft(new h$a$k(this));
        this.n = c0.lazySoft(new h$a$b(this));
        this.o = c0.lazySoft(new h$a$c(this));
        c0.lazySoft(new h$a$f(this));
        c0.lazySoft(new h$a$a(this));
    }

    public static final String access$calculateLocalClassName(h$a h_a, Class cls) {
        Objects.requireNonNull(h_a);
        String simpleName = cls.getSimpleName();
        Method enclosingMethod = cls.getEnclosingMethod();
        if (enclosingMethod != null) {
            d0.z.d.m.checkNotNullExpressionValue(simpleName, ModelAuditLogEntry.CHANGE_KEY_NAME);
            return d0.g0.w.substringAfter$default(simpleName, enclosingMethod.getName() + "$", (String) null, 2, (Object) null);
        }
        Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
        if (enclosingConstructor == null) {
            d0.z.d.m.checkNotNullExpressionValue(simpleName, ModelAuditLogEntry.CHANGE_KEY_NAME);
            return d0.g0.w.substringAfter$default(simpleName, '$', (String) null, 2, (Object) null);
        }
        d0.z.d.m.checkNotNullExpressionValue(simpleName, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return d0.g0.w.substringAfter$default(simpleName, enclosingConstructor.getName() + "$", (String) null, 2, (Object) null);
    }

    public static final Collection access$getDeclaredStaticMembers$p(h$a h_a) {
        return (Collection) h_a.k.getValue(h_a, d[11]);
    }

    public static final Collection access$getInheritedNonStaticMembers$p(h$a h_a) {
        return (Collection) h_a.l.getValue(h_a, d[12]);
    }

    public static final Collection access$getInheritedStaticMembers$p(h$a h_a) {
        return (Collection) h_a.m.getValue(h_a, d[13]);
    }

    public final Collection<f<?>> getAllNonStaticMembers() {
        return (Collection) this.n.getValue(this, d[14]);
    }

    public final Collection<f<?>> getAllStaticMembers() {
        return (Collection) this.o.getValue(this, d[15]);
    }

    public final Collection<f<?>> getDeclaredNonStaticMembers() {
        return (Collection) this.j.getValue(this, d[10]);
    }

    public final d0.e0.p.d.m0.c.e getDescriptor() {
        return (d0.e0.p.d.m0.c.e) this.e.getValue(this, d[0]);
    }

    public final T getObjectInstance() {
        return this.h.getValue(this, d[6]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String getQualifiedName() {
        return (String) this.g.getValue(this, d[3]);
    }

    public final List<d0.e0.c<? extends T>> getSealedSubclasses() {
        return (List) this.i.getValue(this, d[9]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String getSimpleName() {
        return (String) this.f.getValue(this, d[2]);
    }
}
