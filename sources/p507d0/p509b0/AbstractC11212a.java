package p507d0.p509b0;

import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.b0.a */
/* JADX INFO: compiled from: ObservableProperty.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11212a<V> implements ReadWriteProperty<Object, V> {
    private V value;

    public AbstractC11212a(V v) {
        this.value = v;
    }

    public void afterChange(KProperty<?> kProperty, V v, V v2) {
        C12238m.checkNotNullParameter(kProperty, "property");
    }

    public boolean beforeChange(KProperty<?> kProperty, V v, V v2) {
        C12238m.checkNotNullParameter(kProperty, "property");
        return true;
    }

    @Override // kotlin.properties.ReadWriteProperty
    public V getValue(Object obj, KProperty<?> kProperty) {
        C12238m.checkNotNullParameter(kProperty, "property");
        return this.value;
    }

    @Override // kotlin.properties.ReadWriteProperty
    public void setValue(Object obj, KProperty<?> kProperty, V v) {
        C12238m.checkNotNullParameter(kProperty, "property");
        V v2 = this.value;
        if (beforeChange(kProperty, v2, v)) {
            this.value = v;
            afterChange(kProperty, v2, v);
        }
    }
}
