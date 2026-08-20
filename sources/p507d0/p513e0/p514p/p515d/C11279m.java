package p507d0.p513e0.p514p.p515d;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.KMutableProperty$Setter;
import kotlin.reflect.KProperty;
import kotlin.reflect.full.IllegalCallableAccessException;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m */
/* JADX INFO: compiled from: KProperty2Impl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11279m<D, E, V> extends C12052r<D, E, V> implements KProperty, Function2 {

    /* JADX INFO: renamed from: w */
    public final C11251c0.b<a<D, E, V>> f22447w;

    /* JADX INFO: renamed from: d0.e0.p.d.m$a */
    /* JADX INFO: compiled from: KProperty2Impl.kt */
    public static final class a<D, E, V> extends AbstractC12053s.d<V> implements KMutableProperty$Setter, Function3 {

        /* JADX INFO: renamed from: q */
        public final C11279m<D, E, V> f22448q;

        public a(C11279m<D, E, V> c11279m) {
            C12238m.checkNotNullParameter(c11279m, "property");
            this.f22448q = c11279m;
        }

        @Override // p507d0.p513e0.p514p.p515d.AbstractC12053s.a
        public C11279m<D, E, V> getProperty() {
            return this.f22448q;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) throws IllegalCallableAccessException {
            m11458invoke(obj, obj2, obj3);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public void m11458invoke(D d, E e, V v) throws IllegalCallableAccessException {
            getProperty().set(d, e, v);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m$b */
    /* JADX INFO: compiled from: KProperty2Impl.kt */
    public static final class b extends AbstractC12240o implements Function0<a<D, E, V>> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final a<D, E, V> invoke() {
            return new a<>(C11279m.this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11279m(AbstractC11262i abstractC11262i, InterfaceC11453n0 interfaceC11453n0) {
        super(abstractC11262i, interfaceC11453n0);
        C12238m.checkNotNullParameter(abstractC11262i, "container");
        C12238m.checkNotNullParameter(interfaceC11453n0, "descriptor");
        C11251c0.b<a<D, E, V>> bVarLazy = C11251c0.lazy(new b());
        C12238m.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Setter(this) }");
        this.f22447w = bVarLazy;
    }

    public a<D, E, V> getSetter() {
        a<D, E, V> aVarInvoke = this.f22447w.invoke();
        C12238m.checkNotNullExpressionValue(aVarInvoke, "_setter()");
        return aVarInvoke;
    }

    public void set(D d, E e, V v) throws IllegalCallableAccessException {
        getSetter().call(d, e, v);
    }
}
