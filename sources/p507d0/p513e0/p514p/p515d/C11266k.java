package p507d0.p513e0.p514p.p515d;

import com.discord.models.domain.ModelAuditLogEntry;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KMutableProperty0;
import kotlin.reflect.full.IllegalCallableAccessException;
import p507d0.p513e0.p514p.p515d.AbstractC12053s;
import p507d0.p513e0.p514p.p515d.C11251c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.k */
/* JADX INFO: compiled from: KProperty0Impl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11266k<V> extends C12050p<V> implements KMutableProperty0<V> {

    /* JADX INFO: renamed from: w */
    public final C11251c0.b<a<V>> f22398w;

    /* JADX INFO: renamed from: d0.e0.p.d.k$a */
    /* JADX INFO: compiled from: KProperty0Impl.kt */
    public static final class a<R> extends AbstractC12053s.d<R> implements KMutableProperty0.Setter<R> {

        /* JADX INFO: renamed from: q */
        public final C11266k<R> f22399q;

        public a(C11266k<R> c11266k) {
            C12238m.checkNotNullParameter(c11266k, "property");
            this.f22399q = c11266k;
        }

        @Override // p507d0.p513e0.p514p.p515d.AbstractC12053s.a
        public C11266k<R> getProperty() {
            return this.f22399q;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) throws IllegalCallableAccessException {
            invoke2(obj);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public void invoke2(R r) throws IllegalCallableAccessException {
            getProperty().set(r);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.k$b */
    /* JADX INFO: compiled from: KProperty0Impl.kt */
    public static final class b extends AbstractC12240o implements Function0<a<V>> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final a<V> invoke() {
            return new a<>(C11266k.this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11266k(AbstractC11262i abstractC11262i, InterfaceC11453n0 interfaceC11453n0) {
        super(abstractC11262i, interfaceC11453n0);
        C12238m.checkNotNullParameter(abstractC11262i, "container");
        C12238m.checkNotNullParameter(interfaceC11453n0, "descriptor");
        C11251c0.b<a<V>> bVarLazy = C11251c0.lazy(new b());
        C12238m.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Setter(this) }");
        this.f22398w = bVarLazy;
    }

    public void set(V v) throws IllegalCallableAccessException {
        getSetter().call(v);
    }

    @Override // kotlin.reflect.KMutableProperty0
    public a<V> getSetter() {
        a<V> aVarInvoke = this.f22398w.invoke();
        C12238m.checkNotNullExpressionValue(aVarInvoke, "_setter()");
        return aVarInvoke;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11266k(AbstractC11262i abstractC11262i, String str, String str2, Object obj) {
        super(abstractC11262i, str, str2, obj);
        C12238m.checkNotNullParameter(abstractC11262i, "container");
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(str2, "signature");
        C11251c0.b<a<V>> bVarLazy = C11251c0.lazy(new b());
        C12238m.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Setter(this) }");
        this.f22398w = bVarLazy;
    }
}
