package kotlin.reflect;

import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: KProperty.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface KProperty0<V> extends KProperty<V>, Function0<V> {
    V get();

    Object getDelegate();

    /* JADX INFO: renamed from: getGetter */
    KProperty0$Getter<V> mo112getGetter();
}
