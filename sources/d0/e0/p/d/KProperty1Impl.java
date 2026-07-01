package d0.e0.p.d;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.KProperty2;
import d0.e0.p.d.KPropertyImpl;
import d0.e0.p.d.ReflectProperties;
import d0.e0.p.d.m0.c.PropertyDescriptor;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KProperty4;
import kotlin.reflect.full.exceptions;

/* JADX INFO: renamed from: d0.e0.p.d.l, reason: use source file name */
/* JADX INFO: compiled from: KProperty1Impl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class KProperty1Impl<T, V> extends KProperty1Impl2<T, V> implements KProperty2<T, V> {
    public final ReflectProperties.b<a<T, V>> w;

    /* JADX INFO: renamed from: d0.e0.p.d.l$a */
    /* JADX INFO: compiled from: KProperty1Impl.kt */
    public static final class a<T, V> extends KPropertyImpl.d<V> implements KProperty4, Function2 {
        public final KProperty1Impl<T, V> q;

        public a(KProperty1Impl<T, V> kProperty1Impl) {
            Intrinsics3.checkNotNullParameter(kProperty1Impl, "property");
            this.q = kProperty1Impl;
        }

        @Override // d0.e0.p.d.KPropertyImpl.a
        public KProperty1Impl<T, V> getProperty() {
            return this.q;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) throws exceptions {
            m79invoke(obj, obj2);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public void m79invoke(T t, V v) throws exceptions {
            getProperty().set(t, v);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.l$b */
    /* JADX INFO: compiled from: KProperty1Impl.kt */
    public static final class b extends Lambda implements Function0<a<T, V>> {
        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final a<T, V> invoke() {
            return new a<>(KProperty1Impl.this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KProperty1Impl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, Object obj) {
        super(kDeclarationContainerImpl, str, str2, obj);
        Intrinsics3.checkNotNullParameter(kDeclarationContainerImpl, "container");
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(str2, "signature");
        ReflectProperties.b<a<T, V>> bVarLazy = ReflectProperties.lazy(new b());
        Intrinsics3.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Setter(this) }");
        this.w = bVarLazy;
    }

    public a<T, V> getSetter() {
        a<T, V> aVarInvoke = this.w.invoke();
        Intrinsics3.checkNotNullExpressionValue(aVarInvoke, "_setter()");
        return aVarInvoke;
    }

    public void set(T t, V v) throws exceptions {
        getSetter().call(t, v);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KProperty1Impl(KDeclarationContainerImpl kDeclarationContainerImpl, PropertyDescriptor propertyDescriptor) {
        super(kDeclarationContainerImpl, propertyDescriptor);
        Intrinsics3.checkNotNullParameter(kDeclarationContainerImpl, "container");
        Intrinsics3.checkNotNullParameter(propertyDescriptor, "descriptor");
        ReflectProperties.b<a<T, V>> bVarLazy = ReflectProperties.lazy(new b());
        Intrinsics3.checkNotNullExpressionValue(bVarLazy, "ReflectProperties.lazy { Setter(this) }");
        this.w = bVarLazy;
    }
}
