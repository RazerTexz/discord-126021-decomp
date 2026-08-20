package p507d0.p513e0.p514p.p515d;

import com.discord.models.domain.ModelAuditLogEntry;
import java.lang.reflect.Field;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty0;
import kotlin.reflect.full.IllegalPropertyDelegateAccessException;
import p507d0.C12083g;
import p507d0.EnumC12110i;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.p */
/* JADX INFO: compiled from: KProperty0Impl.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12050p<V> extends AbstractC12053s<V> implements KProperty0<V> {

    /* JADX INFO: renamed from: u */
    public final C11251c0.b<a<V>> f25039u;

    /* JADX INFO: renamed from: v */
    public final Lazy<Object> f25040v;

    /* JADX INFO: renamed from: d0.e0.p.d.p$a */
    /* JADX INFO: compiled from: KProperty0Impl.kt */
    public static final class a<R> extends AbstractC12053s.c<R> implements KProperty0.Getter<R> {

        /* JADX INFO: renamed from: q */
        public final C12050p<R> f25041q;

        /* JADX WARN: Multi-variable type inference failed */
        public a(C12050p<? extends R> c12050p) {
            C12238m.checkNotNullParameter(c12050p, "property");
            this.f25041q = c12050p;
        }

        @Override // p507d0.p513e0.p514p.p515d.AbstractC12053s.a
        public C12050p<R> getProperty() {
            return this.f25041q;
        }

        @Override // kotlin.jvm.functions.Function0
        public R invoke() {
            return getProperty().get();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.p$b */
    /* JADX INFO: compiled from: KProperty0Impl.kt */
    public static final class b extends AbstractC12240o implements Function0<a<? extends V>> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final a<V> invoke() {
            return new a<>(C12050p.this);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.p$c */
    /* JADX INFO: compiled from: KProperty0Impl.kt */
    public static final class c extends AbstractC12240o implements Function0<Object> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() throws IllegalPropertyDelegateAccessException {
            C12050p c12050p = C12050p.this;
            Field fieldM10056c = c12050p.m10056c();
            Object boundReceiver = C12050p.this.getBoundReceiver();
            Objects.requireNonNull(c12050p);
            try {
                if (boundReceiver == AbstractC12053s.f25048n && c12050p.getDescriptor().getExtensionReceiverParameter() == null) {
                    throw new RuntimeException('\'' + c12050p + "' is not an extension property and thus getExtensionDelegate() is not going to work, use getDelegate() instead");
                }
                if (fieldM10056c != null) {
                    return fieldM10056c.get(boundReceiver);
                }
                return null;
            } catch (IllegalAccessException e) {
                throw new IllegalPropertyDelegateAccessException(e);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12050p(AbstractC11262i abstractC11262i, InterfaceC11453n0 interfaceC11453n0) {
        super(abstractC11262i, interfaceC11453n0);
        C12238m.checkNotNullParameter(abstractC11262i, "container");
        C12238m.checkNotNullParameter(interfaceC11453n0, "descriptor");
        C11251c0.b<a<V>> bVarLazy = C11251c0.lazy(new b());
        C12238m.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Getter(this) }");
        this.f25039u = bVarLazy;
        this.f25040v = C12083g.lazy(EnumC12110i.PUBLICATION, new c());
    }

    @Override // kotlin.reflect.KProperty0
    public V get() {
        return getGetter().call(new Object[0]);
    }

    @Override // kotlin.reflect.KProperty0
    public Object getDelegate() {
        return this.f25040v.getValue();
    }

    @Override // kotlin.jvm.functions.Function0
    public V invoke() {
        return get();
    }

    @Override // kotlin.reflect.KProperty0
    public a<V> getGetter() {
        a<V> aVarInvoke = this.f25039u.invoke();
        C12238m.checkNotNullExpressionValue(aVarInvoke, "_getter()");
        return aVarInvoke;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12050p(AbstractC11262i abstractC11262i, String str, String str2, Object obj) {
        super(abstractC11262i, str, str2, obj);
        C12238m.checkNotNullParameter(abstractC11262i, "container");
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(str2, "signature");
        C11251c0.b<a<V>> bVarLazy = C11251c0.lazy(new b());
        C12238m.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Getter(this) }");
        this.f25039u = bVarLazy;
        this.f25040v = C12083g.lazy(EnumC12110i.PUBLICATION, new c());
    }
}
