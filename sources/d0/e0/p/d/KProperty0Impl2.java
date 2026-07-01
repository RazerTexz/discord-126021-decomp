package d0.e0.p.d;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.Lazy5;
import d0.LazyJVM;
import d0.e0.p.d.KPropertyImpl;
import d0.e0.p.d.ReflectProperties;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.lang.reflect.Field;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty6;
import kotlin.reflect.full.exceptions2;

/* JADX INFO: renamed from: d0.e0.p.d.p, reason: use source file name */
/* JADX INFO: compiled from: KProperty0Impl.kt */
/* JADX INFO: loaded from: classes3.dex */
public class KProperty0Impl2<V> extends KPropertyImpl<V> implements KProperty6<V> {
    public final ReflectProperties.b<a<V>> u;
    public final Lazy<Object> v;

    /* JADX INFO: renamed from: d0.e0.p.d.p$a */
    /* JADX INFO: compiled from: KProperty0Impl.kt */
    public static final class a<R> extends KPropertyImpl.c<R> implements KProperty6.Getter<R> {
        public final KProperty0Impl2<R> q;

        /* JADX WARN: Multi-variable type inference failed */
        public a(KProperty0Impl2<? extends R> kProperty0Impl2) {
            Intrinsics3.checkNotNullParameter(kProperty0Impl2, "property");
            this.q = kProperty0Impl2;
        }

        @Override // d0.e0.p.d.KPropertyImpl.a
        public KProperty0Impl2<R> getProperty() {
            return this.q;
        }

        @Override // kotlin.jvm.functions.Function0
        public R invoke() {
            return getProperty().get();
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.p$b */
    /* JADX INFO: compiled from: KProperty0Impl.kt */
    public static final class b extends Lambda implements Function0<a<? extends V>> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final a<V> invoke() {
            return new a<>(KProperty0Impl2.this);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.p$c */
    /* JADX INFO: compiled from: KProperty0Impl.kt */
    public static final class c extends Lambda implements Function0<Object> {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() throws exceptions2 {
            KProperty0Impl2 kProperty0Impl2 = KProperty0Impl2.this;
            Field fieldC = kProperty0Impl2.c();
            Object boundReceiver = KProperty0Impl2.this.getBoundReceiver();
            Objects.requireNonNull(kProperty0Impl2);
            try {
                if (boundReceiver == KPropertyImpl.n && kProperty0Impl2.getDescriptor().getExtensionReceiverParameter() == null) {
                    throw new RuntimeException('\'' + kProperty0Impl2 + "' is not an extension property and thus getExtensionDelegate() is not going to work, use getDelegate() instead");
                }
                if (fieldC != null) {
                    return fieldC.get(boundReceiver);
                }
                return null;
            } catch (IllegalAccessException e) {
                throw new exceptions2(e);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KProperty0Impl2(KDeclarationContainerImpl kDeclarationContainerImpl, PropertyDescriptor propertyDescriptor) {
        super(kDeclarationContainerImpl, propertyDescriptor);
        Intrinsics3.checkNotNullParameter(kDeclarationContainerImpl, "container");
        Intrinsics3.checkNotNullParameter(propertyDescriptor, "descriptor");
        ReflectProperties.b<a<V>> bVarLazy = ReflectProperties.lazy(new b());
        Intrinsics3.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Getter(this) }");
        this.u = bVarLazy;
        this.v = LazyJVM.lazy(Lazy5.PUBLICATION, new c());
    }

    @Override // kotlin.reflect.KProperty6
    public V get() {
        return getGetter().call(new Object[0]);
    }

    @Override // kotlin.reflect.KProperty6
    public Object getDelegate() {
        return this.v.getValue();
    }

    @Override // kotlin.jvm.functions.Function0
    public V invoke() {
        return get();
    }

    @Override // kotlin.reflect.KProperty6
    public a<V> getGetter() {
        a<V> aVarInvoke = this.u.invoke();
        Intrinsics3.checkNotNullExpressionValue(aVarInvoke, "_getter()");
        return aVarInvoke;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KProperty0Impl2(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, Object obj) {
        super(kDeclarationContainerImpl, str, str2, obj);
        Intrinsics3.checkNotNullParameter(kDeclarationContainerImpl, "container");
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str2, "signature");
        ReflectProperties.b<a<V>> bVarLazy = ReflectProperties.lazy(new b());
        Intrinsics3.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Getter(this) }");
        this.u = bVarLazy;
        this.v = LazyJVM.lazy(Lazy5.PUBLICATION, new c());
    }
}
