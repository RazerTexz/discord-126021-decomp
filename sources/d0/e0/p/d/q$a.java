package d0.e0.p.d;

import d0.e0.g$a;

/* JADX INFO: compiled from: KProperty1Impl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class q$a<T, V> extends s$c<V> implements g$a<T, V> {
    public final q<T, V> q;

    /* JADX WARN: Multi-variable type inference failed */
    public q$a(q<T, ? extends V> qVar) {
        d0.z.d.m.checkNotNullParameter(qVar, "property");
        this.q = qVar;
    }

    @Override // d0.e0.p.d.s$a
    public q<T, V> getProperty() {
        return this.q;
    }

    @Override // kotlin.jvm.functions.Function1
    public V invoke(T t) {
        return getProperty().get(t);
    }

    @Override // d0.e0.p.d.s$a
    public /* bridge */ /* synthetic */ s getProperty() {
        return getProperty();
    }
}
