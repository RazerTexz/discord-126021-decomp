package d0.b0;

import d0.z.d.Intrinsics3;
import kotlin.properties.Interfaces;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: d0.b0.a, reason: use source file name */
/* JADX INFO: compiled from: ObservableProperty.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ObservableProperty<V> implements Interfaces<Object, V> {
    private V value;

    public ObservableProperty(V v) {
        this.value = v;
    }

    public void afterChange(KProperty<?> kProperty, V v, V v2) {
        Intrinsics3.checkNotNullParameter(kProperty, "property");
    }

    public boolean beforeChange(KProperty<?> kProperty, V v, V v2) {
        Intrinsics3.checkNotNullParameter(kProperty, "property");
        return true;
    }

    @Override // kotlin.properties.Interfaces
    public V getValue(Object obj, KProperty<?> kProperty) {
        Intrinsics3.checkNotNullParameter(kProperty, "property");
        return this.value;
    }

    @Override // kotlin.properties.Interfaces
    public void setValue(Object obj, KProperty<?> kProperty, V v) {
        Intrinsics3.checkNotNullParameter(kProperty, "property");
        V v2 = this.value;
        if (beforeChange(kProperty, v2, v)) {
            this.value = v;
            afterChange(kProperty, v2, v);
        }
    }
}
