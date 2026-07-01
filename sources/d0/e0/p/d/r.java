package d0.e0.p.d;

import d0.e0.p.d.m0.c.n0;
import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: KProperty2Impl.kt */
/* JADX INFO: loaded from: classes3.dex */
public class r<D, E, V> extends s<V> implements KProperty, Function2 {
    public final c0$b<r$a<D, E, V>> u;
    public final Lazy<Field> v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(i iVar, n0 n0Var) {
        super(iVar, n0Var);
        d0.z.d.m.checkNotNullParameter(iVar, "container");
        d0.z.d.m.checkNotNullParameter(n0Var, "descriptor");
        c0$b<r$a<D, E, V>> c0_bLazy = c0.lazy(new r$b(this));
        d0.z.d.m.checkNotNullExpressionValue(c0_bLazy, "ReflectProperties.lazy { Getter(this) }");
        this.u = c0_bLazy;
        this.v = d0.g.lazy(d0.i.PUBLICATION, new r$c(this));
    }

    public V get(D d, E e) {
        return mo112getGetter().call(d, e);
    }

    @Override // d0.e0.p.d.s, kotlin.reflect.KProperty0
    /* JADX INFO: renamed from: getGetter */
    public /* bridge */ /* synthetic */ s$c mo112getGetter() {
        return mo112getGetter();
    }

    @Override // kotlin.jvm.functions.Function2
    public V invoke(D d, E e) {
        return get(d, e);
    }

    @Override // d0.e0.p.d.s, kotlin.reflect.KProperty0
    /* JADX INFO: renamed from: getGetter */
    public r$a<D, E, V> mo112getGetter() {
        r$a<D, E, V> r_aInvoke = this.u.invoke();
        d0.z.d.m.checkNotNullExpressionValue(r_aInvoke, "_getter()");
        return r_aInvoke;
    }
}
