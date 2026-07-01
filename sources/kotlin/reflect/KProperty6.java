package kotlin.reflect;

import androidx.exifinterface.media.ExifInterface;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: kotlin.reflect.KProperty0, reason: use source file name */
/* JADX INFO: compiled from: KProperty.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface KProperty6<V> extends KProperty<V>, Function0<V> {

    /* JADX INFO: renamed from: kotlin.reflect.KProperty0$Getter */
    /* JADX INFO: compiled from: KProperty.kt */
    public interface Getter<V> extends KProperty.Getter<V>, Function0<V> {
    }

    V get();

    Object getDelegate();

    /* JADX INFO: renamed from: getGetter */
    Getter<V> mo112getGetter();
}
