package d0.e0.p.d;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.n0;

/* JADX INFO: compiled from: KProperty1Impl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l<T, V> extends q<T, V> implements d0.e0.e<T, V> {
    public final c0$b<l$a<T, V>> w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(i iVar, String str, String str2, Object obj) {
        super(iVar, str, str2, obj);
        d0.z.d.m.checkNotNullParameter(iVar, "container");
        d0.z.d.m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(str2, "signature");
        c0$b<l$a<T, V>> c0_bLazy = c0.lazy(new l$b(this));
        d0.z.d.m.checkNotNullExpressionValue(c0_bLazy, "ReflectProperties.lazy { Setter(this) }");
        this.w = c0_bLazy;
    }

    public l$a<T, V> getSetter() {
        l$a<T, V> l_aInvoke = this.w.invoke();
        d0.z.d.m.checkNotNullExpressionValue(l_aInvoke, "_setter()");
        return l_aInvoke;
    }

    public void set(T t, V v) {
        getSetter().call(t, v);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(i iVar, n0 n0Var) {
        super(iVar, n0Var);
        d0.z.d.m.checkNotNullParameter(iVar, "container");
        d0.z.d.m.checkNotNullParameter(n0Var, "descriptor");
        c0$b<l$a<T, V>> c0_bLazy = c0.lazy(new l$b(this));
        d0.z.d.m.checkNotNullExpressionValue(c0_bLazy, "ReflectProperties.lazy { Setter(this) }");
        this.w = c0_bLazy;
    }
}
