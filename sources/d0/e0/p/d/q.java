package d0.e0.p.d;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.g$a;
import d0.e0.p.d.m0.c.n0;
import java.lang.reflect.Field;
import kotlin.Lazy;

/* JADX INFO: compiled from: KProperty1Impl.kt */
/* JADX INFO: loaded from: classes3.dex */
public class q<T, V> extends s<V> implements d0.e0.g<T, V> {
    public final c0$b<q$a<T, V>> u;
    public final Lazy<Field> v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(i iVar, String str, String str2, Object obj) {
        super(iVar, str, str2, obj);
        d0.z.d.m.checkNotNullParameter(iVar, "container");
        d0.z.d.m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        d0.z.d.m.checkNotNullParameter(str2, "signature");
        c0$b<q$a<T, V>> c0_bLazy = c0.lazy(new q$b(this));
        d0.z.d.m.checkNotNullExpressionValue(c0_bLazy, "ReflectProperties.lazy { Getter(this) }");
        this.u = c0_bLazy;
        this.v = d0.g.lazy(d0.i.PUBLICATION, new q$c(this));
    }

    @Override // d0.e0.g
    public V get(T t) {
        return mo112getGetter().call(t);
    }

    @Override // d0.e0.g
    public /* bridge */ /* synthetic */ g$a getGetter() {
        return mo112getGetter();
    }

    @Override // kotlin.jvm.functions.Function1
    public V invoke(T t) {
        return get(t);
    }

    @Override // d0.e0.p.d.s, kotlin.reflect.KProperty0
    /* JADX INFO: renamed from: getGetter */
    public /* bridge */ /* synthetic */ s$c mo112getGetter() {
        return mo112getGetter();
    }

    @Override // d0.e0.p.d.s, kotlin.reflect.KProperty0
    /* JADX INFO: renamed from: getGetter */
    public q$a<T, V> mo112getGetter() {
        q$a<T, V> q_aInvoke = this.u.invoke();
        d0.z.d.m.checkNotNullExpressionValue(q_aInvoke, "_getter()");
        return q_aInvoke;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(i iVar, n0 n0Var) {
        super(iVar, n0Var);
        d0.z.d.m.checkNotNullParameter(iVar, "container");
        d0.z.d.m.checkNotNullParameter(n0Var, "descriptor");
        c0$b<q$a<T, V>> c0_bLazy = c0.lazy(new q$b(this));
        d0.z.d.m.checkNotNullExpressionValue(c0_bLazy, "ReflectProperties.lazy { Getter(this) }");
        this.u = c0_bLazy;
        this.v = d0.g.lazy(d0.i.PUBLICATION, new q$c(this));
    }
}
