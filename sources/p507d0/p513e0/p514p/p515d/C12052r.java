package p507d0.p513e0.p514p.p515d;

import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KProperty;
import p507d0.C12083g;
import p507d0.EnumC12110i;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.r */
/* JADX INFO: compiled from: KProperty2Impl.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12052r<D, E, V> extends AbstractC12053s<V> implements KProperty, Function2 {

    /* JADX INFO: renamed from: u */
    public final C11251c0.b<a<D, E, V>> f25045u;

    /* JADX INFO: renamed from: v */
    public final Lazy<Field> f25046v;

    /* JADX INFO: renamed from: d0.e0.p.d.r$a */
    /* JADX INFO: compiled from: KProperty2Impl.kt */
    public static final class a<D, E, V> extends AbstractC12053s.c<V> implements KProperty.Getter, Function2 {

        /* JADX INFO: renamed from: q */
        public final C12052r<D, E, V> f25047q;

        /* JADX WARN: Multi-variable type inference failed */
        public a(C12052r<D, E, ? extends V> c12052r) {
            C12238m.checkNotNullParameter(c12052r, "property");
            this.f25047q = c12052r;
        }

        @Override // p507d0.p513e0.p514p.p515d.AbstractC12053s.a
        public C12052r<D, E, V> getProperty() {
            return this.f25047q;
        }

        @Override // kotlin.jvm.functions.Function2
        public V invoke(D d, E e) {
            return getProperty().get(d, e);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.r$b */
    /* JADX INFO: compiled from: KProperty2Impl.kt */
    public static final class b extends AbstractC12240o implements Function0<a<D, E, ? extends V>> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final a<D, E, V> invoke() {
            return new a<>(C12052r.this);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.r$c */
    /* JADX INFO: compiled from: KProperty2Impl.kt */
    public static final class c extends AbstractC12240o implements Function0<Field> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Field invoke() {
            return C12052r.this.m10056c();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12052r(AbstractC11262i abstractC11262i, InterfaceC11453n0 interfaceC11453n0) {
        super(abstractC11262i, interfaceC11453n0);
        C12238m.checkNotNullParameter(abstractC11262i, "container");
        C12238m.checkNotNullParameter(interfaceC11453n0, "descriptor");
        C11251c0.b<a<D, E, V>> bVarLazy = C11251c0.lazy(new b());
        C12238m.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Getter(this) }");
        this.f25045u = bVarLazy;
        this.f25046v = C12083g.lazy(EnumC12110i.PUBLICATION, new c());
    }

    public V get(D d, E e) {
        return getGetter().call(d, e);
    }

    @Override // kotlin.jvm.functions.Function2
    public V invoke(D d, E e) {
        return get(d, e);
    }

    @Override // p507d0.p513e0.p514p.p515d.AbstractC12053s, kotlin.reflect.KProperty0
    public a<D, E, V> getGetter() {
        a<D, E, V> aVarInvoke = this.f25045u.invoke();
        C12238m.checkNotNullExpressionValue(aVarInvoke, "_getter()");
        return aVarInvoke;
    }
}
