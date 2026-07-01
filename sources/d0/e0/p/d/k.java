package d0.e0.p.d;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.n0;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.KMutableProperty0$Setter;

/* JADX INFO: compiled from: KProperty0Impl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class k<V> extends p<V> implements KMutableProperty0<V> {
    public final c0$b<k$a<V>> w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(i iVar, n0 n0Var) {
        super(iVar, n0Var);
        d0.z.d.m.checkNotNullParameter(iVar, "container");
        d0.z.d.m.checkNotNullParameter(n0Var, "descriptor");
        c0$b<k$a<V>> c0_bLazy = c0.lazy(new k$b(this));
        d0.z.d.m.checkNotNullExpressionValue(c0_bLazy, "ReflectProperties.lazy { Setter(this) }");
        this.w = c0_bLazy;
    }

    @Override // kotlin.reflect.KMutableProperty0
    /* JADX INFO: renamed from: getSetter */
    public /* bridge */ /* synthetic */ KMutableProperty0$Setter mo113getSetter() {
        return mo113getSetter();
    }

    public void set(V v) {
        mo113getSetter().call(v);
    }

    @Override // kotlin.reflect.KMutableProperty0
    /* JADX INFO: renamed from: getSetter */
    public k$a<V> mo113getSetter() {
        k$a<V> k_aInvoke = this.w.invoke();
        d0.z.d.m.checkNotNullExpressionValue(k_aInvoke, "_setter()");
        return k_aInvoke;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(i iVar, String str, String str2, Object obj) {
        super(iVar, str, str2, obj);
        d0.z.d.m.checkNotNullParameter(iVar, "container");
        d0.z.d.m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(str2, "signature");
        c0$b<k$a<V>> c0_bLazy = c0.lazy(new k$b(this));
        d0.z.d.m.checkNotNullExpressionValue(c0_bLazy, "ReflectProperties.lazy { Setter(this) }");
        this.w = c0_bLazy;
    }
}
