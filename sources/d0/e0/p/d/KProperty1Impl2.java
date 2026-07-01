package d0.e0.p.d;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.Lazy5;
import d0.LazyJVM;
import d0.e0.KProperty3;
import d0.e0.p.d.KPropertyImpl;
import d0.e0.p.d.ReflectProperties;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: d0.e0.p.d.q, reason: use source file name */
/* JADX INFO: compiled from: KProperty1Impl.kt */
/* JADX INFO: loaded from: classes3.dex */
public class KProperty1Impl2<T, V> extends KPropertyImpl<V> implements KProperty3<T, V> {
    public final ReflectProperties.b<a<T, V>> u;
    public final Lazy<Field> v;

    /* JADX INFO: renamed from: d0.e0.p.d.q$a */
    /* JADX INFO: compiled from: KProperty1Impl.kt */
    public static final class a<T, V> extends KPropertyImpl.c<V> implements KProperty3.a<T, V> {
        public final KProperty1Impl2<T, V> q;

        /* JADX WARN: Multi-variable type inference failed */
        public a(KProperty1Impl2<T, ? extends V> kProperty1Impl2) {
            Intrinsics3.checkNotNullParameter(kProperty1Impl2, "property");
            this.q = kProperty1Impl2;
        }

        @Override // d0.e0.p.d.KPropertyImpl.a
        public KProperty1Impl2<T, V> getProperty() {
            return this.q;
        }

        @Override // kotlin.jvm.functions.Function1
        public V invoke(T t) {
            return getProperty().get(t);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.q$b */
    /* JADX INFO: compiled from: KProperty1Impl.kt */
    public static final class b extends Lambda implements Function0<a<T, ? extends V>> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final a<T, V> invoke() {
            return new a<>(KProperty1Impl2.this);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.q$c */
    /* JADX INFO: compiled from: KProperty1Impl.kt */
    public static final class c extends Lambda implements Function0<Field> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Field invoke() {
            return KProperty1Impl2.this.c();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KProperty1Impl2(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, Object obj) {
        super(kDeclarationContainerImpl, str, str2, obj);
        Intrinsics3.checkNotNullParameter(kDeclarationContainerImpl, "container");
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str2, "signature");
        ReflectProperties.b<a<T, V>> bVarLazy = ReflectProperties.lazy(new b());
        Intrinsics3.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Getter(this) }");
        this.u = bVarLazy;
        this.v = LazyJVM.lazy(Lazy5.PUBLICATION, new c());
    }

    @Override // d0.e0.KProperty3
    public V get(T t) {
        return getGetter().call(t);
    }

    @Override // kotlin.jvm.functions.Function1
    public V invoke(T t) {
        return get(t);
    }

    @Override // d0.e0.p.d.KPropertyImpl, kotlin.reflect.KProperty6
    public a<T, V> getGetter() {
        a<T, V> aVarInvoke = this.u.invoke();
        Intrinsics3.checkNotNullExpressionValue(aVarInvoke, "_getter()");
        return aVarInvoke;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KProperty1Impl2(KDeclarationContainerImpl kDeclarationContainerImpl, PropertyDescriptor propertyDescriptor) {
        super(kDeclarationContainerImpl, propertyDescriptor);
        Intrinsics3.checkNotNullParameter(kDeclarationContainerImpl, "container");
        Intrinsics3.checkNotNullParameter(propertyDescriptor, "descriptor");
        ReflectProperties.b<a<T, V>> bVarLazy = ReflectProperties.lazy(new b());
        Intrinsics3.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Getter(this) }");
        this.u = bVarLazy;
        this.v = LazyJVM.lazy(Lazy5.PUBLICATION, new c());
    }
}
