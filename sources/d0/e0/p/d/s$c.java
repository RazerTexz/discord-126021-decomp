package d0.e0.p.d;

import d0.e0.p.d.m0.c.m0;
import d0.e0.p.d.m0.c.o0;
import kotlin.reflect.KProperty;
import kotlin.reflect.KProperty$Getter;

/* JADX INFO: compiled from: KPropertyImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class s$c<V> extends s$a<V, V> implements KProperty$Getter<V> {
    public static final /* synthetic */ KProperty[] n = {d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(s$c.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(s$c.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
    public final c0$a o = c0.lazySoft(new s$c$b(this));
    public final c0$b p = c0.lazy(new s$c$a(this));

    @Override // d0.e0.p.d.f
    public d0.e0.p.d.l0.d<?> getCaller() {
        return (d0.e0.p.d.l0.d) this.p.getValue(this, n[1]);
    }

    @Override // d0.e0.p.d.f
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.b getDescriptor() {
        return getDescriptor();
    }

    @Override // d0.e0.p.d.s$a, d0.e0.p.d.f
    public o0 getDescriptor() {
        return (o0) this.o.getValue(this, n[0]);
    }

    @Override // kotlin.reflect.KCallable
    public String getName() {
        StringBuilder sbU = b.d.b.a.a.U("<get-");
        sbU.append(getProperty().getName());
        sbU.append('>');
        return sbU.toString();
    }

    @Override // d0.e0.p.d.s$a, d0.e0.p.d.f
    public /* bridge */ /* synthetic */ m0 getDescriptor() {
        return getDescriptor();
    }
}
