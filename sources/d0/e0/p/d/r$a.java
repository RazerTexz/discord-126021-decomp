package d0.e0.p.d;

import kotlin.jvm.functions.Function2;
import kotlin.reflect.KProperty$Getter;

/* JADX INFO: compiled from: KProperty2Impl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class r$a<D, E, V> extends s$c<V> implements KProperty$Getter, Function2 {
    public final r<D, E, V> q;

    /* JADX WARN: Multi-variable type inference failed */
    public r$a(r<D, E, ? extends V> rVar) {
        d0.z.d.m.checkNotNullParameter(rVar, "property");
        this.q = rVar;
    }

    @Override // d0.e0.p.d.s$a
    public r<D, E, V> getProperty() {
        return this.q;
    }

    @Override // kotlin.jvm.functions.Function2
    public V invoke(D d, E e) {
        return getProperty().get(d, e);
    }

    @Override // d0.e0.p.d.s$a
    public /* bridge */ /* synthetic */ s getProperty() {
        return getProperty();
    }
}
