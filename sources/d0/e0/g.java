package d0.e0;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: KProperty.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface g<T, V> extends KProperty<V>, Function1<T, V> {
    V get(T t);

    g$a<T, V> getGetter();
}
