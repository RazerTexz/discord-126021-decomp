package d0.b0;

import d0.z.d.m;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: ObservableProperty.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a<V> implements ReadWriteProperty<Object, V> {
    private V value;

    public a(V v) {
        this.value = v;
    }

    public void afterChange(KProperty<?> kProperty, V v, V v2) {
        m.checkNotNullParameter(kProperty, "property");
    }

    public boolean beforeChange(KProperty<?> kProperty, V v, V v2) {
        m.checkNotNullParameter(kProperty, "property");
        return true;
    }

    @Override // kotlin.properties.ReadWriteProperty
    public V getValue(Object obj, KProperty<?> kProperty) {
        m.checkNotNullParameter(kProperty, "property");
        return this.value;
    }

    @Override // kotlin.properties.ReadWriteProperty
    public void setValue(Object obj, KProperty<?> kProperty, V v) {
        m.checkNotNullParameter(kProperty, "property");
        V v2 = this.value;
        if (beforeChange(kProperty, v2, v)) {
            this.value = v;
            afterChange(kProperty, v2, v);
        }
    }
}
