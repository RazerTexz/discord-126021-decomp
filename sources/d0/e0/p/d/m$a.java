package d0.e0.p.d;

import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.KMutableProperty$Setter;

/* JADX INFO: compiled from: KProperty2Impl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class m$a<D, E, V> extends s$d<V> implements KMutableProperty$Setter, Function3 {
    public final m<D, E, V> q;

    public m$a(m<D, E, V> mVar) {
        d0.z.d.m.checkNotNullParameter(mVar, "property");
        this.q = mVar;
    }

    @Override // d0.e0.p.d.s$a
    public m<D, E, V> getProperty() {
        return this.q;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        m81invoke(obj, obj2, obj3);
        return Unit.a;
    }

    @Override // d0.e0.p.d.s$a
    public /* bridge */ /* synthetic */ s getProperty() {
        return getProperty();
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public void m81invoke(D d, E e, V v) {
        getProperty().set(d, e, v);
    }
}
