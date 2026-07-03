package p507d0.p513e0.p514p.p515d;

import com.discord.models.domain.ModelAuditLogEntry;
import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import p507d0.C12083g;
import p507d0.EnumC12110i;
import p507d0.p513e0.InterfaceC11234g;
import p507d0.p513e0.p514p.p515d.AbstractC12053s;
import p507d0.p513e0.p514p.p515d.C11251c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11453n0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.q */
/* JADX INFO: compiled from: KProperty1Impl.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12051q<T, V> extends AbstractC12053s<V> implements InterfaceC11234g<T, V> {

    /* JADX INFO: renamed from: u */
    public final C11251c0.b<a<T, V>> f25042u;

    /* JADX INFO: renamed from: v */
    public final Lazy<Field> f25043v;

    /* JADX INFO: renamed from: d0.e0.p.d.q$a */
    /* JADX INFO: compiled from: KProperty1Impl.kt */
    public static final class a<T, V> extends AbstractC12053s.c<V> implements InterfaceC11234g.a<T, V> {

        /* JADX INFO: renamed from: q */
        public final C12051q<T, V> f25044q;

        /* JADX WARN: Multi-variable type inference failed */
        public a(C12051q<T, ? extends V> c12051q) {
            C12238m.checkNotNullParameter(c12051q, "property");
            this.f25044q = c12051q;
        }

        @Override // p507d0.p513e0.p514p.p515d.AbstractC12053s.a
        public C12051q<T, V> getProperty() {
            return this.f25044q;
        }

        @Override // kotlin.jvm.functions.Function1
        public V invoke(T t) {
            return getProperty().get(t);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.q$b */
    /* JADX INFO: compiled from: KProperty1Impl.kt */
    public static final class b extends AbstractC12240o implements Function0<a<T, ? extends V>> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final a<T, V> invoke() {
            return new a<>(C12051q.this);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.q$c */
    /* JADX INFO: compiled from: KProperty1Impl.kt */
    public static final class c extends AbstractC12240o implements Function0<Field> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Field invoke() {
            return C12051q.this.m10056c();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12051q(AbstractC11262i abstractC11262i, String str, String str2, Object obj) {
        super(abstractC11262i, str, str2, obj);
        C12238m.checkNotNullParameter(abstractC11262i, "container");
        C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        C12238m.checkNotNullParameter(str2, "signature");
        C11251c0.b<a<T, V>> bVarLazy = C11251c0.lazy(new b());
        C12238m.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Getter(this) }");
        this.f25042u = bVarLazy;
        this.f25043v = C12083g.lazy(EnumC12110i.PUBLICATION, new c());
    }

    @Override // p507d0.p513e0.InterfaceC11234g
    public V get(T t) {
        return getGetter().call(t);
    }

    @Override // kotlin.jvm.functions.Function1
    public V invoke(T t) {
        return get(t);
    }

    @Override // p507d0.p513e0.p514p.p515d.AbstractC12053s, kotlin.reflect.KProperty0
    public a<T, V> getGetter() {
        a<T, V> aVarInvoke = this.f25042u.invoke();
        C12238m.checkNotNullExpressionValue(aVarInvoke, "_getter()");
        return aVarInvoke;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C12051q(AbstractC11262i abstractC11262i, InterfaceC11453n0 interfaceC11453n0) {
        super(abstractC11262i, interfaceC11453n0);
        C12238m.checkNotNullParameter(abstractC11262i, "container");
        C12238m.checkNotNullParameter(interfaceC11453n0, "descriptor");
        C11251c0.b<a<T, V>> bVarLazy = C11251c0.lazy(new b());
        C12238m.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Getter(this) }");
        this.f25042u = bVarLazy;
        this.f25043v = C12083g.lazy(EnumC12110i.PUBLICATION, new c());
    }
}
