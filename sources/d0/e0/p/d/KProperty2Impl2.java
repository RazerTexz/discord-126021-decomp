package d0.e0.p.d;

import d0.Lazy5;
import d0.LazyJVM;
import d0.e0.p.d.KPropertyImpl;
import d0.e0.p.d.ReflectProperties;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.lang.reflect.Field;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: d0.e0.p.d.r, reason: use source file name */
/* JADX INFO: compiled from: KProperty2Impl.kt */
/* JADX INFO: loaded from: classes3.dex */
public class KProperty2Impl2<D, E, V> extends KPropertyImpl<V> implements KProperty, Function2 {
    public final ReflectProperties.b<a<D, E, V>> u;
    public final Lazy<Field> v;

    /* JADX INFO: renamed from: d0.e0.p.d.r$a */
    /* JADX INFO: compiled from: KProperty2Impl.kt */
    public static final class a<D, E, V> extends KPropertyImpl.c<V> implements KProperty.Getter, Function2 {
        public final KProperty2Impl2<D, E, V> q;

        /* JADX WARN: Multi-variable type inference failed */
        public a(KProperty2Impl2<D, E, ? extends V> kProperty2Impl2) {
            Intrinsics3.checkNotNullParameter(kProperty2Impl2, "property");
            this.q = kProperty2Impl2;
        }

        @Override // d0.e0.p.d.KPropertyImpl.a
        public KProperty2Impl2<D, E, V> getProperty() {
            return this.q;
        }

        @Override // kotlin.jvm.functions.Function2
        public V invoke(D d, E e) {
            return getProperty().get(d, e);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.r$b */
    /* JADX INFO: compiled from: KProperty2Impl.kt */
    public static final class b extends Lambda implements Function0<a<D, E, ? extends V>> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final a<D, E, V> invoke() {
            return new a<>(KProperty2Impl2.this);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.r$c */
    /* JADX INFO: compiled from: KProperty2Impl.kt */
    public static final class c extends Lambda implements Function0<Field> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Field invoke() {
            return KProperty2Impl2.this.c();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KProperty2Impl2(KDeclarationContainerImpl kDeclarationContainerImpl, PropertyDescriptor propertyDescriptor) {
        super(kDeclarationContainerImpl, propertyDescriptor);
        Intrinsics3.checkNotNullParameter(kDeclarationContainerImpl, "container");
        Intrinsics3.checkNotNullParameter(propertyDescriptor, "descriptor");
        ReflectProperties.b<a<D, E, V>> bVarLazy = ReflectProperties.lazy(new b());
        Intrinsics3.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Getter(this) }");
        this.u = bVarLazy;
        this.v = LazyJVM.lazy(Lazy5.PUBLICATION, new c());
    }

    public V get(D d, E e) {
        return getGetter().call(d, e);
    }

    @Override // kotlin.jvm.functions.Function2
    public V invoke(D d, E e) {
        return get(d, e);
    }

    @Override // d0.e0.p.d.KPropertyImpl, kotlin.reflect.KProperty6
    public a<D, E, V> getGetter() {
        a<D, E, V> aVarInvoke = this.u.invoke();
        Intrinsics3.checkNotNullExpressionValue(aVarInvoke, "_getter()");
        return aVarInvoke;
    }
}
