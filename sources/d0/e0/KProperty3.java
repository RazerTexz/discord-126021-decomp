package d0.e0;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: d0.e0.g, reason: use source file name */
/* JADX INFO: compiled from: KProperty.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface KProperty3<T, V> extends KProperty<V>, Function1<T, V> {

    /* JADX INFO: renamed from: d0.e0.g$a */
    /* JADX INFO: compiled from: KProperty.kt */
    public interface a<T, V> extends KProperty.Getter<V>, Function1<T, V> {
    }

    V get(T t);

    a<T, V> getGetter();
}
