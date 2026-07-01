package d0.e0.p.d;

import d0.e0.p.d.m0.c.m0;
import d0.e0.p.d.m0.c.p0;
import kotlin.Unit;
import kotlin.reflect.KMutableProperty$Setter;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: KPropertyImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class s$d<V> extends s$a<V, Unit> implements KMutableProperty$Setter<V> {
    public static final /* synthetic */ KProperty[] n = {d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(s$d.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;")), d0.z.d.a0.property1(new d0.z.d.y(d0.z.d.a0.getOrCreateKotlinClass(s$d.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
    public final c0$a o = c0.lazySoft(new s$d$b(this));
    public final c0$b p = c0.lazy(new s$d$a(this));

    @Override // d0.e0.p.d.f
    public d0.e0.p.d.l0.d<?> getCaller() {
        return (d0.e0.p.d.l0.d) this.p.getValue(this, n[1]);
    }

    @Override // d0.e0.p.d.f
    public /* bridge */ /* synthetic */ d0.e0.p.d.m0.c.b getDescriptor() {
        return getDescriptor();
    }

    @Override // d0.e0.p.d.s$a, d0.e0.p.d.f
    public p0 getDescriptor() {
        return (p0) this.o.getValue(this, n[0]);
    }

    @Override // kotlin.reflect.KCallable
    public String getName() {
        StringBuilder sbU = b.d.b.a.a.U("<set-");
        sbU.append(getProperty().getName());
        sbU.append('>');
        return sbU.toString();
    }

    @Override // d0.e0.p.d.s$a, d0.e0.p.d.f
    public /* bridge */ /* synthetic */ m0 getDescriptor() {
        return getDescriptor();
    }
}
