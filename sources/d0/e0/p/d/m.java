package d0.e0.p.d;

import d0.e0.p.d.m0.c.n0;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: KProperty2Impl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m<D, E, V> extends r<D, E, V> implements KProperty, Function2 {
    public final c0$b<m$a<D, E, V>> w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(i iVar, n0 n0Var) {
        super(iVar, n0Var);
        d0.z.d.m.checkNotNullParameter(iVar, "container");
        d0.z.d.m.checkNotNullParameter(n0Var, "descriptor");
        c0$b<m$a<D, E, V>> c0_bLazy = c0.lazy(new m$b(this));
        d0.z.d.m.checkNotNullExpressionValue(c0_bLazy, "ReflectProperties.lazy { Setter(this) }");
        this.w = c0_bLazy;
    }

    public m$a<D, E, V> getSetter() {
        m$a<D, E, V> m_aInvoke = this.w.invoke();
        d0.z.d.m.checkNotNullExpressionValue(m_aInvoke, "_setter()");
        return m_aInvoke;
    }

    public void set(D d, E e, V v) {
        getSetter().call(d, e, v);
    }
}
