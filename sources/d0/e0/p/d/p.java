package d0.e0.p.d;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.n0;
import kotlin.Lazy;
import kotlin.reflect.KProperty0;
import kotlin.reflect.KProperty0$Getter;

/* JADX INFO: compiled from: KProperty0Impl.kt */
/* JADX INFO: loaded from: classes3.dex */
public class p<V> extends s<V> implements KProperty0<V> {
    public final c0$b<p$a<V>> u;
    public final Lazy<Object> v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(i iVar, n0 n0Var) {
        super(iVar, n0Var);
        d0.z.d.m.checkNotNullParameter(iVar, "container");
        d0.z.d.m.checkNotNullParameter(n0Var, "descriptor");
        c0$b<p$a<V>> c0_bLazy = c0.lazy(new p$b(this));
        d0.z.d.m.checkNotNullExpressionValue(c0_bLazy, "ReflectProperties.lazy { Getter(this) }");
        this.u = c0_bLazy;
        this.v = d0.g.lazy(d0.i.PUBLICATION, new p$c(this));
    }

    @Override // kotlin.reflect.KProperty0
    public V get() {
        return mo112getGetter().call(new Object[0]);
    }

    @Override // kotlin.reflect.KProperty0
    public Object getDelegate() {
        return this.v.getValue();
    }

    @Override // kotlin.reflect.KProperty0
    /* JADX INFO: renamed from: getGetter */
    public /* bridge */ /* synthetic */ KProperty0$Getter mo112getGetter() {
        return mo112getGetter();
    }

    @Override // kotlin.jvm.functions.Function0
    public V invoke() {
        return get();
    }

    @Override // d0.e0.p.d.s, kotlin.reflect.KProperty0
    /* JADX INFO: renamed from: getGetter */
    public /* bridge */ /* synthetic */ s$c mo112getGetter() {
        return mo112getGetter();
    }

    @Override // d0.e0.p.d.s, kotlin.reflect.KProperty0
    /* JADX INFO: renamed from: getGetter */
    public p$a<V> mo112getGetter() {
        p$a<V> p_aInvoke = this.u.invoke();
        d0.z.d.m.checkNotNullExpressionValue(p_aInvoke, "_getter()");
        return p_aInvoke;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(i iVar, String str, String str2, Object obj) {
        super(iVar, str, str2, obj);
        d0.z.d.m.checkNotNullParameter(iVar, "container");
        d0.z.d.m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(str2, "signature");
        c0$b<p$a<V>> c0_bLazy = c0.lazy(new p$b(this));
        d0.z.d.m.checkNotNullExpressionValue(c0_bLazy, "ReflectProperties.lazy { Getter(this) }");
        this.u = c0_bLazy;
        this.v = d0.g.lazy(d0.i.PUBLICATION, new p$c(this));
    }
}
