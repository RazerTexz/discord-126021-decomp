package d0.e0.p.d;

import kotlin.Triple;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: KPackageImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n$a extends i$b {
    public static final /* synthetic */ KProperty[] d = {d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(n$a.class), "kotlinClass", "getKotlinClass()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(n$a.class), "scope", "getScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(n$a.class), "multifileFacade", "getMultifileFacade()Ljava/lang/Class;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(n$a.class), "metadata", "getMetadata()Lkotlin/Triple;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(n$a.class), "members", "getMembers()Ljava/util/Collection;"))};
    public final c0$a e;
    public final c0$a f;
    public final c0$b g;
    public final c0$b h;
    public final /* synthetic */ n i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n$a(n nVar) {
        super(nVar);
        this.i = nVar;
        this.e = c0.lazySoft(new n$a$a(this));
        this.f = c0.lazySoft(new n$a$e(this));
        this.g = c0.lazy(new n$a$d(this));
        this.h = c0.lazy(new n$a$c(this));
        c0.lazySoft(new n$a$b(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final d0.e0.p.d.m0.c.k1.a.f access$getKotlinClass$p(n$a n_a) {
        return (d0.e0.p.d.m0.c.k1.a.f) n_a.e.getValue(n_a, d[0]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Triple<d0.e0.p.d.m0.f.a0.b.g, d0.e0.p.d.m0.f.l, d0.e0.p.d.m0.f.a0.b.f> getMetadata() {
        return (Triple) this.h.getValue(this, d[3]);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Class<?> getMultifileFacade() {
        return (Class) this.g.getValue(this, d[2]);
    }

    public final d0.e0.p.d.m0.k.a0.i getScope() {
        return (d0.e0.p.d.m0.k.a0.i) this.f.getValue(this, d[1]);
    }
}
