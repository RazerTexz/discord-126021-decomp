package d0.e0.p.d;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KMutableProperty$Setter;

/* JADX INFO: compiled from: KProperty1Impl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l$a<T, V> extends s$d<V> implements KMutableProperty$Setter, Function2 {
    public final l<T, V> q;

    public l$a(l<T, V> lVar) {
        d0.z.d.m.checkNotNullParameter(lVar, "property");
        this.q = lVar;
    }

    @Override // d0.e0.p.d.s$a
    public l<T, V> getProperty() {
        return this.q;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        m79invoke(obj, obj2);
        return Unit.a;
    }

    @Override // d0.e0.p.d.s$a
    public /* bridge */ /* synthetic */ s getProperty() {
        return getProperty();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public void m79invoke(T t, V v) {
        getProperty().set(t, v);
    }
}
