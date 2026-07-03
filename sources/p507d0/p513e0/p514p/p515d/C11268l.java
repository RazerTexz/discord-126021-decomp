package p507d0.p513e0.p514p.p515d;

import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KMutableProperty$Setter;
import kotlin.reflect.full.IllegalCallableAccessException;
import p507d0.p513e0.InterfaceC11232e;
import p507d0.p513e0.p514p.p515d.AbstractC12053s;
import p507d0.p513e0.p514p.p515d.C11251c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.l */
/* JADX INFO: compiled from: KProperty1Impl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11268l<T, V> extends C12051q<T, V> implements InterfaceC11232e<T, V> {

    /* JADX INFO: renamed from: w */
    public final C11251c0.b<a<T, V>> f22402w;

    /* JADX INFO: renamed from: d0.e0.p.d.l$a */
    /* JADX INFO: compiled from: KProperty1Impl.kt */
    public static final class a<T, V> extends AbstractC12053s.d<V> implements KMutableProperty$Setter, Function2 {

        /* JADX INFO: renamed from: q */
        public final C11268l<T, V> f22403q;

        public a(C11268l<T, V> c11268l) {
            C12238m.checkNotNullParameter(c11268l, "property");
            this.f22403q = c11268l;
        }

        @Override // p507d0.p513e0.p514p.p515d.AbstractC12053s.a
        public C11268l<T, V> getProperty() {
            return this.f22403q;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws IllegalCallableAccessException {
            m11456invoke(obj, obj2);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public void m11456invoke(T t, V v) throws IllegalCallableAccessException {
            getProperty().set(t, v);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.l$b */
    /* JADX INFO: compiled from: KProperty1Impl.kt */
    public static final class b extends AbstractC12240o implements Function0<a<T, V>> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final a<T, V> invoke() {
            return new a<>(C11268l.this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11268l(AbstractC11262i abstractC11262i, String str, String str2, Object obj) {
        super(abstractC11262i, str, str2, obj);
        C12238m.checkNotNullParameter(abstractC11262i, "container");
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(str2, "signature");
        C11251c0.b<a<T, V>> bVarLazy = C11251c0.lazy(new b());
        C12238m.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Setter(this) }");
        this.f22402w = bVarLazy;
    }

    public a<T, V> getSetter() {
        a<T, V> aVarInvoke = this.f22402w.invoke();
        C12238m.checkNotNullExpressionValue(aVarInvoke, "_setter()");
        return aVarInvoke;
    }

    public void set(T t, V v) throws IllegalCallableAccessException {
        getSetter().call(t, v);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11268l(AbstractC11262i abstractC11262i, InterfaceC11453n0 interfaceC11453n0) {
        super(abstractC11262i, interfaceC11453n0);
        C12238m.checkNotNullParameter(abstractC11262i, "container");
        C12238m.checkNotNullParameter(interfaceC11453n0, "descriptor");
        C11251c0.b<a<T, V>> bVarLazy = C11251c0.lazy(new b());
        C12238m.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Setter(this) }");
        this.f22402w = bVarLazy;
    }
}
